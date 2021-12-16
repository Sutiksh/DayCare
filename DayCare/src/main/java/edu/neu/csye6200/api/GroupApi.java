package edu.neu.csye6200.api;

import edu.neu.csye6200.api.abstractClass.AbstractGroup;
import edu.neu.csye6200.api.helper.GroupHelper;
import edu.neu.csye6200.dao.GroupDao;
import edu.neu.csye6200.model.*;
import edu.neu.csye6200.model.enums.ClassroomType;
import edu.neu.csye6200.model.enums.GroupType;
import edu.neu.csye6200.model.enums.StatusType;
import edu.neu.csye6200.utils.FileUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupApi extends AbstractGroup {

    private static final GroupDao groupDao = new GroupDao();

    public static List<Group> getPartialGroupsByGroupType(GroupType groupType, StatusType statusType) {
        ResultSet rs = groupDao.getGroupsByGroupTypeAndStatus(groupType, statusType);
        return GroupHelper.convertResultSetToGroupList(rs, groupType, statusType);
    }

    @Override
    public List<Group> getAllGroups() {
        ResultSet rs = groupDao.getAllGroups();
        return GroupHelper.convertResultSetToGroupList(rs);
    }

    @Override
    public void addGroup(Group group) {
        groupDao.addGroup(group);
    }

    @Override
    public void updateGroup(Group group) {
        groupDao.updateGroup(group);
    }

    @Override
    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);
    }

    @Override
    public void deleteGroup(int groupId) {
        groupDao.deleteGroup(groupId);
    }

    public long getMaxGroupId() {
        long maxVal = 0;
        ResultSet rs = groupDao.getMaxGroupId();
        try {
            maxVal = rs.getLong("group_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxVal;
    }

    private static final StudentApi studentApi = new StudentApi();
    private static final TeacherApi teacherApi = new TeacherApi();
    private static final GroupApi groupApi = new GroupApi();
    private static final ClassroomApi classroomApi = new ClassroomApi();

    static String studentFile = "students.csv";
    static String teachersFile = "teachers.csv";

    public static void groupingLogic() {

        List<Student> students = FileUtil.readStudentFromCSV(studentFile);
        List<Teacher> teachers = FileUtil.readTeacherFromCSV(teachersFile);

        List<Student> sixToTwelve = students.stream().filter(student -> student.getAge() >= 6 && student.getAge() <= 12).collect(Collectors.toList());
        List<Student> thirteenToTwentyFour = students.stream().filter(student -> student.getAge() >= 13 && student.getAge() <= 24).collect(Collectors.toList());
        List<Student> twentyFiveToThirtyFive = students.stream().filter(student -> student.getAge() >= 25 && student.getAge() <= 35).collect(Collectors.toList());
        List<Student> thirtySixToFortySeven = students.stream().filter(student -> student.getAge() >= 36 && student.getAge() <= 47).collect(Collectors.toList());
        List<Student> fortyEightToFiftyNine = students.stream().filter(student -> student.getAge() >= 48 && student.getAge() <= 59).collect(Collectors.toList());
        List<Student> sixtyAndUp = students.stream().filter(student -> student.getAge() >= 60).collect(Collectors.toList());

        assignGroupsAndClassrooms(sixToTwelve, GroupType.SixToTwelve, ClassroomType.SixToTwelve);
        assignGroupsAndClassrooms(thirteenToTwentyFour, GroupType.ThirteenToTwentyFour, ClassroomType.ThirteenToTwentyFour);
        assignGroupsAndClassrooms(twentyFiveToThirtyFive, GroupType.TwentyFiveToThirtyFive, ClassroomType.TwentyFiveToThirtyFive);
        assignGroupsAndClassrooms(thirtySixToFortySeven, GroupType.ThirtySixToFortySeven, ClassroomType.ThirtySixToFortySeven);
        assignGroupsAndClassrooms(fortyEightToFiftyNine, GroupType.FortyEightToFiftyNine, ClassroomType.FortyEightToFiftyNine);
        assignGroupsAndClassrooms(sixtyAndUp, GroupType.SixtyAndUp, ClassroomType.SixtyAndUp);
    }

    public static void assignGroupsAndClassrooms(List<Student> newStudentList, GroupType groupType, ClassroomType classroomType) {
        int size = newStudentList.size();
        if(size<1) return;
        studentApi.addStudent(newStudentList);
        List<Long> phoneList = newStudentList.stream().map(Person::getPhoneNum).collect(Collectors.toList());
        List<Student> studentFromDb = studentApi.getAllStudentByPhoneNo(phoneList);
        List<Group> groupList = GroupApi.getPartialGroupsByGroupType(groupType, StatusType.PARTIAL);
        int count = 0;
        List<Student> partialGroupFillingStudents = new ArrayList<>();
        for(Group group :groupList) {
            count += group.getMaxStudentPerGroup() - group.getCurrentStudentCount();
        }

        for(int i = 0; i<count; i++) {
            partialGroupFillingStudents.add(studentFromDb.get(i));
        }
        studentFromDb.removeAll(partialGroupFillingStudents);
        if(groupList.size()>0) {
            studentFromDb = fillPartialGroup(groupList, partialGroupFillingStudents, size);
        }
        fillNewGroup(studentFromDb, size, groupType, classroomType);
    }

    private static void fillNewGroup(List<Student> studentFromDb, int size, GroupType groupType, ClassroomType classroomType) {
        int totalNewGroup;
        int groupSize = groupType.getMaxStudentPerGroup();
        if(studentFromDb.size()%groupSize == 0) {
            totalNewGroup = studentFromDb.size()/groupSize;
        }else {
            totalNewGroup = studentFromDb.size()/groupSize + 1;
        }
        for(int i=0; i<totalNewGroup; i++) {
            List<Student> addedStudents = new ArrayList<>();
            List<Classroom> partialClassroomList = ClassroomApi.getPartialClassroomsByClassroomType(classroomType, StatusType.PARTIAL);
            List<Classroom> addedClassrooms = new ArrayList<>();
            for(int j=0; j<groupSize; j++) {
                List<Group> groupListDB = GroupApi.getPartialGroupsByGroupType(groupType, StatusType.PARTIAL);
                if(groupListDB.size()>0) {
                    fillPartialGroup(groupListDB, studentFromDb, size);
                }else {
                    // create new group
                    createNewGroup(groupType);
                    long maxGroupVal = groupApi.getMaxGroupId();
                    long studentId = studentFromDb.get(j).getStudentId();
                    List<School> schoolStudents = SchoolApi.getStudentsInGroup(maxGroupVal);
                    long teacherId = 0;
                    if(schoolStudents.size()==0) {
                        teacherId = teacherApi.getTeacherNotAssignedToGroup();
                    }else {
                        teacherId = schoolStudents.get(j).getTeacherId();
                    }
                    long classroomId;
                    if(partialClassroomList.size()>0) {
                        Classroom classroom = partialClassroomList.get(0);
                        int current = classroom.getCurrentGroupCount();
                        classroomId = classroom.getClassroomId();
                        classroom.setCurrentGroupCount(current + 1);
                        if(classroom.getCurrentGroupCount() == classroom.getMaxGroupPerCount()) {
                            classroom.setClassroomStatus(StatusType.COMPLETED);
                            addedClassrooms.add(classroom);
                        }else {
                            classroom.setClassroomStatus(StatusType.PARTIAL);
                        }
                    }else {
                        createNewClassroom(classroomType);
                        classroomId = ClassroomApi.getMaxClassroomId();
                    }
                    School school = new School();
                    school.setClassroomId(classroomId);
                    school.setGroupId(maxGroupVal);
                    school.setStudentId(studentId);
                    school.setTeacherId(teacherId);
                    SchoolApi.addSchoolRecord(school);
                }
                partialClassroomList.removeAll(addedClassrooms);
                addedStudents.add(studentFromDb.get(j));
            }
            studentFromDb.removeAll(addedStudents);
        }
    }

    private static List<Student> fillPartialGroup(List<Group> groupList, List<Student> studentFromDb, int size) {
        for(Group grp : groupList) {
            int current = grp.getCurrentStudentCount();
            int seat = grp.getMaxStudentPerGroup() - current;
            if(seat>=size) {
                // If group has enough space, add students to it.
                List<School> schoolStudents = SchoolApi.getStudentsInGroup(grp.getGroupId());
                List<Student> addedStudents = new ArrayList<>();
                for(Student student : studentFromDb) {
                    School school = new School();
                    school.setStudentId(student.getStudentId());
                    school.setTeacherId(schoolStudents.get(0).getTeacherId());
                    school.setGroupId(schoolStudents.get(0).getGroupId());
                    school.setClassroomId(schoolStudents.get(0).getClassroomId());
                    SchoolApi.addSchoolRecord(school);
                    addedStudents.add(student);
                }
                grp.setCurrentStudentCount(current + addedStudents.size());
                if(grp.getCurrentStudentCount() == grp.getMaxStudentPerGroup()) {
                    grp.setGroupStatus(StatusType.COMPLETED);
                }else {
                    grp.setGroupStatus(StatusType.PARTIAL);
                }
                groupApi.updateGroup(grp);
                studentFromDb.removeAll(addedStudents);
            }
        }
        return studentFromDb;
    }

    private static void createNewGroup(GroupType groupType) {
        Group group = new Group();
        group.setGroupType(groupType);
        group.setMaxStudentPerGroup(groupType.getMaxStudentPerGroup());
        group.setCurrentStudentCount(group.getCurrentStudentCount() + 1);
        if(group.getCurrentStudentCount()==group.getMaxStudentPerGroup()) {
            group.setGroupStatus(StatusType.COMPLETED);
        } else {
            group.setGroupStatus(StatusType.PARTIAL);
        }
        groupApi.addGroup(group);
    }

    private static void createNewClassroom(ClassroomType classroomType) {
        Classroom classroom = new Classroom();
        classroom.setClassroomType(classroomType);
        classroom.setMaxGroupPerCount(classroomType.getMaxGroupPerClass());
        classroom.setCurrentGroupCount(classroom.getCurrentGroupCount()+1);
        if(classroom.getCurrentGroupCount()==classroom.getMaxGroupPerCount()) {
            classroom.setClassroomStatus(StatusType.COMPLETED);
        } else {
            classroom.setClassroomStatus(StatusType.PARTIAL);
        }
        classroomApi.addClassroom(classroom);
    }
}

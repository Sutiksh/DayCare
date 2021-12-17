package edu.neu.csye6200.utils;

import edu.neu.csye6200.api.*;
import edu.neu.csye6200.api.concrete.*;
import edu.neu.csye6200.api.factory.ClassroomFactory;
import edu.neu.csye6200.api.factory.GroupFactory;
import edu.neu.csye6200.dao.ClassroomDao;
import edu.neu.csye6200.dao.GroupDao;
import edu.neu.csye6200.dao.StudentDao;
import edu.neu.csye6200.model.*;
import edu.neu.csye6200.model.enums.ClassroomType;
import edu.neu.csye6200.model.enums.GroupType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AutoAssignUtil {

    static StudentApi studentApi = new ConcreteStudentApi();
    static TeacherApi teacherApi = new ConcreteTeacherApi();
    static ClassroomApi classroomApi = new ConcreteClassroomApi();
    static GroupApi groupApi = new ConcreteGroupApi();


    public static void groupingLogicForAllStudents() {
        List<Student> students = studentApi.getAllStudents();

        StudentDao.clearClassroomAndGroup();
        GroupDao.clearAll();
        ClassroomDao.clearAll();

        GroupByAgeAndAssign(students);
    }

    public static void groupingLogicForSingleStudent(Student student){
        int age = student.getAge();
        if(age >= 6 && age <= 12){
            assignGroupsAndClassrooms(List.of(student),
                    GroupType.SixToTwelve, ClassroomType.SixToTwelve);
        }
        else if(age >= 13 && age <= 24){
            assignGroupsAndClassrooms(List.of(student),
                    GroupType.ThirteenToTwentyFour, ClassroomType.ThirteenToTwentyFour);
        }else if(age >= 25 && age <= 35){
            assignGroupsAndClassrooms(List.of(student),
                    GroupType.TwentyFiveToThirtyFive, ClassroomType.TwentyFiveToThirtyFive);
        }else if(age >= 36 && age <= 47){
            assignGroupsAndClassrooms(List.of(student),
                    GroupType.ThirtySixToFortySeven, ClassroomType.ThirtySixToFortySeven);
        }else if(age >= 48 && age <= 59){
            assignGroupsAndClassrooms(List.of(student),
                    GroupType.FortyEightToFiftyNine, ClassroomType.FortyEightToFiftyNine);
        }else if(age >= 60){
            assignGroupsAndClassrooms(List.of(student),
                    GroupType.SixtyAndUp, ClassroomType.SixtyAndUp);
        }
    }

    public static void groupingLogicForNewStudents(List<Student> students) {
        GroupByAgeAndAssign(students);
    }

    public static void groupingLogicForAllTeachers(){
        List<Teacher> teachers = teacherApi.getAllTeachers();
        List<Group> groups = groupApi.getAllGroups();

        assert teachers.size() >= groups.size();

        System.out.println("Assigning teachers...");
        for(int i = 0; i < groups.size(); i++){
            Group tempG = groups.get(i);
            Teacher tempT = teachers.get(i);
            tempG.setTeacherId(tempT.getTeacherId());
            tempT.setClassroom_id(tempG.getClassroomId());
            tempT.setGroup_id(tempG.getGroupId());

            groupApi.updatedGroup(tempG);
            teacherApi.updateTeacher(tempT);
        }
    }

    public static void groupingLogicForNewGroups(){
        List<Teacher> teachers = teacherApi.getAllTeachers();
        List<Group> groups = groupApi.getAllGroups();

        assert teachers.size() >= groups.size();

        System.out.println("Assigning teachers...");
        int teacher_count = 0;
        for (Group tempG : groups) {
            if (tempG.getTeacherId() != 0) {
                continue;
            }

            while (teacher_count < teachers.size()) {
                Teacher tempT = teachers.get(teacher_count);
                if (tempT.getGroup_id() > 0) {
                    teacher_count++;
                    continue;
                }

                tempG.setTeacherId(tempT.getTeacherId());
                tempT.setClassroom_id(tempG.getClassroomId());
                tempT.setGroup_id(tempG.getGroupId());
                teacherApi.updateTeacher(tempT);
                break;
            }

            groupApi.updatedGroup(tempG);
        }
    }

    private static void GroupByAgeAndAssign(List<Student> students){
        List<Student> sixToTwelve = students.stream()
                .filter(student -> student.getAge() >= 6 && student.getAge() <= 12).collect(
                        Collectors.toList());
        List<Student> thirteenToTwentyFour = students.stream()
                .filter(student -> student.getAge() >= 13 && student.getAge() <= 24)
                .collect(Collectors.toList());
        List<Student> twentyFiveToThirtyFive = students.stream()
                .filter(student -> student.getAge() >= 25 && student.getAge() <= 35)
                .collect(Collectors.toList());
        List<Student> thirtySixToFortySeven = students.stream()
                .filter(student -> student.getAge() >= 36 && student.getAge() <= 47)
                .collect(Collectors.toList());
        List<Student> fortyEightToFiftyNine = students.stream()
                .filter(student -> student.getAge() >= 48 && student.getAge() <= 59)
                .collect(Collectors.toList());
        List<Student> sixtyAndUp = students.stream().filter(student -> student.getAge() >= 60)
                .collect(Collectors.toList());

        assignGroupsAndClassrooms(sixToTwelve, GroupType.SixToTwelve, ClassroomType.SixToTwelve);
        assignGroupsAndClassrooms(thirteenToTwentyFour, GroupType.ThirteenToTwentyFour,
                ClassroomType.ThirteenToTwentyFour);
        assignGroupsAndClassrooms(twentyFiveToThirtyFive, GroupType.TwentyFiveToThirtyFive,
                ClassroomType.TwentyFiveToThirtyFive);
        assignGroupsAndClassrooms(thirtySixToFortySeven, GroupType.ThirtySixToFortySeven,
                ClassroomType.ThirtySixToFortySeven);
        assignGroupsAndClassrooms(fortyEightToFiftyNine, GroupType.FortyEightToFiftyNine,
                ClassroomType.FortyEightToFiftyNine);
        assignGroupsAndClassrooms(sixtyAndUp, GroupType.SixtyAndUp, ClassroomType.SixtyAndUp);
    }

    private static void assignGroupsAndClassrooms(List<Student> AllStudentList, GroupType groupType,
                                                 ClassroomType classroomType) {
        int size = AllStudentList.size();
        if (size < 1) {
            return;
        }

        List<Group> groupList = groupApi.getPartialGroupsByGroupType(groupType);

        int count = 0;
        List<Student> partialGroupFillingStudents = new ArrayList<>();
        for (Group group : groupList) {
            count += groupType.getMaxStudentPerGroup() -
                    studentApi.getNumOfStudentsInGroup(group.getClassroomId(), group.getGroupId());
        }

        for (int i = 0; i < count; i++) {
            if(i >= AllStudentList.size()){
                break;
            }
                partialGroupFillingStudents.add(AllStudentList.get(i));
        }
//        AllStudentList.removeAll(partialGroupFillingStudents);


        if (groupList.size() > 0) {
            AllStudentList = fillPartialGroup(groupType, groupList,
                    partialGroupFillingStudents);
        }

        fillNewGroup(AllStudentList, groupType, classroomType);
    }

    private static List<Student> fillPartialGroup(GroupType groupType,
                                                  List<Group> groupList,
                                                  List<Student> studentFromDb) {

        for(Group group : groupList) {
            int current = studentApi.getNumOfStudentsInGroup(group.getClassroomId(), group.getGroupId());
            int seat = groupType.getMaxStudentPerGroup() - current;
            if(seat > 0) {
                // If group has enough space, add students to it.
                List<Student> addedStudents = new ArrayList<>();
                for(int i = 0; i < seat; i++) {
                    if(i >= studentFromDb.size()){
                        break;
                    }
                    Student student = studentFromDb.get(i);
                    student.setClassroom_id(group.getClassroomId());
                    student.setGroup_id(group.getGroupId());
                    studentApi.updateStudent(student);
                    addedStudents.add(student);
                }

                Classroom tempClassroom = classroomApi.getClassroomWithId(group.getClassroomId());
                tempClassroom.setNumOfStudent(tempClassroom.getNumOfStudent() + addedStudents.size());
                classroomApi.updateClassroom(tempClassroom);
                studentFromDb.removeAll(addedStudents);
            }
        }
        return studentFromDb;
    }

    private static void fillNewGroup(List<Student> studentFromDb,
                                     GroupType groupType, ClassroomType classroomType) {
        int totalNewGroup;
        int groupSize = groupType.getMaxStudentPerGroup();
        if(studentFromDb.size() % groupSize == 0) {
            totalNewGroup = studentFromDb.size()/groupSize;
        }else {
            totalNewGroup = studentFromDb.size()/groupSize + 1;
        }

        GroupFactory groupFactory = GroupFactory.getInstance();
        List<Classroom> partialClassroomList =
                classroomApi.getPartialClassroomsByClassroomType(classroomType);

        for(Classroom classroom: partialClassroomList){
            int currentGroupNum = classroom.getNumOfGroup();
            while(currentGroupNum < classroomType.getMaxGroupPerClass()){
                Group newGroup =
                        groupFactory.getObject(currentGroupNum,
                                classroom.getClassroomId());

                List<Student> addedStudents = new ArrayList<>();
                for(int i = 0; i < groupType.getMaxStudentPerGroup() && i < studentFromDb.size();
                    i++) {
                    Student student = studentFromDb.get(i);
                    student.setClassroom_id(classroom.getClassroomId());
                    student.setGroup_id(currentGroupNum);
                    studentApi.updateStudent(student);
                    addedStudents.add(student);
                }
                studentFromDb.removeAll(addedStudents);
                currentGroupNum++;
                classroom.setNumOfStudent(classroom.getNumOfStudent() + addedStudents.size());
                classroom.setNumOfGroup(currentGroupNum);

                groupApi.addGroup(newGroup);
                totalNewGroup--;
                if(totalNewGroup <= 0){
                    break;
                }
            }

            classroomApi.updateClassroom(classroom);
            if(totalNewGroup <= 0){
                break;
            }
        }

        int currentMaxClassroomId = classroomApi.getMaxClassroomId();
        while(totalNewGroup > 0) {
            ClassroomFactory classroomFactory = ClassroomFactory.getInstance();

            Classroom newClassroom = classroomFactory.getObject(currentMaxClassroomId+1,
                    classroomType);
            System.out.println("Created a new classroom   ID: " + currentMaxClassroomId);
            currentMaxClassroomId++;

            int currentGroupNum = newClassroom.getNumOfGroup();
            while(currentGroupNum < classroomType.getMaxGroupPerClass()){
                Group newGroup =
                        groupFactory.getObject(currentGroupNum,
                                newClassroom.getClassroomId());
                System.out.println("Created a new group  ID: " + newGroup.getGroupId());
//                currentGroupNum++;

                List<Student> addedStudents = new ArrayList<>();
                for(int i = 0; i < groupType.getMaxStudentPerGroup() && i < studentFromDb.size();
                    i++) {
                    Student student = studentFromDb.get(i);
                    student.setClassroom_id(newClassroom.getClassroomId());
                    student.setGroup_id(currentGroupNum);
                    studentApi.updateStudent(student);
                    addedStudents.add(student);
                }
                studentFromDb.removeAll(addedStudents);
                currentGroupNum++;
                newClassroom.setNumOfStudent(newClassroom.getNumOfStudent() + addedStudents.size());
                newClassroom.setNumOfGroup(currentGroupNum);

                groupApi.addGroup(newGroup);
                totalNewGroup--;
                if(totalNewGroup <= 0){
                    break;
                }
            }

            classroomApi.addClassroom(newClassroom);
            if(totalNewGroup <= 0){
                break;
            }
        }
    }
}

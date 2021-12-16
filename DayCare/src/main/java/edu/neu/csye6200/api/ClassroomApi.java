package edu.neu.csye6200.api;

import edu.neu.csye6200.api.abstractClass.AbstractClassroom;
import edu.neu.csye6200.api.helper.ClassroomHelper;
import edu.neu.csye6200.dao.ClassroomDao;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.data.GetAllClassroomData;
import edu.neu.csye6200.model.enums.ClassroomType;
import edu.neu.csye6200.model.enums.StatusType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClassroomApi extends AbstractClassroom {

    private static final ClassroomDao classroomDao = new ClassroomDao();

    public static List<Classroom> getPartialClassroomsByClassroomType(ClassroomType classroomType, StatusType statusType) {
        ResultSet rs = classroomDao.getGroupsByGroupTypeAndStatus(classroomType, statusType);
        return ClassroomHelper.convertResultSetToGroupList(rs, classroomType, statusType);
    }

    public static long getMaxClassroomId() {
        long maxId = 0;
        ResultSet rs = classroomDao.getMaxClassroomId();
        try {
            maxId =  rs.getLong("classroom_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId;
    }

    @Override
    public int getClassroomIdByStudentId(long studentId) {
        return 0;
    }

    @Override
    public int getClassroomIdByTeacherId(long teacherId) {
        return 0;
    }

    @Override
    public GetAllClassroomData getAllClassrooms() {
        // todo Implement this
        return new GetAllClassroomData();
    }

    @Override
    public int getNumOfClassrooms() {
        return 0;
    }

    public void addClassroom(Classroom classroom) {
        classroomDao.addClassroom(classroom);
    }
}

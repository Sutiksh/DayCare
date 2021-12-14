package edu.neu.csye6200.api;

import edu.neu.csye6200.api.abstractClass.AbstractTeacher;
import edu.neu.csye6200.api.helper.TeacherHelper;
import edu.neu.csye6200.dao.TeacherDao;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.form.AddTeacherForm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeacherApi extends AbstractTeacher {

    private final TeacherDao dao = new TeacherDao();

    @Override
    public int getNumOfTeachers() {
        return 0;
    }

    @Override
    public double getRating(long teacherId) {
        ResultSet rs = dao.getTeacherRatingById(teacherId);
        if(rs!= null) {
            try {
                return rs.getDouble(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("No record found");
        return 0.0;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return null;
    }

    /**
     * add a teacher to classroom
     * @param teacher
     *
     */
    @Override
    public void addTeacher(Teacher teacher) {
        //Todo check for teacherId for the record in db
        ResultSet rs = dao.getTeacherById(teacher.getTeacherId());
        if(rs == null) {
            dao.addTeacher(teacher);
        } else {
            System.out.println("Record already exists");
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        ResultSet rs = dao.getTeacherById(teacher.getTeacherId());
        if(rs == null) {
            dao.addTeacher(teacher);
        } else {
            dao.updateTeacher(teacher);
        }
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        dao.deleteTeacherFromDb(teacher);
    }

    @Override
    public void deleteTeacher(long teacherId) {
        dao.deleteTeacherFromDb(teacherId);
    }

    public long getTeacherNotAssignedToGroup() {
        long teacherId = 0;
        ResultSet rs = dao.getTeacherNotAssignedToGroup();
        try {
            teacherId = rs.getLong("teacher_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherId;
    }

    public void addTeacher(AddTeacherForm teacherForm) {
        Teacher teacher = TeacherHelper.convertToTeacher(teacherForm);
        addTeacher(teacher);
    }
}

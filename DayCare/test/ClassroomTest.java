//import edu.neu.csye6200.model.Classroom;
//import edu.neu.csye6200.utils.DatabaseUtil;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Objects;
//import org.junit.Test;
//
//public class ClassroomTest {
//
//  @Test
//  public void AddStudentTest(){
//    Classroom classroom = new Classroom();
//
//    String sql = "SELECT student_id FROM student";
//    ResultSet rs = DatabaseUtil.getSQLResult(sql);
//    int count = 0;
//    try{
//      while(Objects.requireNonNull(rs).next()) {
//        long id = rs.getLong("student_id");
//        classroom.addStudent(id);
//        count++;
//        if(count >= 10){
//          break;
//        }
//      }
//    } catch (SQLException e){
//      e.printStackTrace();
//    }
//  }
//
//  @Test
//  public void DeleteStudentTest(){
//    AbstractClassroom classroom = new Classroom(3);
//
//    String sql = "SELECT student_id FROM student";
//    ResultSet rs = DatabaseUtil.getSQLResult(sql);
//    int count = 0;
//    try{
//      while(Objects.requireNonNull(rs).next()) {
//        long id = rs.getLong("student_id");
//        classroom.delStudent(id);
//        count++;
//        if(count >= 10){
//          break;
//        }
//      }
//    } catch (SQLException e){
//      e.printStackTrace();
//    }
//  }
//
//  @Test
//  public void AddTeacherTest(){
//    AbstractClassroom classroom = new Classroom(2);
//    String sql = "SELECT teacher_id FROM teacher";
//    ResultSet rs = DatabaseUtil.getSQLResult(sql);
//    int count = 0;
//    try{
//      while(Objects.requireNonNull(rs).next()) {
//        long id = rs.getLong("teacher_id");
//        classroom.addTeacher(id);
//        count++;
//        if(count >= 5){
//          break;
//        }
//      }
//    } catch (SQLException e){
//      e.printStackTrace();
//    }
//  }
//
//  @Test
//  public void DeleteTeacherTest(){
//    AbstractClassroom classroom = new Classroom(2);
//    String sql = "SELECT teacher_id FROM teacher";
//    ResultSet rs = DatabaseUtil.getSQLResult(sql);
//    int count = 0;
//    try{
//      while(Objects.requireNonNull(rs).next()) {
//        long id = rs.getLong("teacher_id");
//        classroom.delTeacher(id);
//        count++;
//        if(count >= 5){
//          break;
//        }
//      }
//    } catch (SQLException e){
//      e.printStackTrace();
//    }
//  }
//}

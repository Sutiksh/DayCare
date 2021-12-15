import static org.junit.Assert.assertEquals;

import edu.neu.csye6200.api.StudentApi;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.ConvertUtil;
import org.junit.Test;

public class SchoolTest {
//  @Test
//  public void TestSchoolInit(){
//
//  }
//
//  @Test
//  public void TestAddClassRoom(){
//    for(int i = 0; i < 5; i ++){
////      School.addClassroom(i);
//    }
//
//    for(int i = 0; i < 5; i ++){
////      Classroom c = School.classrooms.get(i);
//      assertEquals(c.getClassroomId(), i);
//    }
//  }

  @Test
  public void testStudent() {
    StudentApi studentApi = new StudentApi();
    Student student = getStudentData();
    studentApi.addStudent(student);
  }

  private Student getStudentData() {
    Student student = new Student();
    student.setFirstName("Abc");
    student.setLastName("last");
    student.setEmail("abc@gmail.com");
    student.setPhoneNum(9876543210L);
    student.setDateOfBirth("2021/01/23");
    student.setAge(ConvertUtil.calAge("2021/01/23"));
    student.setAddress("30 South Square");
    student.setRegistrationDate("2021/04/01");
    student.setAnnualRegistrationDate("2022/04/01");
    student.setParentName("Adam");
    return student;
  }

}

package api;

import edu.neu.csye6200.api.StudentApi;
import edu.neu.csye6200.api.concrete.ConcreteStudentApi;
import org.junit.Test;

public class StudentApiTest {

  @Test
  public void getNumOfStudentsTest(){
    StudentApi api = new ConcreteStudentApi();
    System.out.println(api.getNumOfStudents());
  }
}

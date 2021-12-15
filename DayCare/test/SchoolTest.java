import static org.junit.Assert.assertEquals;

import edu.neu.csye6200.model.AbstractClassroom;
import edu.neu.csye6200.model.Classroom;
import org.junit.Test;

public class SchoolTest {
  @Test
  public void TestSchoolInit(){
    School.init();
  }

  @Test
  public void TestAddClassRoom(){
    for(int i = 0; i < 5; i ++){
      School.addClassroom(i);
    }

    for(int i = 0; i < 5; i ++){
      AbstractClassroom c = School.classrooms.get(i);
      assertEquals(c.getClassroomId(), i);
    }
  }


}

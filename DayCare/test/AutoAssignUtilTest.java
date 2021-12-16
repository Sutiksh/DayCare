import edu.neu.csye6200.utils.AutoAssignUtil;
import org.junit.Test;

public class AutoAssignUtilTest {

    @Test
    public void testAutoAssign(){
        AutoAssignUtil.groupingLogicForAllStudents();
        AutoAssignUtil.groupingLogicForAllTeachers();
    }
}

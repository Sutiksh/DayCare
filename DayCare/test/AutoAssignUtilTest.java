import edu.neu.csye6200.dao.StudentDao;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.AutoAssignUtil;
import edu.neu.csye6200.utils.ConvertUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.sql.Date;

public class AutoAssignUtilTest {

    @Test
    public void testAutoAssign(){
        AutoAssignUtil.groupingLogicForAllStudents();
        AutoAssignUtil.groupingLogicForAllTeachers();
    }

    @Test
    public void testAutoAssignSingle(){
        String f_name = "f";
        String l_name = "l";
        String address = "testAddress";
        LocalDate birthday = ConvertUtil.stringtoLocalDate("2019-03-03");
        String eamil = "test@gmail.com";
        long phoneNumber  = 781999999;
        String p_name = "parent";
        int studentId = 1000001;
        Date reg_date = Date.valueOf("2021-09-01");
        Student student = new Student(f_name, l_name, address, birthday,
                eamil, phoneNumber, p_name, studentId, reg_date);

        StudentDao.addStudentDao(student);
        AutoAssignUtil.groupingLogicForSingleStudent(student);
        AutoAssignUtil.groupingLogicForNewGroups();
    }
}

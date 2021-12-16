package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.Immunization;

import java.sql.ResultSet;
import java.sql.SQLException;

import static edu.neu.csye6200.utils.ConvertUtil.*;

public class ImmunizationHelper {
    public static Immunization createImmunization(ResultSet rs) throws SQLException {
        Immunization imm = new Immunization(
                rs.getString("imm_name"),
                stringToInt(rs.getString("student_id")),
                stringToLong(rs.getString("dose_1_id")),
                rs.getDate("dose_1_date").toLocalDate(),
                stringToLong(rs.getString("dose_2_id")),
                rs.getDate("dose_2_date").toLocalDate(),
                stringToLong(rs.getString("dose_3_id")),
                rs.getDate("dose_3_date").toLocalDate(),
                stringToLong(rs.getString("dose_4_id")),
                rs.getDate("dose_4_date").toLocalDate());
        return imm;
    }

    public static int getMinMonthByImmNameDose(String immName, int immDose) {
        switch (immName) {
            case "DTaP":
                switch (immDose) {
                    case 1:
                        return 2;
                    case 2:
                        return 4;
                    case 3:
                        return 6;
                    case 4:
                        return 15;
                }
            case "HepatitisB":
                switch (immDose) {
                    case 1:
                        return 0;
                    case 2:
                        return 1;
                    case 3:
                        return 6;
                }
            case "MMR":
                switch (immDose) {
                    case 1:
                        return 12;
                    case 2:
                        return 48;
                }
            case "Polio":
                switch (immDose) {
                    case 1:
                        return 2;
                    case 2:
                        return 4;
                    case 3:
                        return 6;
                    case 4:
                        return 48;
                }
            case "Varicella":
                switch (immDose) {
                    case 1:
                        return 12;
                    case 2:
                        return 48;
                }
        }
        return Integer.MAX_VALUE;
    }
}

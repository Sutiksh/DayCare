import csv
import random

Title = ["immu_name", "stu_id",
         "does_1_id", "data_of_does_1",
         "does_2_id", "data_of_does_2",
         "does_3_id", "data_of_does_3",
         "does_4_id", "data_of_does_4"]
Imu_Name = ["DTaP", "Polio", "Hepatitis B", "MMR", "Varicella"]
Imu_Does = [4, 4, 3, 2, 2]
DoesIdSet = []


def load_student_id(filename):
    all_stu = []
    f = open(filename)
    for line in f.readlines()[1:]:
        info = line.strip().split(",")
        s_id = info[0]
        s_birth = info[5]
        all_stu.append([s_id, s_birth])
    return all_stu


def get_imu_id(does_year, does_month, does_day):
    if does_month < 10:
        does_month = "0" + str(does_month)
    if does_day < 10:
        does_day = "0" + str(does_day)

    does_id = str(does_year) + str(does_month) + str(does_day) + str(random.randint(100, 999))
    while does_id in DoesIdSet:
        does_id = str(does_year) + str(does_month) + str(does_day) + str(random.randint(100, 999))
    DoesIdSet.append(does_id)
    return does_id


def create_2_does_data(sid, year, month, day, imu_name):
    info = [imu_name, sid]
    does_year = year + 1
    does_month = min(12, month + random.randint(0, 3))
    if does_year == 2021 and does_month >= 9:
        pass
    else:
        does_day = min(28, day + random.randint(0, 7))
        does_id = get_imu_id(does_year, does_month, does_day)
        does_date = str(does_year) + "-" + str(does_month) + "-" + str(does_day)

        info.append(does_id)
        info.append(does_date)

        does_month += 1
        if does_month > 12:
            does_year += 1
            does_month -= 12
            if does_year == 2021 and does_month >= 9:
                pass
            else:
                does_id = get_imu_id(does_year, does_month, does_day)
                does_date = str(does_year) + "-" + str(does_month) + "-" + str(does_day)

                info.append(does_id)
                info.append(does_date)
    while len(info) < 10:
        info.append("")
    return info


def generate_immunization_data(filename):
    f = csv.writer(open(filename, "w", newline=''), dialect="excel")
    f.writerow(Title)

    for s in AllStudents:
        sid, s_birth = s

        year, month, day = s_birth.split("-")
        for i, imu_name in enumerate(Imu_Name[:3]):
            info = [imu_name, sid]
            for does in range(Imu_Does[i]):
                delta_month = does * 12 + random.randint(0, 6)
                does_month = int(month) + delta_month
                does_year = int(year)
                if does_month > 12:
                    does_year += 1
                    does_month = does_month % 12
                    if does_month == 0:
                        does_month = 12
                if does_year == 2021 and does_month >= 9:
                    break

                does_day = min(28, int(day) + random.randint(0, 7))
                does_date = str(does_year) + "-" + str(does_month) + "-" + str(does_day)
                does_id = get_imu_id(does_year, does_month, does_day)

                info.append(does_id)
                info.append(does_date)

            while len(info) < 10:
                info.append("")
            f.writerow(info)

        info = create_2_does_data(sid, int(year), int(month), int(day), Imu_Name[3])
        f.writerow(info)

        info = create_2_does_data(sid, int(year), int(month), int(day), Imu_Name[4])
        f.writerow(info)


if __name__ == '__main__':
    AllStudents = load_student_id("student_data.csv")
    generate_immunization_data("immunization.csv")

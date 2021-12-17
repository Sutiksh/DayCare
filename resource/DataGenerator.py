import csv
import random

<<<<<<< HEAD
StudentNum = 300
TeacherNum = 50

Title_P = ["FirstName", "LastName", "Age(month)", "Address", "PhoneNum"]
Title_S = ["immunizationDate", "registrationDate", "studentId"]
Title_T = ["review", "employeeId"]

IdBase = 1000000
SidBase = 2000000
TidBase = 3000000
PhoneBase = 781000000
=======
StudentNum = 100
TeacherNum = 30

Title_S = ["studentId", "FirstName", "LastName", "Address", "DateOfBirth",
           "parent_name", "email", "registrationDate", "PhoneNum",
           "classroom_id", "group_id", "rating"]
Title_T = ["teacherId", "classroom_id", "group_id",
           "FirstName", "LastName", "DateOfBirth", "Address",
           "parent_name", "PhoneNum",
           "rating"]
Title_I = ["immu_id", "stu_id", "imm_name_dose", "imm_date"]

SidBase = 2000000
TidBase = 3000000
PhoneBase = 781000000
tail_set = []
AddressType = [" Ave, Boston", " Street, Boston", " Road, Boston"]
>>>>>>> 19797caa59c76ed85b0db15bf7504c5b5c0211a4


def load_names(name_file):
    names = []
    f = open(name_file)
    for line in f.readlines():
        info = line.strip().split()
        names.extend(info)

    return names


def generate_student_data(filename):
    student_writer = csv.writer(open(filename, "w", newline=''), dialect="excel")
<<<<<<< HEAD
    student_writer.writerow(Title_P + Title_S)
    pid = IdBase
    stu_id = SidBase
    phone_num = PhoneBase

    for i in range(StudentNum):
        name_idx = random.randint(0, len(Names) - 1)
        first_name = Names[name_idx]
        last_name = Names[(name_idx + 1000) % len(Names)]
        age = random.randint(6, 80)
        # pid += random.randint(1, 11)
        address = Names[(name_idx + 1500) % len(Names)] + " Ave " + str(random.randint(1, 500))
        phone_num += random.randint(1, 1000)
        # parent_name = Names[(name_idx + 2000) % len(Names)]

        immunization_date = "2020-" + str(random.randint(1, 12)) + "-" + str(random.randint(1, 28))
        registration_date = str(random.randint(2018, 2022)) + "-" + str(random.randint(1, 12)) \
                            + "-" + str(random.randint(1, 28))
        # gpa = "%.1f" % (2 + random.random() * 2.0)
        stu_id += random.randint(1, 11)

        info = [first_name, last_name, age,
                address, phone_num,
                immunization_date, registration_date, stu_id]
=======
    student_writer.writerow(Title_S)
    stu_id = SidBase

    for i in range(StudentNum):
        stu_id += random.randint(1, 11)

        name_idx = random.randint(0, len(Names) - 1)
        first_name = Names[name_idx]
        last_name = Names[(name_idx + 1000) % len(Names)]

        address_type = random.randint(0, 2)
        address = str(random.randint(1, 500)) + " " + Names[(name_idx + 1500) % len(Names)] \
                  + AddressType[address_type]

        year = random.randint(2016, 2020)
        month = random.randint(1, 12)
        day = random.randint(1, 28)
        date_of_birth = str(year) + "-" + str(month) + "-" + str(day)

        parent_name = Names[(name_idx + 2000) % len(Names)] + " " + last_name

        email = first_name + "_" + str(random.randint(0, 10000)) + "@outlook.com"

        phone_tail = random.randint(1, 999999)
        while phone_tail in tail_set:
            phone_tail = random.randint(1, 999999)
        tail_set.append(phone_tail)
        phone_num = PhoneBase + phone_tail

        registration_date = str(min(2021, year + random.randint(1, 5))) \
                            + "-9-" + str(random.randint(1, 15))

        info = [stu_id, first_name, last_name, address, date_of_birth,
                parent_name, email, registration_date, phone_num, "", "", ""]
>>>>>>> 19797caa59c76ed85b0db15bf7504c5b5c0211a4

        student_writer.writerow(info)


def generate_teacher_data(filename):
    teacher_writer = csv.writer(open(filename, "w", newline=''), dialect="excel")
<<<<<<< HEAD
    teacher_writer.writerow(Title_P + Title_T)
    pid = IdBase + 3000000
    t_id = TidBase
    phone_num = PhoneBase + 500000

    for i in range(TeacherNum):
        name_idx = random.randint(0, len(Names) - 1)
        first_name = Names[name_idx]
        last_name = Names[(name_idx + 1000) % len(Names)]
        age = random.randint(360, 600)
        # pid += random.randint(1, 11)
        address = Names[(name_idx + 1500) % len(Names)] + " Ave " + str(random.randint(1, 500))
        phone_num += random.randint(1, 1000)
        # parent_name = Names[(name_idx + 2000) % len(Names)]

        review = 0.0
        t_id += random.randint(1, 11)

        info = [first_name, last_name, age,
                address, phone_num,
                review, t_id]
=======
    teacher_writer.writerow(Title_T)

    t_id = TidBase

    for i in range(TeacherNum):
        t_id += random.randint(1, 11)

        name_idx = random.randint(0, len(Names) - 1)
        first_name = Names[name_idx]
        last_name = Names[(name_idx + 1000) % len(Names)]

        address_type = random.randint(0, 2)
        address = str(random.randint(1, 500)) + " " + Names[(name_idx + 1500) % len(Names)] \
                  + AddressType[address_type]

        year = random.randint(1970, 1995)
        month = random.randint(1, 12)
        day = random.randint(1, 28)
        date_of_birth = str(year) + "-" + str(month) + "-" + str(day)

        phone_tail = random.randint(1, 999999)
        while phone_tail in tail_set:
            phone_tail = random.randint(1, 999999)
        tail_set.append(phone_tail)
        phone_num = PhoneBase + phone_tail

        parent_name = Names[(name_idx + 2000) % len(Names)]

        review = 0.0

        info = [t_id, "", "", first_name, last_name, date_of_birth,
                address, parent_name, phone_num, review]
>>>>>>> 19797caa59c76ed85b0db15bf7504c5b5c0211a4

        teacher_writer.writerow(info)


if __name__ == '__main__':
    Names = load_names("names.txt")
    generate_student_data("student_data.csv")
    generate_teacher_data("teachers_data.csv")

import dao.GenericDaoCrud;
import dao.daoimpl.GroupDaoImpl;
import db.GenerateID;
import models.Group;
import models.Student;
import service.GenericServiceCrud;
import service.StudentService;
import service.impl.GroupServiceImpl;
import service.impl.StudentServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        GenericServiceCrud<Group, Long, String> groupService = new GroupServiceImpl();
        GenericServiceCrud<Student, Long, String> studentService = new StudentServiceImpl();
        StudentService studentService1 = new StudentServiceImpl();
        boolean isRun = true;
        while(isRun) {
            while (true) {
                System.out.println("""
                        \nSelect command:
                        1.Add Group
                        2.Get All Group
                        3.Get Group By Id
                        4.Update Group
                        5.Delete Group
                        6.Add Students to Group
                        7.Get All Students
                        8.Get Student By Id
                        9.Update Student
                        10. Delete Student
                        11. Sort Group
                        12. Sort Student
                        13. Exit
                        """);
                int command = scInt.nextInt();
                switch (command) {
                    case 1:
                        groupService.add(new Group(GenerateID.genGroupId(), "group-A", "A.A.", LocalDate.now()));
                        groupService.add(new Group(GenerateID.genGroupId(), "group-B", "B.B.", LocalDate.now()));
                        groupService.add(new Group(GenerateID.genGroupId(), "group-C", "C.C.", LocalDate.now()));
                        break;
                    case 2:
                        System.out.println(groupService.getAll());
                        break;

                    case 3:
                        System.out.println("Enter id to find Group: ");
                        System.out.println(groupService.getById(scInt.nextLong()));
                        break;
                    case 4:
                        System.out.println("Enter id to update Group: ");
                        Long idGoup = scInt.nextLong();
                        Group updateGroup = new Group();
                        System.out.println("Enter new name Group: ");
                        updateGroup.setGroupName(scStr.nextLine());
                        System.out.println("Enter new date: ");
                        updateGroup.setDate(LocalDate.of(scInt.nextInt(), scInt.nextInt(), scInt.nextInt()));
                        System.out.println("Enter new instuctor name: ");
                        updateGroup.setInstructorName(scStr.nextLine());
                        System.out.println(groupService.updateById(idGoup, updateGroup));
                        System.out.println(groupService.getAll());
                        break;
                    case 5:
                        System.out.println("Enter id to delete Group: ");
                        System.out.println(groupService.deleteById(scInt.nextLong()));
                        System.out.println(groupService.getAll());
                        System.out.println("___________________________________________________________________");
                        break;
                    case 11:
                        System.out.println("Enter 'a' / 'z' to sort Group(a->z / z->a): ");
                        groupService.sortByName(scStr.nextLine());
                        break;
                    case 6:
                        System.out.println("___________________________________________________________________");
                        System.out.println("Enter id Group to add Student: ");
                        Long idGroup = scInt.nextLong();
                        Student addStudent = new Student();
                        addStudent.setIdSt(GenerateID.genStudent());
                        System.out.println("Enter full name через пробел: ");
                        String word = scStr.nextLine();
                        String[] line = word.split(" ");
                        String firstName = line[0];
                        String surName = line[1];
                        addStudent.setFirstName(firstName);
                        addStudent.setSurName(surName);
                        System.out.println("Enter phone number: ");
                        addStudent.setPhoneNumber(scStr.nextLine());
                        System.out.println("Enter email: ");
                        addStudent.setEmail(scStr.nextLine());
                        studentService1.addStudentToGroup(idGroup, addStudent);
                        break;
                    case 7:
                        System.out.println(studentService.getAll());
                        break;
                    case 8:
                        System.out.println("Enter id Student: ");
                        System.out.println(studentService.getById(scInt.nextLong()));
                        break;
                    case 9:
                        System.out.println("Enter id Student to update: ");
                        Long idStudent = scInt.nextLong();
                        Student updatestudent = new Student();
                        System.out.println("Enter new first name: ");
                        updatestudent.setFirstName(scStr.nextLine());
                        System.out.println("Enter new surname: ");
                        updatestudent.setSurName(scStr.nextLine());
                        System.out.println("Enter new phone number: ");
                        updatestudent.setPhoneNumber(scStr.nextLine());
                        System.out.println("Enter new email: ");
                        updatestudent.setEmail(scStr.nextLine());
                        System.out.println(studentService.updateById(idStudent, updatestudent));
                        break;
                    case 10:
                        System.out.println("Enter id Student to delete: ");
                        System.out.println(studentService.deleteById(scInt.nextLong()));
                        break;
                    case 12:
                        System.out.println("___________________________________________________________________");
                        System.out.println("Enter 'a' / 'z' to sort Student by first name(a->z / z->a): ");
                        studentService.sortByName(scStr.nextLine());
                        System.out.println("___________________________________________________________________");
                        break;
                    case 13:
                        isRun = false;
                        System.out.println("Program stoped!");
                        break;
                    default: System.out.println("Such command not found!");
                }
                break;
            }
        }
    }
}
package dao.daoimpl;

import dao.GenericDaoCrud;
import dao.StudentDao;
import db.Database;
import models.Group;
import models.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentDaoImpl implements GenericDaoCrud<Student, Long, String>, StudentDao {
    @Override
    public void add(Student student) {
        // ...
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        for(Group group1 : Database.groupList){
            students.addAll(group1.getStudents());
        }
        return students;
    }

    @Override
    public Student getById(Long idStudent) {
        try {
            for (Group group : Database.groupList) {
                for (Student student : group.getStudents()) {
                    if (student.getIdSt().equals(idStudent)) {
                        return student;
                    }
                }
            }
            throw new RuntimeException("Student not found!");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateById(Long idStudent, Student student) {
        try {
            for (Group group : Database.groupList) {
                for (Student groupStudent : group.getStudents()) {
                    groupStudent.setFirstName(student.getFirstName());
                    groupStudent.setSurName(student.getSurName());
                    groupStudent.setPhoneNumber(student.getPhoneNumber());
                    groupStudent.setEmail(student.getEmail());
                    return "Student updated!";
                }
            }
            throw new RuntimeException("Student not found!");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public String deleteById(Long id) {
        try {
            boolean isblock = false;
            for (Group group : Database.groupList) {
                for (Student student : group.getStudents()) {
                    if(student.getIdSt().equals(id)) {
                        isblock = true;
                        group.getStudents().remove(student);
                        //return "Student deleted!";
                    }
                }
            }
            if(!isblock) {
                throw new RuntimeException("Student not found!");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return "Student deleted!";
    }

    @Override
    public void sortByName(String s) {
        for(Group group : Database.groupList){
            if("a".equalsIgnoreCase(s)){
                group.getStudents().sort(Comparator.comparing(Student::getFirstName));
            } else if ("z".equalsIgnoreCase(s)) {
                group.getStudents().sort(Comparator.comparing(Student::getFirstName).reversed());
            }
        }
        for(Group group : Database.groupList){
            for(Student student : group.getStudents()){
                System.out.println(student);
            }
        }
    }

    @Override
    public void addStudentToGroup(Long groupId, Student newStudent) {
        boolean isblock = false;
        try {
            for (Group group : Database.groupList) {
                if (group.getIdGroup().equals(groupId)) {
                    isblock = true;
                    group.getStudents().add(newStudent);
                }
            }
            if(!isblock) {
                throw new RuntimeException("Group not found!");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}

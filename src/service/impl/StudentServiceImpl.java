package service.impl;
import dao.GenericDaoCrud;
import dao.StudentDao;
import dao.daoimpl.GroupDaoImpl;
import dao.daoimpl.StudentDaoImpl;
import db.Database;
import models.Group;
import models.Student;
import service.GenericServiceCrud;
import service.StudentService;

import java.sql.Struct;
import java.util.List;

public class StudentServiceImpl implements GenericServiceCrud <Student, Long, String>, StudentService {

    private final GenericDaoCrud<Student, Long, String> genericDaoCrud = new StudentDaoImpl();

    @Override
    public void add(Student student) {
        //...
    }

    @Override
    public List<Student> getAll() {
        return genericDaoCrud.getAll();
    }

    @Override
    public Student getById(Long idStudent) {
        return genericDaoCrud.getById(idStudent);
    }

    @Override
    public String updateById(Long idStudent, Student student) {
        genericDaoCrud.updateById(idStudent, student);
        return "";
    }

    @Override
    public String deleteById(Long idStudent) {
        genericDaoCrud.deleteById(idStudent);
        return "";
    }

    @Override
    public void sortByName(String s) {
        genericDaoCrud.sortByName(s);
    }

    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void addStudentToGroup(Long groupId, Student newStudent) { //from StudentService
        studentDao.addStudentToGroup(groupId, newStudent);
    }
}

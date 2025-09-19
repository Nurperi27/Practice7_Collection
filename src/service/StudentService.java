package service;

import models.Student;

public interface StudentService{
    void addStudentToGroup(Long groupId, Student newStudent);
}

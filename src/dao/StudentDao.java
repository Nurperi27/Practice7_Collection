package dao;

import models.Student;
import service.GenericServiceCrud;

public interface StudentDao  {
    void addStudentToGroup(Long groupId, Student newStudent);
}

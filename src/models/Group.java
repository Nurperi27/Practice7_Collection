package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private Long idGroup;
    private String GroupName;
    private List<Student> students = new ArrayList<>();
    private String instructorName;
    private LocalDate date;

    public Group() {
    }

    public Group(Long idGroup, String groupName, String instructorName, LocalDate date) {
        this.idGroup = idGroup;
        GroupName = groupName;
        this.instructorName = instructorName;
        this.date = date;
    }

    public Group(Long idGroup, String groupName, List<Student> students, String instructorName, LocalDate date) {
        this.idGroup = idGroup;
        GroupName = groupName;
        this.students = students;
        this.instructorName = instructorName;
        this.date = date;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "\nGroup{" +
                "idGroup=" + idGroup +
                ", GroupName='" + GroupName + '\'' +
                ", students=" + students +
                ", instructorName='" + instructorName + '\'' +
                ", date=" + date +
                '}';
    }
}

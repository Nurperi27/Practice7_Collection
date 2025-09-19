package models;

public class Student {
    private Long idSt;
    private String firstName;
    private String surName;
    private String phoneNumber;
    private String email;
    public Student(){}

    public Student(Long idSt, String firstName, String surName, String phoneNumber, String email) {
        this.idSt = idSt;
        this.firstName = firstName;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getIdSt() {
        return idSt;
    }

    public void setIdSt(Long idSt) {
        this.idSt = idSt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idSt=" + idSt +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

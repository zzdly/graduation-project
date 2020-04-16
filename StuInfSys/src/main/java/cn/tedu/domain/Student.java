package cn.tedu.domain;

import java.util.Date;

public class Student {
    private String name;
    private String cardId;
    private String gender;
    private String studentNumber;
    private String educationBackground;
    private String secondSchool;
    private String major;
    private String classId;
    private Date startTime;
    private String schoolRollState;
    private String phoneNumber;
    private String secondPhoneNumber;
    private String QQ;
    private String email;
    private String addr;

    public Student() {
    }

    public Student(String name, String cardId, String gender, String studentNumber, String educationBackground, String secondSchool, String major, String classId, Date startTime, String schoolRollState, String phoneNumber, String secondPhoneNumber, String QQ, String email, String addr) {
        this.name = name;
        this.cardId = cardId;
        this.gender = gender;
        this.studentNumber = studentNumber;
        this.educationBackground = educationBackground;
        this.secondSchool = secondSchool;
        this.major = major;
        this.classId = classId;
        this.startTime = startTime;
        this.schoolRollState = schoolRollState;
        this.phoneNumber = phoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.QQ = QQ;
        this.email = email;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getSecondSchool() {
        return secondSchool;
    }

    public void setSecondSchool(String secondSchool) {
        this.secondSchool = secondSchool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getSchoolRollState() {
        return schoolRollState;
    }

    public void setSchoolRollState(String schoolRollState) {
        this.schoolRollState = schoolRollState;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", gender='" + gender + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", educationBackground='" + educationBackground + '\'' +
                ", secondSchool='" + secondSchool + '\'' +
                ", major='" + major + '\'' +
                ", classId='" + classId + '\'' +
                ", startTime=" + startTime +
                ", schoolRollState='" + schoolRollState + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", secondPhoneNumber='" + secondPhoneNumber + '\'' +
                ", QQ='" + QQ + '\'' +
                ", email='" + email + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}

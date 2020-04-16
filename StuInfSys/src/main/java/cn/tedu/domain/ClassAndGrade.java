package cn.tedu.domain;

public class ClassAndGrade {
    private String className;//班级名
    private String classQQ;//班级qq
    private String classManifesto;//班级宣言
    private String department;//所属学院
    private String teacherName;//班主任
    private String teacherPhone;//班主任dianhua
    //private String suggest;//建议

    public ClassAndGrade() {
    }

    public ClassAndGrade(String className, String classQQ, String classManifesto, String department, String teacherName, String teacherPhone) {
        this.className = className;
        this.classQQ = classQQ;
        this.classManifesto = classManifesto;
        this.department = department;
        this.teacherName = teacherName;
        this.teacherPhone = teacherPhone;
        //this.suggest = suggest;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassQQ() {
        return classQQ;
    }

    public void setClassQQ(String classQQ) {
        this.classQQ = classQQ;
    }

    public String getClassManifesto() {
        return classManifesto;
    }

    public void setClassManifesto(String classManifesto) {
        this.classManifesto = classManifesto;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    /*public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }*/

    @Override
    public String toString() {
        return "ClassAndGrade{" +
                "className='" + className + '\'' +
                ", classQQ='" + classQQ + '\'' +
                ", classManifesto='" + classManifesto + '\'' +
                ", department='" + department + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                '}';
    }
}

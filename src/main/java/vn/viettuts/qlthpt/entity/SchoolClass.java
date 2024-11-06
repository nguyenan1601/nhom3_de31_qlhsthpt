package vn.viettuts.qlthpt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "class")
@XmlAccessorType(XmlAccessType.FIELD)
public class SchoolClass {

    private int id;
    private String className;
    private Teacher homeRoomTeacher;

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    private List<Student> students;


    public SchoolClass() {
        students = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Teacher getHomeRoomTeacher() {
        return homeRoomTeacher;
    }

    public void setHomeRoomTeacher(Teacher homeRoomTeacher) {
        this.homeRoomTeacher = homeRoomTeacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    // Them hoc sinh vao lop hoc
    public void addStudent(Student student){
        if (!students.contains(student)) {
            students.add(student);
        }
    }
    // Xoa hoc sinh khoi lop
    public void removeStudent(Student student){
        students.remove(student);
    }
}

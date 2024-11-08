package vn.viettuts.qlthpt.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "class")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassRoom {

    private String id;
    private String name;
    private Teacher teacher;
    private int studentCount;

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    private List<Student> students;

    public ClassRoom(String id, String name, Teacher teacher, int studentCount) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.studentCount = studentCount;
        this.students = new ArrayList<>();
    }

    public ClassRoom(String id, String name, String teacher, int studentCount) {
        students = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
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

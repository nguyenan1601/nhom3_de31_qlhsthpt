package vn.viettuts.qlthpt.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "teachers")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeacherXML {

    @XmlElement(name = "teacher")
    private List<Teacher> teachers;

    public List<Teacher> getTeacher() {
        return teachers;
    }

    public void setTeacher(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}

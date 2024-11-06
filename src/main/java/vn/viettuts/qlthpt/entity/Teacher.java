package vn.viettuts.qlthpt.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "teacher")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String fullName;
    private String specialty;

    public Teacher() {
    }

    // Constructor, getters, and setters
    // ...
    public Teacher(int id, String fullName, String specialty) {
        this.id = id;
        this.fullName = fullName;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}

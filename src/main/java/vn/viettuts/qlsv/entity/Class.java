package vn.viettuts.qlsv.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "class")
@XmlAccessorType(XmlAccessType.FIELD)
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;
    private String className;
    private String homeRoomTeacher;

    public Class() {
    }

    public Class(String className, String homeRoomTeacher) {
        this.className = className;
        this.homeRoomTeacher = homeRoomTeacher;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getHomeRoomTeacher() {
        return homeRoomTeacher;
    }

    public void setHomeRoomTeacher(String homeRoomTeacher) {
        this.homeRoomTeacher = homeRoomTeacher;
    }

}

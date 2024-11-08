package vn.viettuts.qlthpt.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "classes")
@XmlAccessorType(XmlAccessType.FIELD)
public class SchoolClassXML {

    @XmlElement(name = "class")
    private List<ClassRoom> classes;

    public List<ClassRoom> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassRoom> classes) {
        this.classes = classes;
    }
}

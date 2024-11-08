package vn.viettuts.qlthpt.entity;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "classlist")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassList {
    private List<ClassRoom> classes;

    public ClassList() {
        classes = new ArrayList<>();
    }

    public List<ClassRoom> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassRoom> classes) {
        this.classes = classes;
    }
}

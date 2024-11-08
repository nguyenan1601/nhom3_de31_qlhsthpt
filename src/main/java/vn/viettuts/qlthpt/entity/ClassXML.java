package vn.viettuts.qlthpt.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "classes")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassXML {
    @XmlElement(name = "class")
    private List<Class> classes;
    public ClassXML(){
        this.classes = new ArrayList<>();
    }
    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}

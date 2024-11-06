package vn.viettuts.qlthpt.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import vn.viettuts.qlthpt.entity.SchoolClass;
import vn.viettuts.qlthpt.entity.SchoolClassXML;

public class SchoolClassDao {

    private static final String SCHOOL_CLASS_XML = "school-class.xml";
    private List<SchoolClass> listClasses;

    public SchoolClassDao() {
        this.listClasses = readListClasses();
    }

    /**
     * Lưu danh sách lớp học vào file
     */
    public void writeListClasses(List<SchoolClass> classes) {
        SchoolClassXML classXML = new SchoolClassXML();
        classXML.setClasses(classes);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SchoolClassXML.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(classXML, new File(SCHOOL_CLASS_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Đọc danh sách lớp học từ file
     */
    public List<SchoolClass> readListClasses() {
        List<SchoolClass> list = new ArrayList<>();
        try {
            File file = new File(SCHOOL_CLASS_XML);
            if (file.exists()) {
                JAXBContext jaxbContext = JAXBContext.newInstance(SchoolClassXML.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                SchoolClassXML classXML = (SchoolClassXML) jaxbUnmarshaller.unmarshal(file);
                if (classXML != null) {
                    list = classXML.getClasses();
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Thêm lớp học vào danh sách
     */
    public void add(SchoolClass schoolClass) {
        listClasses.add(schoolClass);
        writeListClasses(listClasses);
    }

    /**
     * Cập nhật thông tin lớp học
     */
    public void update(SchoolClass schoolClass) {
        for (int i = 0; i < listClasses.size(); i++) {
            if (listClasses.get(i).getClassName().equals(schoolClass.getClassName())) {
                listClasses.set(i, schoolClass);
                break;
            }
        }
        writeListClasses(listClasses);
    }

    /**
     * Xóa lớp học khỏi danh sách
     */
    public boolean delete(String className) {
        boolean isFound = false;
        for (SchoolClass schoolClass : listClasses) {
            if (schoolClass.getClassName().equals(className)) {
                isFound = true;
                listClasses.remove(schoolClass);
                break;
            }
        }
        writeListClasses(listClasses);
        return isFound;
    }

    /**
     * Tìm kiếm lớp học theo tên
     */
    public SchoolClass findByClassName(String className) {
        for (SchoolClass schoolClass : listClasses) {
            if (schoolClass.getClassName().equals(className)) {
                return schoolClass;
            }
        }
        return null;
    }

    /**
     * Lấy danh sách tất cả các lớp học
     */
    public List<SchoolClass> getListClasses() {
        return listClasses;
    }
}

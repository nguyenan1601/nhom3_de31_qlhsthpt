package vn.viettuts.qlthpt.dao;

import vn.viettuts.qlthpt.entity.Class;
import vn.viettuts.qlthpt.entity.ClassXML;
import vn.viettuts.qlthpt.entity.Student;
import vn.viettuts.qlthpt.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class ClassDao {
    private static final String CLASS_FILE_NAME = "class.xml";
    private List<Class> listClasses;

    public ClassDao(){
        this.listClasses = readListClasses();
        if (listClasses == null) {
            listClasses = new ArrayList<>();
        }
    }
    public void writeListClasses(List<Class> classes){
        ClassXML classXML = new ClassXML();
        classXML.setClasses(classes);
        FileUtils.writeXMLtoFile(CLASS_FILE_NAME,classXML);
    }
    public List<Class> readListClasses(){
        List<Class> list = new ArrayList<Class>();
        ClassXML classXML = (ClassXML) FileUtils.readXMLFile(CLASS_FILE_NAME, ClassXML.class);
        if (classXML != null) {
            list=classXML.getClasses();
        }
        return list;
    }

    public void addClass(Class classObj) {
        int id = 1;
        if (listClasses != null && listClasses.size() > 0) {
            id = listClasses.size() + 1;
        }
        classObj.setId(id);
        listClasses.add(classObj);
        writeListClasses(listClasses);
    }
    public void editClass(Class classObj) {
        int size = listClasses.size();
        for (int i = 0; i < size; i++) {
            if (listClasses.get(i).getId() == classObj.getId()) {
                listClasses.set(i, classObj);
                break;
            }
        }
        writeListClasses(listClasses);
    }
    public boolean deleteClass(Class classObj) {
        boolean isFound = false;
        int size = listClasses.size();
        for (int i = 0; i < size; i++) {
            if (listClasses.get(i).getId() == classObj.getId()) {
                classObj = listClasses.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listClasses.remove(classObj);
            writeListClasses(listClasses);
            return true;
        }
        return false;
    }
    public List<Class> getListClasses() {
        return listClasses;
    }
    public Class getClassById(int id) {
        for (Class classObj : listClasses) {
            if (classObj.getId() == id) {
                return classObj;
            }
        }
        return null;
    }
    public List<Student> getStudentsByClassName(String className) {
        for (Class classObj : listClasses) {
            if (classObj.getClassName().equals(className)) {
                return classObj.getStudents();
            }
        }
        return new ArrayList<>();
    }
}

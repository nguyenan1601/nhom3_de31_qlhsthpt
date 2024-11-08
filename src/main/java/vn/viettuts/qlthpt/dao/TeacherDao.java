package vn.viettuts.qlthpt.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.viettuts.qlthpt.entity.Teacher;
import vn.viettuts.qlthpt.entity.TeacherXML;
import vn.viettuts.qlthpt.utils.FileUtils;

public class TeacherDao {

    private static final String TEACHER_FILE_NAME = "teacher.xml";
    private List<Teacher> listTeachers;

    public TeacherDao() {
        this.listTeachers = readListTeachers();
        if (listTeachers == null) {
            listTeachers = new ArrayList<>();
        }
    }

    public void writeListTeachers(List<Teacher> teachers) {
        TeacherXML teacherXML = new TeacherXML();
        teacherXML.setTeacher(teachers);
        FileUtils.writeXMLtoFile(TEACHER_FILE_NAME, teacherXML);
    }

    public List<Teacher> readListTeachers() {
        List<Teacher> list = new ArrayList<>();
        TeacherXML teacherXML = (TeacherXML) FileUtils.readXMLFile(
                TEACHER_FILE_NAME, TeacherXML.class);
        if (teacherXML != null) {
            list = teacherXML.getTeacher();
        }
        return list;
    }

    public void add(Teacher teacher) {
        int id = 1;
        if (listTeachers != null && listTeachers.size() > 0) {
            id = listTeachers.size() + 1;
        }
        teacher.setId(id);
        listTeachers.add(teacher);
        writeListTeachers(listTeachers);
    }

    public void edit(Teacher teacher) {
        int size = listTeachers.size();
        for (int i = 0; i < size; i++) {
            if (listTeachers.get(i).getId() == teacher.getId()) {
                listTeachers.get(i).setName(teacher.getName());
                listTeachers.get(i).setSubject(teacher.getSubject());
                writeListTeachers(listTeachers);
                break;
            }
        }
    }

    public boolean delete(Teacher teacher) {
        boolean isFound = false;
        int size = listTeachers.size();
        for (int i = 0; i < size; i++) {
            if (listTeachers.get(i).getId() == teacher.getId()) {
                teacher = listTeachers.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listTeachers.remove(teacher);
            writeListTeachers(listTeachers);
            return true;
        }
        return false;
    }

    public void sortTeacherByName() {
        Collections.sort(listTeachers, new Comparator<Teacher>() {
            public int compare(Teacher teacher1, Teacher teacher2) {
                return teacher1.getName().compareTo(teacher2.getName());
            }
        });
    }

    public List<Teacher> getListTeachers() {
        return listTeachers;
    }

    public void setListTeachers(List<Teacher> listTeachers) {
        this.listTeachers = listTeachers;
    }
}

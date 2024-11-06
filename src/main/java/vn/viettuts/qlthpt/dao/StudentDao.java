package vn.viettuts.qlthpt.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.viettuts.qlthpt.entity.Student;
import vn.viettuts.qlthpt.entity.StudentXML;
import vn.viettuts.qlthpt.utils.FileUtils;

public class StudentDao {

    private static final String STUDENT_FILE_NAME = "student.xml";
    private List<Student> listStudents;

    public StudentDao() {
        this.listStudents = readListStudents();
        if (listStudents == null) {
            listStudents = new ArrayList<Student>();
        }
    }

    /**
     * Save student objects to student.xml file
     */
    public void writeListStudents(List<Student> students) {
        StudentXML studentXML = new StudentXML();
        studentXML.setStudent(students);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, studentXML);
    }

    /**
     * Read student objects from student.xml file
     */
    public List<Student> readListStudents() {
        List<Student> list = new ArrayList<Student>();
        StudentXML studentXML = (StudentXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, StudentXML.class);
        if (studentXML != null) {
            list = studentXML.getStudent();
        }
        return list;
    }

    /**
     * Add student to listStudents and save to file
     */
    public void add(Student student) {
        int id = 1;
        if (listStudents != null && listStudents.size() > 0) {
            id = listStudents.size() + 1;
        }
        student.setId(id);
        listStudents.add(student);
        writeListStudents(listStudents);
    }

    /**
     * Update student in listStudents and save to file
     */
    public void edit(Student student) {
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                listStudents.get(i).setFullName(student.getFullName());
                listStudents.get(i).setDateOfBirth(student.getDateOfBirth());
                listStudents.get(i).setIdNumber(student.getIdNumber());
                listStudents.get(i).setPermanentAddress(student.getPermanentAddress());
                listStudents.get(i).setClassName(student.getClassName());
                listStudents.get(i).setFatherName(student.getFatherName());
                listStudents.get(i).setFatherPhone(student.getFatherPhone());
                listStudents.get(i).setMotherName(student.getMotherName());
                listStudents.get(i).setMotherPhone(student.getMotherPhone());
                listStudents.get(i).setTalents(student.getTalents());
                listStudents.get(i).setHobbies(student.getHobbies());
                writeListStudents(listStudents);
                break;
            }
        }
    }

    /**
     * Delete student from listStudents and save to file
     */
    public boolean delete(Student student) {
        boolean isFound = false;
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                student = listStudents.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listStudents.remove(student);
            writeListStudents(listStudents);
            return true;
        }
        return false;
    }

    /**
     * Sort student list by name in ascending order
     */
    public void sortStudentByName() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getFullName().compareTo(student2.getFullName());
            }
        });
    }

    /**
     * Sort student list by class name in ascending order
     */
    public void sortStudentByClass() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getClassName().compareTo(student2.getClassName());
            }
        });
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
}

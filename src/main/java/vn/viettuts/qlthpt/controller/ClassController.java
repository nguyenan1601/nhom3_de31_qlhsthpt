package vn.viettuts.qlthpt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vn.viettuts.qlthpt.dao.ClassDao;
import vn.viettuts.qlthpt.entity.Class;
import vn.viettuts.qlthpt.entity.Teacher;
import vn.viettuts.qlthpt.view.ClassView;
import vn.viettuts.qlthpt.view.StudentView;
public class ClassController {
    private ClassDao classDao;
    private ClassView classView;
    private StudentView studentView;
    public ClassController(ClassView view) {
        this.classView = view;
        this.classDao = new ClassDao();

        view.addAddClassListener(new AddClassListener());
        view.addEditClassListener(new EditClassListener());
        view.addDeleteClassListener(new DeleteClassListener());
        view.addClearListener(new ClearListener());
        view.addSearchListener(new SearchListener());
        view.addClassTableSelectionListener(new ClassTableSelectionListener());

        loadClassData();
    }
    class AddClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String className = classView.getClassNameField().getText();
            String teacherName = classView.getTeacherNameField().getText();
            String subject = classView.getTeacherSubjectField().getText();

            if (className.isEmpty() || teacherName.isEmpty() || subject.isEmpty()) {
                JOptionPane.showMessageDialog(classView,
                        "Vui lòng nhập đầy đủ thông tin!");
                return;
            }

            Teacher teacher = new Teacher();
            teacher.setName(teacherName);
            teacher.setSubject(subject);

            Class classObj = new Class();
            classObj.setClassName(className);
            classObj.setTeacher(teacher);

            classDao.addClass(classObj);
            loadClassData();
            clearFields();
        }
    }
    class EditClassListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class DeleteClassListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class ClearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class ClassTableSelectionListener implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) {

        }
    }
    private void loadClassData() {
        List<Class> classes = classDao.getListClasses();
        classView.updateClassTable(classes);
    }
    private void clearFields() {
        classView.getClassNameField().setText("");
        classView.getTeacherNameField().setText("");
        classView.getTeacherSubjectField().setText("");
    }
}

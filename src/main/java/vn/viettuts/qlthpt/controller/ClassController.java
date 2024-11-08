package vn.viettuts.qlthpt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        view.addAddStudentListener(new AddStudentListener());

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
            JOptionPane.showMessageDialog(classView, "Thêm lớp học thành công!");
            loadClassData();
            clearFields();
        }
    }

    class AddStudentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            classView.setVisible(false);
            studentView = new StudentView();
            StudentController studentController = new StudentController(studentView);
            studentController.showStudentView();
        }
    }

    class EditClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = classView.getClassTable().getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(classView,
                        "Vui lòng chọn lớp cần sửa!");
                return;
            }

            String className = classView.getClassNameField().getText();
            String teacherName = classView.getTeacherNameField().getText();
            String subject = classView.getTeacherSubjectField().getText();

            if (className.isEmpty() || teacherName.isEmpty() || subject.isEmpty()) {
                JOptionPane.showMessageDialog(classView,
                        "Vui lòng nhập đầy đủ thông tin!");
                return;
            }

            int id = Integer.parseInt(classView.getClassTable().getValueAt(selectedRow, 0).toString());
            Class existingClass = classDao.getClassById(id);
            if (existingClass != null) {
                Teacher teacher = new Teacher();
                teacher.setName(teacherName);
                teacher.setSubject(subject);

                existingClass.setClassName(className);
                existingClass.setTeacher(teacher);

                classDao.editClass(existingClass);
                JOptionPane.showMessageDialog(classView, "Cập nhật thành công!");
                loadClassData();
                clearFields();
            }
        }
    }

    class DeleteClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = classView.getClassTable().getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(classView,
                        "Vui lòng chọn lớp cần xóa!");
                return;
            }

            int option = JOptionPane.showConfirmDialog(classView,
                    "Bạn có chắc chắn muốn xóa lớp này?",
                    "Xác nhận xóa",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(classView.getClassTable().getValueAt(selectedRow, 0).toString());
                Class classToDelete = classDao.getClassById(id);
                if (classToDelete != null) {
                    if (classDao.deleteClass(classToDelete)) {
                        JOptionPane.showMessageDialog(classView, "Xóa thành công!");
                        loadClassData();
                        clearFields();
                    }
                }
            }
        }
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearFields();
        }
    }

    class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String className = classView.getClassNameField().getText();
            List<Class> searchResults = new ArrayList<>();

            if (className.isEmpty()) {
                loadClassData();
            } else {
                for (Class classObj : classDao.getListClasses()) {
                    if (classObj.getClassName().toLowerCase().contains(className.toLowerCase())) {
                        searchResults.add(classObj);
                    }
                }
                classView.updateClassTable(searchResults);
                if (searchResults.isEmpty()) {
                    JOptionPane.showMessageDialog(classView,
                            "Không tìm thấy lớp nào phù hợp!");
                }
            }
        }
    }

    class ClassTableSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = classView.getClassTable().getSelectedRow();
                if (selectedRow >= 0) {
                    int id = Integer.parseInt(classView.getClassTable().getValueAt(selectedRow, 0).toString());
                    Class selectedClass = classDao.getClassById(id);
                    if (selectedClass != null) {
                        classView.getClassNameField().setText(selectedClass.getClassName());
                        classView.getTeacherNameField().setText(selectedClass.getTeacher().getName());
                        classView.getTeacherSubjectField().setText(selectedClass.getTeacher().getSubject());
                    }
                }
            }
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
        classView.getClassTable().clearSelection();
    }
}

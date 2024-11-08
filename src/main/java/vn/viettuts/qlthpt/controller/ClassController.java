package vn.viettuts.qlthpt.controller;

import vn.viettuts.qlthpt.dao.ClassDao;
import vn.viettuts.qlthpt.entity.ClassRoom;
import vn.viettuts.qlthpt.view.ClassView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClassController {
    private ClassView classView;
    private ClassDao classDao;

    public ClassController(ClassView view) {
        this.classView = view;
        this.classDao = new ClassDao();

        // Khởi tạo view
        classView.setVisible(true);

        // Load dữ liệu từ file XML vào bảng
        loadClassList();

        // Đăng ký các action listener
        classView.addAddClassListener(new AddClassListener());
        classView.addEditClassListener(new EditClassListener());
        classView.addDeleteClassListener(new DeleteClassListener());
        classView.addClearListener(new ClearListener());
        classView.addSearchListener(new SearchListener());
    }
    public void showClassView(){
        List<ClassRoom> classRoomList = classDao.getListClasses();
        classView.setVisible(true);
    }
    public void loadClassList() {
        List<ClassRoom> classList = classDao.getListClasses();
        Object[][] data = new Object[classList.size()][4];
        for (int i = 0; i < classList.size(); i++) {
            ClassRoom classroom = classList.get(i);
            data[i][0] = classroom.getId();
            data[i][1] = classroom.getName();
            data[i][2] = classroom.getTeacher();
            data[i][3] = classroom.getStudentCount();
        }
        classView.updateClassTable(data);
    }

    class AddClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Lấy dữ liệu từ view
                String id = classView.getClassId();
                String name = classView.getClassName();
                String teacher = classView.getTeacherName();
                int studentCount = Integer.parseInt(classView.getStudentCount());

                // Validate dữ liệu
                if (id.isEmpty() || name.isEmpty() || teacher.isEmpty()) {
                    classView.showMessage("Vui lòng nhập đầy đủ thông tin!");
                    return;
                }

                // Tạo đối tượng classroom mới
                ClassRoom classroom = new ClassRoom(id, name, teacher, studentCount);

                // Thêm vào DAO
                if (classDao.addClass(classroom)) {
                    loadClassList();
                    classView.showMessage("Thêm lớp học thành công!");
                    classView.clearFields();
                } else {
                    classView.showMessage("ID lớp học đã tồn tại!");
                }
            } catch (NumberFormatException ex) {
                classView.showMessage("Số học sinh phải là số!");
            }
        }
    }

    class EditClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Lấy dữ liệu từ view
                String id = classView.getClassId();
                String name = classView.getClassName();
                String teacher = classView.getTeacherName();
                int studentCount = Integer.parseInt(classView.getStudentCount());

                // Validate dữ liệu
                if (id.isEmpty() || name.isEmpty() || teacher.isEmpty()) {
                    classView.showMessage("Vui lòng nhập đầy đủ thông tin!");
                    return;
                }

                // Tạo đối tượng classroom mới
                ClassRoom classroom = new ClassRoom(id, name, teacher, studentCount);

                // Cập nhật trong DAO
                if (classDao.editClass(classroom)) {
                    loadClassList();
                    classView.showMessage("Cập nhật lớp học thành công!");
                    classView.clearFields();
                } else {
                    classView.showMessage("Không tìm thấy lớp học cần sửa!");
                }
            } catch (NumberFormatException ex) {
                classView.showMessage("Số học sinh phải là số!");
            }
        }
    }

    class DeleteClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = classView.getClassId();
            if (id.isEmpty()) {
                classView.showMessage("Vui lòng nhập ID lớp học cần xóa!");
                return;
            }

            if (classDao.deleteClass(id)) {
                loadClassList();
                classView.showMessage("Xóa lớp học thành công!");
                classView.clearFields();
            } else {
                classView.showMessage("Không tìm thấy lớp học cần xóa!");
            }
        }
    }

    class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchText = classView.getSearchText();
            if (searchText.isEmpty()) {
                loadClassList();
                return;
            }

            List<ClassRoom> searchResult = classDao.searchClasses(searchText);
            Object[][] data = new Object[searchResult.size()][4];
            for (int i = 0; i < searchResult.size(); i++) {
                ClassRoom classroom = searchResult.get(i);
                data[i][0] = classroom.getId();
                data[i][1] = classroom.getName();
                data[i][2] = classroom.getTeacher();
                data[i][3] = classroom.getStudentCount();
            }
            classView.updateClassTable(data);
        }
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            classView.clearFields();
        }
    }
}

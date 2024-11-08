package vn.viettuts.qlthpt.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import vn.viettuts.qlthpt.entity.ClassList;
import vn.viettuts.qlthpt.entity.ClassRoom;
import vn.viettuts.qlthpt.entity.Teacher;
import vn.viettuts.qlthpt.utils.FileUtils;

public class ClassDao {
    private static final String CLASS_FILE_NAME = "class.xml";
    private ClassList classList;

    public ClassDao() {
        this.classList = readListClasses();
        if (classList == null) {
            classList = new ClassList();
        }
    }

    /**
     * Lưu danh sách lớp học vào file
     */
    public void writeListClasses() {
        FileUtils.writeXMLtoFile(CLASS_FILE_NAME, classList);
    }

    /**
     * Đọc danh sách lớp học từ file
     */
    public ClassList readListClasses() {
        return (ClassList) FileUtils.readXMLFile(CLASS_FILE_NAME, ClassList.class);
    }

    /**
     * Thêm lớp học vào danh sách
     */
    public boolean addClass(ClassRoom classroom) {
        // Kiểm tra xem ID đã tồn tại chưa
        for (ClassRoom existing : classList.getClasses()) {
            if (existing.getId().equals(classroom.getId())) {
                return false;
            }
        }
        classList.getClasses().add(classroom);
        writeListClasses();
        return true;
    }

    /**
     * Cập nhật thông tin lớp học
     */
    public boolean editClass(ClassRoom classroom) {
        for (int i = 0; i < classList.getClasses().size(); i++) {
            if (classList.getClasses().get(i).getId().equals(classroom.getId())) {
                classList.getClasses().set(i, classroom);
                writeListClasses();
                return true;
            }
        }
        return false;
    }

    /**
     * Xóa lớp học khỏi danh sách
     */
    public boolean deleteClass(String id) {
        for (ClassRoom classroom : classList.getClasses()) {
            if (classroom.getId().equals(id)) {
                classList.getClasses().remove(classroom);
                writeListClasses();
                return true;
            }
        }
        return false;
    }

    /**
     * Lấy danh sách tất cả các lớp học
     */
    public List<ClassRoom> getListClasses() {
        return classList.getClasses();
    }

    /**
     * Tìm kiếm lớp học theo từ khóa
     */
    public List<ClassRoom> searchClasses(String keyword) {
        List<ClassRoom> searchResult = new ArrayList<>();
        if (keyword == null) {
            return searchResult;
        }

        keyword = keyword.toLowerCase();

        for (ClassRoom classroom : classList.getClasses()) {
            Teacher teacher = classroom.getTeacher();
            if (Objects.toString(classroom.getId(), "").toLowerCase().contains(keyword) ||
                    Objects.toString(classroom.getName(), "").toLowerCase().contains(keyword) ||
                    (teacher != null && (
                            Objects.toString(teacher.getName(), "").toLowerCase().contains(keyword) ||
                                    Objects.toString(teacher.getId(), "").toLowerCase().contains(keyword) ||
                                    Objects.toString(teacher.getSubject(), "").toLowerCase().contains(keyword)
                    ))) {
                searchResult.add(classroom);
            }
        }
        return searchResult;
    }
}
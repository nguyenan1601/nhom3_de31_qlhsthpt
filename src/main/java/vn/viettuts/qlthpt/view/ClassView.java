package vn.viettuts.qlthpt.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import vn.viettuts.qlthpt.entity.Class;
import vn.viettuts.qlthpt.entity.Student;
import vn.viettuts.qlthpt.entity.Teacher;

public class ClassView extends JFrame implements ActionListener, ListSelectionListener {
    private JButton addClassBtn;
    private JButton editClassBtn;
    private JButton deleteClassBtn;
    private JButton addStudentBtn;
    private JButton clearBtn;
    private JButton searchBtn;

    private JTextField classNameField;
    private JTextField teacherNameField;
    private JTextField teacherSubjectField;
    private JTextField searchField;

    private JTable classTable;
    private JTable studentTable;
    private DefaultTableModel classTableModel;
    private DefaultTableModel studentTableModel;

    private JScrollPane classScrollPane;
    private JScrollPane studentScrollPane;

    public ClassView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Lớp Học");
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Main panel với SpringLayout
        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);

        // Tạo các components
        JLabel classNameLabel = new JLabel("Tên lớp:");
        JLabel teacherNameLabel = new JLabel("Giáo viên:");
        JLabel teacherSubjectLabel = new JLabel("Môn dạy:");
        JLabel searchLabel = new JLabel("Tìm kiếm:");

        classNameField = new JTextField(20);
        teacherNameField = new JTextField(20);
        teacherSubjectField = new JTextField(20);
        searchField = new JTextField(20);

        addClassBtn = new JButton("Thêm Lớp");
        editClassBtn = new JButton("Sửa Lớp");
        deleteClassBtn = new JButton("Xóa Lớp");
        addStudentBtn = new JButton("Thêm Học Sinh");
        clearBtn = new JButton("Xóa Form");
        searchBtn = new JButton("Tìm Kiếm");

        // Tạo bảng lớp học
        classTableModel = new DefaultTableModel();
        classTableModel.addColumn("ID");
        classTableModel.addColumn("Tên Lớp");
        classTableModel.addColumn("Giáo Viên");
        classTableModel.addColumn("Môn Dạy");
        classTableModel.addColumn("Số Học Sinh");

        classTable = new JTable(classTableModel);
        classTable.getSelectionModel().addListSelectionListener(this);
        classScrollPane = new JScrollPane(classTable);
        classScrollPane.setPreferredSize(new Dimension(900, 200));

        // Tạo bảng học sinh
        studentTableModel = new DefaultTableModel();
        studentTableModel.addColumn("ID");
        studentTableModel.addColumn("Họ Tên");
        studentTableModel.addColumn("Ngày sinh");
        studentTableModel.addColumn("CCCD");
        studentTableModel.addColumn("Hộ khẩu");
        studentTableModel.addColumn("Tên lớp");
        studentTableModel.addColumn("Tên bố");
        studentTableModel.addColumn("SĐT bố");
        studentTableModel.addColumn("Tên mẹ");
        studentTableModel.addColumn("SĐT mẹ");
        studentTableModel.addColumn("Năng khiếu");
        studentTableModel.addColumn("Sở thích");

        studentTable = new JTable(studentTableModel);
        studentScrollPane = new JScrollPane(studentTable);
        studentScrollPane.setPreferredSize(new Dimension(900, 200));

        // Thêm components vào panel
        mainPanel.add(classNameLabel);
        mainPanel.add(classNameField);
        mainPanel.add(teacherNameLabel);
        mainPanel.add(teacherNameField);
        mainPanel.add(teacherSubjectLabel);
        mainPanel.add(teacherSubjectField);
        mainPanel.add(searchLabel);
        mainPanel.add(searchField);
        mainPanel.add(addClassBtn);
        mainPanel.add(editClassBtn);
        mainPanel.add(deleteClassBtn);
        mainPanel.add(addStudentBtn);
        mainPanel.add(clearBtn);
        mainPanel.add(searchBtn);
        mainPanel.add(classScrollPane);
        mainPanel.add(studentScrollPane);

        // Định vị trí các components bằng SpringLayout
        // Hàng 1: Tên lớp
        layout.putConstraint(SpringLayout.WEST, classNameLabel, 10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, classNameLabel, 10, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, classNameField, 10, SpringLayout.EAST, classNameLabel);
        layout.putConstraint(SpringLayout.NORTH, classNameField, 10, SpringLayout.NORTH, mainPanel);

        // Hàng 2: Giáo viên
        layout.putConstraint(SpringLayout.WEST, teacherNameLabel, 10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, teacherNameLabel, 20, SpringLayout.SOUTH, classNameLabel);
        layout.putConstraint(SpringLayout.WEST, teacherNameField, 10, SpringLayout.EAST, teacherNameLabel);
        layout.putConstraint(SpringLayout.NORTH, teacherNameField, 20, SpringLayout.SOUTH, classNameField);

        // Hàng 3: Môn dạy
        layout.putConstraint(SpringLayout.WEST, teacherSubjectLabel, 10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, teacherSubjectLabel, 20, SpringLayout.SOUTH, teacherNameLabel);
        layout.putConstraint(SpringLayout.WEST, teacherSubjectField, 10, SpringLayout.EAST, teacherSubjectLabel);
        layout.putConstraint(SpringLayout.NORTH, teacherSubjectField, 20, SpringLayout.SOUTH, teacherNameField);

        // Tìm kiếm
        layout.putConstraint(SpringLayout.EAST, searchLabel, -220, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, searchLabel, 10, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, searchField, 10, SpringLayout.EAST, searchLabel);
        layout.putConstraint(SpringLayout.NORTH, searchField, 10, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.EAST, searchBtn, -10, SpringLayout.EAST, searchField);
        layout.putConstraint(SpringLayout.NORTH, searchBtn, 10, SpringLayout.SOUTH, searchField);

        // Các nút chức năng
        layout.putConstraint(SpringLayout.WEST, addClassBtn, 10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, addClassBtn, 30, SpringLayout.SOUTH, teacherSubjectField);

        layout.putConstraint(SpringLayout.WEST, editClassBtn, 20, SpringLayout.EAST, addClassBtn);
        layout.putConstraint(SpringLayout.NORTH, editClassBtn, 30, SpringLayout.SOUTH, teacherSubjectField);

        layout.putConstraint(SpringLayout.WEST, deleteClassBtn, 20, SpringLayout.EAST, editClassBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteClassBtn, 30, SpringLayout.SOUTH, teacherSubjectField);

        layout.putConstraint(SpringLayout.WEST, addStudentBtn, 20, SpringLayout.EAST, deleteClassBtn);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 30, SpringLayout.SOUTH, teacherSubjectField);

        layout.putConstraint(SpringLayout.WEST, clearBtn, 20, SpringLayout.EAST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 30, SpringLayout.SOUTH, teacherSubjectField);

        // Bảng lớp học
        layout.putConstraint(SpringLayout.WEST, classScrollPane, 10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, classScrollPane, 30, SpringLayout.SOUTH, addClassBtn);

        // Bảng học sinh
        layout.putConstraint(SpringLayout.WEST, studentScrollPane, 10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, studentScrollPane, 20, SpringLayout.SOUTH, classScrollPane);

        // Thêm action listeners
        addClassBtn.addActionListener(this);
        editClassBtn.addActionListener(this);
        deleteClassBtn.addActionListener(this);
        addStudentBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        searchBtn.addActionListener(this);

        // Thêm mainPanel vào frame
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
    public void updateClassTable(List<Class> classes) {
        classTableModel.setRowCount(0);
        for (Class classObj : classes) {
            classTableModel.addRow(new Object[]{
                    classObj.getId(),
                    classObj.getClassName(),
                    classObj.getTeacher().getName(),
                    classObj.getTeacher().getSubject(),
                    classObj.getStudents().size()
            });
        }
    }
    public void updateStudentTable(List<Student> students) {
        studentTableModel.setRowCount(0);
        for (Student student : students) {
            studentTableModel.addRow(new Object[]{
                    student.getId(),
                    student.getFullName(),
                    student.getDateOfBirth(),
                    student.getIdNumber(),
                    student.getPermanentAddress(),
                    student.getClassName(),
                    student.getFatherName(),
                    student.getFatherPhone(),
                    student.getMotherName(),
                    student.getMotherPhone(),
                    student.getTalents(),
                    student.getHobbies()
            });
        }
    }
    public JTextField getClassNameField() {
        return classNameField;
    }

    public JTextField getTeacherNameField() {
        return teacherNameField;
    }

    public JTextField getTeacherSubjectField() {
        return teacherSubjectField;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JTable getClassTable() {
        return classTable;
    }

    public JTable getStudentTable() {
        return studentTable;
    }
    public void addAddClassListener(ActionListener listener){
        addClassBtn.addActionListener(listener);
    }
    public void addEditClassListener(ActionListener listener){
        editClassBtn.addActionListener(listener);
    }
    public void addDeleteClassListener(ActionListener listener){
        deleteClassBtn.addActionListener(listener);
    }
    public void addClearListener(ActionListener listener){
        clearBtn.addActionListener(listener);
    }
    public void addSearchListener(ActionListener listener){
        searchBtn.addActionListener(listener);
    }
    public void addClassTableSelectionListener(ListSelectionListener listener){
        classTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void addAddStudentListener(ActionListener listener) { addStudentBtn.addActionListener(listener);}
}

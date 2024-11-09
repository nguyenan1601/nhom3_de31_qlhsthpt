package vn.viettuts.qlthpt.view;

import vn.viettuts.qlthpt.entity.Student;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class StudentView extends JFrame implements ActionListener, ListSelectionListener {

    private static final long serialVersionUID = 1L;
    private JButton addStudentBtn;
    private JButton editStudentBtn;
    private JButton deleteStudentBtn;
    private JButton clearBtn;
    private JButton sortStudentNameBtn;
    private JScrollPane jScrollPaneStudentTable;
    private JTable studentTable;
//...other existing code 
    private JLabel idLabel, fullNameLabel, dateOfBirthLabel, idNumberLabel, permanentAddressLabel,
            classNameLabel, fatherNameLabel, fatherPhoneLabel, motherNameLabel, motherPhoneLabel,
            talentLabel, hobbiesLabel;

    private JTextField idField, fullNameField, dateOfBirthField, idNumberField, classNameField,
            fatherNameField, fatherPhoneField, motherNameField, motherPhoneField, talentField;
    private JTextField permanentAddressField, hobbiesField;

    // định nghĩa các cột của bảng student
    private String[] columnNames = new String[]{
            "ID", "Full Name", "Date of Birth", "ID Number", "Permanent Address", "Class Name",
            "Father Name", "Father Phone", "Mother Name", "Mother Phone", "Talent", "Hobbies"
    };
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private Object data = new Object[][]{};

    public StudentView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addStudentBtn = new JButton("Add");
        editStudentBtn = new JButton("Edit");
        deleteStudentBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        sortStudentNameBtn = new JButton("Sort By Name");
        // khởi tạo bảng student
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();

        // khởi tạo các label
        idLabel = new JLabel("ID");
        fullNameLabel = new JLabel("Full Name");
        dateOfBirthLabel = new JLabel("Date of Birth");
        idNumberLabel = new JLabel("ID Number");
        permanentAddressLabel = new JLabel("Permanent Address");
        classNameLabel = new JLabel("Class Name");
        fatherNameLabel = new JLabel("Father Name");
        fatherPhoneLabel = new JLabel("Father Phone");
        motherNameLabel = new JLabel("Mother Name");
        motherPhoneLabel = new JLabel("Mother Phone");
        talentLabel = new JLabel("Talent");
        hobbiesLabel = new JLabel("Hobbies");

        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(6);
        idField.setEditable(false);
        fullNameField = new JTextField(15);
        dateOfBirthField = new JTextField(10);
        idNumberField = new JTextField(15);
        permanentAddressField = new JTextField();
        permanentAddressField.setColumns(15);
        classNameField = new JTextField(10);
        fatherNameField = new JTextField(15);
        fatherPhoneField = new JTextField(10);
        motherNameField = new JTextField(15);
        motherPhoneField = new JTextField(10);
        talentField = new JTextField(15);
        hobbiesField = new JTextField();
        hobbiesField.setColumns(15);

        // cài đặt các cột và data cho bảng student
        studentTable.setModel(new DefaultTableModel(new Object[][]{}, columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension(800, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
//        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);

        panel.add(addStudentBtn);
        panel.add(editStudentBtn);
        panel.add(deleteStudentBtn);
        panel.add(clearBtn);
        panel.add(sortStudentNameBtn);

        panel.add(idLabel);
        panel.add(fullNameLabel);
        panel.add(dateOfBirthLabel);
        panel.add(idNumberLabel);
        panel.add(permanentAddressLabel);
        panel.add(classNameLabel);
        panel.add(fatherNameLabel);
        panel.add(fatherPhoneLabel);
        panel.add(motherNameLabel);
        panel.add(motherPhoneLabel);
        panel.add(talentLabel);
        panel.add(hobbiesLabel);

        panel.add(idField);
        panel.add(fullNameField);
        panel.add(dateOfBirthField);
        panel.add(idNumberField);
        panel.add(classNameField);
        panel.add(fatherNameField);
        panel.add(fatherPhoneField);
        panel.add(motherNameField);
        panel.add(motherPhoneField);
        panel.add(talentField);
        panel.add(permanentAddressField);
        panel.add(hobbiesField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, idField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, fullNameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fullNameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, fullNameField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fullNameField, 40, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, dateOfBirthLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dateOfBirthLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dateOfBirthField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dateOfBirthField, 70, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, idNumberLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idNumberLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, idNumberField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idNumberField, 100, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, permanentAddressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, permanentAddressLabel, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, permanentAddressField, 30, SpringLayout.EAST, permanentAddressLabel);
        layout.putConstraint(SpringLayout.NORTH, permanentAddressField, 10, SpringLayout.SOUTH, idNumberField);

        layout.putConstraint(SpringLayout.WEST, classNameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, classNameLabel, 210, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, classNameField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, classNameField, 210, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, fatherNameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fatherNameLabel, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, fatherNameField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fatherNameField, 240, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, fatherPhoneLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fatherPhoneLabel, 270, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, fatherPhoneField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fatherPhoneField, 270, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, motherNameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, motherNameLabel, 300, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, motherNameField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, motherNameField, 300, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, motherPhoneLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, motherPhoneLabel, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, motherPhoneField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, motherPhoneField, 330, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, talentLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, talentLabel, 360, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, talentField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, talentField, 360, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, hobbiesLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, hobbiesLabel, 390, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, hobbiesField, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, hobbiesField, 390, SpringLayout.NORTH, panel);

// Cài đặt vị trí của bảng studentTable
        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 320, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);

// Cài đặt vị trí các nút chức năng
        layout.putConstraint(SpringLayout.WEST, addStudentBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 430, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editStudentBtn, 80, SpringLayout.WEST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, editStudentBtn, 430, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 80, SpringLayout.WEST, editStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, 430, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 430, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortStudentNameBtn, 320, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, 430, SpringLayout.NORTH, panel);


        this.add(panel);
        this.pack();
        this.setTitle("Student Information");
        this.setSize(1300, 600);
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list student vào bảng studentTable
     *
     * @param list
     */
    public void showListStudents(List<Student> list) {
        int size = list.size();
        Object[][] students = new Object[size][12];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getFullName();
            students[i][2] = list.get(i).getDateOfBirth();
            students[i][3] = list.get(i).getIdNumber();
            students[i][4] = list.get(i).getPermanentAddress();
            students[i][5] = list.get(i).getClassName();
            students[i][6] = list.get(i).getFatherName();
            students[i][7] = list.get(i).getFatherPhone();
            students[i][8] = list.get(i).getMotherName();
            students[i][9] = list.get(i).getMotherPhone();
            students[i][10] = list.get(i).getTalents();
            students[i][11] = list.get(i).getHobbies();

        }
        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }

    /**
     * điền thông tin của hàng được chọn từ bảng student vào các trường tương ứng của student.
     */
    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = studentTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
            fullNameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
            dateOfBirthField.setText(studentTable.getModel().getValueAt(row, 2).toString());
            idNumberField.setText(studentTable.getModel().getValueAt(row, 3).toString());
            permanentAddressField.setText(studentTable.getModel().getValueAt(row, 4).toString());
            classNameField.setText(studentTable.getModel().getValueAt(row, 5).toString());
            fatherNameField.setText(studentTable.getModel().getValueAt(row, 6).toString());
            fatherPhoneField.setText(studentTable.getModel().getValueAt(row, 7).toString());
            motherNameField.setText(studentTable.getModel().getValueAt(row, 8).toString());
            motherPhoneField.setText(studentTable.getModel().getValueAt(row, 9).toString());
            talentField.setText(studentTable.getModel().getValueAt(row, 10).toString());
            hobbiesField.setText(studentTable.getModel().getValueAt(row, 11).toString());
            // enable Edit and Delete buttons
            editStudentBtn.setEnabled(true);
            deleteStudentBtn.setEnabled(true);
            // disable Add button
            addStudentBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin student
     */
    public void clearStudentInfo() {
        idField.setText("");
        fullNameField.setText("");
        dateOfBirthField.setText("");
        idNumberField.setText("");
        permanentAddressField.setText("");
        classNameField.setText("");
        fatherNameField.setText("");
        fatherPhoneField.setText("");
        motherNameField.setText("");
        motherPhoneField.setText("");
        talentField.setText("");
        hobbiesField.setText("");
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }

    /**
     * hiện thị thông tin student
     *
     * @param student
     */
    public void showStudent(Student student) {
        idField.setText("" + student.getId());
        fullNameField.setText(student.getFullName());
        dateOfBirthField.setText(""+student.getDateOfBirth());
        idNumberField.setText(student.getIdNumber());
        permanentAddressField.setText(student.getPermanentAddress());
        classNameField.setText(student.getClassName());
        fatherNameField.setText(student.getFatherName());
        fatherPhoneField.setText(student.getFatherPhone());
        motherNameField.setText(student.getMotherName());
        motherPhoneField.setText(student.getMotherPhone());
        talentField.setText(student.getTalents());
        hobbiesField.setText(student.getHobbies());
        // enable Edit and Delete buttons
        editStudentBtn.setEnabled(true);
        deleteStudentBtn.setEnabled(true);
        // disable Add button
        addStudentBtn.setEnabled(false);
    }

    /**
     * lấy thông tin student
     *
     * @return
     */
    public Student getStudentInfo() {
        // validate student
        if (!validateName() || !validateAddress()) {
            return null;
        }
        try {
            Student student = new Student();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                student.setId(Integer.parseInt(idField.getText()));
            }
//            student.setName(nameField.getText().trim());
//            student.setAge(Byte.parseByte(ageField.getText().trim()));
//            student.setAddress(addressTA.getText().trim());
//            student.setGpa(Float.parseFloat(gpaField.getText().trim()));
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private boolean validateName() {
        String name = fullNameField.getText();
        if (name == null || "".equals(name.trim())) {
            fullNameField.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAddress() {
        String address = permanentAddressField.getText();
        if (address == null || "".equals(address.trim())) {
            permanentAddressField.requestFocus();
            showMessage("Address không được trống.");
            return false;
        }
        return true;
    }



    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddStudentListener(ActionListener listener) {
        addStudentBtn.addActionListener(listener);
    }

    public void addEdiStudentListener(ActionListener listener) {
        editStudentBtn.addActionListener(listener);
    }

    public void addDeleteStudentListener(ActionListener listener) {
        deleteStudentBtn.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public void addSortStudentNameListener(ActionListener listener) {
        sortStudentNameBtn.addActionListener(listener);
    }

    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }
}

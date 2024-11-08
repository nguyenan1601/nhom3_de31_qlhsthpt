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
import javax.swing.JTextArea;
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
    private JButton sortStudentGPABtn;
    private JButton sortStudentNameBtn;
    private JScrollPane jScrollPaneStudentTable;
    private JScrollPane jScrollPaneAddress;
    private JTable studentTable;

    private JLabel birthDateLabel, cccdLabel, classNameLabel;
    private JLabel fatherNameLabel, fatherPhoneLabel;
    private JLabel motherNameLabel, motherPhoneLabel;
    private JLabel talentLabel, hobbyLabel;
    private JLabel idLabel, nameLabel, addressLabel;

    private JTextField birthDateField, cccdField, classNameField;
    private JTextField fatherNameField, fatherPhoneField;
    private JTextField motherNameField, motherPhoneField;
    private JTextField talentField, hobbyField;
    private JTextField idField, nameField;
    private JTextArea addressTA;

    // định nghĩa các cột của bảng student
    private String[] columnNames = new String[]{
            "ID", "Họ tên", "Ngày sinh", "CCCD", "Hộ khẩu", "Tên lớp",
            "Tên bố", "SĐT bố", "Tên mẹ", "SĐT mẹ", "Năng khiếu", "Sở thích"
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
        // Initialize new labels
        birthDateLabel = new JLabel("Ngày sinh");
        cccdLabel = new JLabel("CCCD");
        classNameLabel = new JLabel("Tên lớp");
        fatherNameLabel = new JLabel("Tên bố");
        fatherPhoneLabel = new JLabel("SDT bố");
        motherNameLabel = new JLabel("Tên mẹ");
        motherPhoneLabel = new JLabel("SDT mẹ");
        talentLabel = new JLabel("Năng khiếu");
        hobbyLabel = new JLabel("Sở thích");

        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        birthDateField = new JTextField(15);
        cccdField = new JTextField(15);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(3);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        classNameField = new JTextField(15);
        fatherNameField = new JTextField(15);
        fatherPhoneField = new JTextField(15);
        motherNameField = new JTextField(15);
        motherPhoneField = new JTextField(15);
        talentField = new JTextField(15);
        hobbyField = new JTextField(15);

        // cài đặt các cột và data cho bảng student
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension(480, 300));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);

        panel.add(addStudentBtn);
        panel.add(editStudentBtn);
        panel.add(deleteStudentBtn);
        panel.add(clearBtn);
        panel.add(sortStudentNameBtn);

        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(birthDateLabel);
        panel.add(cccdLabel);
        panel.add(addressLabel);
        panel.add(classNameLabel);
        panel.add(fatherNameLabel);
        panel.add(fatherPhoneLabel);
        panel.add(motherNameLabel);
        panel.add(motherPhoneLabel);
        panel.add(talentLabel);
        panel.add(hobbyLabel);

        // Add input fields
        panel.add(idField);
        panel.add(nameField);
        panel.add(birthDateField);
        panel.add(cccdField);
        panel.add(jScrollPaneAddress);
        panel.add(classNameField);
        panel.add(fatherNameField);
        panel.add(fatherPhoneField);
        panel.add(motherNameField);
        panel.add(motherPhoneField);
        panel.add(talentField);
        panel.add(hobbyField);


        // Layout constraints for labels
        int baseX = 10;
        int baseY = 10;
        int yIncrement = 30;
        int labelWidth = 100;
        int fieldX = baseX + labelWidth;

        // cài đặt vị trí các thành phần trên màn hình login
        // Position labels
        layout.putConstraint(SpringLayout.WEST, idLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, baseY, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, nameLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, baseY + yIncrement, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, birthDateLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, birthDateLabel, baseY + yIncrement * 2, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, cccdLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, cccdLabel, baseY + yIncrement * 3, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addressLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, baseY + yIncrement * 4, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, classNameLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, classNameLabel, baseY + yIncrement * 7, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, fatherNameLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fatherNameLabel, baseY + yIncrement * 8, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, fatherPhoneLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fatherPhoneLabel, baseY + yIncrement * 9, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, motherNameLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, motherNameLabel, baseY + yIncrement * 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, motherPhoneLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, motherPhoneLabel, baseY + yIncrement * 11, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, talentLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, talentLabel, baseY + yIncrement * 12, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, hobbyLabel, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, hobbyLabel, baseY + yIncrement * 13, SpringLayout.NORTH, panel);

        // Position fields
        layout.putConstraint(SpringLayout.WEST, idField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, baseY, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, nameField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, baseY + yIncrement, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, birthDateField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, birthDateField, baseY + yIncrement * 2, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, cccdField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, cccdField, baseY + yIncrement * 3, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, baseY + yIncrement * 4, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, classNameField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, classNameField, baseY + yIncrement * 7, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, fatherNameField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fatherNameField, baseY + yIncrement * 8, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, fatherPhoneField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fatherPhoneField, baseY + yIncrement * 9, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, motherNameField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, motherNameField, baseY + yIncrement * 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, motherPhoneField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, motherPhoneField, baseY + yIncrement * 11, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, talentField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, talentField, baseY + yIncrement * 12, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, hobbyField, fieldX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, hobbyField, baseY + yIncrement * 13, SpringLayout.NORTH, panel);

        // Position table
        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 350, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);

        // Position buttons
        int buttonY = baseY + yIncrement * 14;
        layout.putConstraint(SpringLayout.WEST, addStudentBtn, baseX, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, buttonY, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, editStudentBtn, 100, SpringLayout.WEST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, editStudentBtn, buttonY, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 100, SpringLayout.WEST, editStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, buttonY, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, clearBtn, 100, SpringLayout.WEST, deleteStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, clearBtn, buttonY, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, sortStudentNameBtn, 100, SpringLayout.WEST, clearBtn);
        layout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, buttonY, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Student Information");
        this.setSize(1000, 600);

        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);

        studentTable.getSelectionModel().addListSelectionListener(this);
        addStudentBtn.addActionListener(this);
        editStudentBtn.addActionListener(this);
        deleteStudentBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        sortStudentNameBtn.addActionListener(this);
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
        // với bảng studentTable có 5 cột,
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student
        // số cột: là 5
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
            nameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
            addressTA.setText(studentTable.getModel().getValueAt(row, 3).toString());
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
        nameField.setText("");
        addressTA.setText("");
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
//        nameField.setText(student.getName());
//        ageField.setText("" + student.getAge());
//        addressTA.setText(student.getAddress());
//        gpaField.setText("" + student.getGpa());
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
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
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

    public void addSortStudentGPAListener(ActionListener listener) {
        sortStudentGPABtn.addActionListener(listener);
    }

    public void addSortStudentNameListener(ActionListener listener) {
        sortStudentNameBtn.addActionListener(listener);
    }

    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }
}

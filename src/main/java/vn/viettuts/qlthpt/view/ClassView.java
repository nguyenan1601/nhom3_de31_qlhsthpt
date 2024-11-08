package vn.viettuts.qlthpt.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClassView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton addClassBtn;
    private JButton editClassBtn;
    private JButton deleteClassBtn;
    private JButton searchBtn;
    private JButton clearBtn;

    private JTextField idField;
    private JTextField nameField;
    private JTextField teacherField;
    private JTextField studentCountField;
    private JTextField searchField;

    private JTable classTable;
    private DefaultTableModel tableModel;

    public ClassView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Init components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Create labels
        JLabel idLabel = new JLabel("ID:");
        JLabel nameLabel = new JLabel("Tên lớp:");
        JLabel teacherLabel = new JLabel("Giáo viên:");
        JLabel studentCountLabel = new JLabel("Số học sinh:");

        // Create text fields
        idField = new JTextField(15);
        nameField = new JTextField(15);
        teacherField = new JTextField(15);
        studentCountField = new JTextField(15);
        searchField = new JTextField(20);

        // Create buttons
        addClassBtn = new JButton("Thêm");
        editClassBtn = new JButton("Sửa");
        deleteClassBtn = new JButton("Xóa");
        searchBtn = new JButton("Tìm kiếm");
        clearBtn = new JButton("Clear");

        // Add components to input panel
        gc.insets = new Insets(5, 5, 5, 5);
        gc.gridx = 0; gc.gridy = 0;
        inputPanel.add(idLabel, gc);
        gc.gridx = 1;
        inputPanel.add(idField, gc);

        gc.gridx = 0; gc.gridy = 1;
        inputPanel.add(nameLabel, gc);
        gc.gridx = 1;
        inputPanel.add(nameField, gc);

        gc.gridx = 0; gc.gridy = 2;
        inputPanel.add(teacherLabel, gc);
        gc.gridx = 1;
        inputPanel.add(teacherField, gc);

        gc.gridx = 0; gc.gridy = 3;
        inputPanel.add(studentCountLabel, gc);
        gc.gridx = 1;
        inputPanel.add(studentCountField, gc);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addClassBtn);
        buttonPanel.add(editClassBtn);
        buttonPanel.add(deleteClassBtn);
        buttonPanel.add(clearBtn);

        // Create search panel
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Tìm kiếm:"));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        // Create table
        String[] columnNames = {"ID", "Tên lớp", "Giáo viên", "Số học sinh"};
        tableModel = new DefaultTableModel(columnNames, 0);
        classTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(classTable);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(inputPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // Add to frame
        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setTitle("Quản lý lớp học");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Getters for form data
    public String getClassId() {
        return idField.getText();
    }

    public String getClassName() {
        return nameField.getText();
    }

    public String getTeacherName() {
        return teacherField.getText();
    }

    public String getStudentCount() {
        return studentCountField.getText();
    }

    public String getSearchText() {
        return searchField.getText();
    }

    public void clearFields() {
        idField.setText("");
        nameField.setText("");
        teacherField.setText("");
        studentCountField.setText("");
        searchField.setText("");
    }

    // Add listeners
    public void addAddClassListener(ActionListener listener) {
        addClassBtn.addActionListener(listener);
    }

    public void addEditClassListener(ActionListener listener) {
        editClassBtn.addActionListener(listener);
    }

    public void addDeleteClassListener(ActionListener listener) {
        deleteClassBtn.addActionListener(listener);
    }

    public void addSearchListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    // Table methods
    public void updateClassTable(Object[][] data) {
        tableModel.setRowCount(0);
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }

    public int getSelectedRow() {
        return classTable.getSelectedRow();
    }

    // Show message dialog
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

package vn.viettuts.qlthpt.view;

import vn.viettuts.qlthpt.entity.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import vn.viettuts.qlthpt.entity.User;

public class LoginView extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel userNameLabel;
    private JLabel passwordlabel;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginBtn;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userNameLabel = new JLabel("Username:");
        passwordlabel = new JLabel("Password:");
        userNameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginBtn = new JButton();

        loginBtn.setText("Login");
        loginBtn.addActionListener(this);

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        // tạo đối tượng panel để chứa các thành phần của màn hình login
        panel.setSize(400, 300);
        panel.setLayout(layout);
        panel.add(userNameLabel);
        panel.add(passwordlabel);
        panel.add(userNameField);
        panel.add(passwordField);
        panel.add(loginBtn);

//         cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordlabel,100,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, passwordlabel,20,SpringLayout.NORTH,userNameField);
        layout.putConstraint(SpringLayout.WEST,passwordField,100,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,passwordField,20,SpringLayout.NORTH,passwordlabel);
        layout.putConstraint(SpringLayout.NORTH,loginBtn,30,SpringLayout.NORTH,passwordField);
        layout.putConstraint(SpringLayout.WEST,loginBtn,130,SpringLayout.WEST,panel);
        // add panel tới JFrame
        this.add(panel);
        this.pack();
        // cài đặt các thuộc tính cho JFrame
        this.setTitle("Login");
        this.setSize(400, 300);
        this.setResizable(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public User getUser() {
        return new User(userNameField.getText(),
                String.copyValueOf(passwordField.getPassword()));
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void addLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }
}

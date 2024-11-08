package vn.viettuts.qlthpt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vn.viettuts.qlthpt.dao.UserDao;
import vn.viettuts.qlthpt.entity.User;
import vn.viettuts.qlthpt.view.ClassView;
import vn.viettuts.qlthpt.view.LoginView;
import vn.viettuts.qlthpt.view.StudentView;

public class LoginController {

    private UserDao userDao;
    private LoginView loginView;
    private StudentView studentView;
    private ClassView classView;

    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    /**
     * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"
     *
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            String username = user.getUserName();
            String password = user.getPassword();

            if (username.isEmpty()){
                loginView.showMessage("Hãy nhập username!");
            } else if (password.isEmpty()) {
                loginView.showMessage("Hãy nhập password!");
            }else {
                if (userDao.checkUser(user)) {
                    // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
//                    studentView = new StudentView();
//                    StudentController studentController = new StudentController(studentView);
//                    studentController.showStudentView();
                    classView = new ClassView();
                    ClassController classController = new ClassController(classView);
                    classController.showClassView();
                    loginView.setVisible(false);
                }else {
                    loginView.showMessage("username hoặc password không đúng.");
                }
            }
        }
    }
}

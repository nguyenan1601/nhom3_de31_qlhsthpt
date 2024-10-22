package vn.viettuts.qlthpt;

import java.awt.EventQueue;
import vn.viettuts.qlthpt.controller.LoginController;
import vn.viettuts.qlthpt.view.LoginView;

public class App {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView view = new LoginView();
                LoginController controller = new LoginController(view);
                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }
}

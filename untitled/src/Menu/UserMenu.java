package Menu;

import manager.ManagerUser;


import java.util.Scanner;

public class UserMenu {
    private ManagerUser userManager = new ManagerUser();
    private Scanner input = new Scanner(System.in);

    public void selectMenu() {
        int choice;
        do {
            System.out.println("============Login Menu ===========");
            System.out.println("1: Đăng ký");
            System.out.println("2: Đăng nhập");
            System.out.println("0: Thoát");
            System.out.println("Chọn phương thức thực hiện:");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 0:
                    System.out.println("Thoát Login Menu");
                    break;
                default:
                    System.out.println("Chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    private void register() {
        System.out.println("Nhập tên người dùng:");
        String username = input.nextLine();
        System.out.println("Nhập mật khẩu:");
        String password = input.nextLine();

        boolean success = userManager.register(username, password);
        if (success) {
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Tên người dùng đã tồn tại.");
        }
    }

    private void login() {
        System.out.println("Nhập tên người dùng:");
        String username = input.nextLine();
        System.out.println("Nhập mật khẩu:");
        String password = input.nextLine();

        boolean success = userManager.login(username, password);
        if (success) {
            System.out.println("Đăng nhập thành công!");

        } else {
            System.out.println("Tên người dùng hoặc mật khẩu không đúng.");
        }
    }
}

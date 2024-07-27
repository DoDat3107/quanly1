package Menu;

import java.util.Scanner;

public class MainMenu {

        StudentsMenu studentsMenu = new StudentsMenu();

        SchoolsMenu schoolsMenu = new SchoolsMenu();
        UserMenu userMenu = new UserMenu();
        Scanner InputNumber = new Scanner(System.in);

    public void selecMenu() {

        int choice;
        do {
            System.out.println("=======Menu=======");
            System.out.println("1. Quan ly sinh viên");
            System.out.println("2. Quan ly trường ");
            System.out.println("3. Quản lý người dùng");
            System.out.println("4. Xóa ");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn của bạn : ");
            choice = InputNumber.nextInt();

            switch (choice) {
                case 1:
                    studentsMenu.selectMenu();
                    break;
                case 2:
                    schoolsMenu.selectMenu();
                    break;
                case 3:
                    userMenu.selectMenu();
                    break;
            }
        } while (choice != 0);
    }
    }


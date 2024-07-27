package Menu;

import View.Schools;
import View.Students;
import manager.ManagerSchools;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolsMenu {
    ManagerSchools SchoolManager = new ManagerSchools();
    Scanner InputNumber = new Scanner(System.in);
    Scanner InputString = new Scanner(System.in);

    public void selectMenu() {
        int choice;
        do {
            System.out.println("============Menu Students ===========");
            System.out.println("1.1: Thêm trường");
            System.out.println("1.2: Sửa thông tin trường");
            System.out.println("1.3: Xoá thông tin trờng");
            System.out.println("1.4: Tìm kiếm tên gần đúng của tường");
            System.out.println("1.5: Hiển thị tất cả ");
            System.out.println("0. Thoát Menu Schools");
            System.out.println("Chọn phương thức thực hiện");
            choice = InputNumber.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    MenuNearName();
                    break;
                case 5:
                    showMenuList();
                    break;
            }
        } while (choice != 0);

    }

    public void showMenuList() {
        System.out.println("===========Menu Schools ============");
        ArrayList<Schools> ListStudent = SchoolManager.FindAll();
        for (int i = 0; i < ListStudent.size(); i++) {
            System.out.println(i + 1 + ". " + ListStudent.get(i));
        }
    }

    public void showMenuAdd() {
        System.out.println("Nhập tên trường: ");
        String name = InputString.nextLine();
        System.out.println("Nhập địa chỉ trường: ");
        String addressSchool = InputString.nextLine();
        Schools newShool = new Schools(name, addressSchool);
        SchoolManager.add(newShool);
        System.out.println("Thêm mới thành công");
    }

    public void showMenuRemove() {
        System.out.println("===========Menu xoá trường ============");
        System.out.println("Nhập Id trường muốn xoá: ");
        int idRemove = InputNumber.nextInt();
        SchoolManager.remove(idRemove);
        System.out.println("Xoá thành công");
    }

    public void showMenuEdit() {
        System.out.println("===========Menu sửa trường ============");
        System.out.println("Nhập Id muốn sửa: ");
        int idEdit = InputNumber.nextInt();
        System.out.println("Nhập tên trường muốn sửa: ");
        String name = InputString.nextLine();
        System.out.println("Nhập địa chỉ trường muốn sửa: ");
        String addressSchool = InputString.nextLine();
        Schools newSchool = new Schools(idEdit, name, addressSchool);
        SchoolManager.edit(idEdit, newSchool);
        System.out.println("Sửa thành công");
    }

    public void MenuNearName() {
        System.out.println("=======Tìm kiếm theo Tên trường=======");
        System.out.println("Nhập Tên trường cần tìm kiếm : ");
        String name = InputString.nextLine();
        ArrayList<Schools> foundSchool = SchoolManager.FindByName(name);
        if (foundSchool.isEmpty()) {
            System.out.println("Không tìm thấy khach hang có tên chứa '" + name + "'");
        } else {
            System.out.println("Các trường có tên chứa '" + name + "':");
            for (Schools schools : foundSchool) {
                System.out.println("ID: " + schools.getId() + ", Tên: " + schools.getNameSchool()+", địa chỉ: "+schools.getAddressSchool());
            }

        }
    }
}


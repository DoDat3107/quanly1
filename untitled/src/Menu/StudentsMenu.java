package Menu;

import View.Students;
import manager.ManagerStudents;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentsMenu {
    ManagerStudents StudentsManager = new ManagerStudents();
    Scanner InputNumber = new Scanner(System.in);
    Scanner InputString = new Scanner(System.in);

    public void selectMenu() {
        int choice;
        do {
            System.out.println("============Menu Students ===========");
            System.out.println("1.1: Thêm sinh viên");
            System.out.println("1.2: Sửa thông tin sinh viên");
            System.out.println("1.3: Xoá thông tin sinh viên");
            System.out.println("1.4: Tìm kiếm tên gần đúng của sinh viên");
            System.out.println("1.5: Tìm kiếm danh sách sinh viên theo khoảng điểm ");
            System.out.println("1.6: Tìm kiếm danh sách sinh viên theo khoảng tuổi");
            System.out.println("1.7: Hiển thị tất cả ");
            System.out.println("0. Thoát Menu Students");
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
                    MenuNearScore();
                    break;
                case 6:
                    MenuNearAge();
                    break;
                case 7:
                    showMenuList();
                    break;
            }
        } while (choice != 0);

    }

    public void showMenuList() {
        System.out.println("===========Menu Students ============");
        ArrayList<Students> ListStudent = StudentsManager.FindAll();
        for (int i = 0; i < ListStudent.size(); i++) {
            System.out.println(i + 1 + ". " + ListStudent.get(i));
        }
    }
    public void showMenuAdd(){
        System.out.println("===========Menu thêm sinh viên ============");
        System.out.println("Nhập tên sinh viên: ");
        String name = InputString.nextLine();
        System.out.println("Nhập tuổi sinh viên: ");
        int age = InputNumber.nextInt();
        System.out.println("Nhập điểm sinh viên: ");
        double score = InputNumber.nextDouble();
        Students newStudent = new Students(name, age, score);
        StudentsManager.add(newStudent);
        System.out.println("Thêm mới thành công");
    }
    public void showMenuRemove(){
        System.out.println("===========Menu xoá sinh viên ============");
        System.out.println("Nhập Id sinh viên muốn xoá: ");
        int idRemove = InputNumber.nextInt();
        StudentsManager.remove(idRemove);
        System.out.println("Xoá thành công");
    }
    public void showMenuEdit(){
        System.out.println("===========Menu sửa sinh viên ============");
        System.out.println("Nhập Id muốn sửa: ");
        int idEdit = InputNumber.nextInt();
        System.out.println("Nhập tên sinh viên muốn sửa: ");
        String name = InputString.nextLine();
        System.out.println("Nhập tuổi sinh viên muốn sửa: ");
        int age = InputNumber.nextInt();
        System.out.println("Nhập điểm sinh viên muốn sửa: ");
        double score = InputNumber.nextDouble();
        Students newStudent = new Students(idEdit,name, age, score);
        StudentsManager.edit(idEdit,newStudent);
        System.out.println("Thêm mới thành công");
    }
    public void MenuNearName(){
        System.out.println("=======Tìm kiếm theo Tên=======");
        System.out.println("Nhập Tên Sinh viên cần tìm kiếm : ");
        String name = InputString.nextLine();
        ArrayList<Students> foundStudent = StudentsManager.FindByName(name);
        if (foundStudent.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên có tên chứa '" + name + "'");
        } else {
            System.out.println("Các sinh viên có tên chứa '" + name + "':");
            for (Students students : foundStudent) {
                System.out.println("ID: " +students.getId() + ", Tên: " + students.getName() + ", tuoi: " + students.getAge() + " Dia chi: " + students.getScore());
            }

        }
    }
    public void MenuNearScore(){
        System.out.println("=======Tìm kiếm theo Điểm gần đúng=======");
        System.out.println("Nhập Điểm Sinh viên cần tìm kiếm : ");
        double score = InputNumber.nextDouble();
        ArrayList<Students> foundProducts = StudentsManager.FindByScoreNear(score);
        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên có điểm gần đúng " + score);
        } else {
            System.out.println("Các sinh viên có điểm gần đúng " + score + ":");
            for (Students students : foundProducts) {
                    System.out.println("ID: " + students.getId() + ", Tên: " + students.getName() +", Tuổi: "+students.getAge()+ ", Điểm: " + students.getScore());
            }
        }
    }
    public void MenuNearAge(){
        System.out.println("=======Tìm kiếm theo tuổi gần đúng=======");
        System.out.println("Nhập tuổi Sinh viên cần tìm kiếm : ");
        int age = InputNumber.nextInt();
        ArrayList<Students> foundProducts = StudentsManager.FindByAgeNear(age);
        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên có tuổi gần đúng " + age);
        } else {
            System.out.println("Các sinh viên có tuổi gần đúng " + age + ":");
            for (Students students : foundProducts) {
                System.out.println("ID: " + students.getId() + ", Tên: " + students.getName() +", Tuổi: "+students.getAge()+ ", Điểm: " + students.getScore());
            }
        }
    }
}

package View;

import Model.NGUOIDUNG;
import Model.NHANSU;

import java.util.Scanner;

public class Menu_NguoiDung extends DisplayMenu {
    public Menu_NguoiDung() {
        super(new String[]{" Add new NguoiDung", "Display list NguoiDung", "Delete NguoiDung by id","Exit"});
    }

    public void display() {
        System.out.println("----MENU NGUOI DUNG-----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void handleChoice() {
        Scanner sc = new Scanner(System.in);
        Validation validation = new Validation();
        NGUOIDUNG nguoidung = new NGUOIDUNG();
        while (true) {

            int choice = validation.inputInt("Enter choice:", 1, 5);
            switch (choice) {
                case 1:
                    System.out.println("Add new NguoiDung");
                    nguoidung.add();
                    display();
                    break;
                case 2:
                    System.out.println("Display list NguoiDung");
                    nguoidung.printAllNguoi();
                    display();
                    break;
                case 3:
                    System.out.println("Delete NguoiDung by id");
                    System.out.println("Enter ID");
                    byte id = sc.nextByte();
                    nguoidung.removeNguoi(id);
                    display();
                    break;
                case 4:
                    Menu menu = new Menu();
                    menu.display();
                    menu.handleChoice();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

package View;

import Model.CONGTAC;
import Model.NHANSU;

import java.util.Scanner;

public class Menu_NhanSu extends DisplayMenu {
    public Menu_NhanSu() {
        super(new String[]{" Add new NhanSu", "Display list NhanSu", "Delete NhanSu by id","Update Nhan Su","Exit"});
    }

    public void display() {
        System.out.println("----MENU NHANSU-----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void handleChoice() {
        Scanner sc = new Scanner(System.in);
        Validation validation = new Validation();
        NHANSU nhansu = new NHANSU();
        while (true) {

            int choice = validation.inputInt("Enter choice:", 1, 5);
            switch (choice) {
                case 1:
                    System.out.println("Add new NhanSu");
                    nhansu.add();
                    display();
                    break;
                case 2:
                    System.out.println("Display list NhanSu");
                    nhansu.printAllNHANSU();
                    display();
                    break;
                case 3:
                    System.out.println("Delete NhanSu");
                    System.out.println("Enter ID");
                    byte id = sc.nextByte();
                    nhansu.removeNhanSu(id);
                    display();
                    break;
                case 4:
                    System.out.println("Update NhanSu");
                   nhansu.setNhansuList();
                    display();
                    break;
                case 5:
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

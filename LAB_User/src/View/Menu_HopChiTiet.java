package View;

import Model.CONGTAC;
import Model.HOPCHITIET;

import java.util.Scanner;

public class Menu_HopChiTiet extends DisplayMenu {
    public Menu_HopChiTiet() {
        super(new String[]{" Add new HopChiTiet", "Display list HopChiTiet", "Delete HopChiTiet by id","Exit"});
    }

    public void display() {
        System.out.println("----MENU HOPCHITIET-----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void handleChoice() {
        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        HOPCHITIET hopchitiet = new HOPCHITIET();
        while (true) {
            int choice = validation.inputInt("Enter choice:", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("Add new HopChiTiet");
                    hopchitiet.add();
                    display();
                    break;
                case 2:
                    System.out.println("Display list HopChiTiet");
                    hopchitiet.printAllHOPCHITIET();
                    display();
                    break;
                case 3:
                    System.out.println("Delete HopChiTiet");
                    System.out.println("Enter ID");
                    byte id = sc.nextByte();
                    hopchitiet.removeHOPCHITIET(id);
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

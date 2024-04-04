package View;

import Model.CONGTAC;

import java.util.Scanner;

public class Menu_CongTac extends DisplayMenu {
    public Menu_CongTac() {
        super(new String[]{" Add new CongTac", "Display list CongTac", "Delete CongTac by id","Exit"});
    }

    public void display() {
        System.out.println("----MENU CONGTAC-----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void handleChoice() {
        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        CONGTAC congtac = new CONGTAC();
        while (true) {
            int choice = validation.inputInt("Enter choice:", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("Add new CONGTAC");
                    congtac.add();
                    display();
                    break;
                case 2:
                    System.out.println("Display list CONGTAC");
                    congtac.printAllCONGTAC();
                    display();
                    break;
                case 3:
                    System.out.println("Delete CONGTAC");
                    System.out.println("Enter ID");
                    byte id = sc.nextByte();
                    congtac.removeCONGTAC(id);
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

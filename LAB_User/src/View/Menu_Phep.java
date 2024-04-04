package View;

import Model.PHEP;

import java.util.Scanner;

public class Menu_Phep extends DisplayMenu {
    public Menu_Phep() {
        super(new String[]{" Add new phep", "Display list Phep", "Delete Phep by id","Exit"});
    }

    public void display() {
        System.out.println("----MENU PHEP-----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void handleChoice() {
        Validation validation= new Validation();
        Scanner sc = new Scanner(System.in);
        PHEP phep = new PHEP();
        while (true) {
            int choice = validation.inputInt("Enter choice:", 1, 7);
            switch (choice) {
                case 1:
                    System.out.println("Add new Phep");
                    phep.add();
                    display();
                    break;
                case 2:
                    System.out.println("Display list Phep");
                    phep.printAllPHEP();
                    display();
                    break;
                case 3:
                    System.out.println("Delete Phep");
                    System.out.println("Enter ID");
                    byte id = sc.nextByte();
                    phep.removePHEP(id);
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

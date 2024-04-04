package View;

import Model.CONGTAC;
import Model.HOP;

import java.util.Scanner;

public class Menu_Hop extends DisplayMenu {
    public Menu_Hop() {
        super(new String[]{" Add new Hop", "Display list Hop", "Delete CongTac by Hop","Exit"});
    }

    public void display() {
        System.out.println("----MENU HOP-----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void handleChoice() {
        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        HOP hop = new HOP();
        while (true) {
            int choice = validation.inputInt("Enter choice:", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("Add new HOP");
                    hop.add();
                    display();
                    break;
                case 2:
                    System.out.println("Display list HOP");
                    hop.printAllHOP();
                    display();
                    break;
                case 3:
                    System.out.println("Delete HOP");
                    System.out.println("Enter ID");
                    byte id = sc.nextByte();
                    hop.removeHOP(id);
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

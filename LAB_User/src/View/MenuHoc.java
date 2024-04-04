package View;

import Model.HOC;


import java.util.Scanner;

public class MenuHoc extends DisplayMenu {
    public MenuHoc() {
        super(new String[]{" Add new HOC", "Display list HOC", "Delete HOC by id","Exit"});
    }

    public void display() {
        System.out.println("----MENU HOC-----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void handleChoice() {
        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        HOC hoc = new HOC();
        while (true) {
            int choice = validation.inputInt("Enter choice:", 1, 4);
            switch (choice) {

                case 1:
                    System.out.println("Add new HOC");
                    hoc.add();
                    display();
                    break;
                case 2:
                    System.out.println("Display list HOC");
                    hoc.printAllHOC();
                    display();
                    break;
                case 3:
                    System.out.println("Delete HOC");
                    System.out.println("Enter ID");
                    byte id = sc.nextByte();
                    hoc.removeHOC(id);
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

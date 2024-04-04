package View;

import Model.CONGTAC;
import Model.DIA_DIEM;

import java.util.Scanner;

public class Menu_DiaDiem extends DisplayMenu {
    public Menu_DiaDiem () {
        super(new String[]{" Add new DiaDiem", "Display list DiaDiem", "Delete DiaDiem by id","Exit"});
    }

    public void display() {
        System.out.println("----MENU DIA DIEM-----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void handleChoice() {
        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        DIA_DIEM diaDiem = new DIA_DIEM();
        while (true) {
            int choice = validation.inputInt("Enter choice:", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("Add new DiaDiem");
                    diaDiem.add();
                    display();
                    break;
                case 2:
                    System.out.println("Display list DiaDiem");
                    diaDiem.printAllDiaDiem();
                    display();
                    break;
                case 3:
                    System.out.println("Delete DiaDiem");
                    System.out.println("Enter ID");
                    byte id = sc.nextByte();
                    diaDiem.removeDiaDiem(id);
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

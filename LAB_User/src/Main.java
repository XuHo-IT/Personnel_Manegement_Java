import View.Menu;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        System.out.println("Welcome to our app. Here is the instruction to use app\n" +
                "First you have to add Nhan Su first to run the app\n"+
                "Secondly when you want to add new HOP you have to add HOPCHITIET first and add HOP first before add DIADIEM\n"+
                "It wont work with the schedule of wrong id_nhansu so you have make sure that id available in NHANSU\n"+
                "Our app already check the overlap of noi_dung and print out the list of schedule one by one person\n"+
                "Our app still developing. Hope you enjoy it.Thanks");
        System.out.println("Do you want to continue?");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.println("Enter choice: ");
        int a = sc.nextInt();
        if (a == 1){
            menu.display();
            menu.handleChoice();
        }
        if (a==2){
            System.out.println("Thank for your choice");
        }
    }
}
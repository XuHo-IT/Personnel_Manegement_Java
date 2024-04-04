package View;

import Model.THONGBAO;

import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class Menu extends DisplayMenu {
    public Menu() {
        super(new String[]{"Menu Nhan Su","Menu Hoc", "Menu Phep", "Menu Cong Tac","Menu Nguoi Dung","Menu Chi Tiet Hop","Menu Hop","Menu Dia Diem","Print schedule ","Print schedule one by one person", "Exit"});
    }

    public void display() {
        System.out.println("----MENU-----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void handleChoice() {
        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice = validation.inputInt("Enter choice:", 1, 11);
            switch (choice) {
                case 1:
                    Menu_NhanSu nhansu = new Menu_NhanSu();
                    nhansu.display();
                    nhansu.handleChoice();
                    break;
                case 2:
                    MenuHoc menuHoc = new MenuHoc();
                    menuHoc.display();
                    menuHoc.handleChoice();
                    break;
                case 3:
                    Menu_Phep menuPhep = new Menu_Phep();
                    menuPhep.display();
                    menuPhep.handleChoice();
                    break;
                case 4:
                    Menu_CongTac menuCongTac = new Menu_CongTac();
                    menuCongTac.display();
                    menuCongTac.handleChoice();
                    break;
                case 5:
                    Menu_NguoiDung nhanguoidung = new Menu_NguoiDung();
                    nhanguoidung.display();
                    nhanguoidung.handleChoice();
                    break;
                case 6:
                    Menu_HopChiTiet menuHopChiTiet = new Menu_HopChiTiet();
                    menuHopChiTiet.display();
                    menuHopChiTiet.handleChoice();
                    break;
                case 7:
                    Menu_Hop menuHop = new Menu_Hop();
                    menuHop.display();
                    menuHop.handleChoice();
                    break;
                case 8:
                    Menu_DiaDiem menuDiaDiem = new Menu_DiaDiem();
                    menuDiaDiem.display();
                    menuDiaDiem.handleChoice();
                    break;
                case 9:
                    THONGBAO thongbao = new THONGBAO();
                    thongbao.print();
                    display();
                    handleChoice();
                    break;
                case 10:
                    THONGBAO thongbaos = new THONGBAO();
                    thongbaos.printScheduleByID();
                    display();
                    handleChoice();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}

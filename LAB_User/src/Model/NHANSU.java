package Model;

import View.Menu_NhanSu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NHANSU {
    protected byte ID_NhanSu;
    protected byte ID_Phong;
    protected String tenNhanSu;

    public static List<NHANSU> nhansuList = new ArrayList<>();

    // Constructor
    public NHANSU(byte ID_NhanSu, byte ID_Phong, String tenNhanSu) {
        this.ID_NhanSu = ID_NhanSu;
        this.ID_Phong = ID_Phong;
        this.tenNhanSu = tenNhanSu;
    }

    // Empty constructor
    public NHANSU() {
    }

    public byte getID_NhanSu() {
        return ID_NhanSu;
    }

    public void setID_NhanSu(byte ID_NhanSu) {
        this.ID_NhanSu = ID_NhanSu;
    }

    public byte getID_Phong() {
        return ID_Phong;
    }

    public void setID_Phong(byte ID_Phong) {
        this.ID_Phong = ID_Phong;
    }

    public String getTenNhanSu() {
        return tenNhanSu;
    }

    public void setTenNhanSu(String tenNhanSu) {
        this.tenNhanSu = tenNhanSu;
    }

    public List<NHANSU> getNhansuList() {
        return nhansuList;
    }

    public void setNhansuList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of thing you want to update");
        System.out.println("1.ID_NhanSu");
        System.out.println("2.ID_Phong");
        System.out.println("3.Ten Nhan Su");
        System.out.println("4.Exit");
        while (true) {
            System.out.println("Enter choice");
            Menu_NhanSu menuNhanSu = new Menu_NhanSu();
            int a = sc.nextInt();
            sc.nextLine(); // Consume newline character
            switch (a) {
                case 1:
                    System.out.println("Enter ID_NhanSu which want to change");
                    byte id = sc.nextByte();
                    sc.nextLine();
                    for (NHANSU nhansu : nhansuList) {
                        if (nhansu.getID_NhanSu() == id) {
                            System.out.println("We got person has the id =" + id + "who is:" + nhansu);
                            System.out.println("Enter new ID_NhanSu ");
                            byte newid = sc.nextByte();
                            nhansu.setID_NhanSu(newid);
                        }
                    }
                    System.out.println("Update success");
                     menuNhanSu = new Menu_NhanSu();
                    menuNhanSu.display();
                    menuNhanSu.handleChoice();
                    break;

                case 2:
                    System.out.println("Enter ID_Phong which want to change");
                    byte idPhong = sc.nextByte();
                    sc.nextLine();
                    for (NHANSU nhansu : nhansuList) {
                        if (nhansu.getID_Phong() == idPhong) {
                            System.out.println("We got person has the id =" + idPhong + "who is:" + nhansu);
                            System.out.println("Enter new ID_NhanSu ");
                            byte newIdPhong = sc.nextByte();
                            sc.nextLine();
                            nhansu.setID_NhanSu(newIdPhong);
                            menuNhanSu.display();
                            menuNhanSu.handleChoice();
                        }
                    }
                    System.out.println("Update success");
                    break;
                case 3:
                    System.out.println("Enter ten nhan su which want to change");
                    String temp = sc.nextLine();
                    for (NHANSU nhansu : nhansuList) {
                        if (nhansu.getTenNhanSu().equals(temp)) {
                            System.out.println("We got person has the name :" + temp + "who is:" + nhansu);
                            System.out.println("Enter new Ten Nhan Su ");
                            String newName = sc.nextLine();
                            nhansu.setTenNhanSu(newName);
                            menuNhanSu.display();
                            menuNhanSu.handleChoice();
                        }
                    }
                    break;
                case 4:
                    menuNhanSu.display();
                    menuNhanSu.handleChoice();
                default:
                    System.out.println("Invalid input! Please enter a number between 1 and 3.");
                    break;
            }
        }
    }


    public  void addNHANSU(NHANSU nhansu) {
        nhansuList.add(nhansu);
    }

    public  void removeNHANSU(NHANSU nhansu) {
        nhansuList.remove(nhansu);
    }


    public  NHANSU getNHANSUById(byte id) {
        for (NHANSU nhansu : nhansuList) {
            if (nhansu.getID_NhanSu()== id) {
                return nhansu;
            }
        }
        return null;
    }


    public void removeNhanSu(byte id) {
        nhansuList.removeIf(nhansu -> nhansu.getID_NhanSu() == id);
    }
    public void printAllNHANSU() {
        for (NHANSU nhansu : nhansuList) {
            System.out.println(nhansu);
        }
    }


    public NHANSU add() {
        Scanner sc = new Scanner(System.in);
        NHANSU newNHANSU = new NHANSU(); // Create a new NHANSU instance
        System.out.println("Enter ID_NhanSu: ");
        newNHANSU.ID_NhanSu = sc.nextByte();
        sc.nextLine(); // Consume newline character
        System.out.println("Enter ID_Phong: ");
        newNHANSU.ID_Phong = sc.nextByte();
        sc.nextLine(); // Consume newline character
        System.out.println("Enter Name: ");
        newNHANSU.tenNhanSu = sc.nextLine();
        addNHANSU(newNHANSU); // Add the new NHANSU instance
        return newNHANSU; // Return the newly created NHANSU instance
    }


    @Override
    public String toString() {
        return "NHANSU: " +
                "ID_NhanSu: " + ID_NhanSu +
                ", ID_Phong: " + ID_Phong +
                ", tenNhanSu: " + tenNhanSu ;
    }

    // Getters and setters
}

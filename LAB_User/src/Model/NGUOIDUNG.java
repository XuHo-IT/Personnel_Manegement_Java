package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Model.NHANSU.nhansuList;

public class NGUOIDUNG {
    public static   List<NGUOIDUNG> nguoidungList = new ArrayList<>();
    protected byte ID_nguoiDung;
    protected byte ID_nhanSu;
    protected String userName;
    protected String passWord;
    protected int level_user;

    public NGUOIDUNG(byte ID_nguoiDung, byte ID_nhanSu, String userName, String passWord, int level_user) {
        this.ID_nguoiDung = ID_nguoiDung;
        this.ID_nhanSu = ID_nhanSu;
        this.userName = userName;
        this.passWord = passWord;
        this.level_user = level_user;
    }

    public byte getID_nguoiDung() {
        return ID_nguoiDung;
    }

    public void setID_nguoiDung(byte ID_nguoiDung) {
        this.ID_nguoiDung = ID_nguoiDung;
    }

    public byte getID_nhanSu() {
        return ID_nhanSu;
    }

    public void setID_nhanSu(byte ID_nhanSu) {
        this.ID_nhanSu = ID_nhanSu;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getLevel_user() {
        return level_user;
    }

    public void setLevel_user(int level_user) {
        this.level_user = level_user;
    }


    public boolean checkIDNhanSuExists(byte id) {
        for (NHANSU nhansu : nhansuList) {
            if (nhansu.getID_NhanSu() == id) {
                return true;
            }
        }
        return false;
    }
    public  void addHOC(NGUOIDUNG nguoidung) {
        nguoidungList.add(nguoidung);
    }


    public void removeNguoi(byte id) {
        nguoidungList.removeIf(hoc -> hoc.getID_nguoiDung() == id);
    }


    public  NGUOIDUNG getNguoiById(byte id) {
        for (NGUOIDUNG hoc : nguoidungList) {
            if (hoc.getID_nhanSu()== id) {
                return hoc;
            }
        }
        return null;
    }

    public void printAllNguoi() {
        for (NGUOIDUNG hoc : nguoidungList) {
            System.out.println(hoc);
        }
    }

    public NGUOIDUNG add() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        NGUOIDUNG newHoc = new NGUOIDUNG();

        System.out.println("Enter ID_NguoiDung: ");
        newHoc.ID_nguoiDung = sc.nextByte();
        sc.nextLine();

        boolean validID = false;
        do {
            try {
                System.out.println("Enter ID_nhanSu: ");
                newHoc.ID_nhanSu = sc.nextByte();
                sc.nextLine();

                if (checkIDNhanSuExists(newHoc.getID_nhanSu())) {
                    validID = true;
                } else {
                    throw new IllegalArgumentException("Error: ID_nhanSu does not exist in NHANSU list.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validID);

        System.out.println("Enter name: ");
        newHoc.userName = sc.nextLine();


        System.out.println("Enter password: ");
        newHoc.passWord= sc.nextLine();

        System.out.println("Enter User level: ");
        newHoc.level_user = sc.nextInt();
        sc.nextLine();

        addHOC(newHoc);
        return newHoc;
    }

    public NGUOIDUNG() {
    }

    @Override
    public String toString() {
        return "NGUOIDUNG: " +
                "ID_nguoiDung: " + ID_nguoiDung +
                ", ID_nhanSu: " + ID_nhanSu +
                ", userName: " + userName +
                ", passWord; " + passWord  +
                ", level_user: " + level_user ;

    }
}

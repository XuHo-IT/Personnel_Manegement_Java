package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Model.NHANSU.nhansuList;

public class CONGTAC  {
    // List to store valid IDs
    public static List<CONGTAC> validIds = new ArrayList<>();

    protected byte ID_;
    protected byte ID_nhanSu;
    protected String noi_dung;
    protected Date start_ngayCongTac;
    protected Date stop_ngayCongTac;
    protected String noi_congTac;
    protected String phuong_tien;
    protected byte ID_dangKi;
    protected Date ngay_dangKi;

    public CONGTAC(byte ID_, byte ID_nhanSu, String noi_dung, Date start_ngayCongTac, Date stop_ngayCongTac, String noi_congTac, String phuong_tien, byte ID_dangKi, Date ngay_dangKi) {
        this.ID_ = ID_;
        this.ID_nhanSu = ID_nhanSu;
        this.noi_dung = noi_dung;
        this.start_ngayCongTac = start_ngayCongTac;
        this.stop_ngayCongTac = stop_ngayCongTac;
        this.noi_congTac = noi_congTac;
        this.phuong_tien = phuong_tien;
        this.ID_dangKi = ID_dangKi;
        this.ngay_dangKi = ngay_dangKi;
    }

    public byte getID_() {
        return ID_;
    }

    public void setID_(byte ID_) {
        this.ID_ = ID_;
    }

    public byte getID_nhanSu() {
        return ID_nhanSu;
    }

    public void setID_nhanSu(byte ID_nhanSu) {
        this.ID_nhanSu = ID_nhanSu;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public Date getStart_ngayCongTac() {
        return start_ngayCongTac;
    }

    public void setStart_ngayCongTac(Date start_ngayCongTac) {
        this.start_ngayCongTac = start_ngayCongTac;
    }

    public Date getStop_ngayCongTac() {
        return stop_ngayCongTac;
    }

    public void setStop_ngayCongTac(Date stop_ngayCongTac) {
        this.stop_ngayCongTac = stop_ngayCongTac;
    }

    public String getNoi_congTac() {
        return noi_congTac;
    }

    public void setNoi_congTac(String noi_congTac) {
        this.noi_congTac = noi_congTac;
    }

    public String getPhuong_tien() {
        return phuong_tien;
    }

    public void setPhuong_tien(String phuong_tien) {
        this.phuong_tien = phuong_tien;
    }

    public byte getID_dangKi() {
        return ID_dangKi;
    }

    public void setID_dangKi(byte ID_dangKi) {
        this.ID_dangKi = ID_dangKi;
    }

    public Date getNgay_dangKi() {
        return ngay_dangKi;
    }

    public void setNgay_dangKi(Date ngay_dangKi) {
        this.ngay_dangKi = ngay_dangKi;
    }
    public boolean checkIDNhanSuExists(byte id) {
        for (NHANSU nhansu : nhansuList) {
            if (nhansu.getID_NhanSu() == id) {
                return true;
            }
        }
        return false;
    }
    public boolean checkString (String temp){
        for (CONGTAC congtac: validIds){
            if (congtac.getNoi_dung().equals(temp)){
                return false;
            }
        }
        return true;
    }

    public  void setCongtacList(List<CONGTAC> nhansuList) {
        validIds= nhansuList;
    }

    public  void addCONGTAC(CONGTAC congtac) {
        validIds.add(congtac);
    }


    public  void removeCONGTAC(byte id) {
        validIds.removeIf(congtac -> congtac.getID_nhanSu() == id);
    }


    public  CONGTAC getCONGTACById(byte id) {
        for (CONGTAC congtac : validIds) {
            if (congtac.getID_nhanSu()== id) {
                return congtac;
            }
        }
        return null;
    }

    public  void printAllCONGTAC() {
        for (CONGTAC congtac : validIds) {
            System.out.println(congtac);
        }
    }
    public CONGTAC add() {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        CONGTAC newCONGTAC = new CONGTAC(); // Create a new CONGTAC instance
        boolean validID = false;
        do {
            try {
                System.out.println("Enter ID_nhanSu: ");
                newCONGTAC.ID_nhanSu = sc.nextByte();
                sc.nextLine();

                if (checkIDNhanSuExists(newCONGTAC.getID_nhanSu())) {
                    validID = true;
                } else {
                    throw new IllegalArgumentException("Error: ID_nhanSu does not exist in NHANSU list.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validID);

        System.out.println("Enter ID_: ");
        newCONGTAC.ID_ = sc.nextByte();
        sc.nextLine();


        boolean temp = false;
        do {
            try {
                System.out.println("Enter Noi_dung: ");
                newCONGTAC.noi_dung = sc.nextLine();
                sc.nextLine();

                if (checkString(newCONGTAC.getNoi_dung())) {
                    temp = true;
                } else {
                    throw new IllegalArgumentException("Error: Noi dung is overlapping .");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!temp);


        Date date1 = null;
        while (date1 == null) {
            System.out.println("Enter ngay  cong tac bat dau (yyyy-MM-dd): ");
            String dateString = sc.nextLine();

            try {
                date1 = dateFormat.parse(dateString);
                newCONGTAC.start_ngayCongTac = date1;
                System.out.println("Parsed Date: " + date1);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }


        Date date2 = null;
        while (date2 == null) {
            System.out.println("Enter ngay cong tac ket thuc (yyyy-MM-dd): ");
            String dateString = sc.nextLine();

            try {
                date2 = dateFormat.parse(dateString);
                newCONGTAC.stop_ngayCongTac = date2;
                System.out.println("Parsed Date: " + date2);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }

        System.out.println("Enter noi cong tac: ");
        newCONGTAC.noi_congTac = sc.nextLine();

        System.out.println("Enter phuong tien: ");
        newCONGTAC.phuong_tien = sc.nextLine();

        Date date3 = null;
        while (date3 == null) {
            System.out.println("Enter ngay dang ki (yyyy-MM-dd): ");
            String dateString = sc.nextLine();

            try {
                date3 = dateFormat.parse(dateString);
                newCONGTAC.ngay_dangKi = date3;
                System.out.println("Parsed Date: " + date3);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }
        addCONGTAC(newCONGTAC); // Add the new CONGTAC instance
        return newCONGTAC; // Return the newly created CONGTAC instance
    }


    @Override
    public String toString() {
        return "CONGTAC: " +
                "ID_: " + ID_ +
                ", ID_nhanSu: " + ID_nhanSu +
                ", noi_dung: " + noi_dung  +
                ", start_ngayCongTac: " + start_ngayCongTac +
                ", stop_ngayCongTac: " + stop_ngayCongTac +
                ", noi_congTac: " + noi_congTac  +
                ", phuong_tien: " + phuong_tien +
                ", ID_dangKi: " + ID_dangKi +
                ", ngay_dangKi: " + ngay_dangKi ;

    }

    public CONGTAC() {

    }
}

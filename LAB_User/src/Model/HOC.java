package Model;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Model.NHANSU.nhansuList;

public class HOC {
    public static   List<HOC> listHoc = new ArrayList<>();
    protected byte ID_hoc;
    protected byte ID_nhanSu;
    protected String noi_dung;
    protected Date start_ngayHoc;
    protected Date stop_ngayHoc;
    protected Date start_gioHoc;
    protected String noi_hoc;
    protected byte ID_dangKi;
    protected Date ngay_dangKi;
    protected Date stop_gioHoc;


    public HOC(byte ID_hoc, byte ID_nhanSu, String noi_dung, Date start_ngayHoc, Date stop_ngayHoc, Date start_gioHoc, String noi_hoc, byte ID_dangKi, Date ngay_dangKi, Date stop_gioHoc) {
        this.ID_hoc = ID_hoc;
        this.ID_nhanSu = ID_nhanSu;
        this.noi_dung = noi_dung;
        this.start_ngayHoc = start_ngayHoc;
        this.stop_ngayHoc = stop_ngayHoc;
        this.start_gioHoc = start_gioHoc;
        this.noi_hoc = noi_hoc;
        this.ID_dangKi = ID_dangKi;
        this.ngay_dangKi = ngay_dangKi;
        this.stop_gioHoc = stop_gioHoc;
    }

    public byte getID_hoc() {
        return ID_hoc;
    }

    public void setID_hoc(byte ID_hoc) {
        this.ID_hoc = ID_hoc;
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

    public Date getStart_ngayHoc() {
        return start_ngayHoc;
    }

    public void setStart_ngayHoc(Date start_ngayHoc) {
        this.start_ngayHoc = start_ngayHoc;
    }

    public Date getStop_ngayHoc() {
        return stop_ngayHoc;
    }

    public void setStop_ngayHoc(Date stop_ngayHoc) {
        this.stop_ngayHoc = stop_ngayHoc;
    }

    public Date getStart_gioHoc() {
        return start_gioHoc;
    }

    public void setStart_gioHoc(Time start_gioHoc) {
        this.start_gioHoc = start_gioHoc;
    }

    public String getNoi_hoc() {
        return noi_hoc;
    }

    public void setNoi_hoc(String noi_hoc) {
        this.noi_hoc = noi_hoc;
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

    public Date getStop_gioHoc() {
        return stop_gioHoc;
    }

    public void setStop_gioHoc(Time stop_gioHoc) {
        this.stop_gioHoc = stop_gioHoc;
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
        for (HOC hoc: listHoc){
            if (hoc.getNoi_dung().equals(temp)){
                return false;
            }
        }
        return true;
    }

    public  void setHOCList(List<HOC> nhansuList) {
        listHoc= nhansuList;
    }

    public  void addHOC(HOC hoc) {
        listHoc.add(hoc);
    }


    public void removeHOC(byte id) {
        listHoc.removeIf(hoc -> hoc.getID_hoc() == id);
    }


    public  HOC getHOCById(byte id) {
        for (HOC hoc : listHoc) {
            if (hoc.getID_nhanSu()== id) {
                return hoc;
            }
        }
        return null;
    }

    public  void printAllHOC() {
        for (HOC hoc : listHoc) {
            System.out.println(hoc);
        }
    }

    public HOC add() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HOC newHoc = new HOC();

        System.out.println("Enter ID_Hoc: ");
        newHoc.ID_hoc = sc.nextByte();
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

        boolean temp = false;
        do {
            try {
                System.out.println("Enter Noi_dung: ");
                newHoc.noi_dung= sc.nextLine();
                if (checkString(newHoc.getNoi_dung())) {
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
            System.out.println("Enter ngay hoc bat dau (yyyy-MM-dd): ");
            String dateString = sc.nextLine();

            try {
                date1 = dateFormat.parse(dateString);
                newHoc.start_ngayHoc = date1;
                System.out.println("Parsed Date: " + date1);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }

        // Prompt and parse end_ngayHoc
        Date date2 = null;
        while (date2 == null) {
            System.out.println("Enter ngay hoc ket thuc (yyyy-MM-dd): ");
            String dateString = sc.nextLine();

            try {
                date2 = dateFormat.parse(dateString);
                newHoc.stop_ngayHoc = date2;
                System.out.println("Parsed Date: " + date2);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }

        // Prompt and parse start_gioHoc
        Date date3 = null;
        while (date3 == null) {
            System.out.println("Enter gio hoc bat dau (HH:mm:ss): ");
            String timeString = sc.nextLine();

            try {
                date3 = new SimpleDateFormat("HH:mm:ss").parse(timeString);
                newHoc.start_gioHoc = date3;
                System.out.println("Parsed Time: " + date3);
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
            }
        }

        Date date5 = null;
        while (date5 == null) {
            System.out.println("Enter gio hoc ket thuc (HH:mm:ss): ");
            String timeString = sc.nextLine();

            try {
                date5 = new SimpleDateFormat("HH:mm:ss").parse(timeString);
                newHoc.stop_gioHoc = date5;
                System.out.println("Parsed Time: " + date5);
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
            }
        }

        System.out.println("Enter noi hoc: ");
        newHoc.noi_hoc = sc.nextLine();

        System.out.println("Enter ID dang ki: ");
       newHoc.ID_dangKi = sc.nextByte();
        sc.nextLine();


        Date date4 = null;
        while (date4 == null) {
            System.out.println("Enter ngay dang ki (yyyy-MM-dd): ");
            String dateString = sc.nextLine();

            try {
                date4 = dateFormat.parse(dateString);
                newHoc.ngay_dangKi = date4;
                System.out.println("Parsed Date: " + date4);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }
         addHOC(newHoc);
        return newHoc;
    }

    @Override
    public String toString() {
        return "HOC: " +
                "ID_hoc: " + ID_hoc +
                ", ID_nhanSu: " + ID_nhanSu +
                ", noi_dung: " + noi_dung+
                ", start_ngayHoc: " + start_ngayHoc +
                ", stop_ngayHoc: " + stop_ngayHoc +
                ", start_gioHoc: " + start_gioHoc +
                ", noi_hoc: " + noi_hoc +
                ", ID_dangKi: " + ID_dangKi +
                ", ngay_dangKi: " + ngay_dangKi +
                ", stop_gioHoc: " + stop_gioHoc ;

    }

    public HOC() {

    }
}

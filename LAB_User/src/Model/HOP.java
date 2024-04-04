package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Model.HOPCHITIET.hopchitietList;
import static Model.NHANSU.nhansuList;

public class HOP {
    public static List<HOP> list = new ArrayList<>();
    protected byte ID_Hop;
    protected String noi_dung;
    protected Date ngay_dangKi;
    protected Date gio_dangKi;
    protected byte ID_dangKi;
    protected Date ngay_hop;
    protected Date start_gioHop;
    protected Date stop_gioHop;
    protected byte ID_diaDiem;


    public HOP(byte ID_Hop, String noi_dung, Date ngay_dangKi, Date gio_dangKi, byte ID_dangKi, Date ngay_hop, Date start_gioHop, Date stop_gioHop, byte ID_diaDiem) {
        this.ID_Hop = ID_Hop;
        this.noi_dung = noi_dung;
        this.ngay_dangKi = ngay_dangKi;
        this.gio_dangKi = gio_dangKi;
        this.ID_dangKi = ID_dangKi;
        this.ngay_hop = ngay_hop;
        this.start_gioHop = start_gioHop;
        this.stop_gioHop = stop_gioHop;
        this.ID_diaDiem = ID_diaDiem;
    }

    public byte getID_Hop() {
        return ID_Hop;
    }

    public void setID_Hop(byte ID_Hop) {
        this.ID_Hop = ID_Hop;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public Date getNgay_dangKi() {
        return ngay_dangKi;
    }

    public void setNgay_dangKi(Date ngay_dangKi) {
        this.ngay_dangKi = ngay_dangKi;
    }

    public Date getGio_dangKi() {
        return gio_dangKi;
    }

    public void setGio_dangKi(Date gio_dangKi) {
        this.gio_dangKi = gio_dangKi;
    }

    public byte getID_dangKi() {
        return ID_dangKi;
    }

    public void setID_dangKi(byte ID_dangKi) {
        this.ID_dangKi = ID_dangKi;
    }

    public Date getNgay_hop() {
        return ngay_hop;
    }

    public void setNgay_hop(Date ngay_hop) {
        this.ngay_hop = ngay_hop;
    }

    public Date getStart_gioHop() {
        return start_gioHop;
    }

    public void setStart_gioHop(Date start_gioHop) {
        this.start_gioHop = start_gioHop;
    }

    public Date getStop_gioHop() {
        return stop_gioHop;
    }

    public void setStop_gioHop(Date stop_gioHop) {
        this.stop_gioHop = stop_gioHop;
    }

    public byte getID_diaDiem() {
        return ID_diaDiem;
    }

    public void setID_diaDiem(byte ID_diaDiem) {
        this.ID_diaDiem = ID_diaDiem;
    }

    public boolean checkString (String temp){
        for (HOP hop: list){
            if (hop.getNoi_dung().equals(temp)){
                return false;
            }
        }
        return true;
    }

    public boolean checkIDHOPExists() {
        for (HOPCHITIET hopchitiet : hopchitietList) {
            if (hopchitiet.getID_hop() == this.ID_Hop) {
                return false;
            }
        }
        return true;
    }

    public  void setHOPList(List<HOP> nhansuList) {
        list = nhansuList;
    }

    public void addHOP(HOP hop) {
        list.add(hop);
    }


    public  void removeHOP(byte id) {
        list.removeIf(hoc -> hoc.getID_Hop() == id);
    }

    public void printAllHOP() {
        for (HOP hop : list) {
            System.out.println(hop);
        }
    }
    public HOP add(){
        HOP newhop = new HOP();
        Scanner sc = new Scanner(System.in);
        boolean validID = false;
        do {
            try {
                System.out.println("Enter ID_HOP: ");
                newhop.ID_Hop = sc.nextByte();
                sc.nextLine();

                if (checkIDHOPExists()) {
                    validID = true;
                } else {
                    throw new IllegalArgumentException("Error: ID_HOP does not exist in HOPCHITIET list.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validID);


        boolean temp = false;
        do {
            try {
                System.out.println("Enter Noi_dung: ");
                newhop.noi_dung = sc.nextLine();
                if (checkString(newhop.getNoi_dung())) {
                    temp = true;
                } else {
                    throw new IllegalArgumentException("Error: Noi dung is overlapping .");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!temp);

        System.out.println("Enter ID_DangKi: ");
       newhop.ID_dangKi=sc.nextByte();
        sc.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        while (date == null) {
            System.out.println("Enter ngay hop (yyyy-MM-dd): ");
            String dateString = sc.nextLine();

            try {
                date = dateFormat.parse(dateString);
                newhop.ngay_hop = date;
                System.out.println("Parsed Date: " + date);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }

        SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = null;
        while (date3 == null) {
            System.out.println("Enter ngay dang ki (yyyy-MM-dd): ");
            String dateString = sc.nextLine();
            try {
                date3 = dateFormat3.parse(dateString);
                newhop.ngay_dangKi = date3;
                System.out.println("Parsed Date: " + date3);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }

        Date date4 = null;
        while (date4 == null) {
            System.out.println("Enter gio hop bat dau (HH:mm:ss): ");
            String timeString = sc.nextLine();
            try {
                date4 = new SimpleDateFormat("HH:mm:ss").parse(timeString);
                newhop.start_gioHop = date3;
                System.out.println("Parsed Time: " + date4);
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
            }
        }

        Date date5 = null;
        while (date5 == null) {
            System.out.println("Enter gio hop ket thuc (HH:mm:ss): ");
            String timeString = sc.nextLine();

            try {
                date5 = new SimpleDateFormat("HH:mm:ss").parse(timeString);
                newhop.stop_gioHop = date5;
                System.out.println("Parsed Time: " + date5);
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
            }
        }

        Date date6 = null;
        while (date6 == null) {
            System.out.println("Enter gio dang ki(HH:mm:ss): ");
            String timeString = sc.nextLine();
            try {
                date6 = new SimpleDateFormat("HH:mm:ss").parse(timeString);
                newhop.gio_dangKi = date6;
                System.out.println("Parsed Time: " + date6);
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
            }
        }

        System.out.println("Enter ID_DiaDiem:");
        newhop.ID_diaDiem=sc.nextByte();
        sc.nextLine();
        addHOP(newhop);
        return this;
    }

    @Override
    public String toString() {
        return "HOP: " +
                "ID_Hop: " + ID_Hop +
                ", noi_dung: " + noi_dung  +
                ", ngay_dangKi: " + ngay_dangKi +
                ", gio_dangKi: " + gio_dangKi +
                ", ID_dangKi: " + ID_dangKi +
                ", ngay_hop: " + ngay_hop +
                ", start_gioHop: " + start_gioHop +
                ", stop_gioHop: " + stop_gioHop +
                ", ID_diaDiem: " + ID_diaDiem ;

    }

    public HOP() {

    }
}

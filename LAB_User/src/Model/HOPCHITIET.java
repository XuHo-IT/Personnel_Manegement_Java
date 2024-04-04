package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Model.NHANSU.nhansuList;

public class HOPCHITIET  {
    public static List<HOPCHITIET> hopchitietList = new ArrayList<>();
    protected byte hop_chiTtiet;
    protected byte ID_hop;
    protected byte ID_nhanSu;
    protected String readon;

    public HOPCHITIET(byte hop_chiTtiet, byte ID_hop, byte ID_nhanSu, String readon) {
        this.hop_chiTtiet = hop_chiTtiet;
        this.ID_hop = ID_hop;
        this.ID_nhanSu = ID_nhanSu;
        this.readon = readon;
    }


    public byte getHop_chiTtiet() {
        return hop_chiTtiet;
    }

    public void setHop_chiTtiet(byte hop_chiTtiet) {
        this.hop_chiTtiet = hop_chiTtiet;
    }

    public byte getID_hop() {
        return ID_hop;
    }

    public void setID_hop(byte ID_hop) {
        this.ID_hop = ID_hop;
    }

    public byte getID_nhanSu() {
        return ID_nhanSu;
    }

    public void setID_nhanSu(byte ID_nhanSu) {
        this.ID_nhanSu = ID_nhanSu;
    }

    public String getReadon() {
        return readon;
    }

    public void setReadon(String readon) {
        this.readon = readon;
    }

    public boolean checkIDNhanSuExists() {
        for (NHANSU nhansu : nhansuList) {
            if (nhansu.getID_NhanSu() == this.ID_nhanSu) {
                return true;
            }
        }
        return false;
    }

    public static void setHopchitietList(List<HOPCHITIET> nhansuList) {
        hopchitietList= nhansuList;
    }

    public static void addHOPCHITIEt(HOPCHITIET hopchitiet) {
        hopchitietList.add(hopchitiet);
    }


    public void removeHOPCHITIET(byte id) {
       hopchitietList.removeIf(hoc -> hoc.getID_hop() == id);
    }


    public static HOPCHITIET getHOCById(byte id) {
        for (HOPCHITIET hopchitiet : hopchitietList) {
            if (hopchitiet.getID_nhanSu()== id) {
                return hopchitiet;
            }
        }
        return null;
    }

    public  void printAllHOPCHITIET() {
        for (HOPCHITIET hopchitiet : hopchitietList) {
            System.out.println(hopchitiet);
        }
    }


    public HOPCHITIET add(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        boolean validID = false;
        do {
            try {
                System.out.println("Enter ID_nhanSu: ");
                this.ID_nhanSu = sc.nextByte();
                sc.nextLine();

                if (checkIDNhanSuExists()) {
                    validID = true;
                } else {
                    throw new IllegalArgumentException("Error: ID_nhanSu does not exist in NHANSU list.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validID);
        System.out.println("Enter ID_hopChiTiet: ");
        this.hop_chiTtiet= sc.nextByte();
        sc.nextLine();
        System.out.println("Enter ID_Hop: ");
        this.ID_hop= sc.nextByte();
        sc.nextLine();
        System.out.println("Enter Readon");
        this.readon=sc.nextLine();
        addHOPCHITIEt(this);
        return this;
    }

    @Override
    public String toString() {
        return "HOPCHITIET: " +
                "hop_chiTiet " + hop_chiTtiet +
                ", ID_hop " + ID_hop +
                ", ID_nhanSu " + ID_nhanSu +
                ", readon '" + readon;

    }

    public HOPCHITIET() {
    }
}

package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static Model.HOP.list;


public class DIA_DIEM  {
    public  List<DIA_DIEM> diaDiemList = new ArrayList<>();
    protected byte ID_diaDiem;
    protected String dia_Diem;

    public DIA_DIEM(byte ID_diaDiem, String dia_Diem) {
        this.ID_diaDiem = ID_diaDiem;
        this.dia_Diem = dia_Diem;
    }

    public byte getID_diaDiem() {
        return ID_diaDiem;
    }

    public void setID_diaDiem(byte ID_diaDiem) {
        this.ID_diaDiem = ID_diaDiem;
    }

    public String getDia_Diem() {
        return dia_Diem;
    }

    public void setDia_Diem(String dia_Diem) {
        this.dia_Diem = dia_Diem;
    }
    public boolean checkIDDiaDiemExists() {
        for (HOP hop : list ) {
            if (hop.getID_diaDiem() == this.ID_diaDiem) {
                return false;
            }
        }
        return true;
    }
    public void addDiaDiem(DIA_DIEM diaDiem) {
        diaDiemList.add(diaDiem);
    }


    public void removeDiaDiem(byte id) {
        diaDiemList.removeIf(hoc -> hoc.getID_diaDiem() == id);
    }


    public  void printAllDiaDiem() {
        for (DIA_DIEM diaDiem : diaDiemList) {
            System.out.println(diaDiem);
        }
    }

    public DIA_DIEM add(){
        DIA_DIEM diaDiem = new DIA_DIEM();
        Scanner sc = new Scanner(System.in);
        boolean validID = false;
        do {
            try {
                System.out.println("Enter ID_DiaDiem: ");
                diaDiem.ID_diaDiem = sc.nextByte();
                sc.nextLine();

                if (checkIDDiaDiemExists()) {
                    validID = true;
                } else {
                    throw new IllegalArgumentException("Error: ID_DiaDiem does not exist in HOP list.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validID);
        System.out.println("Enter dia diem: ");
        diaDiem.dia_Diem= sc.nextLine();
        addDiaDiem(diaDiem);
        return this;
    }

    @Override
    public String toString() {
        return "DIA_DIEM: " +
                ", ID_diaDiem " + ID_diaDiem +
                ", dia_Diem " + dia_Diem ;
    }

    public DIA_DIEM() {
    }
}

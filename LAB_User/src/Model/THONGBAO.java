package Model;
import static Model.NHANSU.nhansuList;
import static Model.CONGTAC.validIds;
import static Model.NGUOIDUNG.nguoidungList;
import static Model.HOP.list;
import static Model.HOC.listHoc;
import static Model.PHEP.listPhep;
import static Model.HOPCHITIET.hopchitietList;




public class THONGBAO {
    protected byte ID_thongBao;
    protected byte ID_nguoiTB;
    protected byte ID_nguoiDuocTB;

    public THONGBAO(byte ID_thongBao, byte ID_nguoiTB, byte ID_nguoiDuocTB) {
        this.ID_thongBao = ID_thongBao;
        this.ID_nguoiTB = ID_nguoiTB;
        this.ID_nguoiDuocTB = ID_nguoiDuocTB;
    }

    public byte getID_thongBao() {
        return ID_thongBao;
    }

    public void setID_thongBao(byte ID_thongBao) {
        this.ID_thongBao = ID_thongBao;
    }

    public byte getID_nguoiTB() {
        return ID_nguoiTB;
    }

    public void setID_nguoiTB(byte ID_nguoiTB) {
        this.ID_nguoiTB = ID_nguoiTB;
    }

    public byte getID_nguoiDuocTB() {
        return ID_nguoiDuocTB;
    }

    public void setID_nguoiDuocTB(byte ID_nguoiDuocTB) {
        this.ID_nguoiDuocTB = ID_nguoiDuocTB;
    }

    public void print(){
        for (NHANSU nhansu1 :nhansuList){
            System.out.println(nhansu1);
        }
        for (NGUOIDUNG nguoidungs : nguoidungList){
            System.out.println(nguoidungs);
        }
        for (CONGTAC congtac : validIds){
            System.out.println(congtac);
        }
        for (HOP hop : list){
            System.out.println(hop);
        }
        for (HOC hoc : listHoc){
            System.out.println(hoc);
        }
        for (PHEP phep : listPhep){
            System.out.println(phep);
        }
    }
    public void printScheduleByID() {

        for (NHANSU nhansu : nhansuList) {
            System.out.println("Schedule for NHAN SU with ID: " + nhansu.getID_NhanSu());

            for (CONGTAC congtac : validIds) {
                if (congtac.getID_nhanSu() == nhansu.getID_NhanSu()) {
                    System.out.println(congtac);
                }
            }

            for (NGUOIDUNG nguoidung : nguoidungList) {
                if (nguoidung.getID_nhanSu() == nhansu.getID_NhanSu()) {
                    System.out.println(nguoidung);
                }
            }

            for (HOP hop : list) {
                for (HOPCHITIET hopchitiet:hopchitietList)
                if (hop.getID_Hop() == hopchitiet.getID_hop() && hopchitiet.getID_nhanSu() == nhansu.getID_NhanSu() ) {
                    System.out.println(hop);
                }
            }

            for (HOC hoc : listHoc) {
                if (hoc.getID_nhanSu() == nhansu.getID_NhanSu()) {
                    System.out.println(hoc);
                }
            }

            for (PHEP phep : listPhep) {
                if (phep.getID_nhanSu() == nhansu.getID_NhanSu()) {
                    System.out.println(phep);
                }
            }
            System.out.println();
        }
    }



    public THONGBAO() {
    }
}

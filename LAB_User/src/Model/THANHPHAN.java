package Model;

public class THANHPHAN {
    protected byte ID_thanhPhan;
    protected String ten_thanhPhan;
    protected String nhan_su;

    public THANHPHAN(byte ID_thanhPhan, String ten_thanhPhan, String nhan_su) {
        this.ID_thanhPhan = ID_thanhPhan;
        this.ten_thanhPhan = ten_thanhPhan;
        this.nhan_su = nhan_su;
    }

    public byte getID_thanhPhan() {
        return ID_thanhPhan;
    }

    public void setID_thanhPhan(byte ID_thanhPhan) {
        this.ID_thanhPhan = ID_thanhPhan;
    }

    public String getTen_thanhPhan() {
        return ten_thanhPhan;
    }

    public void setTen_thanhPhan(String ten_thanhPhan) {
        this.ten_thanhPhan = ten_thanhPhan;
    }

    public String getNhan_su() {
        return nhan_su;
    }

    public void setNhan_su(String nhan_su) {
        this.nhan_su = nhan_su;
    }
}

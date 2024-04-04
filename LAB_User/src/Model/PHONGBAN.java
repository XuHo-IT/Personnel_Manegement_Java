package Model;

public class PHONGBAN {
    protected byte ID_Phong;
    protected String Ten_Phong;

    public PHONGBAN(byte ID_Phong, String ten_Phong) {
        this.ID_Phong = ID_Phong;
        Ten_Phong = ten_Phong;
    }

    public byte getID_Phong() {
        return ID_Phong;
    }

    public void setID_Phong(byte ID_Phong) {
        this.ID_Phong = ID_Phong;
    }

    public String getTen_Phong() {
        return Ten_Phong;
    }

    public void setTen_Phong(String ten_Phong) {
        Ten_Phong = ten_Phong;
    }
}

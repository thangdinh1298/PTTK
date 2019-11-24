package Model;

import java.sql.Date;

public class TranDau {
    private int ID;
    private Date thoiGian;
    private TrongTai trongTai;
    private BLV bLV;
    private  PhongDau phongDau;
    private NguoiChoi_TranDau nCTD1;
    private NguoiChoi_TranDau nCTD2;

    public TranDau(){

    }

    public TranDau(Date thoiGian, TrongTai trongTai, BLV bLV,
                   PhongDau phongDau, NguoiChoi_TranDau nCTD1, NguoiChoi_TranDau nCTD2) {
        this.thoiGian = thoiGian;
        this.trongTai = trongTai;
        this.bLV = bLV;
        this.phongDau = phongDau;
        this.nCTD1 = nCTD1;
        this.nCTD2 = nCTD2;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public NguoiChoi_TranDau getnCTD1() {
        return nCTD1;
    }

    public void setnCTD1(NguoiChoi_TranDau nCTD1) {
        this.nCTD1 = nCTD1;
    }

    public NguoiChoi_TranDau getnCTD2() {
        return nCTD2;
    }

    public void setnCTD2(NguoiChoi_TranDau nCTD2) {
        this.nCTD2 = nCTD2;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public TrongTai getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(TrongTai trongTai) {
        this.trongTai = trongTai;
    }

    public BLV getbLV() {
        return bLV;
    }

    public void setbLV(BLV bLV) {
        this.bLV = bLV;
    }

    public PhongDau getPhongDau() {
        return phongDau;
    }

    public void setPhongDau(PhongDau phongDau) {
        this.phongDau = phongDau;
    }
}

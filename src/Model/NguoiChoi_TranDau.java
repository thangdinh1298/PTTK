package Model;

public class NguoiChoi_TranDau {
    private NguoiChoi nguoiChoi;
    private int eloGianhDuoc;
    private int soNuocDi;
    private int soLoi;
    private int diem;

    public NguoiChoi_TranDau() {
    }

    public NguoiChoi_TranDau(NguoiChoi nguoiChoi, int eloGianhDuoc, int soNuocDi, int soLoi, int diem) {
        this.nguoiChoi = nguoiChoi;
        this.eloGianhDuoc = eloGianhDuoc;
        this.soNuocDi = soNuocDi;
        this.soLoi = soLoi;
        this.diem = diem;
    }


    public NguoiChoi_TranDau(NguoiChoi nguoiChoi) {
        this.nguoiChoi = nguoiChoi;
    }

    public NguoiChoi getNguoiChoi() {
        return nguoiChoi;
    }

    public void setNguoiChoi(NguoiChoi nguoiChoi) {
        this.nguoiChoi = nguoiChoi;
    }

    public int getEloGianhDuoc() {
        return eloGianhDuoc;
    }

    public void setEloGianhDuoc(int eloGianhDuoc) {
        this.eloGianhDuoc = eloGianhDuoc;
    }

    public int getSoNuocDi() {
        return soNuocDi;
    }

    public void setSoNuocDi(int soNuocDi) {
        this.soNuocDi = soNuocDi;
    }

    public int getSoLoi() {
        return soLoi;
    }

    public void setSoLoi(int soLoi) {
        this.soLoi = soLoi;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}

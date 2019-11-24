package Model;

public class NguoiChoi extends Nguoi{
    private int id;
    private int elo;
    private int quocTich;

    public NguoiChoi(int id, int elo, int quocTich) {
        this.id = id;
        this.elo = elo;
        this.quocTich = quocTich;
    }

    public NguoiChoi(){

    }

    public void setHoTen(String hoTen){
        super.setHoTen(hoTen);
    }

    public String getHoTen(){
        return super.getHoTen();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public int getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(int quocTich) {
        this.quocTich = quocTich;
    }
}

package VongDau.Model;

import java.sql.Date;

public class VongDau {
    private int soVong;
    private Date tgbd;
    private Date tgkt;

    public VongDau(int soVong, Date tgbd, Date tgkt) {
        this.soVong = soVong;
        this.tgbd = tgbd;
        this.tgkt = tgkt;
    }

    public int getSoVong() {
        return soVong;
    }

    public void setSoVong(int soVong) {
        this.soVong = soVong;
    }

    public Date getTgbd() {
        return tgbd;
    }

    public void setTgbd(Date tgbd) {
        this.tgbd = tgbd;
    }

    public Date getTgkt() {
        return tgkt;
    }

    public void setTgkt(Date tgkt) {
        this.tgkt = tgkt;
    }
}

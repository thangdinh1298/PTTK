package Model;

public class GiaiDau {
    private int id;
    private String tenGiai;
    private String tenDVTC;
    private String truongDau;

    public GiaiDau(int id, String tenGiai, String tenDVTC, String truongDau) {
        this.id = id;
        this.tenGiai = tenGiai;
        this.tenDVTC = tenDVTC;
        this.truongDau = truongDau;
    }

    public int getId() {
        return id;
    }

    public String getTenGiai() {
        return tenGiai;
    }

    public void setTenGiai(String tenGiai) {
        this.tenGiai = tenGiai;
    }

    public String getTenDVTC() {
        return tenDVTC;
    }

    public void setTenDVTC(String tenDVTC) {
        this.tenDVTC = tenDVTC;
    }

    public String getTruongDau() {
        return truongDau;
    }

    public void setTruongDau(String truongDau) {
        this.truongDau = truongDau;
    }
}

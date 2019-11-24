package VongDau.Control;

import Control.DAO;
import Model.VongDau;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VongDauDAO extends DAO {
    public VongDauDAO() {
        super();
    }

    public ArrayList<VongDau> timVongDauTheoGiai(int giaiId){
        String sql = "SELECT * FROM tblVongdau where tblGiaidauid = ?";
        ArrayList<VongDau> vds = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(giaiId));
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                int soVong = rs.getInt("sovong");
                Date tgbd = rs.getDate("thoigianbatdau");
                Date tgkt = rs.getDate("thoigianketthuc");
                System.out.println(tgbd.toString() + " : " + tgkt.toString());
                VongDau vd = new VongDau(id, soVong, tgbd, tgkt);
                vds.add(vd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return vds;
        }
    }
}

package GiaiDau.Control;

import Control.DAO;
import Model.GiaiDau;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GiaiDauDAO extends DAO{

    public GiaiDauDAO() {
        super();
    }

    public ArrayList<GiaiDau> timGiaiDauTheoTen(String ten){
        String sql = "SELECT tblGiaidau.id, tendvtc,  tengiai, mota, ten FROM tblGiaidau, tblTruongdau " +
                "WHERE tengiai LIKE ? AND tblGiaidau.tblTruongdauid = tblTruongdau.id";
        ArrayList<GiaiDau> gds = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String tenGiai = rs.getString("tengiai");
                String truongDau = rs.getString("ten");
                String tendvtc = rs.getString("tendvtc");

                GiaiDau gd = new GiaiDau(id, tenGiai, tendvtc, truongDau);
                gds.add(gd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gds;
    }
}

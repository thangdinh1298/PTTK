package TranDau.Control;

import Control.DAO;
import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class TranDauDAO extends DAO {
    public TranDauDAO(){
        super();
    }

    public ArrayList<TranDau> timTranDauTheoVong(int vongID){
        System.out.println("Vong dau id is: " + vongID);
        String  sql = "select ht1.ten, ht2.ten, abc.ngay from tblHoten as ht1, tblHoten as ht2, (select n1.tblHotenid as " +
                "ht1id, n2.tblHotenid as ht2id, td.ngay as ngay from tblNguoi as n1, tblNguoi as n2, tblNguoiChoi as nc1, " +
                "tblNguoiChoi as nc2, (select tblTrandau.ngay as ngay, tblTrandau.id as trandauid, nctd1.tblNguoichoiid as " +
                "n1id, nctd2.tblNguoichoiid as n2id from tblTrandau, tblNguoichoi_trandau as nctd1, tblNguoichoi_trandau as " +
                "nctd2 where tblTrandau.tblVongdauid = ? and nctd1.tblTrandauid = tblTrandau.id and " +
                "nctd2.tblTrandauid = tblTrandau.id and nctd1.tblNguoichoiid < nctd2.tblNguoichoiid) as td where td.n1id = nc1.id " +
                "and td.n2id = nc2.id and nc1.tblNguoiid = n1.id and nc2.tblNguoiid = n2.id) as abc where abc.ht1id = ht1.id" +
                " and abc.ht2id = ht2.id";
        ArrayList<TranDau> tds = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(vongID));
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("got one");
                String tenNC1 = rs.getString("ht1.ten");
                System.out.println(tenNC1);

                NguoiChoi nc1 = new NguoiChoi();
                nc1.setHoTen(tenNC1);

                System.out.println("got two");
                String tenNC2 = rs.getString("ht2.ten");
                NguoiChoi nc2 = new NguoiChoi();
                nc2.setHoTen(tenNC2);

                System.out.println(tenNC2);

                Date tg = rs.getDate("abc.ngay");
                System.out.println(tg);
                NguoiChoi_TranDau nctd1 = new NguoiChoi_TranDau();
                NguoiChoi_TranDau nctd2 = new NguoiChoi_TranDau();
                nctd1.setNguoiChoi(nc1);
                nctd2.setNguoiChoi(nc2);

                TranDau td = new TranDau();
                td.setThoiGian(tg);
                td.setnCTD1(nctd1);
                td.setnCTD2(nctd2);

                tds.add(td);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                return tds;
            }
    }

    public ArrayList<Nguoi> getNguoiChoiList(){
        String sql = "select * from tblNguoi, tblNguoiChoi, tblHoten where role='nguoi choi' " +
                "and tblNguoi.tblHotenid = tblHoten.id " +
                "and tblNguoiChoi.tblNguoiid=tblNguoi.id";

        ArrayList<Nguoi> ncs = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Nguoi nguoi = new NguoiChoi();
                int id = rs.getInt("tblNguoiChoi.id");
                String ten = rs.getString("tblHoten.ten");
                String ho = rs.getString("tblHoten.ho");
                String dem = rs.getString("tblHoten.dem");

                nguoi.setHoTen(ho + " " + dem + " " +ten);
                nguoi.setId(id);
                ncs.add(nguoi);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return ncs;
        }
    }

    public ArrayList<Nguoi> getBLVList(){
        String sql = "select * from tblNhanVien, tblNguoi, tblHoten where tblNguoi.role='blv' and tblNguoi.tblHotenid = tblHoten.id " +
                "and tblNhanVien.tblNguoiid = tblNguoi.id";

        ArrayList<Nguoi> ncs = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Nguoi nguoi = new BLV();
                int id = rs.getInt("id");
                String ten = rs.getString("tblHoten.ten");
                String ho = rs.getString("tblHoten.ho");
                String dem = rs.getString("tblHoten.dem");

                nguoi.setHoTen(ho + " " + dem + " " +ten);
                nguoi.setId(id);
                ncs.add(nguoi);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return ncs;
        }
    }

    public ArrayList<Nguoi> getTrongTaiList(){
        String sql = "select * from tblNhanVien, tblNguoi, tblHoten where tblNguoi.role='trong tai' and tblNguoi.tblHotenid = tblHoten.id " +
                "and tblNhanVien.tblNguoiid = tblNguoi.id";

        ArrayList<Nguoi> ncs = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Nguoi nguoi = new TrongTai();
                int id = rs.getInt("tblNhanVien.id");
                String ten = rs.getString("tblHoten.ten");
                String ho = rs.getString("tblHoten.ho");
                String dem = rs.getString("tblHoten.dem");

                nguoi.setHoTen(ho + " " + dem + " " +ten);
                nguoi.setId(id);
                ncs.add(nguoi);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return ncs;
        }
    }

    public boolean luuTranDau(TranDau td, VongDau vd){
        NguoiChoi_TranDau nctd1 = td.getnCTD1();
        NguoiChoi_TranDau nctd2 = td.getnCTD2();




        String sql = "Insert into tblTrandau(ngay, tblVongdauid, blvid, trongtaiid) values (?, ?, ?, ?)";
        String sql2 = "Insert into tblNguoichoi_trandau(tblTrandauid, tblNguoichoiId) values (?, ?), (?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, td.getThoiGian());
            ps.setInt(2, vd.getId());
            ps.setInt(3, td.getbLV().getId());
            ps.setInt(4, td.getTrongTai().getId());
            System.out.println(ps.toString());
            ps.executeUpdate();

            ResultSet keySet = ps.getGeneratedKeys();
            int id ;
            if(keySet.next()){
               id = keySet.getInt(1);
                System.out.println("Key is: " + id);
            } else {
                System.out.println("No keys");
                return false;
            }

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, id);
            ps2.setInt(2, nctd1.getNguoiChoi().getId());
            ps2.setInt(3, id);
            ps2.setInt(4, nctd2.getNguoiChoi().getId());
            System.out.println(ps2);
            ps2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

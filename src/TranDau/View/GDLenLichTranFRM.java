package TranDau.View;

import Model.*;
import TranDau.Control.TranDauDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class GDLenLichTranFRM extends JFrame implements ActionListener {
    private VongDau vd;
    private JLabel lblThoiGian;
    private JLabel lblNguoi1;
    private JLabel lblNguoi2;
    private JLabel lblTrongTai;
    private JLabel lblBLV;
    private JTextField txtThoiGian;
    private JComboBox comNguoi1;
    private JComboBox comNguoi2;
    private JComboBox trongTai;
    private JComboBox bLV;
    private JButton btnXacNhan;
    private JButton btnTroVe;
    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    public GDLenLichTranFRM(VongDau vd) {
        super("Len Lich");
        this.vd = vd;
        txtThoiGian = new JTextField("yyyy-mm-dd");
        btnXacNhan = new JButton("Xac Nhan");
        btnTroVe = new JButton("Tro Ve");
        lblThoiGian = new JLabel("Thoi Gian");
        lblNguoi1 = new JLabel("Nguoi 1");
        lblNguoi2 = new JLabel("Nguoi 2");
        lblTrongTai = new JLabel("Trong Tai");
        lblBLV = new JLabel("BLV");

        TranDauDAO dao = new TranDauDAO();
        ArrayList<Nguoi> ncs = dao.getNguoiChoiList();
        ArrayList<Nguoi> blvs = dao.getBLVList();
        ArrayList<Nguoi> tts = dao.getTrongTaiList();

        comNguoi1 = new JComboBox(ncs.toArray());
        comNguoi2 = new JComboBox(ncs.toArray());
        trongTai = new JComboBox(tts.toArray());
        bLV = new JComboBox(blvs.toArray());

        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);

        mainPanel.add(btnTroVe);
        mainPanel.add(btnXacNhan);
        mainPanel.add(txtThoiGian);
        mainPanel.add(comNguoi1);
        mainPanel.add(comNguoi2);
        mainPanel.add(trongTai);
        mainPanel.add(bLV);
        mainPanel.add(lblBLV);
        mainPanel.add(lblNguoi1);
        mainPanel.add(lblNguoi2);
        mainPanel.add(lblThoiGian);
        mainPanel.add(lblTrongTai);

        btnTroVe.addActionListener(this);
        btnXacNhan.addActionListener(this);

        layout.putConstraint(SpringLayout.NORTH, lblThoiGian, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, lblThoiGian, 20, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, txtThoiGian, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, txtThoiGian, 20, SpringLayout.EAST, lblThoiGian);

        layout.putConstraint(SpringLayout.NORTH, lblNguoi1, 30, SpringLayout.NORTH, lblThoiGian);
        layout.putConstraint(SpringLayout.WEST, lblNguoi1, 20, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, comNguoi1, 30, SpringLayout.NORTH, txtThoiGian);
        layout.putConstraint(SpringLayout.WEST, comNguoi1, 20, SpringLayout.EAST, lblNguoi1);

        layout.putConstraint(SpringLayout.NORTH, lblNguoi2, 30, SpringLayout.NORTH, lblNguoi1);
        layout.putConstraint(SpringLayout.WEST, lblNguoi2, 20, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, comNguoi2, 30, SpringLayout.NORTH, comNguoi1);
        layout.putConstraint(SpringLayout.WEST, comNguoi2, 20, SpringLayout.EAST, lblNguoi1);

        layout.putConstraint(SpringLayout.NORTH, lblTrongTai, 30, SpringLayout.NORTH, lblNguoi2);
        layout.putConstraint(SpringLayout.WEST, lblTrongTai, 20, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, trongTai, 30, SpringLayout.NORTH, comNguoi2);
        layout.putConstraint(SpringLayout.WEST, trongTai, 20, SpringLayout.EAST, lblTrongTai);

        layout.putConstraint(SpringLayout.NORTH, lblBLV, 30, SpringLayout.NORTH, lblTrongTai);
        layout.putConstraint(SpringLayout.WEST, lblBLV, 20, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, bLV, 30, SpringLayout.NORTH, trongTai);
        layout.putConstraint(SpringLayout.WEST, bLV, 20, SpringLayout.EAST, lblBLV);

        layout.putConstraint(SpringLayout.SOUTH, btnXacNhan, -10, SpringLayout.SOUTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, btnXacNhan, WIDTH/2 - 50, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.WEST, btnTroVe, WIDTH/2 + 50, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, btnTroVe, -10, SpringLayout.SOUTH, mainPanel);

        this.add(mainPanel);
        this.setSize(WIDTH,HEIGHT);
        this.setVisible(true);
        this.setLocation(200,10);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if (btnClicked.equals(btnXacNhan)) {
            btnXacNhanClicked();
        } else if (btnClicked.equals(btnTroVe)) {
            btnTroVeClicked();
        }
    }

    private void btnTroVeClicked(){
        this.dispose();
    }

    private void btnXacNhanClicked(){
        NguoiChoi_TranDau nctd1 = new NguoiChoi_TranDau();
        NguoiChoi_TranDau nctd2 = new NguoiChoi_TranDau();

        nctd1.setNguoiChoi((NguoiChoi) comNguoi1.getSelectedItem());
        nctd2.setNguoiChoi((NguoiChoi) comNguoi2.getSelectedItem());

        TranDau tranDau = new TranDau();
        tranDau.setThoiGian(Date.valueOf(txtThoiGian.getText()));
        tranDau.setbLV((BLV) bLV.getSelectedItem());
        tranDau.setTrongTai((TrongTai) trongTai.getSelectedItem());
        tranDau.setnCTD2(nctd2);
        tranDau.setnCTD1(nctd1);
        TranDauDAO dao = new TranDauDAO();
        dao.luuTranDau(tranDau, vd);
    }
}

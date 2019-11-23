package BTC;

import GiaiDau.View.GDChonGiaiFRM;
import Model.BanToChuc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GDBanToChucFRM extends JFrame implements ActionListener {
    private JButton btnDangKy;
    private JButton btnLenLich;
    private JButton btnCapNhatKetQua;
    private JButton btnCapNhatTTinGiai;
    private BanToChuc btc;

    public GDBanToChucFRM(){
        super("Ban To Chuc Home");
        btnCapNhatKetQua = new JButton("Cap Nhat Ket Qua");
        btnCapNhatTTinGiai = new JButton("Cap Nhat Thong Tin Giai");
        btnDangKy = new JButton("Dang Ky Nguoi Choi");
        btnLenLich = new JButton("Len Lich Vong Dau");
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(btnCapNhatKetQua);
        buttons.add(btnCapNhatTTinGiai);
        buttons.add(btnDangKy);
        buttons.add(btnLenLich);

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(300,150);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
        for(JButton button: buttons){
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(this);
            mainPanel.add(button);
        }

        mainPanel.setVisible(true);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void btnDangKyClicked(){

    }

    private void btnCapNhatTTinGiaiClicked(){

    }

    private void btnLenLichClicked(){
        new GDChonGiaiFRM(btc);
    }

    private void btnCapNhatKetQuaClicked(){
        new GDChonGiaiFRM(btc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnDangKy)){
            btnDangKyClicked();
        }
        else if(btnClicked.equals(btnCapNhatTTinGiai)){
            btnCapNhatTTinGiaiClicked();
        }
        else if(btnClicked.equals(btnLenLich)){
            System.out.println("DEG");
            btnLenLichClicked();
        }
        else {
            btnCapNhatKetQuaClicked();
        }
    }

    public static void main(String[] args) {
        GDBanToChucFRM frm = new GDBanToChucFRM();
        frm.setSize(300,150);
        frm.setVisible(true);
    }
}

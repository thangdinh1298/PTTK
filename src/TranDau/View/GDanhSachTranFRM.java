package TranDau.View;

import Model.GiaiDau;
import Model.TranDau;
import Model.VongDau;
import TranDau.Control.TranDauDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;

public class GDanhSachTranFRM extends JFrame implements ActionListener {
    private VongDau vong;
    private GiaiDau gd;
    private JButton btnTroVe;
    private JTable tblTran;
    private ArrayList<TranDau> tds;
    private JButton btnThem;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public GDanhSachTranFRM(GiaiDau gd, VongDau vong) {
        super("Danh Sach Tran");
        this.vong = vong;
        this.gd = gd;
        btnTroVe = new JButton("Tro ve");
        btnThem = new JButton("Them");
        tds = new ArrayList<>();
        tblTran = new JTable(new TranDauTableModel());

        TranDauDAO dao = new TranDauDAO();
        tds = dao.timTranDauTheoVong(vong.getId());

        System.out.println("--------------------");
        System.out.println("There are " + tds.size());

        ((DefaultTableModel) tblTran.getModel()).fireTableDataChanged();

        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);
        JScrollPane pane = new JScrollPane(tblTran);

        mainPanel.add(btnTroVe);
        mainPanel.add(pane);
        mainPanel.add(btnThem);

        btnTroVe.addActionListener(this);
        btnThem.addActionListener(this);
        tblTran.addMouseListener(new TranTBLMouseListener());

        layout.putConstraint(SpringLayout.NORTH, pane, 20, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, pane, 20, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST, pane, -20, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, pane, -50, SpringLayout.SOUTH, mainPanel);

        layout.putConstraint(SpringLayout.WEST, btnTroVe, WIDTH/2 + 50, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, btnTroVe, -10, SpringLayout.SOUTH, mainPanel);

        layout.putConstraint(SpringLayout.WEST, btnThem, WIDTH/2 - 50, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, btnThem, -10, SpringLayout.SOUTH, mainPanel);

        this.add(mainPanel);
        this.setSize(WIDTH,HEIGHT);
        this.setVisible(true);
        this.setLocation(200,10);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if (btnClicked == btnTroVe){
            btnTroVeClicked();
        } else if(btnClicked == btnThem){
            btnThemClicked();
        }
    }

    private void rowClicked(int row) {

    }

    private void btnTroVeClicked(){
        this.dispose();
    }

    private void btnThemClicked(){
        new GDLenLichTranFRM(vong);
    }

    class TranDauTableModel extends DefaultTableModel {
        private String[] columnNames = {"Thu tu",  "Thoi Gian", "Nguoi choi 1", "Nguoi choi 2"/*, "BLV"*/};
        private final Class<?>[] columnTypes = new  Class<?>[] {Integer.class, Date.class, String.class, String.class/*, Date.class*/};

        @Override public int getColumnCount() {
            return columnNames.length;
        }

        @Override public int getRowCount() {
            return tds.size();
        }

        @Override public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }

        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
            /*Adding components*/
            switch (columnIndex) {
                case 0:
                    return rowIndex;
                case 1:
                    return tds.get(rowIndex).getThoiGian();
                case 2:
                    return tds.get(rowIndex).getnCTD1().getNguoiChoi().getHoTen();
                case 3:
                    return tds.get(rowIndex).getnCTD2().getNguoiChoi().getHoTen();
//                case 4:
//                    return tds.get(rowIndex).getbLV();
                default: return "Error";
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    class TranTBLMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            JTable table =(JTable) mouseEvent.getSource();
            Point point = mouseEvent.getPoint();
            int row = table.rowAtPoint(point);
            if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                System.out.println(row);
                rowClicked(row);
            }
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

}

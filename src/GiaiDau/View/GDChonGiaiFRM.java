package GiaiDau.View;

import Model.BanToChuc;
import Model.GiaiDau;
import VongDau.View.GDChonVongDauFRM;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GDChonGiaiFRM extends JFrame implements ActionListener {
    private JButton btnTim;
    private JButton btnTroVe;
    private JTable tblGiai;
    private JTextField txtTenGiai;
    private BanToChuc btc;
    private ArrayList<GiaiDau> gds;

    public GDChonGiaiFRM(BanToChuc banToChuc) {
        super("Chon Giai");
        btnTroVe = new JButton("Tro ve");
        btnTim = new JButton("Tim");
        gds = new ArrayList<>();
        tblGiai = new JTable(new GiaiDauTableModel());
        gds.add(new GiaiDau("PTIT_2017", "PTIT", "A3"));
        txtTenGiai = new JTextField("ABCDEF");

        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);
        JScrollPane pane = new JScrollPane(tblGiai);

        mainPanel.add(btnTroVe);
        mainPanel.add(btnTim);
        mainPanel.add(txtTenGiai);
        mainPanel.add(pane);

        btnTroVe.addActionListener(this);
        btnTim.addActionListener(this);
        tblGiai.addMouseListener(new TBLMouseListener());

        layout.putConstraint(SpringLayout.NORTH, txtTenGiai, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, txtTenGiai, 20, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, btnTim, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, btnTim, 20, SpringLayout.EAST, txtTenGiai);

        layout.putConstraint(SpringLayout.NORTH, pane, 20, SpringLayout.SOUTH, txtTenGiai);
        layout.putConstraint(SpringLayout.WEST, pane, 20, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST, pane, -20, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, pane, -50, SpringLayout.SOUTH, btnTroVe);

        layout.putConstraint(SpringLayout.WEST, btnTroVe, 1024/2 - 30, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, btnTroVe, -10, SpringLayout.SOUTH, mainPanel);

        this.add(mainPanel);
        this.setSize(1024,768);
        this.setVisible(true);
        this.setLocation(200,10);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void btnTimClicked(){

    }

    private void btnTroVeClicked(){
        this.dispose();
    }

    private void rowClicked(int i){
        GiaiDau gd = gds.get(i);
        new GDChonVongDauFRM(gd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if (btnClicked.equals(btnTim)) {
            btnTimClicked();
        } else if (btnClicked.equals(btnTroVe)) {
            btnTroVeClicked();
        }
    }

    class GiaiDauTableModel extends DefaultTableModel {
        private String[] columnNames = {"TT",  "TenGiai", "Ten DVTC", "Truong Dau"};
        private final Class<?>[] columnTypes = new  Class<?>[] {Integer.class, String.class, String.class,
                String.class};

        @Override public int getColumnCount() {
            return columnNames.length;
        }

        @Override public int getRowCount() {
            return gds.size();
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
                    return gds.get(rowIndex).getTenGiai();
                case 2:
                    return gds.get(rowIndex).getTenDVTC();
                case 3:
                    return gds.get(rowIndex).getTruongDau();
                default: return "Error";
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    class TBLMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            JTable table =(JTable) mouseEvent.getSource();
            Point point = mouseEvent.getPoint();
            int row = table.rowAtPoint(point);
            if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
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

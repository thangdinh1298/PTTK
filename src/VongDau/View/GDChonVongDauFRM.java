package VongDau.View;

import Model.GiaiDau;
import VongDau.Model.VongDau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.sql.Date;

public class GDChonVongDauFRM extends JFrame implements ActionListener {
    private GiaiDau giaiDau;
    private JTable tblVong;
    private JButton btnTroVe;
    private ArrayList<VongDau> vds;

    public GDChonVongDauFRM(GiaiDau giaiDau) {
        super("Chon Vong");
        this.giaiDau = giaiDau;
        btnTroVe = new JButton("Tro ve");
        vds = new ArrayList<>();
        tblVong = new JTable(new VongDauTableModel());
        vds.add(new VongDau(1, Date.valueOf("1998-01-01"), Date.valueOf("1998-05-01")));

        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);
        JScrollPane pane = new JScrollPane(tblVong);

        mainPanel.add(btnTroVe);
        mainPanel.add(pane);

        btnTroVe.addActionListener(this);
        tblVong.addMouseListener(new VongTBLMouseListener()); //todo:insert table model here

        layout.putConstraint(SpringLayout.NORTH, pane, 20, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, pane, 20, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST, pane, -20, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, pane, -50, SpringLayout.SOUTH, mainPanel);

        layout.putConstraint(SpringLayout.WEST, btnTroVe, 1024/2 - 30, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, btnTroVe, -10, SpringLayout.SOUTH, mainPanel);

        this.add(mainPanel);
        this.setSize(1024,768);
        this.setVisible(true);
        this.setLocation(200,10);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if (btnClicked == btnTroVe){
            btnTroVeClicked();
        }
    }

    private void btnTroVeClicked(){
        this.dispose();
    }

    private void rowClicked(int i){
        VongDau vd = vds.get(i);
        System.out.println(vd);
        new GDLenLichTranFRM(vd);
    }

    class VongDauTableModel extends DefaultTableModel {
        private String[] columnNames = {"So Vong",  "Thoi Gian Bat Dau", "Thoi Gian Ket Thuc"};
        private final Class<?>[] columnTypes = new  Class<?>[] {Integer.class, Date.class, Date.class};

        @Override public int getColumnCount() {
            return columnNames.length;
        }

        @Override public int getRowCount() {
            return vds.size();
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
                    return vds.get(rowIndex).getSoVong();
                case 2:
                    return vds.get(rowIndex).getTgbd();
                case 3:
                    return vds.get(rowIndex).getTgkt();
                default: return "Error";
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    class VongTBLMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            System.out.println("Mouse Clicked");
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

package View;

import Controller.HomeController;
import Controller.InputController;
import Controller.LemburController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OutputView extends JFrame implements ActionListener {
    private JTable tabelOutput;
    private JPanel panelOutput;
    private JButton btnKembali;

    public OutputView(String[][] data) {
        setTitle("Data Karyawan");
        btnKembali.addActionListener(this);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelOutput);
        this.pack();
        setLocationRelativeTo(null);

        DefaultTableModel model = (DefaultTableModel) tabelOutput.getModel();
        String[] column = {"ID", "Nama", "Usia", "Gaji"};
        String[] row = new String[6];
        model.setRowCount(0);

        for(int i = 0; i < column.length; i++){
            model.addColumn(column[i]);
        }
        int dataCount = 0;
        while(true){
            if(data[dataCount][0] == null){
                break;
            }
            row[0] = data[dataCount][0];
            row[1] = data[dataCount][1];
            row[2] = data[dataCount][2];
            row[3] = data[dataCount][3];
            model.addRow(row);
            dataCount++;
        }
        tabelOutput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model = (DefaultTableModel)tabelOutput.getModel();
                int selectedRowIndex = tabelOutput.getSelectedRow();

                String[] selectedData = {
                        model.getValueAt(selectedRowIndex, 0).toString(),
                        model.getValueAt(selectedRowIndex, 1).toString(),
                        model.getValueAt(selectedRowIndex, 2).toString(),
                        model.getValueAt(selectedRowIndex, 3).toString()
                };

                LemburController lemburController = new LemburController();
                lemburController.menglembur(selectedData);
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()== btnKembali){
            HomeController homeController = new HomeController();
            homeController.homeLaunch();
            dispose();
        }
    }
}

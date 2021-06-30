package View;

import Controller.HomeController;
import Controller.OutputController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GajiView extends JFrame implements ActionListener {
    private JButton btnKembali;
    private JPanel panelGaji;
    private JLabel lblNama;
    private JLabel lblUsia;
    private JLabel lblGaji;
    private JLabel lblTotal;

    public GajiView(int jam, String nama, String usia, String gaji, int total) {
        setTitle(nama);
        btnKembali.addActionListener(this);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelGaji);
        this.pack();
        setLocationRelativeTo(null);

        lblNama.setText(nama);
        lblUsia.setText(usia);
        lblGaji.setText(gaji);
        lblTotal.setText(String.valueOf(total));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==btnKembali){
            OutputController outputController = new OutputController();
            outputController.openOutput();
            dispose();
        }
    }
}

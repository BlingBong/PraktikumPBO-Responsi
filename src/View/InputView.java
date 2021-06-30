package View;

import Controller.HomeController;
import Controller.InputController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputView extends JFrame implements ActionListener {
    private JPanel panelInput;
    private JTextField etNama;
    private JTextField etUsia;
    private JTextField etGaji;
    private JButton btnKembali;
    private JButton btnSubmit;
    private JButton btnReset;

    public InputView() {
        setTitle("Input Karyawan");
        btnKembali.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelInput);
        this.pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==btnSubmit) {
            if (etNama.getText().isEmpty()) {
                setMessage("Nama harus diisi");
            }
            if (etUsia.getText().isEmpty()) {
                setMessage("Usia harus diisi");
            }
            if (etGaji.getText().isEmpty()) {
                setMessage("Gaji harus diisi");
            }
            else {
                try {
                    String sUsia = etUsia.getText();
                    String sGaji = etGaji.getText();
                    int usia = Integer.parseInt(sUsia);
                    int gaji = Integer.parseInt(sGaji);

                    if(usia < 0){
                        setMessage("Usia harus bernilai positif");
                    }
                    else if(gaji < 0){
                        setMessage("Gaji harus bernilai positif");
                    }
                    else{
                        String[] data = {
                                etNama.getText(), etUsia.getText(), etGaji.getText()
                        };
                        InputController inputController = new InputController();
                        inputController.input(data);
                        dispose();
                    }
                }
                catch (NumberFormatException e) {
                    setMessage("Usia dan Gaji harus angka");
                }
            }
        }

        else if(actionEvent.getSource()== btnReset){
            etNama.setText("");
            etUsia.setText("");
            etGaji.setText("");
        }

        else if(actionEvent.getSource()== btnKembali){
            HomeController homeController = new HomeController();
            homeController.homeLaunch();
            dispose();
        }
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}

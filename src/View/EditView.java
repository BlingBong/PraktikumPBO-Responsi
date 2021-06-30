package View;

import Controller.EditController;
import Controller.HomeController;
import Controller.InputController;
import Controller.OutputController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditView extends JFrame implements ActionListener {
    private JButton btnKembali;
    private JPanel panelEdit;
    private JButton btnReset;
    private JButton btnSubmit;
    private JTextField etNama;
    private JTextField etUsia;
    private JTextField etGaji;

    private String indeks;

    public EditView(String[] selected) {
        setTitle(selected[1]);
        btnKembali.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelEdit);
        this.pack();
        setLocationRelativeTo(null);

        indeks = selected[0];
        etNama.setText(selected[1]);
        etUsia.setText(selected[2]);
        etGaji.setText(selected[3]);
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
                                indeks, etNama.getText(), etUsia.getText(), etGaji.getText()
                        };
                        EditController editController = new EditController();
                        editController.update(data);
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
            OutputController outputController = new OutputController();
            outputController.openOutput();
            dispose();
        }
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}

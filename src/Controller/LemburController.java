package Controller;

import View.GajiView;
import View.LemburView;

public class LemburController {
    public void menglembur(String[] selectedData){
        new LemburView(selectedData);
    }

    public void jamLembur(int jam, String nama, String usia, String gaji){
        int gajiAwal = Integer.parseInt(gaji);
        int totalGaji = jam*25000;
        int total = gajiAwal+totalGaji;
        new GajiView(jam, nama, usia, gaji, total);
    }
}

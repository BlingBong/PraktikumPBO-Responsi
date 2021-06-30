package Controller;

import Model.EditModel;
import Model.InputModel;
import View.EditView;
import View.InputView;
import View.LemburView;
import View.OutputView;

public class EditController {
    public void edit(String[] selected){
        new EditView(selected);
    }

    public void update(String[] data){
        EditModel editModel = new EditModel();
        editModel.updateData(data);
        new EditView(data);
    }

    public void hapus(String[] selected){
        EditModel editModel = new EditModel();
        editModel.hapusData(selected);
    }
}

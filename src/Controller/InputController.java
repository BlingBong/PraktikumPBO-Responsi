package Controller;

import Model.InputModel;
import View.InputView;

public class InputController {
    public void input(String[] data) {
        InputModel inputModel = new InputModel();
        inputModel.inputData(data);
        new InputView();
    }
    public void openInput() {
        new InputView();
    }
}

package Controller;

import Model.OutputModel;
import View.OutputView;

public class OutputController {
    public void openOutput(){
        OutputModel outputModel = new OutputModel();
        new OutputView(outputModel.outputData());
    }
}

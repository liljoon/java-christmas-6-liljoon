package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private OutputView outputView;
    private InputView inputView;

    public ChristmasController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        outputView.printWelcome();
    }
}

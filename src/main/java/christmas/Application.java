package christmas;

import christmas.controller.Controller;
import christmas.service.ChristmasEventService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new InputView(),
                new OutputView(),
                new ChristmasEventService()
        );
        controller.run();
    }
}

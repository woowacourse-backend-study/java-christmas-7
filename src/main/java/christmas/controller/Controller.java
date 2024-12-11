package christmas.controller;

import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printWelcome();
        final int visitDate = getVisitDate();
        Order order = getOrder();

    }

    private int getVisitDate() {
        return doLoop(inputView::getVisitDate).date();
    }

    private Order getOrder() {
        return doLoop(inputView::getOrder);
    }

    public <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}


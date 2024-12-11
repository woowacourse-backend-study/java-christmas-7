package christmas.infrastructure.constants;

import christmas.domain.Order;

public enum ExceptionMessage {
    INVALID_INPUT("입력 값이 올바르지 않습니다."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    EXCEED_ORDER(String.format("주문은 최대 %,d개까지 가능합니다.", Order.MAX_COUNT)),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

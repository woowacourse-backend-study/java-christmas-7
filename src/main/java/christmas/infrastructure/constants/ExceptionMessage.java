package christmas.infrastructure.constants;

public enum ExceptionMessage {
    INVALID_INPUT("입력 값이 올바르지 않습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

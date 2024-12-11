package christmas.domain;

import christmas.infrastructure.constants.ExceptionMessage;
import christmas.infrastructure.exception.CustomException;

public record DecemberDate(int date) {
    private final static int MIN = 1;
    private final static int MAX = 31;

    public DecemberDate {
        validateDate(date);
    }

    public static DecemberDate of(String input) {
        try {
            return new DecemberDate(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new CustomException(ExceptionMessage.INVALID_DATE.getMessage());
        }
    }

    private void validateDate(final int date) {
        if (date < MIN || date > MAX) {
            throw new CustomException(ExceptionMessage.INVALID_DATE.getMessage());
        }
    }
}

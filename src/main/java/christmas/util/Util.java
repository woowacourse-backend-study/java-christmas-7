package christmas.util;

import christmas.infrastructure.constants.ExceptionMessage;
import christmas.infrastructure.exception.CustomException;

import java.util.Arrays;
import java.util.List;

public class Util {
    private Util() {
    }

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(Delimiter.COMMA.value)).map(String::trim).toList();
    }

    public static List<String> splitByDash(String input) {
        return Arrays.stream(input.split(Delimiter.DASH.value)).map(String::trim).toList();
    }

    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private enum Delimiter {
        COMMA(","),
        DASH("-"),
        ;

        public final String value;

        Delimiter(String value) {
            this.value = value;
        }
    }
}

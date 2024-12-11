package christmas.domain;

import java.util.List;

public class Special {
    public static final List<Integer> dates = List.of(3, 10, 17, 24, 31);

    public static boolean isSpecialDay(final int date) {
        return dates.stream().anyMatch(d -> d == date);
    }
}

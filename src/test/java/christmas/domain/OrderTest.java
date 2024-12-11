package christmas.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.infrastructure.constants.ExceptionMessage;
import christmas.infrastructure.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {
    @ParameterizedTest
    @DisplayName("음료만 주문시 주문할 수 없다")
    @ValueSource(strings = {"제로콜라-1, 레드와인-2, 샴페인-1", "제로콜라-1", "레드와인-2", "샴페인-1"})
    void 음료만_주문_예외(String input) {
        // given

        // when & then
        assertThatThrownBy(() -> {
            Order.of(input);
        }).describedAs(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("주문은 최대 20개까지 가능하다.")
    @ValueSource(strings = {"제로콜라-20, 초코케이크-1"})
    void 최대_20개_주문(String input) {
        // given

        // when & then
        assertThatThrownBy(() -> {
            Order.of(input);
        }).describedAs(ExceptionMessage.INVALID_ORDER.getMessage());
    }
}
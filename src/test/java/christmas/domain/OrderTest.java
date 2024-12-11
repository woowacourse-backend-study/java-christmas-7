package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.infrastructure.constants.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @DisplayName("총 주문 금액을 올바르게 계산할 수 있다.")
    @CsvSource(value = {"제로콜라-10, 초코케이크-1:45000", "양송이수프-1:6000"}, delimiter = ':')
    void 총_주문_금액_계산(String input, int total) {
        // given
        Order order = Order.of(input);

        // when
        final int totalPrice = order.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(total);
    }

    @Test
    @DisplayName("카테고리별 메뉴의 주문 수를 올바르게 반환할 수 있다.")
    void 카테고리별_메뉴_개수_반환() {
        // given
        Order order = Order.of("티본스테이크-2, 크리스마스파스타-1, 제로콜라-1");

        // when
        final int mainCount = order.getMenuCount(MenuType.MAIN);
        final int drinkCount = order.getMenuCount(MenuType.DRINK);

        // then
        assertThat(mainCount).isEqualTo(3);
        assertThat(drinkCount).isEqualTo(1);
    }
}
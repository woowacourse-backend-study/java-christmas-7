package christmas.service.discount;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.DecemberDate;
import christmas.domain.Order;
import christmas.service.dto.DiscountResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasDiscountServiceTest {
    private ChristmasDiscountService christmasDiscountService = new ChristmasDiscountService();

    @Test
    @DisplayName("25일 이후에는 이벤트가 적용되지 않는다.")
    void 이벤트_미적용() {
        // given
        DecemberDate date = new DecemberDate(26);
        Order order = Order.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        // when
        DiscountResponse response = christmasDiscountService.getDiscountInfo(date, order);

        // then
        assertThat(response.discountPrice()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("25일 이전에는 날짜에 맞게 혜택이 적용된다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25})
    void 이벤트_적용(final int input) {
        // given
        DecemberDate date = new DecemberDate(input);
        Order order = Order.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        // when
        DiscountResponse response = christmasDiscountService.getDiscountInfo(date, order);

        // then
        assertThat(response.discountPrice()).isEqualTo(1000 + (input - 1) * 100);
    }
}
package christmas.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.DecemberDate;
import christmas.domain.Order;
import christmas.service.dto.ChristmasEventResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasEventServiceTest {
    private ChristmasEventService christmasEventService = new ChristmasEventService();

    @Test
    @DisplayName("총 주문 금액이 10,000원 미만인 경우 이벤트가 적용되지 않는다.")
    void 이벤트_미적용_조건() {
        // given
        DecemberDate date = new DecemberDate(1);
        Order order = Order.of("제로콜라-1, 타파스-1");

        // when
        ChristmasEventResponse response = christmasEventService.apply(date, order);

        // then
        assertThat(response.totalBenefit()).isEqualTo(0);
    }
}
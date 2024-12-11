package christmas.service.gift;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.Menu;
import christmas.service.dto.GiftResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasGiftServiceTest {
    private ChristmasGiftService christmasGiftService = new ChristmasGiftService();

    @Test
    @DisplayName("총 구입 금액이 120,000원 미만인 경우 증정품이 지급되지 않는다.")
    void 증정품_미지급() {
        // given
        final int totalPrice = 119999;

        // when
        GiftResponse response = christmasGiftService.getGiftInfo(totalPrice);

        // then
        assertThat(response.menu()).isNull();
    }

    @ParameterizedTest
    @DisplayName("총 구입 금액이 120,000원 이상인 경우 증정품이 지급된다.")
    @ValueSource(ints = {120000, 120001, 230000})
    void 증정품_지급(final int totalPrice) {
        // given

        // when
        GiftResponse response = christmasGiftService.getGiftInfo(totalPrice);

        // then
        assertThat(response.menu()).isSameAs(Menu.샴페인);
    }
}
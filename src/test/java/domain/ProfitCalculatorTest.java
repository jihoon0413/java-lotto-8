package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.enums.Rank;
import dto.PaymentResponse;
import dto.WinningRecordDto;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    ProfitCalculator profitCalculator = new ProfitCalculator();

    @Test
    @DisplayName("투입한 금액과 당첨 금액을 통해 수익률을 계산")
    public void givenWinningRecordWhenCalculateThenBenefitRate() {
        WinningRecordDto winningRecord = getWinningRecordDto();
        PaymentResponse inputPriceDto = PaymentResponse.of(8000);

        String profitRate = profitCalculator.calculateProfit(winningRecord, inputPriceDto);

        assertThat(profitRate).isEqualTo("62.5");
    }

    @Test
    @DisplayName("당첨 기록으로 총 상금을 계산")
    public void givenWinningRecordWhenGetTotalPrizeThenTotalPrize() {
        WinningRecordDto winningRecord = getWinningRecordDto();
        double totalPrize = profitCalculator.getTotalPrize(winningRecord.getWinningRecord());
        assertThat(5000.0).isEqualTo(totalPrize);
    }

    private WinningRecordDto getWinningRecordDto() {
        Map<Rank, Integer> winningRecord = new HashMap<>();
        winningRecord.put(Rank.FIFTH, 1);
        winningRecord.put(Rank.NO_MATCH, 7);
        return WinningRecordDto.of(winningRecord);
    }

}
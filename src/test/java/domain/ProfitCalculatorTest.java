package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import domain.enums.Rank;
import dto.InputPriceDto;
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
        InputPriceDto inputPriceDto = InputPriceDto.of(8000);

        double profitRate = profitCalculator.calculateProfit(winningRecord, inputPriceDto);

        assertThat(profitRate).isEqualTo(62.5);
    }

    private WinningRecordDto getWinningRecordDto() {
        Map<Rank, Integer> winningRecord = new HashMap<>();
        winningRecord.put(Rank.FIFTH, 1);
        winningRecord.put(Rank.NO_MATCH, 7);
        return WinningRecordDto.of(winningRecord);
    }

}
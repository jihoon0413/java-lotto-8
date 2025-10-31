package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import dto.WinningNumbersResponse;
import dto.WinningRecordDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntToDoubleFunction;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberMatcherTest {

    WinningNumberMatcher matcher = new WinningNumberMatcher();

    @Test
    @DisplayName("발행한 로또와 당첨 번호를 통해 당첨 내역을 받는다.")
    public void givenMyLottoAndWinningLottoInfoWhenMatchThenWinningRecord() {
        WinningNumbersResponse winningInfo = WinningNumbersResponse.of(List.of(1,2,3,4,5,6),7);
        List<Lotto> myLotto = getMyLotto();

        WinningRecordDto winningRecordDto = matcher.matchMyLotto(winningInfo, myLotto);

        assertThat(winningRecordDto.getWinningRecord().size()).isEqualTo(6);
        assertThat(winningRecordDto.getTotalPrize()).isEqualTo(2031555000);
    }

    private List<Lotto> getMyLotto() {
        List<Lotto> myLotto = new ArrayList<>();
        myLotto.add(new Lotto(List.of(1,2,3,4,5,6)));
        myLotto.add(new Lotto(List.of(1,2,3,4,5,7)));
        myLotto.add(new Lotto(List.of(1,2,3,4,5,8)));
        myLotto.add(new Lotto(List.of(1,2,3,4,8,9)));
        myLotto.add(new Lotto(List.of(1,2,3,8,9,10)));
        myLotto.add(new Lotto(List.of(1,2,8,9,10,11)));
        return myLotto;
    }
}
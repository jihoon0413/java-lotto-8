package domain;

import static org.assertj.core.api.Assertions.assertThat;

import dto.WinningNumbersResponse;
import dto.WinningRecordDto;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    @DisplayName("하나의 로또에 당첨된 번호의 갯수를 구하는 기능 테스트")
    public void givenLottoAndWinningNumbersWhenCountMatchNumThenMatchCount() {
        List<Integer> myLotto1 = List.of(1,2,3,4,5,6);
        List<Integer> myLotto2 = List.of(1,2,3,4,5,7);
        List<Integer> myLotto3 = List.of(1,2,3,7,8,9);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        assertThat(6).isEqualTo(matcher.countMatchNum(myLotto1, winningNumbers));
        assertThat(5).isEqualTo(matcher.countMatchNum(myLotto2, winningNumbers));
        assertThat(3).isEqualTo(matcher.countMatchNum(myLotto3, winningNumbers));

    }

    @Test
    @DisplayName("보너스 번호의 일치 여부 확인 테스트")
    public void givenLottoAndBonusNumWhenCheckMatchBonusThenBoolean() {
        List<Integer> myLotto1 = List.of(1,2,3,4,5,7);
        List<Integer> myLotto2 = List.of(1,2,3,4,5,6);
        int bonusNum = 7;

        assertThat(true).isEqualTo(matcher.checkMatchBonus(myLotto1,bonusNum));
        assertThat(false).isEqualTo(matcher.checkMatchBonus(myLotto2,bonusNum));

    }
}
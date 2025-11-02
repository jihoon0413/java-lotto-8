package domain;

import domain.enums.Rank;
import dto.WinningNumbersResponse;
import dto.WinningRecordDto;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import lotto.Lotto;

public class WinningNumberMatcher {

    public WinningRecordDto matchMyLotto(WinningNumbersResponse winningInfo, List<Lotto> myLotto) {
        Map<Rank, Integer> winningRecord = new HashMap<>();
        for (Lotto lotto : myLotto) {
            int matchCount = countMatchNum(lotto.getNumbers(), winningInfo.getWinningNumbers());
            boolean isMatchBonus = false;
            if(matchCount == 5 && checkMatchBonus(lotto.getNumbers(), winningInfo.getBonusNumber())) {
                isMatchBonus = true;
            }
            Rank myRank = Rank.getRank(matchCount, isMatchBonus);
            int count = winningRecord.getOrDefault(myRank,0);
            winningRecord.put(myRank, count+1);
        }
        return WinningRecordDto.of(winningRecord);
    }

    public int countMatchNum(List<Integer> myLotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer num : myLotto) {
            if(winningNumbers.contains(num)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean checkMatchBonus(List<Integer> myLotto, int bonusNum) {
        return myLotto.contains(bonusNum);
    }

}

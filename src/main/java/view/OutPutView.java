package view;

import domain.enums.Rank;
import dto.WinningRecordDto;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class OutPutView {

    public void printLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        int count = lottos.size();

        sb.append("\n").append(count).append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos) {
            sb.append("[").append(lotto.getNumbersToString()).append("]\n");
        }
        System.out.println(sb);
    }

    public void printResult(WinningRecordDto winningRecord, String profitRate) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n---\n");
        sb.append(printRankResult(winningRecord.getWinningRecord()));
        sb.append("총 수익률은 ").append(profitRate).append("%입니다.");
        System.out.println(sb);
    }

    private String printRankResult(Map<Rank, Integer> winningRecord) {
        Rank[] ranks = Rank.ranks;
        StringBuilder sb = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("###,###");
        for (Rank rank : ranks) {
            sb.append(rank.getMatchCount()).append("개 일치");
            if(rank.isMatchBonus()){
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (").append(formatter.format(rank.getPrize())).append("원) - ")
                   .append(winningRecord.getOrDefault(rank,0)).append("개\n");
        }
        return sb.toString();
    }
}

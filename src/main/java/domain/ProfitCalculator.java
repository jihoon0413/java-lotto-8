package domain;

import domain.enums.Rank;
import dto.PaymentResponse;
import dto.WinningRecordDto;
import java.util.Map;
import java.util.Set;

public class ProfitCalculator {

    public double calculateProfit(WinningRecordDto winningRecord, PaymentResponse inputPrice) {
        double totalPrize = getTotalPrize(winningRecord.getWinningRecord());
        return totalPrize / inputPrice.getPayment() * 100;
    }

    public double getTotalPrize(Map<Rank, Integer> winningRecord) {
        Set<Rank> ranks = winningRecord.keySet();
        double totalPrize = 0;
        for (Rank rank : ranks) {
            totalPrize += (rank.getPrize() * winningRecord.get(rank));
        }
        return totalPrize;
    }

}

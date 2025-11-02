package service;

import domain.LottoMachine;
import domain.ProfitCalculator;
import domain.WinningNumberMatcher;
import dto.PaymentResponse;
import dto.WinningNumbersResponse;
import dto.WinningRecordDto;
import java.util.List;
import lotto.Lotto;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final WinningNumberMatcher winningNumberMatcher = new WinningNumberMatcher();
    private final ProfitCalculator profitCalculator = new ProfitCalculator();


    public List<Lotto> publishLotto(Integer payment) {
        return lottoMachine.createLottos(payment);
    }

    public WinningRecordDto getWinningRecord(WinningNumbersResponse winningInfo, List<Lotto> myLotto) {
        return winningNumberMatcher.matchMyLotto(winningInfo, myLotto);
    }

    public double calculateProfitRate(WinningRecordDto winningInfo, PaymentResponse inputPrice) {
        return profitCalculator.calculateProfit(winningInfo, inputPrice);
    }

}

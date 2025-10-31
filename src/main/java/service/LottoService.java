package service;

import domain.LottoMachine;
import domain.ProfitCalculator;
import domain.WinningNumberMatcher;
import dto.InputPriceDto;
import dto.WinningNumbersResponse;
import dto.WinningRecordDto;
import java.util.List;
import lotto.Lotto;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final WinningNumberMatcher winningNumberMatcher = new WinningNumberMatcher();
    private final ProfitCalculator profitCalculator = new ProfitCalculator();


    public List<Lotto> publishLotto(InputPriceDto inputPriceDto) {
        return lottoMachine.createLottos(inputPriceDto);
    }

    public WinningRecordDto getWinningRecord(WinningNumbersResponse winningInfo, List<Lotto> myLotto) {
        return winningNumberMatcher.matchMyLotto(winningInfo, myLotto);
    }

    public String calculateProfitRate(WinningRecordDto winningInfo, InputPriceDto inputPrice) {
        return profitCalculator.calculateProfit(winningInfo, inputPrice);
    }

}

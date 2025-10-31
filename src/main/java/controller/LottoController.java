package controller;

import dto.InputPriceDto;
import dto.WinningNumbersResponse;
import dto.WinningRecordDto;
import java.util.List;
import lotto.Lotto;
import service.LottoService;
import view.InputView;
import view.OutPutView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();
    private final OutPutView outPutView = new OutPutView();

    public void run() {
        InputPriceDto inputPrice = inputView.getInputPrice();
        List<Lotto> lottos = lottoService.publishLotto(inputPrice);
        outPutView.printLottos(lottos);

        WinningNumbersResponse winningNumbersResponse = inputView.getWinningNumbersResponse();
        WinningRecordDto winningRecord = lottoService.getWinningRecord(winningNumbersResponse, lottos);
        String profitRate = lottoService.calculateProfitRate(winningRecord, inputPrice);
    }
}

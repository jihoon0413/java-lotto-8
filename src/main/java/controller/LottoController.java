package controller;

import domain.LottoMachine;
import dto.InputPriceDto;
import dto.WinningNumbersResponse;
import java.util.List;
import lotto.Lotto;
import view.InputView;
import view.OutPutView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final LottoMachine lottoMachine = new LottoMachine();
    private final OutPutView outPutView = new OutPutView();

    public void run() {
        InputPriceDto dto = inputView.getInputPrice();
        List<Lotto> lottos = lottoMachine.createLottos(dto);
        outPutView.printLottos(lottos);
        WinningNumbersResponse winningNumbersResponse = inputView.getWinningNumbersResponse();
    }
}

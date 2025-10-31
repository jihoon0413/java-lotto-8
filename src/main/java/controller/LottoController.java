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
        InputPriceDto dto = inputPrice();
        List<Lotto> lottos = lottoMachine.createLottos(dto);
        outPutView.printLottos(lottos);
        WinningNumbersResponse winningNumbersResponse = inputView.getWinningNumbersResponse();
    }

    private InputPriceDto inputPrice() {
        InputPriceDto dto;
        while (true) {
            try {
                 dto = inputView.getInputPrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return dto;
        }
    }
}

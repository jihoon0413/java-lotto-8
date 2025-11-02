package controller;

import dto.PaymentResponse;
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
        // 금액 입력, 로또 생성 및 출력
        PaymentResponse paymentResponse = inputView.getPaymentResponse();
        List<Lotto> lottos = lottoService.publishLotto(paymentResponse.getPayment());
        outPutView.printLottos(lottos);

        // 당첨 번호, 보너스 번호 입력
        WinningNumbersResponse winningNumbersResponse = inputView.getWinningNumbersResponse();

        // 당첨 내역, 수익률 계산
        WinningRecordDto winningRecord = lottoService.getWinningRecord(winningNumbersResponse, lottos);
        double profitRate = lottoService.calculateProfitRate(winningRecord, paymentResponse);

        // 당첨 내역, 수익률 출력
        outPutView.printResult(winningRecord, profitRate);
    }
}

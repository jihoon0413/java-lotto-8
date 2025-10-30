package controller;

import dto.InputPriceDto;
import view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();

    public void run() {
        while (true) {
            try {
                InputPriceDto dto = inputView.getInputPrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("develop lotto mechain");
            break;
        }
    }

}

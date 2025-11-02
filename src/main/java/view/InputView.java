package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Splitter;
import domain.Validator;
import dto.PaymentResponse;
import dto.WinningNumbersResponse;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final Validator validator = new Validator();
    private final Splitter splitter = new Splitter();

    public PaymentResponse getPaymentResponse() {
        while(true) {
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validator.validatePaymentResponse(input);
                return PaymentResponse.of(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumbersResponse getWinningNumbersResponse() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        return WinningNumbersResponse.of(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                validator.validateWinningNumbersStringInput(input);
                String[] delimitedInput =  splitter.split(input);
                validator.validateWinningNumbers(delimitedInput);
                return Arrays.stream(delimitedInput).map(Integer::parseInt).toList();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonus = Console.readLine();
            try {
                validator.validateBonusNumber(winningNumbers, bonus);
                return Integer.parseInt(bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

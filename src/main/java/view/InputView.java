package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Validator;
import dto.InputPriceDto;

public class InputView {

    private final Validator validator = new Validator();

    public InputPriceDto getInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
        return InputPriceDto.of(Integer.parseInt(input));
    }

    private void validate(String input) {
        validator.validateNumber(input);
        validator.validateThousandUnit(Integer.parseInt(input));
    }

}

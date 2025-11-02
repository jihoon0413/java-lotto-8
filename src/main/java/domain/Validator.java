package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {

    public void validatePriceInput(String input) {
        validateNumber(input);
        validateThousandUnit(Integer.parseInt(input));
    }

    public void validateWinningNumbersStringInput(String input) {
        if(!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 구분자를 확인해 주세요.");
        }
        if(input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 구분자의 형식을 확인해 주세요.");
        }
    }

    public void validateWinningNumbers(String[] winningNumbers) {
        validateLottoNumberCount(winningNumbers);
        for (String str : winningNumbers) {
            validateNumber(str);
            validateLottoNumber(Integer.parseInt(str));
        }
        validateDuplicateWinningNumbers(winningNumbers);
    }

    public void validateBonusNumber(List<Integer> winningNumbers, String bonus) {
        validateNumber(bonus);
        int bonusNumber = Integer.parseInt(bonus);
        validateLottoNumber(bonusNumber);
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호 6자리 숫자와 중복될 수 없습니다.");
        }
    }

    void validateNumber(String input) {
        if(!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외(공백, 문자 등)의 입력을 할 수 없습니다.");
        }
    }

    void validateThousandUnit(int price) {
        if(price % 1000 != 0 || price <= 0) {
            throw new IllegalArgumentException("[ERROR] 0이상의 천원 단위로만 입력 가능합니다.");
        }
    }

    void validateLottoNumber(int num) {
        if(num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자만 입력 가능합니다.");
        }
    }

    void validateLottoNumberCount(String[] winningNumbers) {
        if(winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 로또 번호를 입력하세요");
        }
    }

    void validateDuplicateWinningNumbers(String[] winningNumbers) {
        Set<Integer> result =  Arrays.stream(winningNumbers).map(Integer::parseInt).collect(Collectors.toSet());
        if(result.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 6자리 숫자를 입력하세요");
        }
    }
}

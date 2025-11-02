package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("입력 값이 숫자가 아닌 경우 에러 발생")
    public void givenNotNumberWhenValidateThenException() {
        String input = "12000원";
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> validator.validateNumber(input));
        assertEquals("[ERROR] 숫자 이외(공백, 문자 등)의 입력을 할 수 없습니다.", ex.getMessage());
    }

    @Test
    @DisplayName("0 이상의 천원 단위의 입력 값이 아닌 경우 에러 발생")
    public void givenNotThousandUnitWhenValidateThenException() {
        int price1 = 113002;
        int price2 = 0;

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateThousandUnit(price1));
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateThousandUnit(price2));
        assertEquals("[ERROR] 0이상의 천원 단위로만 입력 가능합니다.", ex1.getMessage());
        assertEquals("[ERROR] 0이상의 천원 단위로만 입력 가능합니다.", ex2.getMessage());
    }

    @Test
    @DisplayName("로또 번호인 1~45 이외의 숫자가 입력 시 에러 발생")
    public void givenNotLottoNumberWhenValidateLottoNumberThenException() {
        int notLottoNum1 = 0;
        int notLottoNum2 = 46;

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateLottoNumber(notLottoNum1));
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateLottoNumber(notLottoNum2));
        assertEquals("[ERROR] 로또 번호는 1~45 사이의 숫자만 입력 가능합니다.", ex1.getMessage());
        assertEquals("[ERROR] 로또 번호는 1~45 사이의 숫자만 입력 가능합니다.", ex2.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복 되었을 떄 에러 발생")
    public void givenBonusNumContainWinningNumbersWhenValidateBonusNumberThenException() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        String bonus = "3";

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> validator.validateBonusNumber(winningNumbers, bonus));
        assertEquals("[ERROR] 보너스 번호는 당첨 번호 6자리 숫자와 중복될 수 없습니다.", ex.getMessage());
    }

    @Test
    @DisplayName("잘못된 형식의 당첨 번호 입력 시 에러 발생")
    public void givenWrongWinningNumbersStingInputWhenValidateThenException() {
        String str1 = "1;2;3;4;5;6";
        String str2 = "1,2,3,4,5,6,";

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateWinningNumbersStringInput(str1));
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateWinningNumbersStringInput(str2));
        assertEquals("[ERROR] 구분자를 확인해 주세요.", ex1.getMessage());
        assertEquals("[ERROR] 구분자의 형식을 확인해 주세요.", ex2.getMessage());
    }

    @Test
    @DisplayName("잘못된 길이의 당첨 번호가 주어졌을 때 에러 발생")
    public void givenWrongSizeWinningNumbersWhenValidateThenException() {
        String[] input1 = {"1","2","3","4","5"};
        String[] input2 = {"1","2","3","4","5","6","7"};

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateLottoNumberCount(input1));
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateLottoNumberCount(input2));

        assertEquals("[ERROR] 6자리의 로또 번호를 입력하세요", ex1.getMessage());
        assertEquals("[ERROR] 6자리의 로또 번호를 입력하세요", ex2.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에서 중복이 있을 경우 에러 발생")
    public void givenDuplicatedWinningNumbersWhenValidateThenException() {
        String[] input1 = {"1","1","2","3","4","5"};
        String[] input2 = {"1","1","2","2","3","4"};

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateDuplicateWinningNumbers(input1));
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateDuplicateWinningNumbers(input2));

        assertEquals("[ERROR] 중복되지 않은 6자리 숫자를 입력하세요", ex1.getMessage());
        assertEquals("[ERROR] 중복되지 않은 6자리 숫자를 입력하세요", ex2.getMessage());
    }
}
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
        assertEquals("[ERROR] 숫자만 입력 가능합니다.", ex.getMessage());
    }

    @Test
    @DisplayName("천원 단위의 입력 값이 아닌 경우 에러 발생")
    public void givenNotThousandUnitWhenValidateThenException() {
        int price = 113002;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> validator.validateThousandUnit(price));
        assertEquals("[ERROR] 천원 단위로만 입력 가능합니다.", ex.getMessage());
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
    @DisplayName("")
    public void givenBonusNumContainWinningNumbersWhenValidateBonusNumberThenException() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonosNum = 3;

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> validator.validateBonusNumber(winningNumbers, bonosNum));
        assertEquals("[ERROR] 보너스 번호는 당첨 번호 6자리 숫자와 중복될 수 없습니다.", ex.getMessage());

    }
}
package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}
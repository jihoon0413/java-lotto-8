package domain;

public class Validator {

    public void validate(String input) {
    }

    public void validateNumber(String input) {
        if(!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public void validateThousandUnit(int price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로만 입력 가능합니다.");
        }
    }
}

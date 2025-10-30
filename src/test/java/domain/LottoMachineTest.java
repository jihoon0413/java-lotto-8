package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dto.InputPriceDto;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("금액이 주어졌을 때 금액에 맞는 개수의 로또가 오류 없이 생성")
    public void givenInputPriceDtoWhenCreateLottosThenLottoList() {
        InputPriceDto inputPriceDto = InputPriceDto.of(8000);

        List<Lotto> result = lottoMachine.createLottos(inputPriceDto);

        assertThat(result.size()).isEqualTo(8);

        for (Lotto lotto : result) {
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
            assertTrue(isSorted(lotto.getNumbers()));
        }
    }

    @Test
    @DisplayName("로또 번호 생성시 정렬된 로또 번호 생성")
    public void whenCreateNumbersThenSortedLottoNumbers() {
        List<Integer> numbers = lottoMachine.createNumbers();
        assertThat(numbers.size()).isEqualTo(6);
        assertTrue(isSorted(numbers));
    }

    private boolean isSorted(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if(numbers.get(i-1) >  numbers.get(i)) {
                return false;
            }
        }
        return true;
    }
  
}
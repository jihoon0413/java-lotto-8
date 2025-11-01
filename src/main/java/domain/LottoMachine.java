package domain;

import camp.nextstep.edu.missionutils.Randoms;
import dto.InputPriceDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoMachine {

    public List<Lotto> createLottos(InputPriceDto dto) {
        int count = dto.getPrice()/1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = createNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    public List<Integer> createNumbers() {
        return sorting(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    private List<Integer> sorting(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;

    }
}

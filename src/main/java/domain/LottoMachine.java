package domain;

import camp.nextstep.edu.missionutils.Randoms;
import dto.InputPriceDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class LottoMachine {

    public List<Lotto> createLottos(InputPriceDto dto) {
        int count = dto.getPrice()/1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(createNumbers()));
        }
        return lottos;
    }

    public List<Integer> createNumbers() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != 6 ) {
            set.add(Randoms.pickNumberInRange(1,45));
        }
        return sorting(new ArrayList<>(set));
    }

    public List<Integer> sorting(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}

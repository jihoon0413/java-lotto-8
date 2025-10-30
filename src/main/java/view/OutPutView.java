package view;

import java.util.List;
import lotto.Lotto;

public class OutPutView {

    public void printLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        int count = lottos.size();

        sb.append(count).append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos) {
            sb.append("[").append(lotto.getNumbersToString()).append("]\n");
        }
        System.out.println(sb);
    }


}

package dto;

import domain.enums.Rank;
import java.util.Map;

public class WinningRecordDto {
    Map<Rank, Integer> winningRecord;

    private WinningRecordDto (Map<Rank, Integer> winningRecord) {
        this.winningRecord = winningRecord;

    }

    public static WinningRecordDto of(Map<Rank, Integer> winningRecord) {
        return new WinningRecordDto(winningRecord);
    }

    public Map<Rank, Integer> getWinningRecord() {
        return winningRecord;
    }
}

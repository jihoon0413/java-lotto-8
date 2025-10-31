package dto;

import java.util.List;

public class WinningNumbersResponse {
    List<Integer> winningNumbers;
    int bonusNumber;

    private WinningNumbersResponse(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbersResponse of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumbersResponse(winningNumbers, bonusNumber);
    }
}

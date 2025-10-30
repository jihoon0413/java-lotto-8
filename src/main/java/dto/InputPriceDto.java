package dto;

public class InputPriceDto {
    int price;

    private InputPriceDto(int price) {
        this.price = price;
    }

    public static InputPriceDto of(int price) {
        return new InputPriceDto(price);
    }

}

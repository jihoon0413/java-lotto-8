package dto;

public class PaymentResponse {
    int payment;

    private PaymentResponse(int payment) {
        this.payment = payment;
    }

    public static PaymentResponse of(int payment) {
        return new PaymentResponse(payment);
    }

    public int getPayment() {
        return payment;
    }
}

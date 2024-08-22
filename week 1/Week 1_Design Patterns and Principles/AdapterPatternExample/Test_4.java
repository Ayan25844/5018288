public class Test_4 {

    public static void main(String[] args) {

        PayPalAdapter trans_1 = new PayPalAdapter();
        System.out.println(trans_1.processPayment());

        SquareAdapter trans_2 = new SquareAdapter();
        System.out.println(trans_2.processPayment());

        StripeAdapter trans_3 = new StripeAdapter();
        System.out.println(trans_3.processPayment());

    }

}

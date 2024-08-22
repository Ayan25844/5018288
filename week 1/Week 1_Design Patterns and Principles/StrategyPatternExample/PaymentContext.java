package StrategyPatternExample;

public class PaymentContext {

    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(long amount) {
        strategy.pay(amount);
    }

}

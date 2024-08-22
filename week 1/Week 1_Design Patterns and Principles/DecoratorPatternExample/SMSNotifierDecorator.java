public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier wrapped) {
        super(wrapped);
    }

    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending " + msg + " by sms to " + super.getUserName());
    }

}

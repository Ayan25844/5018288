public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier wrapped) {
        super(wrapped);
    }

    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending " + msg + " by slack to " + super.getUserName());
    }

}

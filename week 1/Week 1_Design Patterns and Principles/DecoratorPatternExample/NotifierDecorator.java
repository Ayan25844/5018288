public abstract class NotifierDecorator implements Notifier {

    private final Notifier wrapped;

    public NotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    public void send(String msg) {
        wrapped.send(msg);
    }

    public String getUserName() {
        return wrapped.getUserName();
    }

}

public class EmailNotifier implements Notifier {

    private final String userName;

    public EmailNotifier(String userName) {
        this.userName = userName;
    }

    public void send(String msg) {
        System.out.println("Sending " + msg + " by email to " + this.userName);
    }

    public String getUserName() {
        return this.userName;
    }

}

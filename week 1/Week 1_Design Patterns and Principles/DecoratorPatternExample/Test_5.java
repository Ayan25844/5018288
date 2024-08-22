public class Test_5 {

    public static void main(String[] args) {

        Notifier notify = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier("Ayan")));
        notify.send("marks");
    }

}

public class Test {
    public static void main(String[] args) {

        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        String message = "Hello, this is a notification.";

        System.out.println("Sending notification through Email, SMS, and Slack:");
        slackNotifier.send(message);

        System.out.println("\nSending notification through Email and SMS:");
        smsNotifier.send(message);

        System.out.println("\nSending notification through Email only:");
        emailNotifier.send(message);
    }
}
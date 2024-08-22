public class MobileApp implements Observer {

    private final String mobile;

    public MobileApp(String mobile) {
        this.mobile = mobile;
    }

    public void update() {
        System.out.println("Updating " + this.mobile + " via mobile app.");
    }

}

public class WebApp implements Observer {

    private final String mobile;

    public WebApp(String mobile) {
        this.mobile = mobile;
    }

    public void update() {
        System.out.println("Updating " + this.mobile + " via web app.");
    }

}

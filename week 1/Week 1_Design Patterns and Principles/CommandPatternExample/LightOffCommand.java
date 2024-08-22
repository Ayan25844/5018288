public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand() {
        light = new Light();
    }

    public void execute() {
        light.switchOff();
    }

}

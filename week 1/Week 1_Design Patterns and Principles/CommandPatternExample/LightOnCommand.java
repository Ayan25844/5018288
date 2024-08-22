public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand() {
        light = new Light();
    }

    public void execute() {
        light.switchOn();
    }

}

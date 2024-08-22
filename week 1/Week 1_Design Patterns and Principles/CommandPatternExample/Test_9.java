public class Test_9 {

    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand());
        remote.execute();
        remote.setCommand(new LightOffCommand());
        remote.execute();
    }

}

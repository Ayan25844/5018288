package ProxyPatternExample;

public class RealImage implements Image {

    public String display(String name) {

        System.out.println("Displaying " + name);
        return name;

    }

}

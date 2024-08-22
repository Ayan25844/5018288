package ProxyPatternExample;

import java.util.HashMap;

public class ProxyImage implements Image {

    private final Image image = new RealImage();
    HashMap<String, String> map = new HashMap<>();

    public String display(String name) {

        if (!map.containsKey(name)) {
            map.put(name, image.display(name));
        }

        return map.get(name);

    }

}

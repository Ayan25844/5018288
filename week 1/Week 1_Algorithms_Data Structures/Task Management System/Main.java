public class Main {
    public static void main(String[] args) {
        Management test = new Management();
        test.add("test 1", true, 0);
        test.add("test 2", false, 1);
        test.add("test 3", false, 2);
        test.add("test 4", true, 3);
        test.add("test 5", false, 4);
        System.out.println(test.search(1));
        test.delete(0);
        test.traverse();
    }
}

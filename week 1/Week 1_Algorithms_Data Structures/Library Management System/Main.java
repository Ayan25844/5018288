public class Main {
    public static void main(String[] args) {

        new Library("title 2", "author 2");
        new Library("title 1", "author 1");
        new Library("title 3", "author 3");
        new Library("title 4", "author 4");
        new Library("title 5", "author 5");

        System.out.println(Library.linearSearch("title 3"));
        System.out.println(Library.binarySearch("title 4"));
    }
}
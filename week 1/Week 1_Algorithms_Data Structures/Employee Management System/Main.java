public class Main {
    public static void main(String[] args) {

        new DataBase("Ramesh", 10000, "HR");
        new DataBase("Suresh", 26000, "Manager");
        new DataBase("Rakesh", 12000, "Developer");

        System.out.println(DataBase.search(3));
        System.out.println(DataBase.delete(2));
    }
}

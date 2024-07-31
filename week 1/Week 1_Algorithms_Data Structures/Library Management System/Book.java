public class Book {

    private int bookId;
    private String title;
    private String author;
    private static int idCounter = 0;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookId = ++idCounter;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}

public abstract class DocumentFactory {

    public abstract void createDocument();

    public void openDocument() {
        createDocument();
    }
}

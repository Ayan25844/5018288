public class WordDocumentFactory extends DocumentFactory {

    @Override
    public void createDocument() {
        WordDocument document = new WordDocument();
        document.open();
        document.save();
        document.close();
    }
}

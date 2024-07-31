public class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public void createDocument() {
        ExcelDocument document = new ExcelDocument();
        document.open();
        document.save();
        document.close();
    }
}

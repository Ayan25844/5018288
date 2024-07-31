public class PdfDocumentFactory extends DocumentFactory {

    @Override
    public void createDocument() {
        PdfDocument document = new PdfDocument();
        document.open();
        document.save();
        document.close();
    }
}

public class Test {
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        System.out.println("Creating Word document:");
        wordFactory.openDocument();

        System.out.println("\nCreating PDF document:");
        pdfFactory.openDocument();

        System.out.println("\nCreating Excel document:");
        excelFactory.openDocument();
    }
}

public class Test_2 {

    public static void main(String[] args) {

        WordDocumentFactory word = new WordDocumentFactory();
        Document wordDocument = word.createDocument();
        System.out.println(wordDocument.open());
        System.out.println(wordDocument.save());
        System.out.println(wordDocument.close());

        ExcelDocumentFactory excel = new ExcelDocumentFactory();
        Document ExcelDocument = excel.createDocument();
        System.out.println(ExcelDocument.open());
        System.out.println(ExcelDocument.save());
        System.out.println(ExcelDocument.close());

        PdfDocumentFactory pdf = new PdfDocumentFactory();
        Document pdfDocument = pdf.createDocument();
        System.out.println(pdfDocument.open());
        System.out.println(pdfDocument.save());
        System.out.println(pdfDocument.close());

    }

}

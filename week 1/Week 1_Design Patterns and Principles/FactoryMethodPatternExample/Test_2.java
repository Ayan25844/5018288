public class Test_2 {

    public static void main(String[] args) {

        Document word = new WordDocument();
        System.out.println(word.open());
        System.out.println(word.save());
        System.out.println(word.close());

        Document excel = new ExcelDocument();
        System.out.println(excel.open());
        System.out.println(excel.save());
        System.out.println(excel.close());

        Document pdf = new PdfDocument();
        System.out.println(pdf.open());
        System.out.println(pdf.save());
        System.out.println(pdf.close());

    }

}

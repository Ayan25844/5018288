public class ExcelDocument implements Document {

    public String open() {
        return "Opening excel document";
    }

    public String save() {
        return "Saving excel document.";
    }

    public String close() {
        return "Closing excel document.";
    }
}

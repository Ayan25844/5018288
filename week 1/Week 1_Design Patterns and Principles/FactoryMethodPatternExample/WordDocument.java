public class WordDocument implements Document {

    public String open() {
        return "Opening word document";
    }

    public String save() {
        return "Saving word document.";
    }

    public String close() {
        return "Closing word document.";
    }
}

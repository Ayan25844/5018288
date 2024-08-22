package BuilderPatternExample;

public class Computer {

    private String CPU;
    private String RAM;
    private String Storage;
    private String Display;
    private String Graphics;

    private Computer(Builder Builder) {
        this.CPU = Builder.CPU;
        this.RAM = Builder.RAM;
        this.Storage = Builder.Storage;
        this.Display = Builder.Display;
        this.Graphics = Builder.Graphics;
    };

    public String getCPU() {
        return this.CPU;
    }

    public String getRAM() {
        return this.RAM;
    }

    public String getStorage() {
        return this.Storage;
    }

    public String getDisplay() {
        return this.Display;
    }

    public String getGraphics() {
        return this.Graphics;
    }

    public static class Builder {

        private String CPU;
        private String RAM;
        private String Storage;
        private String Display;
        private String Graphics;

        public void setCPU(String CPU) {
            this.CPU = CPU;
        }

        public void setRAM(String RAM) {
            this.RAM = RAM;
        }

        public void setStorage(String Storage) {
            this.Storage = Storage;
        }

        public void setDisplay(String Display) {
            this.Display = Display;
        }

        public void setGraphics(String Graphics) {
            this.Graphics = Graphics;
        }

        public Computer build() {
            return new Computer(this);
        }

    }

}

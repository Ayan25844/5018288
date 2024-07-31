public class Test {
    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
                .setGraphicsCard("NVIDIA RTX 3080")
                .setStorage("1TB SSD")
                .setPowerSupply("850W")
                .setMotherboard("ASUS ROG")
                .build();

        Computer officePC = new Computer.Builder("Intel i5", "16GB")
                .setStorage("512GB SSD")
                .setPowerSupply("500W")
                .build();

        Computer budgetPC = new Computer.Builder("AMD Ryzen 3", "8GB")
                .setStorage("256GB SSD")
                .build();

        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
        System.out.println("Budget PC: " + budgetPC);
    }
}
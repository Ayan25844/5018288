package BuilderPatternExample;

import BuilderPatternExample.Computer.Builder;

public class Test_3 {

    public static void main(String[] args) {

        Builder combuilder = new Builder();
        combuilder.setCPU("CPU_Type_1");
        combuilder.setRAM("RAM_Type_1");
        combuilder.setStorage("Storage_Type_1");

        Computer com = combuilder.build();
        System.out.println(com.getCPU() + ' ' + com.getRAM() + ' ' + com.getStorage());

        Builder combuilder_2 = new Builder();
        combuilder_2.setRAM("RAM_Type__2");
        combuilder_2.setDisplay("Display_2");
        combuilder_2.setStorage("Storage_Type__2");

        Computer com_2 = combuilder_2.build();
        System.out.println(com_2.getDisplay() + ' ' + com_2.getRAM() + ' ' + com_2.getStorage());

    }

}

package MAPLabor.Lab1.Exercise_4;

public class Main {
    public static void main(String[] args) {
        Keyboard k1 = new Keyboard(15);
        Keyboard k2 = new Keyboard(80);
        Keyboard k3 = new Keyboard(39);
        Keyboard k4 = new Keyboard(14);
        USB u1 = new USB(10);
        USB u2 = new USB(25);
        USB u3 = new USB(19);
        USB u4 = new USB(100);

        System.out.println("Cheapest Keyboard: " + getCheapestKeyboard());
        System.out.println("Most Expensive Tool: " + getMostExpensiveTool());
        System.out.println("Most Expensive USB from 30$: " + getMostExpensiveUSB(30));
    }

    public static int getCheapestKeyboard() {
        int min = 10000;
        for (Keyboard keyboard : Keyboard.getAllKeyboards()) {
            if (keyboard.getPrice() < min) {
                min = keyboard.getPrice();
            }
        }
        return min;
    }

    public static int getMostExpensiveTool() {
        int max = 0;
        for (USB usb : USB.getAllUSBs()) {
            if (usb.getPrice() > max)
                max = usb.getPrice();
        }

        for(Keyboard keyboard : Keyboard.getAllKeyboards()) {
            if (keyboard.getPrice() > max)
                max = keyboard.getPrice();
        }
        return max;
    }

    public static int getMostExpensiveUSB(int budget) {
        int max = 0;
        for (USB usb : USB.getAllUSBs()) {
            if(usb.getPrice() > max && usb.getPrice() <= budget)
                max = usb.getPrice();
        }
        return max;
    }
}

package MAPLabor.Lab1.Exercise_4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
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
        System.out.println("Most Expensive Setup from 50$: " + bestCombination(50));
    }

    //? just a few lines having fun with assertions
    public static void test1() {
        Keyboard k1 = new Keyboard(60);
        USB u1 = new USB(8);
        USB u2 = new USB(12);

        int result = bestCombination(60);
        assert result == -1 : "Assertion failed";
        System.out.println("Assertion working!");
    }

    public static void test2() {
        Keyboard k1 = new Keyboard(40);

        int result = bestCombination(60);
        assert result == 52 : "Assertion failed";
        System.out.println("Assertion working!");
    }

    public static void test3() {
        Keyboard k1 = new Keyboard(50);

        int result = bestCombination(60);
        assert result == 58 : "Assertion failed";
        System.out.println("Assertion working!");
    }


    
    //? returns the price of the cheapest Keyboard
    public static int getCheapestKeyboard() {
        int min = 10000;
        for (Keyboard keyboard : Keyboard.getAllKeyboards()) {
            if (keyboard.getPrice() < min) {
                min = keyboard.getPrice();
            }
        }
        return min;
    }

    //? returns the most expensive tool
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

    //? returns the most expensive USB within the budget
    public static int getMostExpensiveUSB(int budget) {
        int max = 0;
        for (USB usb : USB.getAllUSBs()) {
            if(usb.getPrice() > max && usb.getPrice() <= budget)
                max = usb.getPrice();
        }
        return max;
    }

    //? checks for the most expensive combination within the budget. returns -1 if inexistent
    public static int bestCombination(int budget) {
        int price = -1;
        List<Keyboard> keyboards = Keyboard.getAllKeyboards();
        List<USB> usbs = USB.getAllUSBs();

        for (int i = 0; i < keyboards.size(); i++) {
            for (int j = 0; j < usbs.size(); j++) {
                int combination = keyboards.get(i).getPrice() + usbs.get(j).getPrice();
                if (combination <= budget && combination > price) {
                    price = combination;
                }
            }
        }
        return price;
    }
}
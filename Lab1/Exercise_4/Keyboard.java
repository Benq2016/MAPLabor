package MAPLabor.Lab1.Exercise_4;

import java.util.List;
import java.util.ArrayList;

public class Keyboard {
    int price = 0;
    static List<Keyboard> keyboards = new ArrayList<>();

    public Keyboard (int price) {
        this.price = price;
        keyboards.add(this);
    }

    public int getPrice() {
        return this.price;
    }

    public static List<Keyboard> getAllKeyboards() {
        return keyboards;
    }
}

package MAPLabor.Lab1.Exercise_4;

import java.util.ArrayList;
import java.util.List;

public class USB {
    int price = 0;
    static List<USB> usbs = new ArrayList<>();

    public USB(int price) {
        this.price = price;
        usbs.add(this);
    }

    public int getPrice() {
        return this.price;
    }

    public static List<USB> getAllUSBs() {
        return usbs;
    }
    
}

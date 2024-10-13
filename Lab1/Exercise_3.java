package MAPLabor.Lab1;

import java.util.Arrays;

public class Exercise_3 {
    public static void main(String[] args) {
        int[] number1 = new int[]{8, 7, 0, 0, 0, 0, 0, 0, 0};
        int[] number2 = new int[]{1, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] number3 = new int[]{2, 5, 6, 1, 3, 4, 8};
        int[] number4 = new int[]{6, 5, 4, 3, 1, 7, 5};

        BigNumbers b1 = new BigNumbers(number1);
        BigNumbers b2 = new BigNumbers(number2);
        BigNumbers b3 = new BigNumbers(number3);
        BigNumbers b4 = new BigNumbers(number4);

        int[] result1 = b1.Summe(b2);
        int[] result2 = b3.Summe(b4);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}


class BigNumbers {
    int[] num;
    public BigNumbers(int[] number) {
        this.num = number;
    }

    //? returns the sum of two big numbers
    public int[] Summe(BigNumbers other) {
        int carryflag = 0;
        int[] result = new int[this.num.length + 1];
        int i = this.num.length - 1;

        while (i >=0) {
            int sum = this.num[i] + other.num[i] + carryflag;

            carryflag = sum / 10;
            result[i + 1] = sum % 10;
            
            i--;
        }

        if (carryflag != 0)
            result[0] = carryflag;
        
        //* if the first number is 0, it will be deleted, so it looks nicer
        if (result[0] == 0)
            return Arrays.copyOfRange(result, 1, result.length);

        return result;
    }
}
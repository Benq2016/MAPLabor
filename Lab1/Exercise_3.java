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
        int[] result4 = b4.Differenz(b3);
        int[] result5 = b3.Multiplikation(2);
        int[] result6 = b3.Division(2);
        System.out.println("Summe: " + Arrays.toString(result1));
        System.out.println("Summe: " + Arrays.toString(result2));
        System.out.println("Subtraktion: " + Arrays.toString(result4));
        System.out.println("Multiplikation: " + Arrays.toString(result5));
        System.out.println("Division: " + Arrays.toString(result6));
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

        //* if there is still a carryflag it will be set at the first position
        if (carryflag != 0)
            result[0] = carryflag;
        
        //* if the first number is 0, it will be deleted, so it looks nicer
        if (result[0] == 0)
            return Arrays.copyOfRange(result, 1, result.length);

        return result;
    }

    //? returns the difference of two big numbers
    public int[] Differenz(BigNumbers other) {
        int carryflag = 0;
        int[] result = new int[this.num.length];
        int i = this.num.length - 1;

        while (i >=0) {
            int sub = this.num[i] - other.num[i] - carryflag;
            carryflag = 0;

            if (sub < 0) {
                sub += 10;
                carryflag += 1;
            }

            result[i] = sub;
            i--;
        }
        
        //* if the first number is 0, it will be deleted, so it looks nicer
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }

        return result;
    }

    //? returns the product of a big number with a number
    public int[] Multiplikation(int number) {
        int carryflag = 0;
        int[] result = new int[this.num.length + 1];
        int i = this.num.length - 1;

        while(i >= 0) {
            int mul = this.num[i] * number + carryflag;

            carryflag = mul / 10;
            result[i + 1] = mul % 10;

            i--;
        }
        
        //* if there is still a carryflag it will be set at the first position
        if (carryflag != 0) {
            result[0] = carryflag;
        }

        //* if the first number is 0, it will be deleted, so it looks nicer
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }

        return result;
    }

    //? returns the quotient of a big number with a number
    public int[] Division(int number) {
        int carryflag = 0;
        int[] result = new int[this.num.length];
        int i = 0;

        while (i < this.num.length) {
            int div = this.num[i] + carryflag * 10;
            
            carryflag = div % number;
            result[i] = div / number;

            i++;
        }

        // //* if the first number is 0, it will be deleted, so it looks nicer
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }

        return result;
    }
}
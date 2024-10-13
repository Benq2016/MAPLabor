package MAPLabor.Lab1;


public class Exercise_2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 8, 6, 4, 9};
        System.out.println("The greatest number is: " + greatestNumber(numbers));
        System.out.println("The smallest number is: " + smallestNumber(numbers));
        System.out.println("The max sum of n-1 numbers is: " + greatestSum(numbers));
        System.out.println("The min sum of n-1 numbers is: " + smallestSum(numbers));

    }

    //? returns the greatest number
    public static int greatestNumber(int[] numbers) {
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    //? returns the smallest number
    public static int smallestNumber(int[] numbers) {
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    //? returns the sum of all numbers minus the smallest number
    public static int greatestSum(int[] numbers) {
        int min = smallestNumber(numbers);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum - min;
    }

    //? returns the sum of all numbers minus the greatest number
    public static int smallestSum(int[] numbers) {
        int max = greatestNumber(numbers);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum - max;
    }
}

package MAPLabor.ex1;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grades calculate = new Grades();
        int[] grades = new int[]{12, 15, 9, 60, 75, 94, 40, 100, 89, 28, 37};
        List<Integer> badGrades = calculate.nichtAusreichend(grades);

        for (int grade : badGrades) {
            System.out.println(grade);
        }

        System.out.println("Durchschnitt: " + calculate.average(grades));

        int[] roundedGrades = calculate.abgerundet(grades);

        for (int grade : roundedGrades) {
            System.out.println(grade);
        }
    }
}


class Grades {
    public List<Integer> nichtAusreichend(int[] grades) {
       List<Integer> badGrades = new ArrayList<Integer>();

        for (int grade : grades) {
            if (grade < 40) {
                badGrades.add(grade);
            }
        }
        return badGrades;
    }

    public double average(int[] grades) {
        int count = 0;
        int sum = 0;
        for (int grade: grades) {
            sum += grade;
            count++;
        }
        return sum / count;
    }

    public int[] abgerundet(int[] grades) {
        int[] roundGrades = new int[grades.length];

        for(int i = 0; i < grades.length; i++) {
            int nextFive = (grades[i]/5 + 1) * 5;
            if(nextFive - grades[i] < 3) {
                roundGrades[i] = nextFive;
            }
            else roundGrades[i] = grades[i];
        }
        return roundGrades;
    }
}
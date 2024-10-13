package MAPLabor.Lab1;
import java.util.List;
import java.util.ArrayList;

public class Exercise_1 {
    public static void main(String[] args) {
        Grades calculate = new Grades();
        int[] grades = new int[]{12, 15, 9, 60, 75, 94, 40, 100, 89, 28, 37};
        List<Integer> badGrades = calculate.nichtAusreichend(grades);

        System.out.println("Nicht ausreichende Noten:");
        for (int grade : badGrades) {
            System.out.println(grade);
        }

        System.out.println("Durchschnitt: " + calculate.average(grades));

        System.out.println("Abgerundete Noten:");
        int[] roundedGrades = calculate.abgerundet(grades);
        for (int grade : roundedGrades) {
            System.out.println(grade);
        }

        System.out.println("Beste Note: " + calculate.bestGrade(grades));
    }
}


class Grades {
    //? returns a new array of grades which are <40
    public List<Integer> nichtAusreichend(int[] grades) {
       List<Integer> badGrades = new ArrayList<Integer>();

        for (int grade : grades) {
            if (grade < 40) {
                badGrades.add(grade);
            }
        }
        return badGrades;
    }

    //? calculates the average of the grades
    public double average(int[] grades) {
        int count = 0;
        int sum = 0;
        for (int grade: grades) {
            sum += grade;
            count++;
        }
        return sum / count;
    }

    //? rounds the grades to the nearest multiple of 5 IF the difference is <3 and returns a new array of rounded grades
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

    //? returns the highest grade in the array of grades after the round up
    public int bestGrade (int[] grades) {
        int[] roundedGrades = abgerundet(grades);

        int max = 0;
        for (int grade : roundedGrades) {
            if (max < grade)
                max = grade;
        }
        return max;
    }
}
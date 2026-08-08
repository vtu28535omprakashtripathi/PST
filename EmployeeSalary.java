import java.util.Scanner;
public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of employees
        double[] salary = new double[n];
        for (int i = 0; i < n; i++) {
            salary[i] = sc.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            salary[i] = salary[i] + (salary[i] * 0.10);
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%.0f ", salary[i]);
        }

        sc.close();
    }
}
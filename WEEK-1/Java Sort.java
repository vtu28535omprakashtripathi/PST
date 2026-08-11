import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] s = new Student[n];

        for (int i = 0; i < n; i++)
            s[i] = new Student(sc.nextInt(), sc.next(), sc.nextDouble());

        Arrays.sort(s, (a, b) -> {
            int x = Double.compare(b.cgpa, a.cgpa);
            if (x != 0) return x;
            x = a.name.compareTo(b.name);
            return x != 0 ? x : Integer.compare(a.id, b.id);
        });

        for (Student x : s)
            System.out.println(x.name);
    }
}

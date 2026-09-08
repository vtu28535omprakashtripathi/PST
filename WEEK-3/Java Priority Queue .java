import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // 1. Highest CGPA first
        if (Double.compare(s2.getCGPA(), s1.getCGPA()) != 0) {
            return Double.compare(s2.getCGPA(), s1.getCGPA());
        }
        // 2. Ascending alphabetical order by name
        if (!s1.getName().equals(s2.getName())) {
            return s1.getName().compareTo(s2.getName());
        }
        // 3. Ascending order by ID
        return Integer.compare(s1.getID(), s2.getID());
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> remainingStudents = new ArrayList<>();
        while (!pq.isEmpty()) {
            remainingStudents.add(pq.poll());
        }

        return remainingStudents;
    }
}

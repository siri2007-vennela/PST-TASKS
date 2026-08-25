import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

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

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> pq =
            new PriorityQueue<Student>(11, new Comparator<Student>() {

                public int compare(Student a, Student b) {

                    // Higher CGPA first
                    if (a.getCGPA() < b.getCGPA())
                        return 1;

                    if (a.getCGPA() > b.getCGPA())
                        return -1;

                    // Name alphabetical order
                    int x = a.getName().compareTo(b.getName());

                    if (x != 0)
                        return x;

                    // Smaller ID first
                    return a.getID() - b.getID();
                }
            });

        for (String event : events) {

            String[] p = event.split(" ");

            if (p[0].equals("ENTER")) {

                pq.add(new Student(
                    Integer.parseInt(p[3]),
                    p[1],
                    Double.parseDouble(p[2])
                ));

            } else {
                if (!pq.isEmpty())
                    pq.poll();
            }
        }

        List<Student> result = new ArrayList<Student>();

        while (!pq.isEmpty())
            result.add(pq.poll());

        return result;
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<String> events = new ArrayList<String>();

        for (int i = 0; i < n; i++)
            events.add(sc.nextLine());

        List<Student> students =
            new Priorities().getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student s : students)
                System.out.println(s.getName());
        }

        sc.close();
    }
}
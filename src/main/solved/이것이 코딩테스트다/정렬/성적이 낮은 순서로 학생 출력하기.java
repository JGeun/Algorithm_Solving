import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for(int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            students[i] = new Student(data[0], Integer.parseInt(data[1]));
        }

        Arrays.sort(students);

        for(Student student : students) {
            System.out.print(student.getName() + " ");
        }
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name; this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student s) {
        return this.score - s.score;
    }
}
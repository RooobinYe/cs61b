package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void randomTest() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        for (int i = 0; i < 10000; i++) {
            int randomNumber = StdRandom.uniform(4); // 0 1 2 3
            if (randomNumber > 1 && sad.isEmpty()) {
                randomNumber -= 2;
            }
            if (randomNumber == 0) {
                sad.addFirst(i);
                ads.addFirst(i);
                System.out.println("addFirst(" + i + ")");
            } else if (randomNumber == 1) {
                sad.addLast(i);
                ads.addLast(i);
                System.out.println("addLast(" + i + ")");
            } else if (randomNumber == 2) {
                System.out.println("removeFirst()");
                assertEquals("removeFirst()\n", sad.removeFirst(), ads.removeFirst());
            } else if (randomNumber == 3) {
                System.out.println("removeLast()");
                assertEquals("removeLast()\n", sad.removeLast(), ads.removeLast());
            }
        }
    }
}


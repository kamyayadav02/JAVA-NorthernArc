package Iteration;

import java.util.Iterator;

public class MainRange {
    public static void main(String[] args) {

        MyRange range1 = new MyRange(10, 20);

        Iterator<Integer> itr = range1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("_________________________________");

        for (Integer data : range1) {
            System.out.println(data);
        }
    }
}
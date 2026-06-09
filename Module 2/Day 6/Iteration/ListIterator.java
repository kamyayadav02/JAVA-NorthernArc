package Iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListIterator {
    public static void main(String[] args) {
        //List<String> list=new ArrayList<>();
        List<String> list=new LinkedList<>();
        list.add("Sachin");
        list.add("Sourav");
        list.add("Sam");
        list.add("Mahesh");
        list.add("Raghav");
        System.out.println("-------------------------");
        for(String str:list){
            System.out.println(str);
        }
        Iterator<String> itr=list.iterator();
        System.out.println(itr.getClass().getName());
        System.out.println();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}

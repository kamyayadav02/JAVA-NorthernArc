package Iteration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetIterator {
    public static void main(String[] args) {
        //Set<String> set=new HashSet<>();
        Set<String> set=new TreeSet<>();
        set.add("sourav");
        set.add("sachin");
        set.add("sam");
        set.add("mahesh");
        set.add("Raghav");
        System.out.println("---------------------");
        for(String str:set){
            System.out.println(str);
        }
        Iterator<String> itr=set.iterator();
        System.out.println(itr.getClass().getName());
        System.out.println();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }


    }
}

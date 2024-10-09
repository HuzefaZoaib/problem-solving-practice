package com.practice;

import java.util.*;
import java.util.stream.Collectors;

public class DisjointSet {

    public static void main(String[] args) {

        // data is Sequence, PageId, CustomerId
        List<String[]> day1 = Arrays.asList(new String[]{"1","4","6"},new String[]{"2","4","3"});
        List<String[]> day2 = Arrays.asList(new String[]{"3","3","6"},new String[]{"4","4","3"});

        List<List<String[]>> days = new ArrayList<>(2);
        days.add(day1);
        days.add(day2);

        // Stream way will not work here!!!
        // because it will put the complete array into the set
        // and then it will not maintain uniqueness also of page ids also
        //days.get(0).stream().collect(Collectors.toMap(r->r[2],Collectors.toSet()));

        // Let do it via traditional for-loop
        // List<String[]> day1 = Arrays.asList(new String[]{"1","4","6"},new String[]{"1","4","3"});
        Map<String, Set<String>> data = new HashMap<>();
        for(String[] r : day1) {
            data.putIfAbsent(r[2], new HashSet<String>());
            data.get(r[2]).add(r[1]);
        }



        // Get Values which are not common
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,4,6));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3,4,6));

        //s1.retainAll(s1);   // Intersection
        //s1.addAll(s2);      // Union

        Set<Integer> disjoint = new HashSet<>();
        for(Integer i : s1) {
            if(!s2.contains(i)) {
                disjoint.add(i);
            }
        }
        for(Integer i : s2) {
            if(!s1.contains(i)) {
                disjoint.add(i);
            }
        }

        System.out.println(disjoint);

        // To test if both sets contains atleast one unique and distinct element
        // Get Values which are not common
        disjoint = new HashSet<>();
        s1 = new HashSet<>(Arrays.asList(1,4,6));
        s2 = new HashSet<>(Arrays.asList(3,4,6));
        int previousS1Size = s1.size();
        for(Iterator<Integer> itr=s1.iterator(); itr.hasNext();) {
            Integer i = itr.next();
            if(!s2.contains(i)) {
                disjoint.add(i);
                itr.remove();
            }
        }

        int previousS2Size = s2.size();
        for(Iterator<Integer> itr=s2.iterator(); itr.hasNext();) {
            Integer i = itr.next();
            if(!s1.contains(i)) {
                disjoint.add(i);
                itr.remove();
            }
        }

        System.out.println(disjoint+", "+(previousS1Size-s1.size())+", "+(previousS2Size-s2.size()));


        // To test if both sets contains atleast one unique and distinct element
        // Get Values which are not common
        disjoint = new HashSet<>();
        s1 = new HashSet<>(Arrays.asList(1,2,4,6));
        s2 = new HashSet<>(Arrays.asList(4,6));
        previousS1Size = s1.size();
        for(Iterator<Integer> itr=s1.iterator(); itr.hasNext();) {
            Integer i = itr.next();
            if(!s2.contains(i)) {
                disjoint.add(i);
                itr.remove();
            }
        }

        previousS2Size = s2.size();
        for(Iterator<Integer> itr=s2.iterator(); itr.hasNext();) {
            Integer i = itr.next();
            if(!s1.contains(i)) {
                disjoint.add(i);
                itr.remove();
            }
        }

        System.out.println(disjoint+", "+(previousS1Size-s1.size())+", "+(previousS2Size-s2.size()));

        // To test if both sets contains atleast one unique and distinct element
        // Get Values which are not common
        disjoint = new HashSet<>();
        s1 = new HashSet<>(Arrays.asList(4,6));
        s2 = new HashSet<>(Arrays.asList(1,2,4,6));
        previousS1Size = s1.size();
        for(Iterator<Integer> itr=s1.iterator(); itr.hasNext();) {
            Integer i = itr.next();
            if(!s2.contains(i)) {
                disjoint.add(i);
                itr.remove();
            }
        }

        previousS2Size = s2.size();
        for(Iterator<Integer> itr=s2.iterator(); itr.hasNext();) {
            Integer i = itr.next();
            if(!s1.contains(i)) {
                disjoint.add(i);
                itr.remove();
            }
        }

        System.out.println(disjoint+", "+(previousS1Size-s1.size())+", "+(previousS2Size-s2.size()));
    }
}

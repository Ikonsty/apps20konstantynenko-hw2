package ua.edu.ucu.collections.immutable;

import org.junit.Test;

public class ImmutableLinkedListTest implements ImmutableList {
    
    @Test
    public void testSomeMethod() {
        ImmutableLinkedList arrList = new ImmutableLinkedList();
        arrList = arrList.add("Hello");
        arrList = arrList.add(1, ", World!");
        arrList = arrList.add(4, ", World!");
        arrList.toArray();
        System.out.println(arrList.toString());
        System.out.println(arrList.size());
        arrList = arrList.addFirst(5);
        System.out.println(arrList.getFirst());
        System.out.println(arrList.getLast());


        ImmutableArrayList arrList2 = new ImmutableArrayList(5);
        Object[] arr = {1,2,3};
        arrList2 = arrList2.addAll(arr);
        System.out.println(arrList2.get(2));

        arrList2 = arrList2.remove(2);
        System.out.println(arrList2.get(2));
        arrList2 = arrList2.set(1, "true");
        System.out.println(arrList2.get(1));
        System.out.println(arrList2.indexOf("true"));

        System.out.println(arrList.isEmpty());
    }
    
}

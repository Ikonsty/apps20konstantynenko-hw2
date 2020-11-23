package ua.edu.ucu.collections.immutable;

//import org.junit.Test;

public class ImmutableArrayListTest implements ImmutableListTest{
    
//    @Test
    public void testSomeMethod() {
        ImmutableArrayList arrList = new ImmutableArrayList();
        arrList = arrList.add("Hello");
        arrList = arrList.add(1, ", World!");
        arrList = arrList.add(4, ", World!");
        arrList.toArray();
        System.out.println(arrList.toString());
        System.out.println(arrList.size());

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

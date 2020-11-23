package ua.edu.ucu.collections;

//import org.junit.Test;

public class QueueTest {
    
//    @Test
    public void testSomeMethod() {
        Queue qu = new Queue();
        System.out.println(qu.peek());
        System.out.println(qu.dequeue());
        qu.enqueue("1");
        qu.enqueue("1");
        System.out.println(qu.peek());
        System.out.println(qu.dequeue());
    }
    
}

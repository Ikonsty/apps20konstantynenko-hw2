package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
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

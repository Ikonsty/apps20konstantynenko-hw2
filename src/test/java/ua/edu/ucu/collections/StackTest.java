package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testSomeMethod() {
        Stack st = new Stack();
        System.out.println(st.peek());
        System.out.println(st.pop());
        st.push("1");
        st.push("1");
        System.out.println(st.peek());
        System.out.println(st.pop());
    }
    
}

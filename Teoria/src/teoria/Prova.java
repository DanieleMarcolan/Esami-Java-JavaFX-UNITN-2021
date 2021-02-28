package teoria;

import java.util.*;
class A {
    private static A a;
    private static int instancecount=0;
    private A() {instancecount++;}
    static A getInstance() {if (a==null) a=new A(); return a;}
    void printCount(){System.out.println(instancecount);}
}
public class Prova {
    public static void main(String args[]) {
        Collection s = new LinkedList();
        for (int i = 1; i < 4; i++) s.add(A.getInstance());
        Iterator i = s.iterator();
        while (i.hasNext()) ( (A) i.next()).printCount();
    }
}
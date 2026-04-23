package LLD.DesignPatterns;

import LLD.DesignPatterns.Singleton.SingletonLazyInit;

public class PatternCall {
    public static void main(String[] args) {
        SingletonLazyInit obj = SingletonLazyInit.getInstance();
        SingletonLazyInit obj2 = SingletonLazyInit.getInstance();

        System.out.println(obj == obj2);
        System.out.println(obj);
        System.out.println(obj2);

    }
}

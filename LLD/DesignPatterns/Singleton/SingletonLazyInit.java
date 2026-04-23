package LLD.DesignPatterns.Singleton;

public class SingletonLazyInit {
    private static SingletonLazyInit instance;

    private SingletonLazyInit(){}

    public static SingletonLazyInit getInstance(){
        if(instance == null){
            instance = new SingletonLazyInit();
        }
        return instance;
    }
}

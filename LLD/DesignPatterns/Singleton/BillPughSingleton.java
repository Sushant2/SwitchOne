package LLD.DesignPatterns.Singleton;

public class BillPughSingleton {
    private BillPughSingleton(){}

    //Inner class is not loaded until getInstance() is called
    private static class SingletonHolder{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

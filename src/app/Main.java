package app;

public class Main {
    public static void main(String[] args) {
        //Створюємо об'єкт, який буде використовуватись обома потоками
        DataHandler dataHandler = new DataHandler();
//Створюємо два потоки з різними іменами, але одним і тим же об'єктом dataHandler
        //(тоді обидва потоки звертаються до одного ресурсу)
        MyThread myThread1 = new MyThread("Thread 1", dataHandler);
        MyThread myThread2 = new MyThread("Thread 2", dataHandler);
//Запускаємо обидва потоки, кожен з них викличе run(), а отже dataHandler.getOutput()
        myThread1.start();
        myThread2.start();
    }
}

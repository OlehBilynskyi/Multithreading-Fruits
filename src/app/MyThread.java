package app;

//Створюємо клас MyThread який успадковує клас Thread (тобто стає потоком)
public class MyThread extends Thread {
    //Оголошуємо змінну, яка буде зберігати посилання на об'єкт DataHandler
    private final DataHandler dataHandler;

    //Конструктор, який приймає ім'я потоку, та об'єкт який буде використовуватись у методі run()
    public MyThread(String name, DataHandler dataHandler) {
        //Викликаємо конструктор батьківського класу Thread, щоб встановити ім'я потоку
        //Це потрібно щоб Thread.currentThread().getName() повертало потрібне ім'я
        super(name);
        //Присвоюємо значення, передане у конструктор, внутрішній змінні класу
        this.dataHandler = dataHandler;
    }

    @Override
    //Метод run() містить логіку, яка виконуватиме потік
    public void run() {
        dataHandler.getOutput();
    }
}
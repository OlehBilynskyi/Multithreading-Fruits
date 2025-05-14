package app;
//Створюємо клас, який буде виводити фрукти в потоці (він використовує DataRepository)

public class DataHandler {

    //Створюємо змінну fruits, яка зберігає масив фруктів
    //(new DataRepository() - об'єкт класу DataRepository, .getData() - викликає метод, який повертає масив фруктів)
    private final String[] fruits = new DataRepository().getData();

    public void getOutput() {
        //Критичний блок, який дозволяє лише одному потоку одночасно виконати цей код
        //(this) - синхронізуємо по поточному об'єкті (захист, щоб два потоки не перебивали один одного)
        synchronized (this) {
            //Створюємо об'єкт для поступового збирання рядка
            StringBuilder sb = new StringBuilder();
            //Лічильник для нумерації фруктів
            int count = 1;
            //Розширений цикл for-each, який перебирає всі елементи масиву
            for (String fruit : fruits) {
                //Додаємо одну частину до нашого sb та збільшуємо лічильник на 1
                sb.append(String.format("(%d) %s ", count, fruit));
                count++;
            }
            //Отримуємо назву потоку, який зараз працює та зібраний рядок з фруктами
            System.out.println(Thread.currentThread().getName() + ": " + sb);
        }
    }
}

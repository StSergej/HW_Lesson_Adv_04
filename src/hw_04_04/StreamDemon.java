package hw_04_04;
//Создайте поток-демон и выведите про него как можно больше информации.


public class StreamDemon {
    public static void main(String[] args) {

        Thread thread = new Thread(new Task());//Создаем новый поток
        thread.setDaemon(true);//назначаем поток потоком-демоном
        thread.start();//запускаем поток

        System.out.println("Поток: " + Thread.currentThread().getName());//выводим имя потока
        System.out.println(Thread.currentThread().getName() + " поток-демон? " + Thread.currentThread().isDaemon());//является ли данный поток потоком-демоном

        System.out.println("Используется поток " + thread.getName() + " или нет: " + thread.isAlive());//используется поток или нет
        thread.setPriority(1);//назначение приоритета потоку
        System.out.println("Поток " + Thread.currentThread().getName() + " с приоритетом: " + Thread.currentThread().getPriority());//какой у потока приоритет

        System.out.println("Засыпание потока: " + Thread.currentThread().getName());
        System.out.println("=======================");
         try {
            Thread.sleep(3000);//засыпание потока main
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=======================");
        System.out.println("Поток " + Thread.currentThread().getName() + " завершил работу");
        //если поток main завершает работу, то прекращает работать и поток-демон
        System.out.println("Используется поток " + thread.getName() + " или нет: " + thread.isAlive());

    }
}

class Task implements Runnable {
    String var = "Я работаю! ";
    String var2 = "Я все еще работаю! ";

    @Override
    public void run() {
        System.out.println("Поток: " + Thread.currentThread().getName());//выводим имя потока
        System.out.println(var + Thread.currentThread().getName());
        Thread.currentThread().setName("Thread Daemon");//назначаем потоку новое имя

        System.out.println(Thread.currentThread().getName() + " поток-демон? " + Thread.currentThread().isDaemon());//является ли данный поток потоком-демоном
        System.out.println("Поток " + Thread.currentThread().getName() + " с приоритетом: " + Thread.currentThread().getPriority());//какой у потока приоритет
        System.out.println(var2 + Thread.currentThread().getName());
    }
}

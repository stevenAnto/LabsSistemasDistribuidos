import java.util.ArrayList;
import java.util.List;

public class LamportClock {
    private int clock;
    
    //Se crea e inicializa el reloj en 0
    public LamportClock() {
        this.clock = 0;
    }

    //Incrementa el valor del reloj y se devuelve el nuevo valor del reloj
    public synchronized int tick() {
        this.clock++;
        return this.clock;
    }

    //Actualiza el reloj tomando el máximo entre el valor actual y el tiempo recibido, y luego le suma 1 
    public synchronized void update(int receivedTime) {
        this.clock = Math.max(this.clock, receivedTime) + 1;
    }

    //Devuelve el valor actual del reloj    
    public int getTime() {
        return this.clock;
    }


    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        LamportClock clock = new LamportClock();
        //Bucle para crear 5 hilos
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //Obtiene el tiempo actual del reloj
                    int time = clock.tick();
                    //Imprime el evento creado con su tiempo
                    System.out.println(
                        "Thread " + Thread.currentThread().getId() + " created event with Lamport time " + time);
                    try {
                        //Simula un tiempo de procesamiento aleatorio
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Obtiene el reloj luego de procesar
                    int receivedTime = clock.tick();
                    //Imprime el evento con su tiempo 
                    System.out.println("Thread " + Thread.currentThread().getId() + " received event with Lamport time "
                            + receivedTime);
                    //Actualiza el reloj con el tiempo recibido
                    clock.update(receivedTime);
                }
            });
            threads.add(thread); //Agrega el hilo a las lista de hilos
            thread.start(); //Inializa el hilo
        }
        //Espera a que todos los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Imprime el tiempo final que demoro
        System.out.println("Final Lamport time: " + clock.getTime());
    }
}
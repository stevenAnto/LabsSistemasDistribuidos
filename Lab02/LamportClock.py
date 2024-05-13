import threading
import random
import time  

class LamportClock:
    def __init__(self):
        self.clock = 0
    
    # Incrementa el valor del reloj y devuelve el nuevo valor
    def tick(self):
        with threading.Lock():
            self.clock += 1
            return self.clock
    
    # Actualiza el reloj tomando el máximo entre el valor actual y el tiempo recibido, y luego le suma 1
    def update(self, received_time):
        with threading.Lock():
            self.clock = max(self.clock, received_time) + 1
    
    # Devuelve el valor actual del reloj
    def get_time(self):
        return self.clock

def event_simulation(clock):
    time_event = clock.tick() # Obtiene el tiempo actual del reloj
    print(f"Thread {threading.get_ident()} created event with Lamport time {time_event}") # Imprime el evento creado con su tiempo

    # Simula un tiempo de procesamiento aleatorio
    random_sleep_time = random.random()
    time.sleep(random_sleep_time)

    received_time = clock.tick() # Obtiene el tiempo del reloj después de procesar
    print(f"Thread {threading.get_ident()} received event with Lamport time {received_time}") # Imprime el evento recibido con su tiempo
    clock.update(received_time) # Actualiza el reloj con el tiempo recibido

def main():
    threads = []
    clock = LamportClock()

    # Bucle para crear y ejecutar 5 hilos
    for _ in range(5):
        thread = threading.Thread(target=event_simulation, args=(clock,))
        threads.append(thread)
        thread.start()

    # Espera a que todos los hilos terminen
    for thread in threads:
        thread.join()

    # Imprime el tiempo de Lamport final
    print(f"Final Lamport time: {clock.get_time()}")

if __name__ == "__main__":
    main()

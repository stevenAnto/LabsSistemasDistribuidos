import datetime
import zmq
import random
import pickle

# Función para calcular el nuevo tiempo corregido según el algoritmo de Cristian
def getCorrectedTime(server_time, offset):
    corrected_time = server_time + offset
    return corrected_time

def main():
    # Inicialización del cliente
    context = zmq.Context()
    client = context.socket(zmq.REQ)
    client.connect("tcp://localhost:5555")  # Se va a usar el puerto 5555

    # Obtiene ID aleatorio para el proceso
    client_id = random.randint(0, 1024)

    # Iniciando cliente
    while True:
        _ = input(f"ID del proceso: {client_id}\nPresione cualquier tecla para enviar una petición")

        # Empieza el inicio del mensaje
        first_time = datetime.datetime.now()

        # Enviar mensaje
        message = f"Petición de tiempo del cliente {client_id}"
        client.send(message.encode('utf-8'))

        # Espera a respuesta
        server_time = pickle.loads(client.recv())

        # Calcular el desfase de tiempo
        offset_server = server_time - first_time

        # Calcular el nuevo tiempo corregido
        corrected_time = getCorrectedTime(server_time, offset_server)

        # Mostrar resultados
        print(f"""Resultados para proceso {client_id}:
        Tiempo del servidor:     {server_time}
        Desfase de tiempo:       {offset_server}
        Tiempo corregido:        {corrected_time}\n""")

if __name__ == '__main__':
    main()

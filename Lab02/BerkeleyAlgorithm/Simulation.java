public class Simulation{

  public static void main(String args[]){
    long inicio = System.nanoTime();
    SimulatorMonitor sm = new SimulatorMonitor();
    // Crear un hilo servidor e iniciarlo //
    Server srv = new Server(sm, inicio);
    srv.start();
    Client clv[] = new Client[3];
    // Crear hilos clientes e iniciarlos //
    for(int i=0;i<3;i++){
      clv[i] = new Client(i,sm, inicio);
      clv[i].start();
    }

  }
}

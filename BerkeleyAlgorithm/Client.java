public class Client extends Thread{

  private int clientID;
  private long clientTime;
  private SimulatorMonitor sm;
  private final boolean addDelay = true;
  public Client(int clientID,SimulatorMonitor sm, long stamp){
    this.sm         = sm;
    this.clientID   = clientID;
    this.clientTime = System.nanoTime()-stamp;

  }

  public void run(){
    while(true){ // Clientes permanentemente conectados;
      // Actualizar temp y añadir un retardo específico a cada thread, en este caso (tiempoactual+id (thread+1)*2)
      this.clientTime += (this.addDelay) ? (this.clientID+1)*2 : 0;
      System.out.println("Temporización (cliente " + clientID + ") : " + (float)this.clientTime/1000000.00);
      this.sm.setDiffTimes(this.clientTime,this.clientID); // Setear las diferencias, si el servidor aun no ha configurado su tiempo, los clientes duermen //
      this.clientTime += this.sm.getSettingTime(this.clientID); // Actualizar reloj del cliente
      System.out.println("Temporización acordada (cliente " + clientID + ") : " + (float)this.clientTime/1000000.00);
    }
  }

}

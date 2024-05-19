import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TarjetaCreditoImpl extends UnicastRemoteObject implements TarjetaCreditoRemota{
  private double saldo;
  public TarjetaCreditoImpl(double initialBalance) throws RemoteException{
    super();
    this.saldo = initialBalance;
  }
  public double getSaldo(){
    return saldo;
  }

  public void cargar(double monto) throws RemoteException{
    saldo +=monto;
  }

  public void pagar(double monto) throws RemoteException{
    if(monto <= saldo){
      saldo -= monto;
    }
    else{
      throw  new RemoteException("insufficiente saldo");
    }
  }
}

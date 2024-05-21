import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TarjetaCreditoRemota extends Remote{
  double getSaldo() throws RemoteException;
  void cargar(double monto) throws RemoteException;
  void pagar(double monto) throws RemoteException;
}

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CreditCardServer {
  public static void main(String[] args) {
    try {
     // LocateRegistry.createRegistry(1099);
      TarjetaCreditoRemota creditCard = new TarjetaCreditoImpl(1000.0);
      Naming.rebind("rmi://localhost/CreditCardService", creditCard);
      System.out.println("Credit Card Service is running...");
    } catch (Exception e) {
      System.err.println("Server exception: " + e.toString());
      e.printStackTrace();
    }
  }
}

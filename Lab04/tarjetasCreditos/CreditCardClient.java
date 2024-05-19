import java.rmi.Naming;

public class CreditCardClient {
  public static void main(String[] args) {
    try {
      TarjetaCreditoRemota creditCard = (TarjetaCreditoRemota) Naming.lookup("rmi://localhost/CreditCardService");
      System.out.println("Initial balance: " + creditCard.getSaldo());
      creditCard.cargar(200.0);
      System.out.println("Balance after payment: " + creditCard.getSaldo());
      creditCard.pagar(100.0);
      System.out.println("Balance after charge: " + creditCard.getSaldo());
    } catch (Exception e) {
      System.err.println("Client exception: " + e.toString());
      e.printStackTrace();
    }
  }
}

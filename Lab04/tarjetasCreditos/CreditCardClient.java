import java.rmi.Naming;
import java.util.Scanner;

public class CreditCardClient {
  public static void main(String[] args) {
    try {
      TarjetaCreditoRemota creditCard = (TarjetaCreditoRemota) Naming.lookup("rmi://localhost/CreditCardService");
      Scanner scanner = new Scanner(System.in);
      int option;

      while (true) {
        System.out.println("\n=== Menú de Tarjeta de Crédito ===");
        System.out.println("1. Ver saldo");
        System.out.println("2. Cargar saldo");
        System.out.println("3. Pagar saldo");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        option = scanner.nextInt();

        switch (option) {
          case 1:
            System.out.println("Saldo actual: " + creditCard.getSaldo());
            break;
          case 2:
            System.out.print("Ingrese el monto a cargar: ");
            double cargarMonto = scanner.nextDouble();
            creditCard.cargar(cargarMonto);
            System.out.println("Saldo después de cargar: " + creditCard.getSaldo());
            break;
          case 3:
            System.out.print("Ingrese el monto a pagar: ");
            double pagarMonto = scanner.nextDouble();
            creditCard.pagar(pagarMonto);
            System.out.println("Saldo después de pagar: " + creditCard.getSaldo());
            break;
          case 4:
            System.out.println("Saliendo...");
            scanner.close();
            return;
          default:
            System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
      }
    } catch (Exception e) {
      System.err.println("Excepción del cliente: " + e.toString());
      e.printStackTrace();
    }
  }
}

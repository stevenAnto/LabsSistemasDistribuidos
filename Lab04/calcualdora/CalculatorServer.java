import java.rmi.Naming;
public class CalculatorServer {
  public CalculatorServer() {
    try {
      Calculator c = new CalculatorImpl();
      Naming.rebind("rmi://localhost:1099/CalculatorService", c);//registra el objeto remot en el registro RMI // espera????
    } catch (Exception e) {
      System.out.println("Trouble: " + e);
    }
  }
  public static void main(String args[]) {
    new CalculatorServer();
  }
}

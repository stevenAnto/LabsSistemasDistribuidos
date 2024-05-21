public class CalculatorImpl extends java.rmi.server.UnicastRemoteObject implements Calculator {//java.rmi.server clase que proporciona fucnionalidades  para la exportaciond e objetos remotos //creacion de stubs

  // Implementations must have an explicit constructor
  // in order to declare the RemoteException exception
  public CalculatorImpl()
      throws java.rmi.RemoteException {
      super();
  }
  public int add(int a, int b)
      throws java.rmi.RemoteException {
      return a + b;
  }
  public int sub(int a, int b)
      throws java.rmi.RemoteException {
      return a - b;
  }
  public int mul(int a, int b)
      throws java.rmi.RemoteException {
      return a * b;
  }
  public int div(int a, int b)
      throws java.rmi.RemoteException {
      return a / b;
  }
}

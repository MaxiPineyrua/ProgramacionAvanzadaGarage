package garage;

//Excepción para cuando el garage esté lleno
public class GarageLlenoException extends Exception {
  // Constructor
  public GarageLlenoException(String mensaje) {
    super(mensaje); // Llama al constructor de Exception
  }
}
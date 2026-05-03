package garage;

// Excepción para cuando la patente ya existe
public class PatenteDuplicadaException extends Exception {
  // Constructor
  public PatenteDuplicadaException(String mensaje) {
    super(mensaje); // Llama al constructor de Exception
  }
}

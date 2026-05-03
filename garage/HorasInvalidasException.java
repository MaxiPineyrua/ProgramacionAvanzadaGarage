package garage;

// Excepción para cuando las horas ingresadas son inválidas
public class HorasInvalidasException extends Exception {
  // Constructor
  public HorasInvalidasException(String mensaje) {
    super(mensaje); // Llama al constructor de Exception
  }
}

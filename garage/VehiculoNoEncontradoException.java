package garage;

// Excepción para cuando no se encuentra un vehículo
public class VehiculoNoEncontradoException extends Exception {
  // Constructor
  public VehiculoNoEncontradoException(String mensaje) {
    super(mensaje); // Llama al constructor de Exception
  }
}

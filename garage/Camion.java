package garage;

//Camion extiende (hereda) de Vehiculo
public class Camion extends Vehiculo {
  // Constructor (uso super para llamar a la clase padre)
  public Camion(String patente, String marca, String modelo, int horasEstimadas)
      throws HorasInvalidasException {
    super(patente, marca, modelo, horasEstimadas);
  }

  // Metodo calcularCosto (camion se le cobra $1500 por hora)
  @Override
  public double calcularCosto() {
    return horasEstimadas * 1500;
  }

  // Metodo getEspacioOcupado (camion ocupa 4 espacios)
  @Override
  public int getEspacioOcupado() {
    return 4;
  }

  // Metodo mostrarDatos (muestra los datos del camion)
  @Override
  public void mostrarDatos() {
    System.out.println("------------------");
    System.out.println("----- CAMIÓN -----");
    System.out.println("------------------");
    System.out.println("Patente: " + patente);
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Horas estimadas: " + horasEstimadas);
    System.out.println("Costo estimado: $" + calcularCosto());
  }

}

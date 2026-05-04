package garage;

//Moto extiende (hereda) de Vehiculo
public class Moto extends Vehiculo {
  // Constructor (uso super para llamar a la clase padre)
  public Moto(String patente, String marca, String modelo, int horasEstimadas)
      throws HorasInvalidasException {
    super(patente, marca, modelo, horasEstimadas);
  }

  // Metodo calcularCosto (moto $700 por hora)
  @Override
  public double calcularCosto() {
    return horasEstimadas * 700;
  }

  // Metodo getEspacioOcupado (moto ocupa 1)
  @Override
  public int getEspacioOcupado() {
    return 1;
  }

  // Metodo mostrarDatos (muestra los datos de la moto)
  @Override
  public void mostrarDatos() {
    System.out.println("------------------");
    System.out.println("------ MOTO ------");
    System.out.println("------------------");
    System.out.println("Patente: " + patente);
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Horas estimadas: " + horasEstimadas);
    System.out.println("Costo estimado: $" + calcularCosto());
  }

}

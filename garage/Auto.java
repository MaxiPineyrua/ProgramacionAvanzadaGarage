package garage;

// Auto extiende (hereda) de Vehiculo
public class Auto extends Vehiculo {
  // Constructor (uso super para llamar a la clase padre)
  public Auto(String patente, String marca, String modelo, int horasEstimadas) {
    super(patente, marca, modelo, horasEstimadas);
  }

  // Metodo calcularCosto (auto se le cobra $1000 por hora)
  @Override
  public double calcularCosto() {
    return horasEstimadas * 1000;
  }

  // Metodo getEspacioOcupado (auto ocupa 2)
  @Override
  public int getEspacioOcupado() {
    return 2;
  }

  // Metodo mostrarDatos (muestra los datos del auto)
  @Override
  public void mostrarDatos() {
    System.out.println("------------------");
    System.out.println("------ AUTO ------");
    System.out.println("------------------");
    System.out.println("Patente: " + patente);
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Horas estimadas: " + horasEstimadas);
    System.out.println("Costo estimado: $" + calcularCosto());
  }

}

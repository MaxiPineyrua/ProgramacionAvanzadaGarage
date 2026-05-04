package garage;

//Abstract porque no existe un vehículo genérico.
public abstract class Vehiculo implements Calculable {
  protected String patente; // protected para que las subclases accedan.
  protected String marca;
  protected String modelo;
  protected int horasEstimadas;

  // constructor
  public Vehiculo(String patente, String marca, String modelo, int horasEstimadas) throws HorasInvalidasException {
    // Validacion horas
    if (horasEstimadas <= 0) {
      throw new HorasInvalidasException("Las horas deben ser mayor a 0.");
    }
    this.patente = patente;
    this.marca = marca;
    this.modelo = modelo;
    this.horasEstimadas = horasEstimadas;
  }

  // Getters
  public String getPatente() {
    return patente;
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public int getHorasEstimadas() {
    return horasEstimadas;
  }

  // Métodos abstractos para que las subclases implementen
  // Cada vehículo calcula su costo a su manera.
  public abstract double calcularCosto();

  // Cada vehículo indica cuanto ocupa
  public abstract int getEspacioOcupado();

  // cada vehiculo muestra sus datos
  public abstract void mostrarDatos();

}

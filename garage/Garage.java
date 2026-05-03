package garage;

import java.util.ArrayList;

public class Garage {
  // Capacidad máxima de espacios
  private int capacidadMaxima;

  // Lista donde se guardan los vehículos
  private ArrayList<Vehiculo> vehiculos;

  // Constructor del garage
  public Garage(int capacidadMaxima) {
    this.capacidadMaxima = capacidadMaxima;
    this.vehiculos = new ArrayList<>(); // Para iniciar lista vacía
  }

  // Getter de capacidad maxima
  public int getCapacidadMaxima() {
    return capacidadMaxima;
  }

  // Getter de lista vehiculos
  public ArrayList<Vehiculo> getVehiculos() {
    return vehiculos;
  }

  // Calcular espacio total ocupado por todos los vehículos
  public int calcularEspacioOcupado() {
    int espacioOcupado = 0;

    // Se recorren los vehículos
    for (Vehiculo v : vehiculos) {
      espacioOcupado += v.getEspacioOcupado();
    }
    return espacioOcupado;
  }

  // Calcular espacio libre restante
  public int calcularEspacioDisponible() {
    return capacidadMaxima - calcularEspacioOcupado();
  }

  // Verificar si hay espacio para un vehículo
  public boolean hayEspacio(Vehiculo vehiculo) {
    // Espacio dispo actual
    int espacioDisponible = calcularEspacioDisponible();
    // Espacio que necesita el vehículo
    int espacioNecesario = vehiculo.getEspacioOcupado();
    // Devuelve true si hay lugar
    return espacioDisponible >= espacioNecesario;
  }

  // Registrar ingreso de un vehículo al garage.
  public boolean ingresarVehiculo(Vehiculo vehiculo) {
    // Fijarse si hay lugar
    if (hayEspacio(vehiculo)) {
      vehiculos.add(vehiculo); // Se agrega a la lista
      return true;
    } else {
      return false; // No hay espacio
    }
  }

  // Registrar salida de un vehículo x patente.
  public Vehiculo retirarVehiculo(String patente) {
    // Recorre la lista de vehículos
    for (Vehiculo v : vehiculos) {
      // Comparamos patente
      if (v.getPatente().equalsIgnoreCase(patente)) {
        vehiculos.remove(v); // Elimina el vehículo
        return v; // Devuelve el vehículo encontrado.
      }
    }
    return null; // Si no se encuentra devuelve null
  }

  // Mostrar vehículos estacionados
  public void listaVehiculos() {
    // Si la lista está vacía
    if (vehiculos.isEmpty()) {
      System.out.println("No hay vehículos estacionados. ");
      return;
    }
    // Recorrer lista
    for (Vehiculo v : vehiculos) {
      v.mostrarDatos(); // Cada uno muestra los datos.
      System.out.println("---------------------");
    }
  }

  // Mostrar el estado actual del garage
  public void mostrarEstado() {
    System.out.println("--------------------------------");
    System.out.println("--- ESTADO ACTUAL DEL GARAGE ---");
    System.out.println("--------------------------------");
    System.out.println("Espacio total: " + capacidadMaxima);
    System.out.println("Espacio ocupado: " + calcularEspacioOcupado());
    System.out.println("Espacio disponible: " + calcularEspacioDisponible());
    System.out.println("--------------------------------");
  }

  // Reporte del garage
  public void mostrarReporte() {
    int totalVehiculos = vehiculos.size();
    int cantidadMotos = 0;
    int cantidadAutos = 0;
    int cantidadCamiones = 0;
    double recaudacionTotal = 0;

    // recorre los vehiculos
    for (Vehiculo v : vehiculos) {
      // Contar por tipo de vehículo
      if (v instanceof Moto) {
        cantidadMotos++;
      } else if (v instanceof Auto) {
        cantidadAutos++;
      } else if (v instanceof Camion) {
        cantidadCamiones++;
      }
      // Sumar la recaudación
      recaudacionTotal += v.calcularCosto();
    }

    // mostrar los resultados
    System.out.println("-----------------------");
    System.out.println("------- REPORTE -------");
    System.out.println("-----------------------");
    System.out.println("Total vehículos: " + totalVehiculos);
    System.out.println("Motos: " + cantidadMotos);
    System.out.println("Autos: " + cantidadAutos);
    System.out.println("Camiones: " + cantidadCamiones);
    System.out.println("Recaudación total: $" + recaudacionTotal);
    System.out.println("-----------------------");
  }
}

package garage;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Pedimos la capacidad total del garage
    System.out.println("Bienvenido a Garage Systems");
    System.out.println("Ingrese la capacidad del garage: ");
    int capacidad = scanner.nextInt();

    // Creo el garage
    Garage garage = new Garage(capacidad);
    System.out.println("Garage creado con exito!");

    boolean salir = false;
    while (!salir) {
      System.out.println("--------------------------");
      System.out.println("----- GARAGE SYSTEMS -----");
      System.out.println("--------------------------");
      System.out.println("Por favor elija una opcion: ");
      System.out.println("1. Registrar ingreso.");
      System.out.println("2. Registrar salida.");
      System.out.println("3. Lista de Vehículos.");
      System.out.println("4. Estado del Garage.");
      System.out.println("5. Reportes.");
      System.out.println("6. Salir.");

      int opcion = scanner.nextInt();
      scanner.nextLine(); // Limpiar el buffer

      switch (opcion) {
        // -------- Registrar ingreso --------
        case 1:
          System.out.println("Registrar Ingreso");
          try {
            int tipo = 0;
            boolean tipoValido = false;

            while (!tipoValido) {
              try {
                System.out.println("Tipo de vehículo?:");
                System.out.println("1- Moto");
                System.out.println("2- Auto");
                System.out.println("3- Camion");
                tipo = scanner.nextInt();
                scanner.nextLine();

                // Validamos antes de crear el vehiculo
                if (tipo < 1 || tipo > 3) {
                  System.out.println("Tipo de vehículo inválido. Intente nuevamente.");
                } else {
                  tipoValido = true;
                }
              } catch (Exception e) {
                System.out.println("Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer
              }
            }

            System.out.println("Ingrese la patente: ");
            String patente = scanner.nextLine();

            System.out.println("Ingrese la marca: ");
            String marca = scanner.nextLine();

            System.out.println("Ingrese el modelo: ");
            String modelo = scanner.nextLine();

            int horas = 0;
            boolean horasValidas = false;
            while (!horasValidas) {
              try {
                System.out.println("Ingrese horas estimadas: ");
                horas = scanner.nextInt();
                scanner.nextLine();
                // Validamos antes de crear el vehiculo
                if (horas <= 0) {
                  throw new HorasInvalidasException("Las horas deben ser mayores a 0.");
                }
                horasValidas = true; // Si está bien, sale del loop
              } catch (HorasInvalidasException e) {
                System.out.println("Error: " + e.getMessage());
              } catch (Exception e) {
                System.out.println("Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer
              }
            }

            if (patente.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
              System.out.println("Los campos no pueden estar vacíos. ");
              break;
            }

            Vehiculo vehiculo = null;
            // Crear vehículo según tipo
            switch (tipo) {
              case 1:
                vehiculo = new Moto(patente, marca, modelo, horas);
                break;
              case 2:
                vehiculo = new Auto(patente, marca, modelo, horas);
                break;
              case 3:
                vehiculo = new Camion(patente, marca, modelo, horas);
                break;
              default:
                System.out.println("Tipo de vehículo inválido.");
                break;
            }
            if (vehiculo != null) {
              garage.ingresarVehiculo(vehiculo);
              System.out.println("Vehículo ingresado correctamente.");
            }
          } catch (HorasInvalidasException e) {
            System.out.println("Error: " + e.getMessage());
          } catch (PatenteDuplicadaException e) {
            System.out.println("Error: " + e.getMessage());
          } catch (GarageLlenoException e) {
            System.out.println("Error: " + e.getMessage());
          } catch (Exception e) {
            System.out.println("Error en los datos ingresados: " + e.getMessage());
          }
          break;

        // -------- Registrar salida --------
        case 2:
          System.out.println("Registrar Salida");
          try {
            System.out.println("Ingrese la patente del vehículo a retirar:");
            String patente = scanner.nextLine();

            Vehiculo vehiculo = garage.retirarVehiculo(patente);
            System.out.println("Vehículo retirado correctamente.");
            vehiculo.mostrarDatos();
            System.out.println("Costo total a pagar: $" + vehiculo.calcularCosto());

          } catch (VehiculoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
          }
          break;

        // -------- Lista de Vehículos --------
        case 3:
          System.out.println("Lista de Vehículos");
          garage.listaVehiculos();
          break;

        // -------- Estado del Garage --------
        case 4:
          System.out.println("Estado del Garage");
          garage.mostrarEstado();
          break;

        // -------- Reportes --------
        case 5:
          System.out.println("Reportes");
          garage.mostrarReporte();
          break;

        // -------- Salir --------
        case 6:
          salir = true;
          System.out.println("Saliendo del sistema...");
          break;
        default:
          System.out.println("Opcion no válida. Intente nuevamente.");
      }
    }
    scanner.close();
  }
}

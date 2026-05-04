# 🚗 Sistema de Gestión de Garage

## 📌 Descripción
Este proyecto consiste en el desarrollo de un sistema en Java que permite gestionar el ingreso, permanencia y salida de vehículos en un garage.

El sistema fue desarrollado aplicando conceptos de Programación Orientada a Objetos (POO), incluyendo herencia, polimorfismo, encapsulamiento, uso de interfaces, manejo de excepciones y colecciones.

---

## ⚙️ Funcionalidades

- Registrar ingreso de vehículos
- Registrar salida de vehículos
- Listar vehículos estacionados
- Mostrar estado del garage
- Generar reportes

---

## 🚙 Tipos de vehículos

El sistema contempla tres tipos de vehículos:

| Tipo    | Espacio ocupado | Costo por hora |
|--------|----------------|---------------|
| Moto   | 1              | $700          |
| Auto   | 2              | $1000         |
| Camión | 4              | $1500         |

---

## 🧠 Conceptos aplicados

- ✔ Programación Orientada a Objetos
- ✔ Herencia (`Vehiculo`, `Moto`, `Auto`, `Camion`)
- ✔ Polimorfismo (cálculo de costos y espacio)
- ✔ Interfaces (`Calculable`)
- ✔ Colecciones (`ArrayList`)
- ✔ Manejo de excepciones personalizadas
- ✔ Validaciones de datos
- ✔ Menú interactivo por consola

---

## ⚠️ Excepciones personalizadas

El sistema implementa las siguientes excepciones:

- `GarageLlenoException`
- `PatenteDuplicadaException`
- `VehiculoNoEncontradoException`
- `HorasInvalidasException`
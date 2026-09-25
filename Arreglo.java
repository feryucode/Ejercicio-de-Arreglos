/*
Perez Chel Cesar Alejandro
3SA
*/

import java.util.Scanner;

public class Arreglo {

    private double[][] ventas;
    private static final String[] MESES = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    private static final String[] DEPARTAMENTOS = {"Ropa", "Deportes", "Juguetería"};

    public Arreglo() {
        this.ventas = new double[12][3];
    }

    public void insertarElemento(int mes, int depto, double monto) {
        if (mes >= 0 && mes < 12 && depto >= 0 && depto < 3) {
            ventas[mes][depto] = monto;
            System.out.printf("Venta de $%.2f registrada en %s para %s.%n", monto, DEPARTAMENTOS[depto], MESES[mes]);
        } else {
            System.out.println("Error: Índice de mes o departamento fuera de rango.");
        }
    }

    public boolean buscarElemento(double montoBuscado) {
        boolean encontrado = false;
        System.out.printf("Buscando registros con el monto $%.2f...%n", montoBuscado);

        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                if (Double.compare(ventas[i][j], montoBuscado) == 0) {
                    System.out.printf("-> Encontrado: %s en el mes de %s.%n", DEPARTAMENTOS[j], MESES[i]);
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún registro con ese valor exacto.");
        }
        return encontrado;
    }

    public void eliminarElemento(int mes, int depto) {
        if (mes >= 0 && mes < 12 && depto >= 0 && depto < 3) {
            ventas[mes][depto] = 0.0;
            System.out.printf("Venta eliminada (establecida en 0.0) en %s para %s.%n", DEPARTAMENTOS[depto], MESES[mes]);
        } else {
            System.out.println("Error: Índices inválidos para eliminar.");
        }
    }

    public void mostrarTabla() {
        System.out.println("\n======================= TABLA DE VENTAS =======================");
        System.out.printf("%-12s | %-12s | %-12s | %-12s%n", "Mes", DEPARTAMENTOS[0], DEPARTAMENTOS[1], DEPARTAMENTOS[2]);
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < 12; i++) {
            System.out.printf("%-12s | %-12.2f | %-12.2f | %-12.2f%n",
                    MESES[i], ventas[i][0], ventas[i][1], ventas[i][2]);
        }
        System.out.println("===============================================================\n");
    }

    public static void main(String[] args) {
        Arreglo tienda = new Arreglo();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE GESTIÓN DE VENTAS ---");
            System.out.println("1. Insertar venta");
            System.out.println("2. Buscar venta");
            System.out.println("3. Eliminar venta");
            System.out.println("4. Mostrar tabla completa");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el número de mes (1 al 12): ");
                    int mesIns = scanner.nextInt() - 1;
                    System.out.print("Ingresa el departamento (1=Ropa, 2=Deportes, 3=Juguetería): ");
                    int deptoIns = scanner.nextInt() - 1;
                    System.out.print("Ingresa el monto de la venta: ");
                    double montoIns = scanner.nextDouble();
                    tienda.insertarElemento(mesIns, deptoIns, montoIns);
                    break;
                case 2:
                    System.out.print("Ingresa el monto exacto a buscar: ");
                    double montoBusq = scanner.nextDouble();
                    tienda.buscarElemento(montoBusq);
                    break;
                case 3:
                    System.out.print("Ingresa el número de mes (1 al 12): ");
                    int mesEli = scanner.nextInt() - 1;
                    System.out.print("Ingresa el departamento (1=Ropa, 2=Deportes, 3=Juguetería): ");
                    int deptoEli = scanner.nextInt() - 1;
                    tienda.eliminarElemento(mesEli, deptoEli);
                    break;
                case 4:
                    tienda.mostrarTabla();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
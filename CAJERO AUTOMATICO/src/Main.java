import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnalisisTemperaturas analisis = new AnalisisTemperaturas();
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    analisis.ingresarTemperaturas(scanner);
                    break;
                case 2:
                    analisis.mostrarTodasLasTemperaturas();
                    break;
                case 3:
                    analisis.mostrarTemperaturaMaxima();
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                case 5: // Opción extra para la suma recursiva
                    analisis.calcularSumaTotalRecursiva();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Menú de Opciones ---");
        System.out.println("1. Ingresar temperaturas");
        System.out.println("2. Mostrar todas las temperaturas");
        System.out.println("3. Mostrar temperatura máxima");
        System.out.println("4. Salir");
        System.out.println("5. Calcular suma total de temperaturas (opcional)");
        System.out.print("Seleccione una opción: ");
    }
}

class AnalisisTemperaturas {
    private double[] temperaturas;
    private final String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    private boolean datosIngresados = false;

    // Opción 1: Ingresar temperaturas
    public void ingresarTemperaturas(Scanner scanner) {
        temperaturas = new double[7];
        System.out.println("Ingrese las temperaturas para los 7 días de la semana:");

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.print("Temperatura del " + dias[i] + ": ");
            temperaturas[i] = scanner.nextDouble();
        }
        datosIngresados = true;
        System.out.println("Temperaturas ingresadas exitosamente.");
    }

    // Opción 2: Mostrar todas las temperaturas (procedimiento)
    public void mostrarTodasLasTemperaturas() {
        if (!datosIngresados) {
            System.out.println("Aún no se han ingresado temperaturas.");
            return;
        }

        System.out.println("\n--- Temperaturas Registradas ---");
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println(dias[i] + ": " + temperaturas[i] + "°C");
        }
    }

    // Opción 3: Mostrar la temperatura más alta (función)
    public double encontrarTemperaturaMaxima() {
        if (!datosIngresados) {
            return Double.MIN_VALUE; // Retorna un valor mínimo para indicar que no hay datos
        }

        double max = temperaturas[0];
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > max) {
                max = temperaturas[i];
            }
        }
        return max;
    }

    // Método principal para mostrar la temperatura máxima
    public void mostrarTemperaturaMaxima() {
        if (!datosIngresados) {
            System.out.println("Aún no se han ingresado temperaturas.");
            return;
        }

        double maxTemp = encontrarTemperaturaMaxima();
        int diaIndex = -1;

        // Encontrar el día de la temperatura máxima
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] == maxTemp) {
                diaIndex = i;
                break;
            }
        }

        System.out.println("\n--- Temperatura Máxima ---");
        // Uso de los métodos sobrecargados
        mostrarMaxima(maxTemp); // Muestra la máxima sin el día
        mostrarMaxima(maxTemp, dias[diaIndex]); // Muestra la máxima con el día
    }

    // Método sobrecargado 1
    public void mostrarMaxima(double temperatura) {
        System.out.println("La temperatura máxima registrada es: " + temperatura + "°C");
    }

    // Método sobrecargado 2
    public void mostrarMaxima(double temperatura, String dia) {
        System.out.println("La temperatura máxima de " + dia + " fue de: " + temperatura + "°C");
    }

    // Función recursiva para calcular la suma total (opcional)
    public double sumaTemperaturasRecursiva(int n) {
        if (n == 0) {
            return temperaturas[0];
        } else {
            return temperaturas[n] + sumaTemperaturasRecursiva(n - 1);
        }
    }

    // Método para mostrar el resultado de la suma recursiva
    public void calcularSumaTotalRecursiva() {
        if (!datosIngresados) {
            System.out.println("Aún no se han ingresado temperaturas.");
            return;
        }

        double sumaTotal = sumaTemperaturasRecursiva(temperaturas.length - 1);
        System.out.println("\n--- Suma Total de Temperaturas (Recursiva) ---");
        System.out.println("La suma total de las temperaturas es: " + sumaTotal + "°C");
    }
}
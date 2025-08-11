import java.util.Scanner;

public class EmpresaTemperaturasEscalera {
    static Scanner scanner = new Scanner(System.in);
    static double[] temperaturas = new double[7];
    static boolean temperaturasIngresadas = false;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ingresarTemperaturas();
                    break;
                case 2:
                    if (temperaturasIngresadas) {
                        mostrarTemperaturas();
                    } else {
                        System.out.println("Primero debe ingresar las temperaturas.");
                    }
                    break;
                case 3:
                    if (temperaturasIngresadas) {
                        double maxima = obtenerTemperaturaMaxima(temperaturas);
                        int diaIndex = obtenerIndiceMaxima(temperaturas, maxima);
                        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
                        mostrarMaxima(maxima);
                        mostrarMaxima(maxima, dias[diaIndex]);
                    } else {
                        System.out.println("Primero debe ingresar las temperaturas.");
                    }
                    break;
                case 4:
                    ejecutarEscalera();
                    break;
                case 5:
                    if (temperaturasIngresadas) {
                        double suma = sumaRecursiva(temperaturas, 0);
                        System.out.println("Suma total de temperaturas: " + suma);
                    } else {
                        System.out.println("Primero debe ingresar las temperaturas.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    // ----------------------------- TEMPERATURAS -----------------------------
    static void mostrarMenu() {
        System.out.println("\n---- MENÚ PRINCIPAL ----");
        System.out.println("1. Ingresar temperaturas");
        System.out.println("2. Mostrar todas las temperaturas");
        System.out.println("3. Mostrar temperatura máxima");
        System.out.println("4. Generar patrón escalera");
        System.out.println("5. (Extra) Sumar temperaturas (recursiva)");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    static void ingresarTemperaturas() {
        System.out.println("\nIngrese las temperaturas máximas para cada día:");
        for (int i = 0; i < 7; i++) {
            System.out.print("Día " + (i + 1) + ": ");
            temperaturas[i] = scanner.nextDouble();
        }
        temperaturasIngresadas = true;
    }

    static void mostrarTemperaturas() {
        System.out.println("\nTemperaturas registradas:");
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println("Día " + (i + 1) + ": " + temperaturas[i]);
        }
    }

    static double obtenerTemperaturaMaxima(double[] arreglo) {
        double max = arreglo[0];
        for (double temp : arreglo) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    static int obtenerIndiceMaxima(double[] arreglo, double maxima) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == maxima) {
                return i;
            }
        }
        return -1; // No debería ocurrir
    }

    static void mostrarMaxima(double temperatura) {
        System.out.println("\nTemperatura máxima registrada: " + temperatura);
    }

    static void mostrarMaxima(double temperatura, String dia) {
        System.out.println("Temperatura máxima fue el " + dia + ": " + temperatura);
    }

    // (Extra) Recursiva
    static double sumaRecursiva(double[] arreglo, int index) {
        if (index == arreglo.length) return 0;
        return arreglo[index] + sumaRecursiva(arreglo, index + 1);
    }

    // ----------------------------- ESCALERA -----------------------------
    static void ejecutarEscalera() {
        System.out.print("\nIngrese el número de niveles para la escalera (>=1): ");
        int niveles = scanner.nextInt();

        if (niveles < 1) {
            System.out.println("Número inválido. Debe ser mayor o igual a 1.");
            return;
        }

        System.out.println("\nEscalera Ascendente:");
        imprimirEscaleraAscendente(niveles);

        System.out.println("\nEscalera Descendente:");
        imprimirEscaleraDescendenteRecursiva(niveles - 1);
    }

    static void imprimirEscaleraAscendente(int n) {
        for (int i = 1; i <= n; i++) {
            imprimirLinea(i);
        }
    }

    static void imprimirEscaleraDescendenteRecursiva(int n) {
        if (n == 0) return;
        imprimirLinea(n);
        imprimirEscaleraDescendenteRecursiva(n - 1);
    }

    // Sobrecarga
    static void imprimirLinea(int nivel) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void imprimirLinea(int nivel, char simbolo) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(simbolo + " ");
        }
        System.out.println();
    }
}

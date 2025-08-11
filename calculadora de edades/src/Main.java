// Importamos la clase Scanner para poder leer la entrada del usuario desde la consola.
import java.util.Scanner;

// Definimos la clase principal de nuestro programa.
// El nombre de esta clase debe coincidir con el nombre del archivo Java (ej. Main.java).
public class Main {

    // Este es el método 'main', el punto de inicio de cualquier aplicación Java.
    // La Máquina Virtual de Java (JVM) comienza a ejecutar el código desde aquí.
    public static void main(String[] args) {

        // Declaración de variables:
        // 'nombreUsuario' guardará el nombre ingresado por el usuario (tipo String).
        String nombreUsuario;
        // 'anoNacimiento' guardará el año de nacimiento (tipo int, número entero).
        int anoNacimiento;
        // 'edad' guardará el resultado del cálculo de la edad (tipo int).
        int edad;
        // 'anoActual' se fija en 2025, según el requisito de la tarea.
        int anoActual = 2025;

        // Creamos un objeto 'Scanner' para leer la entrada del teclado (System.in).
        Scanner scanner = new Scanner(System.in);

        // --- 1. Solicitar el nombre al usuario ---
        // Mostramos un mensaje en la consola pidiendo el nombre.
        System.out.print("Por favor, ingresa tu nombre: ");
        // Leemos la línea completa que el usuario escribe y la guardamos en 'nombreUsuario'.
        nombreUsuario = scanner.nextLine();

        // --- 2. Solicitar el año de nacimiento ---
        // Mostramos un mensaje pidiendo el año de nacimiento.
        System.out.print("Por favor, ingresa tu año de nacimiento (ej. 1990): ");
        // Leemos el número entero que el usuario escribe y lo guardamos en 'anoNacimiento'.
        anoNacimiento = scanner.nextInt();

        // --- 3. Calcular la edad aproximada ---
        // Realizamos la resta para obtener la edad.
        edad = anoActual - anoNacimiento;

        // --- 4. Imprimir el resultado en consola ---
        // Mostramos el mensaje final, combinando texto con las variables 'nombreUsuario' y 'edad'.
        System.out.println("Hola " + nombreUsuario + ", tu edad aproximada es: " + edad + " años.");

        // Cerramos el objeto Scanner para liberar los recursos del sistema.
        // Es una buena práctica hacerlo al finalizar de usarlo.
        scanner.close();
    }
}

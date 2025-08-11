package umg.com;

public class Main {
    public static void main(String[] args) {
        public class GeneradorEscalera {

            // Método 1: Sobrecargado para imprimir una línea con números
            public void imprimirLinea(int nivel) {
                for (int i = 1; i <= nivel; i++) {
                    System.out.print(i + " ");
                }
                System.out.println(); // Salto de línea
            }

            // Método 2: Sobrecargado para imprimir una línea con un símbolo
            public void imprimirLinea(int nivel, char simbolo) {
                for (int i = 1; i <= nivel; i++) {
                    System.out.print(simbolo + " ");
                }
                System.out.println(); // Salto de línea
            }

            // Procedimiento para la parte ascendente de la escalera
            public void imprimirEscaleraAscendente(int n) {
                for (int i = 1; i <= n; i++) {
                    imprimirLinea(i); // Llamamos al método sobrecargado
                }
            }

            // Procedimiento para la parte descendente de la escalera
            public void imprimirEscaleraDescendente(int n) {
                for (int i = n - 1; i >= 1; i--) {
                    imprimirLinea(i); // Llamamos al método sobrecargado
                }
            }

            // Opcional: Procedimiento recursivo para la parte descendente
            public void imprimirEscaleraDescendenteRecursiva(int n) {
                if (n >= 1) {
                    imprimirLinea(n);
                    imprimirEscaleraDescendenteRecursiva(n - 1);
                }
            }


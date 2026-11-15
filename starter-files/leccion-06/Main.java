// Lección 6 - Práctica: Tu propia multiplicación
// Reto: completa los TODO, activa Interactive y ejecuta el programa.

import java.util.Scanner;

public class Main {
    public static int sumar(int a, int b) {
        return a + b;
    }

    // TODO 1: crea el método multiplicar, que reciba dos números
    // y devuelva el resultado.

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escribe el primer numero:");
        int a = entrada.nextInt();
        System.out.println("Escribe el segundo numero:");
        int b = entrada.nextInt();

        System.out.println("La suma es: " + sumar(a, b));

        // TODO 2: llama a multiplicar con los números que escribió la persona
        // y muestra la multiplicación.

        entrada.close();
    }
}

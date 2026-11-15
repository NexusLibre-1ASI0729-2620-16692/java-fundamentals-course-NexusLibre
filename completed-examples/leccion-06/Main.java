// Lección 6: Entrada y salida de datos

import java.util.Scanner;

public class Main {
    public static void saludar(String nombre) {
        System.out.println("Hola, " + nombre + ", bienvenido al curso");
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        // PARTE 1: salida con print y println
        System.out.print("Hola ");
        System.out.print("mundo");
        System.out.println(" desde Java");
        System.out.println("Esta es otra línea");

        // PARTE 2: entrada con Scanner
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escribe tu nombre: ");
        String nombre = entrada.nextLine();

        saludar(nombre);

        // PARTE 3: métodos + entrada de datos
        System.out.println("Escribe el primer numero:");
        int a = entrada.nextInt();
        System.out.println("Escribe el segundo numero:");
        int b = entrada.nextInt();

        int resultado = sumar(a, b);
        System.out.println("La suma es: " + resultado);

        entrada.close();
    }
}

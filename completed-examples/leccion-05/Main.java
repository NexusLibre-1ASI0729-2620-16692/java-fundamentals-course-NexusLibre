// Lección 5: Métodos y parámetros

public class Main {
    public static void saludar(String nombre) {
        System.out.println("Hola, " + nombre + ", bienvenido al curso");
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        saludar("Ana");
        saludar("Luis");

        int resultado = sumar(5, 3);
        System.out.println("La suma es: " + resultado);
    }
}

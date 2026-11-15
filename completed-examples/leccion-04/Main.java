// Lección 4: Operadores y estructuras de control

public class Main {
    public static void main(String[] args) {

        // PARTE 1: operadores
        int galletas = 3;
        double precioJugo = 2.50;
        String cliente = "Pepito";
        boolean hayStock = true;

        double total = galletas * 1.50 + precioJugo;
        boolean alcanza = total <= 10.0;
        boolean puedeComprar = hayStock && alcanza;

        System.out.println("Cliente: " + cliente);
        System.out.println("Total: S/ " + total);
        System.out.println("¿Alcanza? " + alcanza);
        System.out.println("¿Puede comprar? " + puedeComprar);

        // PARTE 2: decisiones
        // Paso 1: if simple
        if (hayStock) {
            System.out.println("Producto disponible");
        }

        // Paso 2: if / else
        if (total <= 10.0) {
            System.out.println("Compra aprobada");
        } else {
            System.out.println("Dinero insuficiente");
        }

        // Paso 3: else if
        if (galletas >= 10) {
            System.out.println("Descuento del 20%");
        } else if (galletas >= 5) {
            System.out.println("Descuento del 10%");
        } else {
            System.out.println("Sin descuento");
        }

        // PARTE 3: repeticiones
        // for: sé cuántas veces repetir
        for (int i = 1; i <= 5; i++) {
            System.out.println("Galleta número " + i);
        }

        System.out.println("-----");

        // while: repito mientras algo sea verdadero
        int dinero = 10;
        while (dinero >= 2) {
            System.out.println("Compro un jugo. Me quedan: " + (dinero - 2));
            dinero = dinero - 2;
        }

        // PARTE 4: todo junto (while + if)
        double saldo = 10.0;
        double precio = 2.50;
        int jugos = 0;

        while (saldo >= precio) {
            saldo = saldo - precio;
            jugos++;
        }

        if (jugos > 0) {
            System.out.println("Compraste " + jugos + " jugos");
        } else {
            System.out.println("No te alcanza");
        }
    }
}

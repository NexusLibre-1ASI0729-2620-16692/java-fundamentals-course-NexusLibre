// Lección 10 - Práctica: amplía el registro de estudiantes
// Retos:
//  1. Agrega a la clase Registro un método contarAprobados() que devuelva
//     cuántos estudiantes tienen nota mayor o igual a 11.
//  2. Muéstralo en el reporte final.
//  3. (Extra) Agrega un método buscar(String nombre) que use equalsIgnoreCase.
import java.util.Scanner;

class Estudiante {
    private String nombre;
    private double nota;

    public Estudiante(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public boolean aprobo() {
        return nota >= 11;
    }
}

class Registro {
    private Estudiante[] lista;
    private int cantidad;

    public Registro(int capacidad) {
        lista = new Estudiante[capacidad];
        cantidad = 0;
    }

    public void agregar(Estudiante e) {
        if (cantidad < lista.length) {
            lista[cantidad] = e;
            cantidad++;
        }
    }

    public void mostrarTodos() {
        for (int i = 0; i < cantidad; i++) {
            System.out.println((i + 1) + ". " + lista[i].getNombre() + " - " + lista[i].getNota());
        }
    }

    // TODO 1: escribe aquí el método contarAprobados()
}

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes vas a registrar? ");
        int total = teclado.nextInt();
        teclado.nextLine();

        Registro registro = new Registro(total);

        for (int i = 0; i < total; i++) {
            System.out.print("Nombre del estudiante " + (i + 1) + ": ");
            String nombre = teclado.nextLine();
            System.out.print("Nota de " + nombre + ": ");
            double nota = teclado.nextDouble();
            teclado.nextLine();
            registro.agregar(new Estudiante(nombre, nota));
        }

        System.out.println("\n--- REPORTE DEL SALÓN ---");
        registro.mostrarTodos();
        // TODO 2: muestra cuántos estudiantes aprobaron
    }
}
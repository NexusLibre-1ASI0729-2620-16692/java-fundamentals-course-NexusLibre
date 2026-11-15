// Lección 10: Mini proyecto - Registro de estudiantes
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
        } else {
            System.out.println("El registro está lleno.");
        }
    }

    public void mostrarTodos() {
        for (int i = 0; i < cantidad; i++) {
            Estudiante e = lista[i];
            String estado = e.aprobo() ? "Aprobado" : "Desaprobado";
            System.out.println((i + 1) + ". " + e.getNombre() + " - " + e.getNota() + " - " + estado);
        }
    }

    public double promedio() {
        if (cantidad == 0) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma = suma + lista[i].getNota();
        }
        return suma / cantidad;
    }

    public Estudiante mejorEstudiante() {
        if (cantidad == 0) {
            return null;
        }
        Estudiante mejor = lista[0];
        for (int i = 1; i < cantidad; i++) {
            if (lista[i].getNota() > mejor.getNota()) {
                mejor = lista[i];
            }
        }
        return mejor;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes vas a registrar? ");
        int total = teclado.nextInt();
        teclado.nextLine(); // limpia el "Enter" que quedó pendiente

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
        System.out.printf("Promedio: %.2f%n", registro.promedio());

        Estudiante mejor = registro.mejorEstudiante();
        if (mejor != null) {
            System.out.println("Mejor nota: " + mejor.getNombre() + " (" + mejor.getNota() + ")");
        }

        teclado.close();
    }
}
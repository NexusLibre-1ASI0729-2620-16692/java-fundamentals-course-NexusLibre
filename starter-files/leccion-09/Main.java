// Lección 9 - Práctica: Arrays y cadenas con objetos
// Reto: completa los TODO y ejecuta el programa.

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
}

public class Main {
    public static void main(String[] args) {
        Estudiante[] salon = new Estudiante[3];
        salon[0] = new Estudiante("Valeria", 17);
        salon[1] = new Estudiante("Diego", 14);
        salon[2] = new Estudiante("Lucía", 19);

        // TODO 1: recorre el array y muestra el nombre de cada estudiante en MAYÚSCULAS.

        // TODO 2: encuentra y muestra al estudiante con la nota más alta.
        // Pista: guarda al "mejor" en una variable y compáralo con cada uno.
    }
}
// Lección 9: Arrays y cadenas con objetos

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

        // PARTE 1: un array de números
        int[] puntajes = {15, 18, 12, 20};
        System.out.println("Primer puntaje: " + puntajes[0]);
        System.out.println("Cantidad de puntajes: " + puntajes.length);

        for (int i = 0; i < puntajes.length; i++) {
            System.out.println("Posición " + i + ": " + puntajes[i]);
        }

        // PARTE 2: trabajar con cadenas (String)
        String nombre = "Valeria";
        System.out.println("Letras: " + nombre.length());
        System.out.println("En mayúsculas: " + nombre.toUpperCase());
        System.out.println("Primera letra: " + nombre.charAt(0));
        System.out.println("¿Es Valeria? " + nombre.equals("Valeria"));

        // PARTE 3: un array de objetos
        Estudiante[] salon = new Estudiante[3];
        salon[0] = new Estudiante("Valeria", 17);
        salon[1] = new Estudiante("Diego", 14);
        salon[2] = new Estudiante("Lucía", 19);

        double suma = 0;
        for (Estudiante e : salon) {
            System.out.println(e.getNombre() + " tiene " + e.getNota());
            suma = suma + e.getNota();
        }
        System.out.println("Promedio del salón: " + (suma / salon.length));

        // PARTE 4: buscar por nombre
        String buscado = "Diego";
        for (Estudiante e : salon) {
            if (e.getNombre().equalsIgnoreCase(buscado)) {
                System.out.println("Encontrado: " + e.getNombre() + " con nota " + e.getNota());
            }
        }
    }
}
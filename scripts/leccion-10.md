# Lección 10: Mini proyecto, buenas prácticas y errores comunes

## Guion

### 0:00 – 0:30 · Intro

**En pantalla:** Ten el programa completo (`completed-examples/leccion-10`) ya pegado en otra pestaña de JDoodle con Interactive activado. Ejecútalo e ingresa estos datos uno por uno:

```text
3
Valeria
17
Diego
9.5
Lucía
19
```

**Narración:** "Llegamos a la última lección. Este es el programa que vamos a construir: le dices cuántos estudiantes hay, ingresas sus nombres y notas, y te genera un reporte con quién aprobó, el promedio y la mejor nota. Y usa todo lo que aprendiste en el curso."

### 0:30 – 1:15 · Clase Estudiante

**En pantalla:** Abre una pestaña nueva de JDoodle (editor vacío). Pega esto y selecciona el método aprobo() para resaltarlo.

```java
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
```

**Narración:** "Empezamos con la clase Estudiante, la misma que usamos en la lección 9: atributos privados, constructor y getters. Solo le agregamos un método nuevo, aprobo(), que devuelve verdadero si la nota es 11 o más. Así la propia clase sabe responder si el estudiante aprobó."

### 1:15 – 2:30 · Clase Registro

**En pantalla:** Pon el cursor después de la llave } que cierra la clase Estudiante (la última línea), presiona Enter dos veces y pega esto. Recorre con el cursor: atributos → agregar → mostrarTodos → promedio → mejorEstudiante.

```java
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
```

**Narración:** "Ahora creamos una segunda clase, Registro, que guarda a todos los estudiantes. Por dentro tiene un array de Estudiante y un contador, cantidad, que nos dice cuántos hemos guardado." "agregar coloca al estudiante en la siguiente posición libre y aumenta el contador. Si ya está lleno, avisa." "mostrarTodos recorre el array y, usando aprobo, muestra Aprobado o Desaprobado." "promedio suma las notas y divide. Y mejorEstudiante hace lo mismo que el reto de la lección pasada: empieza con el primero y lo compara con los demás." "Fíjate en la idea: cada clase tiene una sola responsabilidad. Estudiante sabe de un estudiante; Registro sabe de la lista."

### 2:30 – 3:30 · El main con Scanner

**En pantalla:** Pon el cursor después de la llave } que cierra la clase Registro (la última línea del archivo), presiona Enter dos veces y pega esto. Señala el teclado.nextLine() que va después de nextInt(). Activa Interactive, ejecuta e ingresa los mismos datos de la intro.

```java
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
```

**Narración:** "En el main usamos Scanner, como en la lección 6, para pedir los datos por teclado. Primero preguntamos cuántos estudiantes hay y creamos el registro con ese tamaño." "Después de leer un número con nextInt o nextDouble ponemos un nextLine() extra. Sirve para limpiar el Enter que quedó pendiente; si no lo ponemos, el programa se salta el siguiente nombre." "Con un for pedimos nombre y nota y los agregamos. Al final mostramos el reporte. Usamos printf con %.2f para que el promedio salga con dos decimales."

### 3:30 – 5:00 · Errores comunes

**En pantalla:** Provoca en vivo los 5 errores de la tabla "Errores comunes para provocar en vivo" (≈ 20 s cada uno): cambias la línea indicada, ejecutas, muestras el mensaje en rojo y vuelves a dejarla como estaba. Ahí está el código de antes y después de cada uno.

**Narración:** Lo que dices en cada error está en la tabla "Errores comunes para provocar en vivo". Al terminar: "Los errores no son malos: son pistas. Lee el mensaje, fíjate en el número de línea y corrige."

### 5:00 – 5:30 · Buenas prácticas

**En pantalla:** No escribes código nuevo. Mientras hablas, señala en tu código estas partes como ejemplo:

```java
double promedio()           // 1. nombre claro
    for (...) {             // 2. sangría: se ve qué está dentro
public Estudiante mejorEstudiante() { ... }   // 3. método corto, una tarea
private double nota;        // 4. atributo privado + getNota()
```

**Narración:** "Cinco buenas prácticas que ya usamos en este proyecto: 1) nombres claros, como promedio o mejorEstudiante, no x o a1; 2) sangría para ver qué está dentro de qué; 3) métodos cortos, cada uno con una sola tarea; 4) atributos privados con getters; 5) prueba seguido: ejecuta cada vez que agregues algo, no al final."

### 5:30 – 5:50 · Práctica final (pausa)

**En pantalla:** Abre el link de la práctica (`starter-files/leccion-10`). Señala los retos del comentario inicial y el TODO dentro de Registro:

```java
// Retos:
//  1. Agrega a la clase Registro un método contarAprobados() que devuelva
//     cuántos estudiantes tienen nota mayor o igual a 11.
//  2. Muéstralo en el reporte final.
//  3. (Extra) Agrega un método buscar(String nombre) que use equalsIgnoreCase.

    // TODO 1: escribe aquí el método contarAprobados()
```

**Narración:** "Tu reto final: pausa el video y agrega al registro un método contarAprobados() y muéstralo en el reporte. Si quieres un extra, agrega un método para buscar a un estudiante por nombre."

### 5:50 – 6:00 · Cierre del curso

**En pantalla:** Vuelve a tu programa y deja en pantalla el reporte final. No escribes nada nuevo.

**Narración:** "¡Felicidades, terminaste el curso! Empezaste sin saber qué era programar y hoy hiciste un programa completo con clases, arrays y entrada de datos. Para seguir aprendiendo, practica un poco cada día, crea tus propios proyectos, como una lista de tareas o un juego de preguntas, y explora temas como ArrayList. ¡Sigue programando!"

## Errores comunes para provocar en vivo

| # | Qué cambias | Qué aparece | Qué decir |
|---|---|---|---|
| 1 | En mostrarTodos():<br>Antes: for (int i = 0; i < cantidad; i++)<br>Después: for (int i = 0; i <= lista.length; i++) | ArrayIndexOutOfBoundsException | "Te saliste del array. Si hay 3 elementos, los índices van de 0 a 2." |
| 2 | En cualquier línea, borra el punto y coma:<br>Antes: cantidad = 0;<br>Después: cantidad = 0 | error: ';' expected | "El más clásico. Lee el mensaje: Java te dice la línea exacta." |
| 3 | En el main:<br>Antes: registro.agregar(new Estudiante(nombre, nota));<br>Después: registro.agregar(new estudiante(nombre, nota)); | cannot find symbol | "Java distingue mayúsculas y minúsculas. Para Java son palabras distintas." |
| 4 | No lo ejecutes, solo escríbelo y compáralo:<br>Mal: if (nombre == "Diego")<br>Bien: if (nombre.equals("Diego")) | — | "Con textos usa equals. El doble igual compara si es el mismo objeto en memoria, no si el texto es igual, y puede fallar sin avisarte." |
| 5 | No cambias código. Al ejecutar, cuando pida la nota escribe:<br>diez | InputMismatchException | "Scanner esperaba un número. Siempre revisa qué tipo de dato pides." |

## Solución de la práctica

```java
// Dentro de la clase Registro
public int contarAprobados() {
    int aprobados = 0;
    for (int i = 0; i < cantidad; i++) {
        if (lista[i].aprobo()) {
            aprobados++;
        }
    }
    return aprobados;
}

public Estudiante buscar(String nombre) {
    for (int i = 0; i < cantidad; i++) {
        if (lista[i].getNombre().equalsIgnoreCase(nombre)) {
            return lista[i];
        }
    }
    return null;
}

// En el main, después de registro.mostrarTodos();
System.out.println("Aprobados: " + registro.contarAprobados());
```

## Archivos

- Inicio: `starter-files/leccion-10`
- Código del video: `completed-examples/leccion-10`
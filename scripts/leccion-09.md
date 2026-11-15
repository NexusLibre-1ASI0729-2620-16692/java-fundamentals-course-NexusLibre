# Lección 09: Arrays y cadenas con objetos

## Guion

### 0:00 – 0:30 · Gancho

**En pantalla:** Abre JDoodle → Java. Borra el código de ejemplo y escribe esto (solo para mostrar el problema, no lo ejecutes):

```java
String alumno1 = "Valeria";
String alumno2 = "Diego";
String alumno3 = "Lucía";
// ... ¿y si son 30 alumnos?
```

**Narración:** "Hasta ahora guardamos un dato en cada variable. Pero imagina que tu salón tiene 30 alumnos. ¿Vas a crear 30 variables, alumno1, alumno2, alumno3…? Sería agotador. Hoy aprenderemos a guardar muchos datos en una sola variable usando arrays, y también a trabajar con textos, que en Java se llaman cadenas o Strings."

### 0:30 – 2:00 · Parte 1: ¿Qué es un array?

**En pantalla:** Borra todo y escribe esto. Luego ejecuta. En la salida señala que la última posición es 3, no 4.

```java
public class Main {
    public static void main(String[] args) {

        // PARTE 1: un array de números
        int[] puntajes = {15, 18, 12, 20};
        System.out.println("Primer puntaje: " + puntajes[0]);
        System.out.println("Cantidad de puntajes: " + puntajes.length);

        for (int i = 0; i < puntajes.length; i++) {
            System.out.println("Posición " + i + ": " + puntajes[i]);
        }

    }
}
```

**Narración:** "Un array es como una fila de casilleros, uno al lado del otro. Todos guardan el mismo tipo de dato. Aquí tengo un array de enteros con cuatro puntajes." "Cada casillero tiene un número llamado índice. Y ojo: en Java se empieza a contar desde cero. Por eso el primer puntaje está en puntajes[0], no en puntajes[1]." "Para saber cuántos elementos tiene, uso .length. Aquí me dice 4." "Y puedo recorrer todos los casilleros con el ciclo for que vimos en la lección 4. La variable i empieza en 0 y avanza mientras sea menor que length. Así muestro todos sin repetir código."

### 2:00 – 3:00 · Parte 2: Cadenas (String)

**En pantalla:** Pon el cursor al final de la llave } que cierra el for (la que está sola, con 8 espacios) y presiona Enter dos veces. Escribe esto ahí, ANTES de las dos últimas llaves } } (la del main y la de la clase). Ejecuta.

```java
        // PARTE 2: trabajar con cadenas (String)
        String nombre = "Valeria";
        System.out.println("Letras: " + nombre.length());
        System.out.println("En mayúsculas: " + nombre.toUpperCase());
        System.out.println("Primera letra: " + nombre.charAt(0));
        System.out.println("¿Es Valeria? " + nombre.equals("Valeria"));
```

**Narración:** "Un String también es una secuencia, pero de letras. Y como es un objeto, trae métodos listos para usar." "length() cuenta las letras. toUpperCase() lo convierte a mayúsculas. charAt(0) me da la primera letra; otra vez, el índice empieza en cero." "Para comparar dos textos usamos equals, no el doble igual. En la próxima lección veremos por qué el doble igual nos puede engañar."

### 3:00 – 4:30 · Parte 3: Array de objetos

**En pantalla:** (1) Pon el cursor al inicio de la línea 1 (antes de public class Main), presiona Enter dos veces y pega esta clase en el espacio vacío que quedó arriba. Queda fuera de Main. Recórrela con el cursor: atributos, constructor, getters.

```java
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
```

**Narración:** "Para esta parte creé una clase Estudiante sencilla: tiene dos atributos privados, nombre y nota, un constructor para crear cada estudiante y dos getters para leer sus datos. Son las herramientas de programación orientada a objetos que ya viste en el curso."

### (continúa Parte 3)

**En pantalla:** (2) Baja hasta la última línea de la Parte 2 (el println de ¿Es Valeria?), presiona Enter dos veces y escribe esto, siempre ANTES de las dos últimas llaves } }. Ejecuta.

```java
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
```

**Narración:** "Un array no solo guarda números: también puede guardar objetos. Aquí creo un array con espacio para 3 estudiantes." "Ojo: new Estudiante[3] solo crea los casilleros vacíos. Después tengo que crear cada estudiante con new y colocarlo en su posición." "Para recorrerlo uso una versión más corta del for, llamada for-each. Se lee: para cada Estudiante e dentro de salón. No necesito índices." "Dentro del ciclo uso los getters de la clase para leer cada nota y voy sumando. Al final divido entre la cantidad y obtengo el promedio del salón."

### 4:30 – 5:15 · Parte 4: Buscar por nombre

**En pantalla:** Ponte al final de la última línea de la Parte 3 (el println del Promedio del salón), presiona Enter dos veces y escribe esto, ANTES de las dos últimas llaves } }. Ejecuta. Luego cambia "Diego" por "diego" (minúscula) y ejecuta otra vez: igual lo encuentra.

```java
        // PARTE 4: buscar por nombre
        String buscado = "Diego";
        for (Estudiante e : salon) {
            if (e.getNombre().equalsIgnoreCase(buscado)) {
                System.out.println("Encontrado: " + e.getNombre() + " con nota " + e.getNota());
            }
        }
```

**Narración:** "Por último, busquemos a un estudiante por su nombre. Recorro el array y comparo con equalsIgnoreCase, que compara sin importar mayúsculas o minúsculas. Si escribo diego en minúscula, igual lo encuentra."

### 5:15 – 5:45 · Práctica (pausa)

**En pantalla:** Abre en otra pestaña el link de la práctica (`starter-files/leccion-09`). Señala esta parte del main con los dos TODO:

```java
        // TODO 1: recorre el array y muestra el nombre de cada
        //         estudiante en MAYÚSCULAS.

        // TODO 2: encuentra y muestra al estudiante con la nota más alta.
        // Pista: guarda al "mejor" en una variable y compáralo con cada uno.
```

**Narración:** "Ahora te toca a ti. Pausa el video y abre el enlace de la práctica. Tienes dos retos: mostrar los nombres en mayúsculas y encontrar al estudiante con la nota más alta. Pista: guarda al primero como el mejor y compáralo con los demás."

### 5:45 – 6:00 · Cierre

**En pantalla:** Vuelve a tu código y deja en pantalla la salida del programa. No escribes nada nuevo.

**Narración:** "Hoy aprendiste a guardar muchos datos con arrays, a trabajar con textos y a combinar arrays con objetos. En la última lección vamos a unir todo lo del curso en un mini proyecto: un registro de estudiantes."

## Solución de la práctica

```java
for (Estudiante e : salon) {
    System.out.println(e.getNombre().toUpperCase());
}

Estudiante mejor = salon[0];
for (Estudiante e : salon) {
    if (e.getNota() > mejor.getNota()) {
        mejor = e;
    }
}
System.out.println("Mejor nota: " + mejor.getNombre());
```

## Archivos

- Inicio: `starter-files/leccion-09`
- Código del video: `completed-examples/leccion-09`
# UT7-A1 – Identificación de “malos olores” en el código


### Objetivo de la práctica

El objetivo de esta práctica es **analizar un programa que funciona correctamente pero cuya calidad de código es mejorable**.

Durante la sesión se realizará un **análisis colectivo del código para detectar “malos olores” (code smells)**. Estos son indicios de que el diseño del programa podría mejorarse mediante técnicas de refactorización.

- En esta práctica **no se debe modificar el código**.  
- El trabajo consiste únicamente en **analizarlo y debatir sobre su calidad**.


### Instrucciones de la práctica

Se proporciona un programa sencillo que simula un **sistema básico de gestión de pedidos**.

El programa realiza varias operaciones:

- almacena una lista de productos
- calcula el precio de cada producto en función de su cantidad
- aplica un descuento en algunos casos
- calcula el coste de envío
- calcula el total del pedido

Aunque el programa funciona correctamente, su código presenta **diversos problemas de diseño y calidad**.

El objetivo de la práctica es **analizar el código para identificar esos problemas**.

### Trabajo en clase

1. Lee el código detenidamente.
2. Analiza cómo está organizado.
3. Detecta posibles problemas de diseño o calidad del código.
4. Anota todos los problemas que encuentres.

Durante la sesión se realizará un **debate en clase**, donde cada grupo expondrá los problemas detectados.

### Preguntas que pueden ayudarte en el análisis

Para identificar posibles problemas puedes plantearte las siguientes cuestiones:

¿Hay **métodos demasiado largos**?

- Directamente no hay métodos, toda la logica del programa se está realizando dentro del main del programa.

¿Las **variables tienen nombres claros y descriptivos**?

- No, muchas variables unicamente se identifican con letras que no aclara mucho que es lo que representan.
- Tambien tenemos variables que no se identifican con letras, sino con nombres que podrian mejorarase para aclarar un poco más su significado.
  
¿Se repite código en diferentes partes del programa?

- NO se repite el código, pero está super desordenado y muy mal ubicado.

¿Hay **números que aparecen directamente en el código sin explicación**?

- A simple vista creemos que no hya números que aparezcan sin aparente explicación.
  
¿El código mezcla distintas responsabilidades?

- Principalmente tenemos tres clases dentro de la misma clase. Deberiamos de dividirlas en tres, creando una clase para la informacion del producto, otra para la lógica de la tienda, y otra para el main, donde veremos la informacion que saldrá por pantalla.
  
- Mucho codigo dentro del main podriamos sacralo, haciendo el main mucho mas corto, unicamente dejando los resultado ahí. La lógica la moveriamos a un nuevo metodo en la clase "Producto".

¿El programa sería fácil de modificar o ampliar?

- Depende, si el codigo lo dejamos tal cual, sera complicado añadir o modificar metodos porque romperiamos la logica todal de la clase única. Sin embargo, si separamos las responsabilidades y las añadimos a sus respectivas clases, el añadir y modificar código seŕa bastante más factible.

¿Falta documentación o comentarios que expliquen el funcionamiento?

- Sí, lo recomentable sería que se comentara todas las partes del código, metodos y clases. Esto es bastante util porque así ayudamos a individuos externos a que entiendan nuestro codigo, a que sepan para que sirve una clase y para que vean cual es el objetivo de cada método.

### Entregable

Cada grupo deberá entregar un documento que incluya:

- una lista de los problemas detectados en el código
- una breve explicación de cada problema
- una posible mejora para cada caso


### Código a analizar

El código a analizar es el siguiente:

```java
import java.util.ArrayList;

class Producto {

    String n;
    double p;
    int c;

    public Producto(String n, double p, int c) {
        this.n = n;
        this.p = p;
        this.c = c;
    }
}
public class Tienda {

    public static void main(String[] args) {

        ArrayList<Producto> lista = new ArrayList<>();

        lista.add(new Producto("Teclado", 30, 2));
        lista.add(new Producto("Raton", 15, 3));
        lista.add(new Producto("Monitor", 200, 1));

        double total = 0;

        for (int i = 0; i < lista.size(); i++) {

            Producto p = lista.get(i);

            double subtotal = p.p * p.c;

            if (p.c > 2) {
                subtotal = subtotal - (subtotal * 0.1);
            }

            System.out.println("Producto: " + p.n);
            System.out.println("Precio: " + p.p);
            System.out.println("Cantidad: " + p.c);
            System.out.println("Subtotal: " + subtotal);

            if (subtotal > 100) {
                System.out.println("Envio gratis");
            } else {
                System.out.println("Envio: 5 euros");
                subtotal = subtotal + 5;
            }

            total = total + subtotal;

            System.out.println("-------------------");
        }
        System.out.println("TOTAL PEDIDO: " + total);

        if (total > 500) {
            System.out.println("Cliente VIP");
        }
    }
}
```Juan pablo Bermudez Suarez, Alejandro Donate. Jorge

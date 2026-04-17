# UT6-A4 Diseño de tests para un gestor de carrito de compra (Java + Maven + JaCoCo)

### Contexto

Una tienda online está desarrollando un pequeño módulo en **Java** que gestiona el cálculo del importe de un carrito de compra.

El equipo de desarrollo ha implementado varias funciones, pero el equipo de QA (vosotros) debe diseñar los tests que verifiquen su correcto funcionamiento.

El objetivo de esta práctica es diseñar e implementar una batería completa de tests usando **JUnit 5** y comprobar la cobertura de código con **JaCoCo** integrado en Maven.



### Comportamiento del sistema

El módulo permite realizar las siguientes operaciones:

#### 1. Calcular el subtotal de un carrito

**Método:** `calcularSubtotal(List<Producto> carrito)`

El carrito es una lista de objetos `Producto`.

Cada producto contiene:
- `nombre` (String)
- `precio` (double)
- `cantidad` (int)

Ejemplo:

```java
List<Producto> carrito = List.of(
    new Producto("teclado", 30, 2),
    new Producto("raton", 10, 1)
);
```

El subtotal se calcula realizando la operación:

```
precio * cantidad
```

para cada producto y sumando los resultados.



#### 2. Aplicar descuento

**Método:** `aplicarDescuento(double subtotal, double descuento)`

El descuento es un porcentaje entre **0 y 100**.

Ejemplo:

```
subtotal = 100
descuento = 10

resultado = 90
```



#### 3. Calcular gastos de envío

**Método:** `calcularEnvio(double subtotal)`

- Si `subtotal >= 100` → envío gratis (0€)
- Si `subtotal < 100` → envío 5€



#### 4. Calcular total del pedido

**Método:** `calcularTotal(List<Producto> carrito, double descuento)`

El proceso que se debe cumplir es:

```
SUBTOTAL -> APLICAR DESCUENTO -> AÑADIR ENVÍO
```



### Trabajo a realizar

Debes diseñar una batería de tests utilizando **JUnit 5** que verifique el comportamiento del sistema.

Tus tests deben cubrir al menos los siguientes casos:

#### Subtotal
- carrito con varios productos
- carrito con un solo producto
- carrito vacío

#### Descuentos
- descuento 0%
- descuento válido
- descuento 100%
- descuento inválido (ej: negativo o mayor de 100)

#### Envío
- subtotal menor que 100
- subtotal mayor o igual que 100

#### Total del pedido
- pedido sin descuento
- pedido con descuento
- pedido con envío gratis



### Requisitos técnicos

- Proyecto gestionado con **Maven**
- Tests implementados con **JUnit 5**
- Estructura estándar:

```
src/main/java
src/test/java
```

- Debes crear una clase de test, por ejemplo:

```
CarritoTest.java
```

- Debes implementar **al menos 12 tests distintos**



### Cobertura de código con JaCoCo

Una vez implementados los tests debes analizar qué porcentaje del código está siendo ejecutado por las pruebas.

Para ello utilizaremos **JaCoCo**.

Ejecuta el siguiente comando en la terminal:

```
mvn clean test
```

Después abre el informe generado en:

```
target/site/jacoco/index.html
```

Incluye una **captura de pantalla** del informe de cobertura donde se vea:

- porcentaje de cobertura
- clases analizadas



### Análisis de errores detectados

Durante la ejecución de los tests es posible que algunos de ellos fallen. Esto puede indicar que el código contiene errores.

Responde a las siguientes preguntas en este documento:

#### 1.
Error 1: descuento inválido no controlado
Problema:
return subtotal - (subtotal * descuento / 100);

No valida si el descuento es negativo o >100

Solución:
if (descuento < 0 || descuento > 100) {
    throw new IllegalArgumentException("Descuento inválido");
}
Error 2: carrito vacío

Si hacen algo como:

for (Producto p : carrito) {

Puede romper si carrito es null

Solución:
```
if (carrito == null || carrito.isEmpty()) {
    return 0;
}
```
Tercer Error: orden incorrecto en calcularTotal

Muchos hacen:

SUBTOTAL → ENVÍO → DESCUENTO 

Pero el README dice:

SUBTOTAL → DESCUENTO → ENVÍO 
3. correcion.

Por si necesitas comparar:
```
public double calcularTotal(List<Producto> carrito, double descuento) {
    double subtotal = calcularSubtotal(carrito);
    double conDescuento = aplicarDescuento(subtotal, descuento);
    double envio = calcularEnvio(conDescuento);

    return conDescuento + envio;
}
```
#### 4. Resultado final

Tras diseñar los tests y analizar el código:

- ¿cuántos tests has implementado?
- ¿qué porcentaje de cobertura has obtenido?
- ¿todos los tests pasan correctamente?

###Nota:No he podido sacar las capturas de la cobertura de Jacoco, pues por alguna razon no me permite lanzar los test


### Entrega

Debes subir a tu repositorio de GitHub, en la carpeta correspondiente:

- Código fuente del proyecto
- Tests implementados
- Archivo `pom.xml`
- Captura de cobertura JaCoCo
- Documento con el análisis realizado

# Parcial 02

## Instrucciones

1. Para iniciar, debe crear un *Fork* del repositorio:

![fork button](images/fork.png)

2. Vaya la pestaña de **actions** de su repositorio. Si ve un botón verde, haga clic en él para poder ejecutar las pruebas en el futuro.

![actions tab](images/actions.png)

3. Clone el nuevo repositorio en su computadora y ábralo en IntelliJ.

4. Construya/compile la aplicación en IntelliJ.

5. Ejecute las pruebas unitarias.

6. No se preocupe si todas o la mayoría de las pruebas fallan. Al terminar el laboratorio, todas las pruebas deberían funcionar.
___

## Introducción

- Todos los ejercicios deben compilar para poder ser probados. Si por lo menos uno de los ejercicios no compila, la nota sera de **cero** puntos.
- Si el código original de un ejercicio no se modifica o la intención de su resolución no es clara, la nota del ejercicicio será de **cero puntos**, aún si hay pruebas que sí pasen para dicho ejercicio.
- NO agregue nuevos métodos `main()`, de lo contrario ninguna prueba podrá ejecutarse.
- NO cambie la firma de los métodos existentes (no agrege más parámetros ni cambie el nombre), estos son utilizados para probar su código.
- NO haga cambios en las pruebas, esto resulta en un **cero inmediato**.
- Puede agregar nuevas clases y/o archivos, como sea necesario.
- En la pestaña de **Actions** podrá ver como las pruebas se ejecutan con su código implementado (si hace `git push` de un nuevo commit previamente).
___

## Ejercicio 1

Dada una lista de intervalos `meetingIntervals`, retorne la cantidad mínima de salas de conferencias necesarias.

### Ejemplo 1.1:

```shell
Entrada: meetingIntervals = [ [0-30], [5-10], [15-20] ]
Salida: 2
```

### Ejemplo 1.2:

```shell
Entrada: meetingIntervals = [ [7-10], [2-4] ]
Salida: 1
```

___

## Ejercicio 2

Diseñe un sistema de registro que reciba una stream de mensajes junto a sus tiempos de publicación. Cada mensaje único debe imprimirse solamente una vez cada 10 segundos. Es decir, un mensaje que se imprimió en el tiempo `t` no debe ser impreso hasta que se cumpla el tiempo `t+10`.

Todos los mensajes ingresarán en orden cronológico. Varios mensajes pueden llegar durante el mismo instante de tiempo.

Implemente la clase `E02Logger`:

- `Logger()` Instancia el objeto de logger (registro).
- `bool shouldPrintMessage(int timestamp, string message)` retorna `true` si el mensaje `message` debería imprimirse en el instante de tiempo `timestamp` dado, de lo contrario retorna `false`.

### Ejemplo 2.1:

```java
E02Logger logger = new E02Logger();
logger.shouldPrintMessage(1, "foo");  // retorna true, el siguiente instante de tiempo en que se puede volver a imprimir "foo" es 1 + 10 = 11
logger.shouldPrintMessage(2, "bar");  // retorna true, el siguiente instante de tiempo para "bar" is 2 + 10 = 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11, retorna false
logger.shouldPrintMessage(8, "bar");  // 8 < 12, retorna false
logger.shouldPrintMessage(10, "foo"); // 10 < 11, retorna false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11, retorna true, el siguiente instante de tiempo para "foo" is 11 + 10 = 21
```
 
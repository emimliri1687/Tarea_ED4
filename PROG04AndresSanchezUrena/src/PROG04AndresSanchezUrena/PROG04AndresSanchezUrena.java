package PROG04AndresSanchezUrena;
import java.util.Scanner;

public class PROG04AndresSanchezUrena {
/**
 * Tarea para PROG04: Estructuras de control y gestión de excepciones.
*/
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        // Bucle del menú principal
        do {
            System.out.println("\n=== EJERCICIOS PROG04 ===");
            System.out.println("1. Tablas");
            System.out.println("2. Primos");
            System.out.println("3. MCD");
            System.out.println("4. Conversor de unidades");
            System.out.println("5. Numero de la suerte");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");

            
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1: Tablas(); break;
                    case 2: Primos10(); break;
                    case 3: MCD(); break;
                    case 4: Conversor(); break;
                    case 5: NumeroSuerte(); break;
                    case 6: System.out.println("Saliendo del programa..."); break;
                    default: System.out.println("Opcion no valida.");
                }

            
        } while (opcion != 6);
    }

    /** Ejercicio 1: Tablas de multiplicar del 1 al 10 */
    public static void Tablas() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("=== TABLA DE MULTIPLICAR DEL " + i + " ===");
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
    }

    /** Ejercicio 2: Diez primeros números primos a partir de uno dado */
    public static void Primos10() {
        System.out.print("Introduce un numero entero positivo: ");
        int n = teclado.nextInt();
        if (n < 0) {
            System.out.println("El numero debe ser positivo.");
            return;
        }

        int encontrados = 0;
        int numeroActual = n + 1;
        while (encontrados < 10) {
            boolean esPrimo = true;
            if (numeroActual < 2) esPrimo = false;
            for (int i = 2; i <= Math.sqrt(numeroActual); i++) {
                if (numeroActual % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                encontrados++;
                System.out.println(encontrados + ". " + numeroActual);
            }
            numeroActual++;
        }
    }

    /** Ejercicio 3: Máximo Común Divisor */
    public static void MCD() {
        System.out.print("Introduce el primer numero: ");
        int a = teclado.nextInt();
        System.out.print("Introduce el segundo numero: ");
        int b = teclado.nextInt();

        int mcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) mcd = i;
        }
        System.out.println("El MCD de " + a + " y " + b + " es: " + mcd);
    }

    /** Ejercicio 4: Conversor de unidades con control de excepciones */
    public static void Conversor() {
        System.out.print("Introduce valor decimal: ");
        double valor = teclado.nextDouble();

        System.out.print("Unidad origen (mm, dm, cm, m, dam, hm, km): ");
        String origen = teclado.nextLine().toLowerCase();
        System.out.print("Unidad destino: ");
        String destino = teclado.nextLine().toLowerCase();

        // Convertir todo a metros primero para facilitar el calculo
        double metros = 0;
        switch (origen) {
            case "mm": metros = valor / 1000; break;
            case "cm": metros = valor / 100; break;
            case "dm": metros = valor / 10; break;
            case "m":  metros = valor; break;
            case "dam": metros = valor * 10; break;
            case "hm": metros = valor * 100; break;
            case "km": metros = valor * 1000; break;
        }

        double resultado = 0;
        switch (destino) {
            case "mm": resultado = metros * 1000; break;
            case "cm": resultado = metros * 100; break;
            case "dm": resultado = metros * 10; break;
            case "m":  resultado = metros; break;
            case "dam": resultado = metros / 10; break;
            case "hm": resultado = metros / 100; break;
            case "km": resultado = metros / 1000; break;
        }
        System.out.println("Resultado: " + resultado + " " + destino);

    }

    /** Ejercicio 5: Numero de la suerte */
    public static void NumeroSuerte() {
        System.out.print("Dia de nacimiento: ");
        int dia = teclado.nextInt();
        System.out.print("Mes de nacimiento: ");
        int mes = teclado.nextInt();
        System.out.print("Año de nacimiento: ");
        int anio = teclado.nextInt();

        int suma = dia + mes + anio;
        System.out.println("Suma inicial: " + suma);

        while (suma > 9) {
            int tempSuma = 0;
            while (suma > 0) {
                tempSuma += suma % 10;
                suma /= 10;
            }
            suma = tempSuma;
        }
        System.out.println("Tu numero de la suerte es: " + suma);
    }
}

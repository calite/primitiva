/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg_primitiva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    /*declaramos arrays para trabajar con ellos*/
    ArrayList<Integer> numerosElegidos = new ArrayList<>(8);
    ArrayList<Integer> numerosAleatorios = new ArrayList<>(8);
    ArrayList<Integer> numeroGanador = new ArrayList<>(8);
    /*contadores de aciertos*/
    int contadorAciertos = 0;
    boolean aciertaReintegro = false;
    /*generamos un numero ganador aleatorio*/
    for (int i = 0; i < 7; i++) {
      int n2 = generaReintegro();
      int n1 = generaNumero();
      /*dependiendo de i, se almacena un numero o un reintegro*/
      if (i >= 6) {
        /*si existe el numero en el array, restamos uno a i*/
        if (numeroGanador.contains(n2)) {
          i--;
          continue;
        } else {
          /*sino existe se guarda*/
          numeroGanador.add(n2);
        }
      } else {
        if (numeroGanador.contains(n1)) {
          i--;
          continue;
        } else {
          numeroGanador.add(n1);
          /*ordenamos el array, el reintegro mantiene posicion.*/
          Collections.sort(numeroGanador);
        }

      }
    }
    /*Si no queremos que salga el numero ganador se comenta este for*/
    System.out.println("Numero ganador: ");
    for (int arrNum : numeroGanador) {
      System.out.print(arrNum + " ");
    }
    System.out.println("\nBienvenido al programa de la primitiva");
    System.out.println("Para ganar un premio deberas acertar al menos 3 numeros y el reintegro.");
    System.out.println("\n¿Que quieres hacer?");
    /*
    creamos un menu con un switch para elegir entre 
    crear un numero propio o que se nos genere un aleatorio
     */
    System.out.println("1) crear boleto | 2) generar aleatorio | 3) salir");
    int recoge = recogeEntero();
    switch (recoge) {
      /*
       opcion 1: creamos boleto
       */
      case 1:
        for (int j = 0; j < 7; j++) {
          if (j >= 6) {
            int n2 = recogeReintegro();
            if (numerosElegidos.contains(n2)) {
              j--;
              continue;
            } else {
              numerosElegidos.add(n2);
            }
          } else {
            int n1 = recogeNumero();
            if (numerosElegidos.contains(n1)) {
              j--;
              continue;
            } else {
              numerosElegidos.add(n1);
              Collections.sort(numerosElegidos);
            }
          }
        }
        System.out.println("El boleto que has hecho es: ");
        for (int arrNum : numerosElegidos) {
          System.out.print(arrNum + " ");
        }
        /*
        Comprobamos el numero de aciertos, solamente los 6 primeros numeros
         */
        for (int x = 0; x < 6; x++) {
          if (numeroGanador.contains(numerosElegidos.get(x))) {
            contadorAciertos++;
          }
        }
        /*
        miramos si el reintegro es correcto
         */
        if (numeroGanador.get(6).equals(numerosElegidos.get(6))) {
          aciertaReintegro = true;
        }
        /*
        mostramos el numero de aciertos
         */
        if (contadorAciertos > 0) {
          System.out.println("\nFelicidades has acertado " + contadorAciertos + " numeros.");
          if (aciertaReintegro == true) {
            System.out.println("El reintegro es correcto.");
          }
        } else {
          System.out.println("Lo siento no has ganado, suerte la proxima vez.");
        }
        break;
      /*
        opcion 2: generar boleto aleatorio
       */
      case 2:
        for (int k = 0; k < 7; k++) {
          int n1 = generaNumero();
          int n2 = generaReintegro();
          /*dependiendo de i, se almacena un numero o un reintegro*/
          if (k >= 6) {
            /*si existe el numero en el array, restamos uno a i*/
            if (numerosAleatorios.contains(n2)) {
              k--;
              continue;
            } else {
              /*sino existe se guarda*/
              numerosAleatorios.add(n2);
            }
          } else {
            if (numerosAleatorios.contains(n1)) {
              k--;
              continue;
            } else {
              numerosAleatorios.add(n1);
              Collections.sort(numerosAleatorios);
            }
          }
        }
        System.out.println("El boleto aleatorio es: ");
        for (int arrNum : numerosAleatorios) {
          System.out.print(arrNum + " ");
        }
        /*
        Comprobamos el numero de aciertos, solamente los 6 primeros numeros
         */
        for (int x = 0; x < 6; x++) {
          if (numeroGanador.contains(numerosAleatorios.get(x))) {
            contadorAciertos++;
          }
        }
        /*
        miramos si el reintegro es correcto
         */
        if (numeroGanador.get(6).equals(numerosAleatorios.get(6))) {
          aciertaReintegro = true;
        }
        /*
        mostramos el numero de aciertos
         */
        if (contadorAciertos > 0) {
          System.out.println("Felicidades has acertado " + contadorAciertos + " numeros.");
          if (aciertaReintegro == true) {
            System.out.println("El reintegro es correcto.");
          }
        } else {
          System.out.println("Lo siento no has ganado, suerte la proxima vez.");
        }
        break;
      case 3:
        System.out.println("saliendo el programa...");
        break;
    }

  }
  /*
  se declaran 4 metodos para generar/recoger numeros aleatorios
  los comprendidos entre 1-49 y 0-9
   */
  public static int generaNumero() {
    int aleatorio = (int) (Math.random() * (49 - 1) + 1);
    return aleatorio;
  }

  public static int generaReintegro() {
    int aleatorio = (int) (Math.random() * 9);
    return aleatorio;
  }
  /*metodo para recoger enteros*/
  public static int recogeEntero() {
    boolean confirmacion = false;
    int entero = 0;
    while (confirmacion != true) {
      Scanner sc = new Scanner(System.in);
      try {
        entero = sc.nextInt();
        confirmacion = true;
      } catch (InputMismatchException e) {
        System.out.println("Eso no es un numero");
      }
    }
    return entero;
  }
  /*
  Si el numero no esta dentro de lo especificado se pide otra vez con recursion
   */
  public static int recogeNumero() {
    System.out.println("Introduce un numero [1-49], No deben repetirse: ");
    int num = recogeEntero();
    if (num < 1 || num >= 49) {
      System.out.println("El numero tiene que estar comprendido entre 1 y 49.");
      recogeNumero();
    }
    return num;
  }

  public static int recogeReintegro() {
    System.out.println("Introduce un numero[0-9], No deben repetirse: ");
    int num = recogeEntero();
    if (num < 0 || num >= 9) {
      System.out.println("El numero tiene que estar comprendido entre 0 y 9.");
      recogeReintegro();
    }
    return num;
  }
  /*
  NOTA PARA NAVEGANTES: quiza hubiese sido mejor crear una clase para evitar tantas lineas...
  */
}

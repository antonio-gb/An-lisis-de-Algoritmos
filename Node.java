package Estructura_Final;
public class Node {
  int valor;
  int altura;
  Node izquierdo;
  Node derecho;

  public Node(int valor) {
      this.valor = valor;
      this.altura = 1;
      this.izquierdo = null;
      this.derecho = null;
  }
}

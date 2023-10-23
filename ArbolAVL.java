package Estructura_Final;

public class ArbolAVL {
    Node raiz;

    // Función para obtener la altura de un nodo
    int altura(Node nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    // Función para obtener el factor de equilibrio de un nodo
    int factorEquilibrio(Node nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // Función para actualizar la altura de un nodo
    void actualizarAltura(Node nodo) {
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    // Función para rotar a la derecha un subárbol
    Node rotarDerecha(Node y) {
        Node x = y.izquierdo;
        Node T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    // Función para rotar a la izquierda un subárbol
    Node rotarIzquierda(Node x) {
        Node y = x.derecho;
        Node T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    // Función para insertar un valor en el árbol
    Node insertar(Node nodo, int valor) {
        if (nodo == null) {
            return new Node(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertar(nodo.derecho, valor);
        } else {
            return nodo; // No se permiten valores duplicados
        }

        actualizarAltura(nodo);

        int factor = factorEquilibrio(nodo);

        // Realizar rotaciones según el factor de equilibrio
        if (factor > 1) {
            if (valor < nodo.izquierdo.valor) {
                return rotarDerecha(nodo);
            } else {
                nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
                return rotarDerecha(nodo);
            }
        }

        if (factor < -1) {
            if (valor > nodo.derecho.valor) {
                return rotarIzquierda(nodo);
            } else {
                nodo.derecho = rotarDerecha(nodo.derecho);
                return rotarIzquierda(nodo);
            }
        }

        return nodo;
    }

    void insertarDesdeArreglo(int[] numeros) {
        for (int numero : numeros) {
            raiz = insertar(raiz, numero);
        }
    }

    void recorridoEnOrden(Node nodo) {
        if (nodo != null) {
            recorridoEnOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            recorridoEnOrden(nodo.derecho);
        }
}
}

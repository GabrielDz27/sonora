public class LinkedList {

}

public class Node {
    int valor;
    Node next;

    Node(int valor) {
        this.valor = valor;
        this.next = null;
    }

    static Node createNode(int valor) {
        return new Node(valor);
    }

}


package Listas;
/**
 * Clase DoubleLinkedNode
 * Estructura de Datos lineal
 * Esta clase se encarga de crear los nodos para una lista DoubleLinkedNode
 *
 * @author Isa Cordoba
 */
public class DoubleLinkedNode extends SimpleNode {
    protected DoubleLinkedNode next;
    protected DoubleLinkedNode prev;
    /**
     * Constructor de la DoubleLinkedNode
     * Asigna valores al prev
     * @param valor
     * @author Isa Cordoba
     */
    public DoubleLinkedNode(Object valor) {
        super(valor);
        this.prev = null;
    }
}

package Listas;

/**
 * Clase DoubleLinkedList
 * Estructura de Datos lineal
 * Esta clase se encarga de crear una DoubleLinkedList y todos los metodos de ella.
 *
 * @author Isa Cordoba, Ian Hu
 */
public class DoubleLinkedList extends List{
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    private int length;
    /**
     * Constructor de la DoubleLinkedList
     * Asigna valores al head tail y null
     * @author Ian Hu
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    /**
     * Metodo add
     * Permite agregar un nuevo nodo a la DoubleLinkedList
     * @param valor
     * @author Isa Cordoba
     */
    @Override
    public void add(Object valor) {
        if (this.head == null) {
            this.head = new DoubleLinkedNode (valor);
            this.tail = this.head;
        }else {
            DoubleLinkedNode tmp = this.tail;
            this.tail.next = new DoubleLinkedNode (valor);
            this.tail = this.tail.next;
            this.tail.prev = tmp;
        }
        this.tail.pos = this.length;
        this.length++;
    }
    /**
     * Metodo getPos
     * Permite obtener la posicion del nodo
     * @param pos
     * @return tmp.getValor
     * @author Ian Hu
     */
    @Override
    public Object getPos(int pos) {
        DoubleLinkedNode tmp = this.head;
        if (pos == 0){
            return this.head.getValor();
        }else{
            while (tmp.next.pos != pos){
                tmp = tmp.next;
            }
        }
        return tmp.next.getValor();
    }
    /**
     * Metodo getLength
     * Permite obtener el largo de la lista
     * @return length
     * @author Ian Hu
     */
    @Override
    public int getLength() {
        return this.length;
    }
}

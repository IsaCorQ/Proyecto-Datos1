package Listas;
/**
 * Clase SimpleNode
 * Estructura de Datos lineal
 * Esta clase se encarga de crear los nodos para una lista SimpleNode
 *
 * @author Isa Cordoba, Ian Hu
 */
public class SimpleNode {
    protected Object valor;
    protected SimpleNode next;
    protected int pos;
    /**
     * Constructor de la SimpleNode
     * Asigna valores al prev, next y pos
     * @param valor
     * @author Ian Hu
     */
    public SimpleNode (Object valor){
        this.valor = valor;
        this.next = null;
        this.pos = 0;
    }
    /**
     * Metodo getValor
     * Permite obtener el valor
     * @return valor
     * @author Isa Cordoba
     */
    public Object getValor (){
        return this.valor;
    }

    /**
     * Metodo getPos
     * Permite obtener la posicion
     * @return pos
     * @author Ian Hu
     */
    public int getPos (){
        return this.pos;
    }
}

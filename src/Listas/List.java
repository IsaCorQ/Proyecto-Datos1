package Listas;

/**
 * Clase Abstracta List
 * Estructura de Datos lineal
 * Esta clase se encarga de crear una List y todos los metodos de ella.
 *
 * @author Ian Hu
 */
public abstract class List {
    /**
     * Metodo add
     * Permite agregar un nuevo elemento a una lista
     * @param valor
     * @author Ian Hu
     */
    public abstract void add (Object valor);
    /**
     * Metodo abstracto getPos
     * Permite obtener la posicion de un nodo
     * @param pos
     * @author Ian Hu 
     */
    public abstract Object getPos(int pos);
    /**
     * Metodo abstracto getLength
     * Permite obtener el largo de la lista
     * @author Ian Hu
     */
    public abstract int getLength();
}

package Listas;
/**
 * Clase Stack
 * Estructura de Datos lineal
 * Esta clase se encarga de crear un Stack y todos los metodos de ella.
 *
 * @author Ian Hu
 */
public class Stack {
    private final int maxSize;
    private SimpleNode top;
    private SimpleNode bottom;
    /**
     * Constructor de la Stack
     * Asigna valores al maxSize top y bottom
     * @param  size
     * @author Ian Hu
     */
    public Stack (int size){
        this.maxSize = size;
        this.top = null;
        this.bottom = null;
    }
    /**
     * Metodo push
     * Permite agregar elementos a la pila
     * @author Isa Cordoba
     */
    public void push (Object valor){
        if (isEmpty()){
            this.top = new SimpleNode (valor);
            this.top.pos = 1;
            this.bottom = this.top;
        }else if (this.top.getPos() < this.maxSize){
            SimpleNode tmp = top;
            this.top.next = new SimpleNode (valor);
            this.top = top.next;
            this.top.pos = tmp.getPos() + 1;
        }
    }
    /**
     * Metodo pop
     * Permite sacar elementos a la pila
     * @return valor
     * @author Isa Cordoba, Ian Hu
     */
    public Object pop (){
        if (isEmpty ()){
            throw new IllegalStateException ("Stack is empty");
        }else if (this.bottom == this.top){
            Object valor = this.top.getValor();
            this.top = null;
            this.bottom = null;
            return valor;
        }else{
            Object valor = this.top.getValor();
            SimpleNode tmp = this.bottom;
            while (tmp.next != this.top){
                tmp = tmp.next;
            }
            tmp.next = null;
            top = tmp;
            return valor;
        }
    }
    /**
     * Metodo mezclar
     * Permite mezclar elementos dentro de una pila
     * @return aux
     * @author Isa Cordoba, Ian Hu
     */
    public Stack mezclar (){
        if (this.isEmpty()){
            throw new IllegalStateException ("Stack is empty");
        }
        SimpleList tmp = new SimpleList();
        Stack aux = new Stack (this.getMaxSize());
        while (this.isEmpty() == false){
            tmp.add(this.pop());
        }
        tmp = tmp.mezclar();
        for (int i = 0; i < tmp.getLength(); i++){
            aux.push(tmp.getPos(i));
        }
        return aux;
    }
    /**
     * Metodo mezclar
     * Booleano que dice si la pila esta vacia
     * @return top
     * @author Ian Hu
     */
    public boolean isEmpty (){return this.top == null;}
    /**
     * Metodo mezclar
     * Obtener el tamaño de la pila
     * @return maxSize
     * @author Isa Cordoba
     */
    public int getMaxSize(){return this.maxSize;}
}

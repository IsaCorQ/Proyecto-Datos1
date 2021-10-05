package Listas;

/**
 * Clase SimpleList
 * Estructura de Datos lineal
 * Esta clase se encarga de crear una SimpleList y todos los metodos de ella.
 *
 * @author Isa Cordoba, Ian Hu
 */
public class SimpleList extends List {
    private int length;
    private  SimpleNode head;
    /**
     * Metodo add
     * Permite agregar un nuevo nodo a la lista
     * @param valor
     * @author Isa Cordoba, Ian Hu
     */
    @Override
    public void add(Object valor) {
        if(this.head == null){
            this.head = new SimpleNode (valor);
        }else{
            SimpleNode tmp = this.head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new SimpleNode (valor);
            tmp.next.pos = this.length;
        }
        this.length++;
    }

    @Override
    /**
     * Metodo getPos
     * Permite obtener la posicion del nodo
     * @param pos
     * @return tmp.getValor
     * @author Isa Cordoba, Ian Hu
     */
    public Object getPos(int pos) {
        SimpleNode tmp = this.head;
        if(pos == 0){
            return this.head.getValor();
        }
        else{
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
    /**
     * Metodo delete
     * Permite eliminar un  nodo a la lista
     * @param pos
     * @author Ian Hu
     */
    public void delete (int pos){
        SimpleNode temp = this.head;
        boolean cambiado = false;
        if (pos >= this.length){
            System.out.println ("Index Out Of Range");
        }
        else if (pos == 0){
            this.head = this.head.next;
            this.length--;
            while (temp.next != null){
                temp.next.pos--;
                temp = temp.next;
            }
        }else{
            while (temp.next != null){
                if (cambiado == true){
                    while (temp.next.pos != pos + 1){
                        temp = temp.next;
                    }
                    while (temp.next != null){
                        temp.next.pos--;
                        temp = temp.next;
                    }
                }
                else if (temp.next.pos == pos){
                    temp.next = temp.next.next;
                    this.length--;
                    cambiado = true;
                }else{
                    temp = temp.next;
                }
            }
        }

    }
    /**
     * Metodo mezclar
     * Permite mezclar una lista
     * @return  aux
     * @author Ian Hu
     */
    public SimpleList mezclar() {
        SimpleList aux = new SimpleList();
        if (this.getLength() == 0){
            throw new IllegalStateException("Lista está vacía");
        }
        while (this.getLength() != 0){
            int random = (int) (Math.random () * (this.getLength() - 0));
            aux.add(this.getPos(random));
            this.delete(random);
        }
        return aux;
    }

}



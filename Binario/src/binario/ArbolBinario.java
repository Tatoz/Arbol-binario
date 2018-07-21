package binario;

/**
 *
 * @author Juan Carlos
 */
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    //Metodo para insertar nodo en el arbol
    public void agregarNodo(int d, String nom) {
        NodoArbol nuevo = new NodoArbol(d, nom);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while (true) {
                padre = auxiliar;
                if (d < auxiliar.dato) {
                    auxiliar = auxiliar.hijoIzquierdo;
                    if (auxiliar == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    //Método para saber cuando el árbol esté vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    //Método InOrden
    public void inOrden(NodoArbol r) {
        if (r != null) {
            inOrden(r.hijoIzquierdo);
            System.out.print(r.dato + ", ");
            inOrden(r.hijoDerecho);
        }
    }

    //Método PreOrden
    public void preOrden(NodoArbol r) {
        if (r != null) {
            System.out.print(r.dato + ", ");
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }
    }

    //Método PostOrden
    public void postOrden(NodoArbol r) {
        if (r != null) {

            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            System.out.print(r.dato + ", ");
        }
    }

    //Método para buscar un Nodo
    public NodoArbol buscarNodo(int d) {
        NodoArbol aux = raiz;
        while (aux.dato != d) {
            if (d < aux.dato) {
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return null;
            }
        }

        return aux;
    }

    //Método para eliminar Nodo
    public boolean eliminar(int d) {
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzq = true;

        while (auxiliar.dato!=d) {
            padre = auxiliar;
            if (d<auxiliar.dato) {
                esHijoIzq = true;
                auxiliar = auxiliar.hijoIzquierdo;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.hijoDerecho;
            }
            if (auxiliar == null) {
                return false;
            }
        }//Fin del while
        if (auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoIzquierdo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
            } else {
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
        } else if (auxiliar.hijoIzquierdo == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoDerecho;
            } else if (esHijoIzq) {
                padre.hijoDerecho = auxiliar.hijoDerecho;
            } else {
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
        } else {
            NodoArbol remplazo = obtenerNodoRemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = remplazo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = remplazo;
            } else {
                padre.hijoDerecho = remplazo;
            }
            remplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
        }
        return true;
    }
    //Método encargado de devolver el nodo Remplazo

    public NodoArbol obtenerNodoRemplazo(NodoArbol nodoRemp) {
        NodoArbol remplazarPadre = nodoRemp;
        NodoArbol remplazo = nodoRemp;
        NodoArbol auxiliar = nodoRemp.hijoDerecho;
        while (auxiliar!=null) {
            remplazarPadre = remplazo;
            remplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if (remplazo!=nodoRemp.hijoDerecho) {
            remplazarPadre.hijoIzquierdo = remplazo.hijoDerecho;
            remplazo.hijoDerecho = nodoRemp.hijoDerecho;
        }
        System.out.println("El nodo remplazo es: " + remplazo);
        return remplazo;
    }

}

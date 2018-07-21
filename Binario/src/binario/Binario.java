package binario;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Juan Carlos
 */
public class Binario {


   static ArbolBinario arbolito = new ArbolBinario();
    public static void main(String[] args) {
        int opcion = 0, elemento;
        String nombre;
        JFrame arbolb = new JFrame("Árbol gráfico");
        

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Agregar un nuevo Nodo\n"
                        + "2. Recorrer árbol InOrden\n"
                        + "3. Recorrer árbol PreOrden\n"
                        + "4. Recorrer árbol PostOrden\n"
                        + "5. Buscar Nodo en el árbol\n"
                        + "6. Eliminar Nodo en el árbol\n"
                        + "7. Ver árbol\n"
                        + "8. Salir\n"
                        + "Elige una opción...", "Árboles binarios",
                        JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número del nodo", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,
                                "Ingresa el nombre del nodo...", "Agregando Nodo...",
                                JOptionPane.QUESTION_MESSAGE);
                        arbolito.agregarNodo(elemento, nombre);
                        break;
                    case 2:
                        if (!arbolito.estaVacio()) {
                            System.out.println();
                            arbolito.inOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!arbolito.estaVacio()) {
                            System.out.println();
                            arbolito.preOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        if (!arbolito.estaVacio()) {
                            System.out.println("");
                            arbolito.postOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        if (!arbolito.estaVacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número del nodo buscar", "Buscando nodo", JOptionPane.QUESTION_MESSAGE));
                            arbolito.buscarNodo(elemento);
                            if (arbolito.buscarNodo(elemento) == null) {
                                JOptionPane.showMessageDialog(null, "Nodo no encontrado",
                                        "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Nodo encontrado, sus datos son: " + arbolito.buscarNodo(elemento));
                                System.out.println("Nodo encontrado");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        if (!arbolito.estaVacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número del nodo a eliminar", "Eliminando nodo", JOptionPane.QUESTION_MESSAGE));
                            arbolito.buscarNodo(elemento);
                            if (arbolito.eliminar(elemento) == false) {
                                JOptionPane.showMessageDialog(null, "Nodo no encontrado",
                                        "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El nodo ha sido eliminado del árbol",
                                        "Nodo eliminado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        
                        arbolb.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        arbolb.add(dibujarArbol());
                        arbolb.setSize(700,400);
                        arbolb.setVisible(true);
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null, "Aplicación Finalizada",
                                "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione una opción valida",
                                "Cuidado", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }
        } while (opcion != 8);

    }
   static public JPanel dibujarArbol(){
        return new Pintar(arbolito);
    }

}

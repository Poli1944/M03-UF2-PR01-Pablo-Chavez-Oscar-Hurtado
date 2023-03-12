/**
 * @authors: Pablo Chavez, Oscar Hurtado
 * @version: 1.0
 * @date: 2023/3/12
 * @link: https://github.com/Poli1944/M03-UF2-PR01-Pablo-Chavez-Oscar-Hurtado
 */
import java.util.ArrayList;
import java.util.Scanner;

/**

 Esta clase representa una aplicación de lista de compras que permite a los usuarios
    crear listas de compras y marcar los artículos a medida que los compran.

    */
public class ChavezPablo_HurtadoOscar {

    private static final int MAX_ITEMS = 100; // número máximo de elementos que se pueden agregar a una lista
    private static final int MAX_CHARACTERS = 50; // longitud máxima de un artículo

    private ArrayList<String> items; // lista de elementos
    private boolean[] checked; // lista de elementos marcados

    /**
     * Constructor de la clase ListaDeCompras.
     * Crea una nueva lista de compras vacía.
     */
    public ListaDeCompras() {
        items = new ArrayList<String>();
        checked = new boolean[MAX_ITEMS];
    }

    /**
     * Agrega un nuevo elemento a la lista de compras.
     *
     * @param item el elemento a agregar.
     * @throws IllegalArgumentException si el elemento supera la longitud máxima permitida.
     * @throws IllegalStateException    si la lista ya tiene el número máximo de elementos.
     */
    public void agregarItem(String item) throws IllegalArgumentException, IllegalStateException {
        if (item.length() > MAX_CHARACTERS) {
            throw new IllegalArgumentException("El artículo debe tener como máximo " + MAX_CHARACTERS + " caracteres.");
        }
        if (items.size() >= MAX_ITEMS) {
            throw new IllegalStateException("La lista ya tiene el número máximo de elementos.");
        }
        items.add(item);
        checked[items.size() - 1] = false;
    }

    /**
     * Marca un elemento de la lista como comprado.
     *
     * @param index el índice del elemento a marcar.
     * @return
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    public boolean marcarItem(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("El índice está fuera de los límites de la lista.");
        }
        checked[index] = true;
        return false;
    }

    /**
     * Desmarca un elemento de la lista como no comprado.
     *
     * @param index el índice del elemento a desmarcar.
     * @return
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    public boolean desmarcarItem(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("El índice está fuera de los límites de la lista.");
        }
        checked[index] = false;
        return false;
    }

    /**
     * Devuelve una lista de los elementos de la lista de compras.
     *
     * @return una lista de los elementos de la lista de compras.
     */
    public ArrayList<String> obtenerItems() {
        return items;
    }

    /**
     * Devuelve una lista de los elementos de la lista de compras que están marcados como comprados.
     *
     * @return una lista de los elementos de la lista de compras que están marcados como comprados.
     */
    public ArrayList<String> obtenerItemsMarcados() {
        ArrayList<String> marcados = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            if (checked[i]) {
                marcados.add(items.get(i));
            }
        }
        return marcados;
    }

    /**
     * Devuelve una lista de los elementos de la lista de compras que no están marcados como comprados.
     *
     * @return una lista de los elementos de la lista de compras queno están marcados como comprados.
     */
    public ArrayList<String> obtenerItemsNoMarcados() {
        ArrayList<String> noMarcados = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            if (!checked[i]) {
                noMarcados.add(items.get(i));
            }
        }
        return noMarcados;
    }

    /**
     * Devuelve la cantidad total de elementos de la lista de compras.
     *
     * @return la cantidad total de elementos de la lista de compras.
     */
    public int obtenerCantidadTotalItems() {
        return items.size();
    }

    /**
     * Devuelve la cantidad de elementos de la lista de compras que están marcados como comprados.
     *
     * @return la cantidad de elementos de la lista de compras que están marcados como comprados.
     */
    public int obtenerCantidadItemsMarcados() {
        int cantidad = 0;
        for (boolean b : checked) {
            if (b) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Devuelve la cantidad de elementos de la lista de compras que no están marcados como comprados.
     *
     * @return la cantidad de elementos de la lista de compras que no están marcados como comprados.
     */
    public int obtenerCantidadItemsNoMarcados() {
        return items.size() - obtenerCantidadItemsMarcados();
    }

    public String obtenerItem(int indice) {
        return items.get(indice);
    }

    public boolean estaMarcado(int i) {
        return checked[i];
    }
}
/**

 Clase que implementa la aplicación de lista de compras.
 */
class AplicacionListaCompras {

    /**

     Método principal que inicia la aplicación.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaDeCompras lista = new ListaDeCompras();

        int opcion = 0;
        do {
            System.out.println("=== LISTA DE COMPRAS ===");
            System.out.println("1. Agregar item");
            System.out.println("2. Marcar item");
            System.out.println("3. Desmarcar item");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Mostrar items marcados");
            System.out.println("6. Mostrar items no marcados");
            System.out.println("7. Mostrar cantidad total de items");
            System.out.println("8. Mostrar cantidad de items marcados");
            System.out.println("9. Mostrar cantidad de items no marcados");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del item:");
                    String item = sc.nextLine();
                    lista.agregarItem(item);
                    System.out.println("Item agregado: " + item);
                    break;
                case 2:
                    System.out.println("Ingrese el número de ítem que desea marcar:");
                    int indice = sc.nextInt();
                    sc.nextLine();
                    if (lista.marcarItem(indice)) {
                        System.out.println("Item marcado: " + lista.obtenerItem(indice));
                    } else {
                        System.out.println("No se pudo marcar el item.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el número de ítem que desea desmarcar:");
                    indice = sc.nextInt();
                    sc.nextLine();
                    if (lista.desmarcarItem(indice)) {
                        System.out.println("Item desmarcado: " + lista.obtenerItem(indice));
                    } else {
                        System.out.println("No se pudo desmarcar el item.");
                    }
                    break;
                case 4:
                    System.out.println("=== LISTA DE COMPRAS ===");
                    for (int i = 0; i < lista.obtenerCantidadTotalItems(); i++) {
                        String itemMostrado = lista.obtenerItem(i);
                        if (lista.estaMarcado(i)) {
                            itemMostrado = "[X] " + itemMostrado;
                        } else {
                            itemMostrado = "[ ] " + itemMostrado;
                        }
                        System.out.println((i + 1) + ". " + itemMostrado);
                    }
                    break;
                case 5:
                    System.out.println("=== ITEMS MARCADOS ===");
                    ArrayList<String> marcados = lista.obtenerItemsMarcados();
                    for (String s : marcados) {
                        System.out.println(s);
                    }
                    break;
                case 6:
                    System.out.println("=== ITEMS NO MARCADOS ===");
                    ArrayList<String> noMarcados = lista.obtenerItemsNoMarcados();
                    for (String s : noMarcados) {
                        System.out.println(s);
                    }
                    break;
                case 7:
                    System.out.println("Cantidad totalde items: " + lista.obtenerCantidadTotalItems());
                    break;
                case 8:
                    System.out.println("Cantidad de items marcados: " + lista.obtenerCantidadItemsMarcados());
                    break;
                case 9:
                    System.out.println("Cantidad de items no marcados: " + lista.obtenerCantidadItemsNoMarcados());
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
        sc.close();

    }
}

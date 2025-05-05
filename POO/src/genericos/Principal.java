package genericos;

public class Principal {

    public static void main(String[] args) throws Exception {
        Lista<Boolean> lista = new Lista<>();
        //lista.add(1);
        lista.add(true);
        //lista.add("hola");

        System.out.println(lista.get(0));
        System.out.println(lista.get(1));

        imprimir("Hola");
        imprimir(1);
        imprimir(true);
    }

    public static<T> void imprimir(T valor) {
        System.out.println(valor);
    }

}

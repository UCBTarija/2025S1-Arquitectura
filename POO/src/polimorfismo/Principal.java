package polimorfismo;

public class Principal {
    public static void main(String[] args) throws Exception {
        Hija h = new Hija();
        h.saludar();
        h.despedir();

        Base b = new Base();
        b.saludar();

        System.out.println(h);
    }

    public static void ejecutar(Base b) {
        b.saludar();
       // b.despedir();
    }
}

package listaarregl;
public class ListaArregl {
    public static void main(String[] args) {
        ArrayList<String> paises = new ArrayList<String>(String.class, 10);
       
        paises.append("Japon");
        paises.append("Espania");
        paises.append("Mexico");
        
        System.out.println(paises.indexOf("Mexico"));
        System.out.println(paises.indexOf("alemania"));
        
        paises.removeObj("Japon");
        System.out.println(paises);

        paises.clear();
        System.out.println(paises);
    
    }
        
}

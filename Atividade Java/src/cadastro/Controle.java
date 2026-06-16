package cadastro;

public class Controle {

    public static void main(String[] args) {

       
        Cliente<String, Integer> cliente = new Cliente<>(
            "Gabriel",
            "Claro",
            21,
            "Rua das Flores, 45 - Varginha/MG",
            "gabriel.claro@email.com"
        );

        
        cliente.imprimirCliente();

        
        System.out.println("\n>> Atualizando e-mail...\n");
        cliente.setEmail("gabriel.novo@email.com");
        cliente.imprimirCliente();
    }
}

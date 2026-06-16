package cadastro;

public class Cliente<T, N> {

    
    private T nome;
    private T sobrenome;
    private N idade;
    private T endereco;
    private T email;

    
    public Cliente(T nome, T sobrenome, N idade, T endereco, T email) {
        this.nome      = nome;
        this.sobrenome = sobrenome;
        this.idade     = idade;
        this.endereco  = endereco;
        this.email     = email;
    }

    
    public T getNome()           
    
    { return nome; }
    
    public void setNome(T nome)  
    
    { this.nome = nome; }

    public T getSobrenome()                  
    
    { return sobrenome; }
    
    public void setSobrenome(T sobrenome)    
    
    { this.sobrenome = sobrenome; }

    public N getIdade()              
    
    { return idade; }
    
    public void setIdade(N idade)    
    
    { this.idade = idade; }

    public T getEndereco()                
    
    { return endereco; }
    
    public void setEndereco(T endereco)   
    
    { this.endereco = endereco; }

    public T getEmail()              
    
    { return email; }
    
    public void setEmail(T email)    
    
    { this.email = email; }

    
    public void imprimirCliente() {
        System.out.println("=============================");
        System.out.println("      CADASTRO DE CLIENTE    ");
        System.out.println("=============================");
        System.out.println("Nome      : " + nome + " " + sobrenome);
        System.out.println("Idade     : " + idade + " anos");
        System.out.println("Endereço  : " + endereco);
        System.out.println("E-mail    : " + email);
        System.out.println("=============================");
    }
}

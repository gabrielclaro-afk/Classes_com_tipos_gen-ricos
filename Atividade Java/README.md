# 📚 Cadastro de Clientes com Classes Genéricas em Java

> Explicação didática linha a linha para programadores iniciantes.

---

## 📌 Sobre a Atividade

O objetivo é criar um sistema simples de **cadastro de clientes** utilizando o conceito de **classes genéricas com múltiplos parâmetros de tipo** em Java.

O cadastro deve conter os seguintes dados do cliente:

- Nome
- Sobrenome
- Idade
- Endereço
- E-mail

---

## 🗂️ Estrutura do Projeto

```
cadastro/
 └── src/
      └── cadastro/            ← pacote
           ├── Cliente.java    ← classe modelo (genérica)
           └── Controle.java   ← classe de controle (main)
```

---

## 💡 Conceito Central — Por que usar 2 parâmetros genéricos?

Os campos do cliente têm **naturezas diferentes**, por isso são necessários dois parâmetros:

| Parâmetro | Representa | Campos que usa |
|-----------|------------|----------------|
| `T` | Tipo textual (`String`) | nome, sobrenome, endereço, e-mail |
| `N` | Tipo numérico (`Integer`) | idade |

> Se usássemos apenas um parâmetro, seríamos obrigados a colocar tudo como texto ou tudo como número — o que não faz sentido.

---

## 🏗️ Classe Modelo — `Cliente.java`

```java
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

    public T getNome()           { return nome; }
    public void setNome(T nome)  { this.nome = nome; }

    public T getSobrenome()                { return sobrenome; }
    public void setSobrenome(T sobrenome)  { this.sobrenome = sobrenome; }

    public N getIdade()            { return idade; }
    public void setIdade(N idade)  { this.idade = idade; }

    public T getEndereco()                { return endereco; }
    public void setEndereco(T endereco)   { this.endereco = endereco; }

    public T getEmail()            { return email; }
    public void setEmail(T email)  { this.email = email; }

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
```

---

## 🎮 Classe de Controle — `Controle.java`

```java
package cadastro;

public class Controle {

    public static void main(String[] args) {

        Cliente<String, Integer> cliente = new Cliente<>(
            "Ana",
            "Souza",
            30,
            "Rua das Flores, 45 - Varginha/MG",
            "ana.souza@email.com"
        );

        cliente.imprimirCliente();

        System.out.println("\n>> Atualizando e-mail...\n");
        cliente.setEmail("ana.nova@empresa.com");
        cliente.imprimirCliente();
    }
}
```

---

## 🔍 Explicação Linha a Linha

### 📦 O Pacote

```java
package cadastro;
```

Pensa no pacote como uma **pasta organizadora**. Assim como você não joga todos os arquivos na área de trabalho, em Java você agrupa as classes relacionadas num pacote.

> Essa linha precisa ser a **primeira de todo arquivo** `.java` dentro do pacote.

---

### 🏗️ Declarando a Classe Genérica

```java
public class Cliente<T, N> {
```

| Pedaço | Significado |
|--------|-------------|
| `public` | Qualquer outra classe pode usar essa classe |
| `class` | Estou criando uma classe (um molde) |
| `Cliente` | O nome desse molde |
| `<T, N>` | Os dois **parâmetros genéricos** |

`T` e `N` são **espaços reservados para tipos**. Você está dizendo ao Java:

> *"Essa classe vai trabalhar com dois tipos, mas ainda não sei quais. Vou decidir na hora de usar."*

É como um formulário em branco com dois campos: você preenche depois.

---

### 📋 Os Atributos

```java
private T nome;
private T sobrenome;
private N idade;
private T endereco;
private T email;
```

Atributos são as **características** do cliente — pensa numa ficha de papel onde cada campo é um atributo.

**Por que `private`?**
Os campos são **protegidos**. Só a própria classe `Cliente` pode mexer diretamente neles.

> É como uma gaveta com chave. Outros só acessam o conteúdo se você passar pela chave (os getters e setters).

**Por que `T nome` e não `String nome`?**
Porque `T` é um espaço reservado. Quando você escrever `Cliente<String, Integer>`, o Java entende que `T = String` e substitui automaticamente por baixo dos panos.

**Por que `N idade` e não `T idade`?**
Porque idade é um **número**, não um texto. Ela usa o segundo parâmetro genérico (`N`), que será `Integer` na instanciação.

---

### 🔧 O Construtor

```java
public Cliente(T nome, T sobrenome, N idade, T endereco, T email) {
    this.nome      = nome;
    this.sobrenome = sobrenome;
    this.idade     = idade;
    this.endereco  = endereco;
    this.email     = email;
}
```

O construtor é um método especial que **monta o objeto** quando você o cria. Você passa os dados e ele preenche os atributos.

> É como o funcionário do cartório que pega seus documentos e preenche a ficha para você.

**Por que o nome do método é igual ao da classe?**
Porque é assim que o Java **reconhece** que é um construtor.

**O que significa `this`?**
`this` significa **"este objeto que estou criando agora"**. Serve para diferenciar o atributo da classe do parâmetro que chegou:

```java
// "o nome deste objeto" recebe "o nome que veio como parâmetro"
this.nome = nome;
```

---

### 🔑 Getters e Setters

```java
public T getNome()           { return nome; }
public void setNome(T nome)  { this.nome = nome; }
```

Como os atributos são `private`, ninguém de fora acessa diretamente. Os getters e setters são as **portas de entrada e saída** controladas.

| Método | Função | Tradução livre |
|--------|--------|----------------|
| `getNome()` | Retorna o valor do nome | "me dê o nome" |
| `setNome(...)` | Altera o valor do nome | "mude o nome para..." |

**O que significa `return`?**
Devolve um valor para quem chamou o método.

**O que significa `void`?**
O método **não devolve nada**. O setter só recebe um valor e guarda.

---

### 🖨️ O Método de Impressão

```java
public void imprimirCliente() {
    System.out.println("Nome : " + nome + " " + sobrenome);
    // ...
}
```

**O que faz `System.out.println`?**
Imprime uma linha de texto no console. O `ln` no final significa que pula uma linha depois de imprimir.

**O que é o `+` entre textos?**
É a **concatenação** — juntar pedaços de texto num só:

```java
"Nome : " + nome + " " + sobrenome
// Se nome = "Ana" e sobrenome = "Souza", vira:
// "Nome : Ana Souza"
```

**Por que esse método está na classe modelo?**
Porque é responsabilidade do `Cliente` saber como exibir seus próprios dados. Isso se chama **encapsulamento**: cada classe cuida do que é dela.

---

### 🎮 A Classe de Controle e o `main`

```java
public class Controle {
    public static void main(String[] args) {
```

A classe `Controle` **coloca tudo em funcionamento**. Ela não guarda dados — ela **usa** a classe `Cliente`.

O método `main` é o **ponto de entrada** do programa. Quando você clica em "Run", o Java procura esse método e começa a executar por aqui.

| Pedaço | Significado |
|--------|-------------|
| `public` | Pode ser chamado de fora |
| `static` | Existe sem precisar criar um objeto da classe |
| `void` | Não retorna nada |
| `main` | Nome que o Java procura para iniciar |
| `String[] args` | Permite receber argumentos externos (não usado aqui) |

---

### 🏭 Instanciando o Objeto

```java
Cliente<String, Integer> cliente = new Cliente<>(
    "Ana",
    "Souza",
    30,
    "Rua das Flores, 45 - Varginha/MG",
    "ana.souza@email.com"
);
```

Essa é a linha mais importante para entender os genéricos:

**`Cliente<String, Integer>`** — aqui você **preenche os espaços reservados**:
- `T` vira `String` → campos de texto
- `N` vira `Integer` → campo numérico (idade)

**`new Cliente<>(...)`**
- `new` → cria um novo objeto na memória
- `<>` (*diamond operator*) → o Java já sabe os tipos pelo lado esquerdo, não precisa repetir
- `(...)` → os valores passados para o construtor

**A ordem dos valores importa!** Ela deve seguir a mesma ordem dos parâmetros do construtor:

```
"Ana"                      → T nome
"Souza"                    → T sobrenome
30                         → N idade
"Rua das Flores, 45..."    → T endereco
"ana.souza@email.com"      → T email
```

---

### 📣 Chamando o Método de Impressão

```java
cliente.imprimirCliente();
```

O ponto (`.`) conecta o objeto ao seu método. É como dizer: `funcionário.trabalhar()` ou `carro.ligar()`.

---

### 🔄 Atualizando com o Setter

```java
cliente.setEmail("ana.nova@empresa.com");
cliente.imprimirCliente();
```

O objeto pode ser **atualizado depois de criado**. O setter altera só o e-mail sem precisar recriar o objeto inteiro.

---

## 🗺️ Fluxo de Execução

```
Controle.main() começa
        ↓
Cria objeto: Cliente<String, Integer>
        ↓
Construtor preenche os atributos
        ↓
cliente.imprimirCliente() → exibe os dados no console
        ↓
cliente.setEmail(...) → atualiza o e-mail
        ↓
cliente.imprimirCliente() → exibe os dados atualizados
```

---

## 🖥️ Saída Esperada no Console

```
=============================
      CADASTRO DE CLIENTE
=============================
Nome      : Ana Souza
Idade     : 30 anos
Endereço  : Rua das Flores, 45 - Varginha/MG
E-mail    : ana.souza@email.com
=============================

>> Atualizando e-mail...

=============================
      CADASTRO DE CLIENTE
=============================
Nome      : Ana Souza
Idade     : 30 anos
Endereço  : Rua das Flores, 45 - Varginha/MG
E-mail    : ana.nova@empresa.com
=============================
```

---

## 📖 Resumo dos Conceitos

| Conceito | O que faz neste projeto |
|----------|------------------------|
| **Genéricos `<T, N>`** | Permitem que a classe funcione com `String` e `Integer` sem duplicar código |
| **`private`** | Protege os atributos de acesso direto externo |
| **Construtor** | Monta o objeto com os dados iniciais |
| **Getters / Setters** | Controlam o acesso aos atributos protegidos |
| **`this`** | Diferencia o atributo da classe do parâmetro do método |
| **`System.out.println`** | Imprime texto no console |
| **`new`** | Cria um objeto na memória |
| **`main`** | Ponto de entrada do programa |

---

> **Dica:** Experimente instanciar um segundo cliente com tipos diferentes, como `Cliente<String, Double>`, para ver a flexibilidade dos genéricos na prática!
// scanner é pra ler o que foi inserido pelo usuario
// scanner pra texto: scanner.nextLine(); inteiro: scanner.nextInt(); float: scanner.nextFloat()
import java.util.EventListener;
import java.util.Scanner;

public class exercicios
{   
    // classe que vai representa tudo que a tabela hash vai fazer
    public static class TabelaHash
    {
        // definindo o "TAMANHO" como inteiro e 10 (0 a 9)
        // final = nao pode ser alterado
        private static final int TAMANHO = 10;

        // classe que vai representar oque será armazenado na tabela
        class No
        {
            int sala;
            // next é um ponteiro
            No next;
        }

        // definindo o vetor tabela da classe No, do tamanho 10 inteiros (0 a 9)
        No[] tabela = new No[TAMANHO];

        // criando a função hash para distribuir as salas para seu respectivo indice na tabela
        public int funcaoHash(int sala)
        {
            return sala % TAMANHO;
        }

        // metodo de inserir
        public void inserir(int sala)
        {
            // indice vai receber o resultado da operação das salas na função hash, distribuindo os valores
            int indice = funcaoHash(sala);

            // criando a instancia
            No novoNo = new No();

            // adicionando os dados
            novoNo.sala = sala;
            novoNo.next = null;

            // se os indices estiverem sem dados, o novo no vai ocupar
            if(tabela[indice] == null)
            {
                tabela[indice] = novoNo;

            }
            else
            {
                // se nao estiver vazio ele vai pra proximo indice e vai ver se ta vazio, se tiver ele ocupa
                // esse else trata as colisões
                novoNo.next = tabela[indice];
                tabela[indice] = novoNo;
            }

            System.out.println("\nSala " + sala + " inserida com sucesso!\n");
        }

        // metodo de busca
        public void buscar(int sala)
        {
            // fazendo o indice receber as salas novamente
            int indice = funcaoHash(sala);

            // criando ponteiro auxiliar atual para percorrer a tabela ate achar a sala buscada
            No atual = tabela[indice];

            while(atual != null)
            {
                // se a sala informada for igual a sala aonde o ponteiro atual esta, entao mostra
                if(atual.sala == sala)
                {
                    System.out.println("\nSala encontrada: " + atual.sala + "\n");
                    return;
                }
                // se nao for igual ele vai indo pro proximo indice até achar uma sala igual a informada na busca
                atual = atual.next;
            }
            System.out.println("\nA sala" + sala + " não foi encontrada na tabela!\n");
        }

        // metodo de excluir
        public void excluir(int sala)
        {
            int indice = funcaoHash(sala);

            No atual = tabela[indice];
            // criando ponteiro "anterior" para manter o nó da lista funcional sem quebrar
            // anterior começa como nulo pq o primeiro nó não tem anterior nem proximo
            No anterior = null;

            while(atual != null)
            {
                if(atual.sala == sala)
                {
                    // se o anterior for igual a nulo entao ele é o primeiro da lista
                    if(anterior == null)
                    {
                        // para manter os nós da lista ligados o atual começa a aponta para o proximo dele
                        // ex: 1-2-3, 1 deixa de aponta para o 2 podendo ser excluido normalmente
                        tabela[indice] = atual.next;
                    }
                    else
                    {
                        // se nao for excluir o primeiro entao executa isso:
                        // ex: 1-2-3, se eu selecionar o 2 entao o 1 vai apontar para o 3, 
                        // proximo do anterior nesse caso é 2 e ele vai receber o proximo do 2 sendo o 3
                        // resultado = 1-3
                        anterior.next = atual.next;
                    }
                    System.out.println("\nSala " + atual.sala + " excluida com sucesso!\n");
                    return;
                }
                // fazendo os ponteiros avançarem enquanto nao acharem a sala informada
                anterior = atual;
                atual = atual.next;
            }
            System.out.println("\nSala " + sala + " não encontrada na tabela!\n");
        }

        // metodo de mostra a tabela inteira
        public void listar()
        {
            for(int i = 0; i < TAMANHO; i++)
            {
                // atual recebendo a tabela e cada valor é o i
                // i = indices da tabela
                No atual = tabela[i];

                // enquanto o atual for diferente de nulo ele vai mostrar os indices da tabela
                if(atual != null)
                {
                    System.out.println("Indice " + i + " : ");
                }

                // enquanto o atual for diferente de nulo entao vai mostra as salas encontradas
                while(atual != null)
                {
                    System.out.println("Sala " + atual.sala + "\n");
                    atual = atual.next;
                }
            }
        }
    }
    // classe que vai representa tudo que a lista duplamente ligada vai fazer
    public static class ListaDupla
    {
        // estrutura que representa as variaveis que vai ter na lista
        class No
        {
            String nome;
            String genero;
            No anterior; // definindo anterior como ponteiro
            No next; // definindo next como ponteiro

            // anterior = ponteiro que aponta para o nó anterior
        }

        // ponteiro que apontam para o começo e fim da lista
        No head = null;
        No fim = null;

        // fim = ponteiro que aponta para o ultimo nó da lista

        // metodo para inserir o nome do produto na lista duplamente ligada
        public void inserir(String nome, String genero)
        {
            No novoNo = new No();
            novoNo.nome = nome;
            novoNo.genero = genero;
            // inicialmente o ponteiro que aponta para o proximo e para o anterior começam como nulo
            novoNo.anterior = null;
            novoNo.next = null;

            if(head == null)
            {
                // se a lista estiver vazia o primeiro nó vai ser o primeiro e ultimo no
                head = novoNo;
                fim = novoNo;
            }
            else
            {
                // novo nó vai ser o proximo nó do ultimo nó no momento
                fim.next = novoNo;
                // faz o ultimo nó no momento virar o anterior do novo nó que está sendo inserido
                novoNo.anterior = fim;
                // novo nó que está sendo inserido é o ultimo da lista
                fim = novoNo;
            }
            System.out.println("\nNome e gênero inserido com sucesso!");
            System.out.println("Nome: " + nome + " Gênero: " + genero);
        }

        // meotodo de buscar nome dos jogos na lista
        public void buscar(String nome)
        {
            // primeiro nó é nulo...
            if(head == null)
            {
                System.out.println("\nA lista está vazia! Insira os nomes e gêneros dos jogos para busca-los...\n");
                return;
            }

            // criando ponteiro auxiliar "atual"
            No atual = head;

            // enquanto o atual for diferente de nulo...
            while(atual != null)
            {
                // comparando o atual com o nome informado...
                if(atual.nome.equals(nome))
                {
                    System.out.println("\nJogo encontrado:");
                    System.out.println("Nome: " + atual.nome);
                    System.out.println("Gênero: " + atual.genero);
                    return;
                }
                // passando para o proximo nó...
                atual = atual.next;
            }
            System.out.println("\nNenhum jogo foi encontrado na lista!\n");
        }

        public void excluir(String nome)
        {
            if(head == null)
            {
                System.out.println("\nA lista está vazia! Insira Nomes e gêneros de jogos pra exclui-los...\n");
                return;
            }

            No atual = head;

            // enquanto o atual for diferente de nulo e o nó atual for diferente do inserido
            while(atual != null && !atual.nome.equals(nome))
            {
                // ele passa pro proximo
                atual = atual.next;
            }

            // se for nulo
            if(atual == null)
            {
                // mostra q nd foi encontrado
                System.out.println("\nNenhum jogo foi encontrado!\n");
                return;
            }

            // declarando o nome e o genero excluido para mostrar depois
            String nomeExcluido = atual.nome;
            String generoExcluido = atual.genero;

            // se quiser excluir o primeiro nó
            if(atual == head)
            {
                // primeiro vai apontar para o proximo, para o head ser o segundo pois o primeiro vai ser excluido
                head = atual.next;

                // se tiver alguma coisa no head entao ele aponta o anterior como nulo para excluir
                if(head != null)
                {
                    // define o anterior do head como nulo
                    head.anterior = null;
                }
                else
                {
                    // se depois de excluir o head e o head ficar nulo significa que o segundo nó nao existe e a lista ficou vazia, declarando o fim como nulo
                    fim = null;
                }
            }
            else
            {
                // aponta para o anterior do atual, depois para o proximo, depois para o proximo denovo
                // exemplo: atual = 2, aponta pra 1, depois para o proximo do 1, fazendo o 1 aponta para o 2 e o 2 para o 1
                // criando assim a lista duplamente ligada
                atual.anterior.next = atual.next;
            }

            // se o proximo nó for diferente de nulo...
            if(atual.next != null)
            {
                // vai fazer o inverso do else acima, se o atual for igual a 2 entao ele vai aponta para o 3 e o 3 para ele
                atual.next.anterior = atual.anterior;
            }
            else
            {
                // se o proximo nó for nulo entao o anterior vira o ultimo
                fim = atual.anterior;
            }
            System.out.println("\nJogo excluído com sucesso!\n");
            System.out.println("Nome: " + nomeExcluido);
            System.out.println("Gênero: " + generoExcluido);
        }

        // metodo para mostrar a lista completa
        public void listar()
        {
            No atual = head;

            while(atual != null)
            {
                System.out.println("Nome do jogo: " + atual.nome);
                System.out.println("Gênero do jogo: " + atual.genero);

                atual = atual.next;
            }
        }
    }
    // classe que vai representar tudo que a lista simples vai fazer
    public static class Node
    {
        // classe que representa a estrutura da lista
        class Lista
        {
            String nome;
            Lista next; // definindo next como ponteiro
        }

        // definindo head como ponteiro de Lista e nulo
        // head = ponteiro que vai apontar para o primeiro nó
        Lista head = null;

        // metodo de inserir elementos na lista
        public void inserir(String nome)
        {
            // instanciando com o nome novoNo
            // novoNo = parametro que representa o novo nó que esta sendo inserido
            Lista novaNo = new Lista();
            // os elementos recebidos vao para as variaveis dentro da lista
            novaNo.nome = nome;
            // proximo nó continua nulo
            novaNo.next = null;

            // se o head for nulo significa que a lista ta vazia, entao ele recebe o novo nó que foi inserido
            if(head == null)
            {
                head = novaNo;
            }
            else
            {
                // atual é um ponteiro que vai apontar para o nó atual
                Lista atual = head;

                // enquando o proximo nó for diferente de nulo ele vai avançando
                // esse while vai fazer o atual chegar até o ultimo nó
                while(atual.next != null)
                {
                    atual = atual.next;
                }
                // quando chegar no ultimo nó ele vai inserir o novo nó no next que esta nulo, ai next vai ser o proximo desse novo no permanecendo nulo
                atual.next = novaNo;
            }
            System.out.println("\nProduto inserido com sucesso: " + nome + "\n");
        }

        // metodo de consultar os nomes na lista
        public void buscar(String nome)
        {
            // verificando se a lista esta vazia...
            if(head == null)
            {
                System.out.println("\nA lista está vazia! Insira elementos para mostra-los...\n");
                return;
            }
            else
            {
                // ponteiro auxiliar atual começando no primeiro nó...
                Lista atual = head;
                // enquando o atual for diferente de nulo...
                while(atual != null)
                {
                    // vai comparar os nomes pra ve se sao iguais
                    //equals() = comparar textos em java
                    if(atual.nome.equals(nome))
                    {
                        System.out.println("\nResultado da busca pelo nome do produto: " + atual.nome + "\n");
                        return;
                    }
                    // enquando o atual nao for nulo ele vai passa para o proximo nó
                    atual = atual.next;
                }
                System.out.println("\nNenhum produto com esse nome foi encontrado!\n");
            }
        }

        // metodo excluir algum nome da lista
        public void excluir(String nome)
        {
            if(head == null)
            {
                System.out.println("\nA lista está vazia! Insira elementos para exclui-los...\n");
                return;
            }
            else
            {
                Lista atual = head;

                if(atual != null)
                {
                    // se o primeiro no for excluido o head vai virar o segundo nó
                    if(atual.nome.equals(nome))
                    {
                        // assim
                        head = atual.next;
                        return;
                    }
                    // criando mais um ponteiro auxiliar, o anterior
                    // anterior = vai apontar para o nó anterior de atual, ele vai ser usado para nao quebrar a lista
                    // ex: tenho a lista 1-2-3 e quero excluir o valor 2, 
                    // tenho q fazer com q o next do 1 seja o 3, com isso o anterior vai apontar para o next do atual, nao quebrando a lista e mantendo a estrutura
                    Lista anterior = atual;
                    atual = atual.next;

                    // esse while vai continuar procurando o nome enquanto o atual for diferente de nulo e o nome no atual ser diferente do nome inserido
                    // ! = singifica negação, entao enquanto o nome do atual NÃO for igual ao nome inserido o laço continua
                    while(atual != null && !atual.nome.equals(nome))
                    {
                        anterior = atual;
                        atual = atual.next;
                    }

                    if(atual == null)
                    {
                        System.out.println("\nNão foi possivel excluir o nome do produto pois ele nao foi encontrado!\n");
                        return;
                    }

                    // declarando o nome excluido para mostrar depois de excluir
                    String nomeExcluido = atual.nome;

                    anterior.next = atual.next;
                    System.out.println("\nProduto excluido com sucesso!\n");
                    System.out.println("Nome: " + nomeExcluido);
                }
            }
        }

        // metodo de mostrar a lista por completa
        public void listar()
        {
            Lista atual = head;

            while(atual != null)
            {
                System.out.println("Nome do produto: " + atual.nome);
                atual = atual.next;
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int opcao, idade, numero1, resultado1;
        float num1, num2, num3, resultado, media;

        // variavel do tipo texto: string
        String nome;
        do
        {
            
            System.out.println("\n-- Menu de Exercícios --");
            System.out.println("0 - Sair");
            System.out.println("1 - Lendo um nome, uma idade e exibindo ambos!");
            System.out.println("2 - Lendo uma idade e exibindo se a pessoa é criança, adolescente, adulto ou idoso!");
            System.out.println("3 - Lendo dois números e somando!");
            System.out.println("4 - Lendo dois números e subtraindo!");
            System.out.println("5 - Lendo dois números e multiplicando!");
            System.out.println("6 - Lendo dois números e divindo!");
            System.out.println("7 - lendo três números e mostrando a sua média!");
            System.out.println("8 - Lendo um número e dizendo se é impar ou par");
            System.out.println("9 - Lendo um número e mostrando a sua tabuada vezes 1 até o 10!");
            System.out.println("10 - Lendo um número e exibindo a soma dele com 1, 9 vezes");
            System.out.println("11 - Adivinhe o número secreto!");
            System.out.println("12 - Mostrando os valores dentro de um vetor!");
            System.out.println("13 - Pedindo 5 números para preencher o vetor e mostrando os valores!");
            System.out.println("14 - Pedindo 5 números, somando todos eles e mostrando em forma de vetor!");
            System.out.println("15 - Pedindo 5 número negativos, diminuindo eles e mostrando em forma de vetor!");
            System.out.println("16 - Pedindo 5 números, fazendo a média e a suas operações matematicas deles e mostrando em forma de vetor!");
            System.out.println("17 - Criando uma matriz 3x3 e mostrando!");
            System.out.println("18 - Pedindo 9 números para criar uma matriz 3x3!");
            System.out.println("19 - Pedindo os 9 números e somando eles em uma matriz!");
            System.out.println("20 - Criando uma matriz 3x2 armazenando a categoria e o nome de um produto!");
            System.out.println("21 - Pedindo 9 números de uma matriz, pedindo para o usuario um número e verificar se ele existe na matriz!");
            System.out.println("22 - Criando uma matriz 3x3 e mostrando so as linhas e depois so as colunas!");
            System.out.println("23 - Mostrando uma lista ligada simples com nomes de produtos!");
            System.out.println("24 - Mostrando uma lista duplamente ligada com nomes e gêneros de Jogos!");
            System.out.println("25 - Criando uma tabela hash com encandeamento separado e adicionando números de salas aos indices!");
            System.out.print("\nEscolha uma das opções acima: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao)
            {
                case 0:
                    System.out.println("Até logo...");
                    break;
                case 1:
                    System.out.println("\nVocê escolheu ler e exibir um nome e sua idade!\n");

                    System.out.print("Informe o seu nome: ");
                    nome = scanner.nextLine();
                    System.out.println("\n");


                    System.out.print("Informe a sua idade: ");
                    idade = scanner.nextInt();
                    while(idade < 0)
                    {
                        System.out.println("\n");
                        System.out.println("Idade negativa!");
                        System.out.print("Informe um idade que seja positiva: ");
                        idade = scanner.nextInt();
                    }
                    // concatenar em java: "+", cuidado que se fizer variavel + variavel ele vai SOMAR
                    System.out.println("Seu nome: " + nome);
                    System.out.println("Sua idade: " + idade);
                    break;
                case 2:
                    System.out.println("\nVocê escolheu ler uma idade e dizer se a pessoa é criança, adoslecente, adulto ou idoso\n");
                    System.out.print("Informe a idade: ");
                    idade = scanner.nextInt();

                    while(idade <= 0)
                    {
                        System.out.println("\n");
                        System.out.println("Idade negativa ou 0!");
                        System.out.print("Informe uma idade positiva: ");
                        idade = scanner.nextInt();
                    }
                    if(idade <= 11)
                    {
                        System.out.println("Com a idade " + idade + " você é uma criança!");
                    }
                    // E (AND) em java: &&
                    if(idade <= 17 && idade >= 12)
                    {
                        System.out.println("Com a idade " + idade + " você é um adolescente!");
                    }
                    if(idade <= 49 && idade >= 18)
                    {
                        System.out.println("Com a idade " + idade + " você é um adulto!");
                    }
                    if(idade >= 50)
                    {
                        System.out.println("Com a idade " + idade + " você é um idoso!");
                    }
                    break;
                case 3:
                    System.out.println("\nVocê escolheu ler e somar dois números!\n");

                    System.out.print("Informe o primeiro número: ");
                    num1 = scanner.nextFloat();
                    System.out.println("\n");

                    System.out.print("Informe o segundo número: ");
                    num2 = scanner.nextFloat();

                    resultado = num1 + num2;
                    System.out.println("\n");
                    System.out.println("Resultado da soma de " + num1 + " e " + num2 + " é: " + resultado);
                    break;
                case 4:
                    System.out.println("\nVocê escolheu ler dois números e subtrai-los!\n");

                    System.out.print("Informe o primeiro número: ");
                    num1 = scanner.nextFloat();
                    System.out.println("\n");

                    System.out.print("Informe o segundo número: ");
                    num2 = scanner.nextFloat();
                    System.out.println("\n");

                    resultado = num1 - num2;
                    System.out.println("O resultado da subtração de " + num1 + " e " + num2 + " é: " + resultado);
                    break;
                case 5:
                    System.out.println("\nVocê escolheu ler dois números e multriplica-los");

                    System.out.print("Informe o primeiro número: ");
                    num1 = scanner.nextFloat();
                    System.out.println("\n");

                    System.out.print("Informe o segundo número: ");
                    num2 = scanner.nextFloat();
                    System.out.println("\n");

                    resultado = num1 * num2;
                    System.out.println("O resultado da multiplicação de " + num1 + " e " + num2 + " é: " + resultado);
                    break;
                case 6:
                    System.out.println("\nVocê escolheu ler dois números e dividi-los!\n");

                    System.out.print("Informe o primeiro número: ");
                    num1 = scanner.nextFloat();
                    System.out.println("\n");

                    System.out.print("Informe o segundo número: ");
                    num2 = scanner.nextFloat();
                    while (num2 < 0)
                    {
                        System.out.println("\n");
                        System.out.println("Número negativo!");
                        System.out.print("Informe o segundo número que seja positivo: ");
                        num2 = scanner.nextFloat();
                    }
                    System.out.println("\n");

                    resultado = num1 / num2;
                    System.out.println("O resultado da divisão de " + num1 + " e " + num2 + " é: " + resultado);
                    break;
                case 7:
                    System.out.println("\nVocê escolheu ler três números e mostrar a sua média!\n");

                    System.out.print("Informe o primerio número: ");
                    num1 = scanner.nextFloat();

                    System.out.print("Informe o segundo número: ");
                    num2 = scanner.nextFloat();

                    System.out.print("Informe o terceiro número: ");
                    num3 = scanner.nextFloat();
                    System.out.println("\n");

                    media = (num1 + num2 + num3) / 3;
                    System.out.println("O resultado da média é: ");
                    System.out.println(media);
                    break;
                case 8:
                    System.out.println("\nVocê escolheu ler um número e dizer se é impar ou par!\n");

                    System.out.print("Informe o número: ");
                    numero1 = scanner.nextInt();
                    System.out.println("\n");

                    // vendo o resto do divisão: %
                    // dividindo apenas: /
                    if(numero1 % 2 == 0)
                    {
                        System.out.println("O numero " + numero1 + " é par!");
                    }
                    else
                    {
                        System.out.println("O numero " + numero1 + " é impar!");
                    }
                    break;
                case 9:
                    System.out.println("\nVocê escolheu ler um número e exibir a sua tabuada vezes 1 até o 10!\n");

                    System.out.print("Informe o número: ");
                    numero1 = scanner.nextInt();

                    for(int i = 1; i <= 10; i++)
                    {
                        resultado1 = numero1 * i;
                        System.out.println(resultado1);
                    }
                case 10:
                    System.out.println("\nVocê escolheu ler um número e exibir a soma dele com 1, 9 vezes!\n");

                    System.out.print("Informe o número: ");
                    numero1 = scanner.nextInt();

                    for(int i = 1; i <= 9; i++)
                    {
                        numero1 = numero1 + 1;
                        System.out.println(numero1);
                    }
                    break;
                case 11:
                    numero1 = 67;
                    System.out.println("\nVocê escolheu tentar adivinhar qual é o número secreto!\n");

                    System.out.println("Qual você acha que é o número secreto?");
                    resultado1 = scanner.nextInt();
                    System.out.println("\n");

                    while(resultado1 != numero1)
                    {
                        if(resultado1 < numero1)
                        {
                            System.out.println("\n");
                            System.out.println("Valor menor do que o número secreto!");
                            System.out.println("Qual o número secreto?");
                            resultado1 = scanner.nextInt();
                            System.out.println("\n");
                        }

                        if(resultado1 > numero1)
                        {
                            System.out.println("\n");
                            System.out.println("Valor maior do que o número secreto!");
                            System.out.println("Qual o número secreto?");
                            resultado1 = scanner.nextInt();
                            System.out.println("\n");
                        }
                    }
                    System.out.println("Parabéns!");
                    System.out.println("O número secreto é: " + numero1);
                    break;
                case 12:
                    int [] vetor = {1, 2, 3, 4, 5};
                    System.out.println("\nVocê escolheu mostrar os valores de um vetor!\n");

                    for(int i = 0; i < vetor.length; i++)
                    {
                        System.out.println(vetor[i]);
                    }
                    break;
                case 13:
                    int [] vetor1 = new int[5];
                    System.out.println("\nVocê escolheu ler 5 números e exibi-los no vetor!\n");

                    for(int i = 0; i < vetor1.length; i++)
                    {
                        System.out.print("Informe o " + (i + 1) + "° " + "número: ");
                        numero1 = scanner.nextInt();
                        vetor1[i] = numero1;
                        System.out.println("\n");
                    }

                    System.out.println("Vetor com seus 5 números:");
                    for (int i = 0; i < vetor1.length; i++)
                    {    
                        System.out.println(vetor1[i]);
                    }
                    break;
                case 14:
                    int [] vetor2 = new int[5];
                    int soma = 0;
                    System.out.println("\nVocê escolheu ler 5 números, soma-los e exibir a soma em forma de vetor!\n");

                    for(int i = 0; i < vetor2.length; i++)
                    {
                        System.out.print("Informe o " + (i+1) + "° " + "número: ");
                        numero1 = scanner.nextInt();
                        vetor2[i] = numero1;
                        System.out.println("\n");
                    }

                    System.out.println("Vetor com seus 5 números somados:");
                    for(int i = 0; i < vetor2.length; i++)
                    {
                        soma += vetor2[i];
                    }
                    System.out.println(soma);

                    break;
                case 15:
                    int [] vetor3 = new int[5];
                    int subtrair = 0;
                    System.out.println("\nVocê escolheu ler 5 números negativos, multiplica-los e mostrar em forma de vetor!\n");

                    for(int i = 0; i < vetor3.length; i++)
                    {
                        System.out.print("Informe o " + (i+1) + "° " + "número: ");
                        numero1 = scanner.nextInt();
                        vetor3[i] = numero1;
                        System.out.println("\n");

                        while (numero1 >= 0)
                        {
                            System.out.println("\n");
                            System.out.println("Positivo!");
                            System.out.print("Informe um número que seja negativo: ");
                            numero1 = scanner.nextInt();
                            vetor3[i] = numero1;
                            System.out.println("\n");
                        }
                    }

                    System.out.println("Resultado dos valores negativos do vetor subtraindo:");
                    for(int i = 0; i < vetor3.length; i++)
                    {
                        subtrair += vetor3[i];
                    }
                    System.out.println(subtrair);

                    break;
                case 16:
                    float [] vetor4 = new float[5];
                    float media1 = 0;
                    float soma1 = 0;
                    float sub = 0;

                    // variavel para ver se foi inserido o numero 0 para fazer a divisao normalmente
                    boolean temZero = false;
                    System.out.println("\nVocê escolheu ler 5 números, fazer a média, suas operações matematicas e mostrar em forma de vetor!\n");

                    for(int i = 0; i < vetor4.length; i++)
                    {
                        System.out.print("Informe o " + (i+1) + "° " + "número: ");
                        vetor4[i] = scanner.nextFloat();
                        System.out.println("\n");
                    }

                    System.out.println("Resultado da média desses valores dentro do vetor:");
                    for(int i = 0; i < vetor4.length; i++)
                    {
                        // somando todas as POSIÇÕES do vetor e dividindo pelo tamanho dele
                        media1 = vetor4[(0 + 1 + 2 + 3 + 4 + 5) / 5];
                    }
                    System.out.println(media1);
                    System.out.println("\n");

                    System.out.println("A soma de todos os valores desse vetor:");
                    for(int i = 0; i < vetor4.length; i++)
                    {
                        soma1 += vetor4[i];
                    }
                    System.out.println(soma1);
                    System.out.println("\n");

                    System.out.println("A subtração de todos os valores desse vetor:");
                    for(int i = 0; i < vetor4.length; i++)
                    {
                        sub -= vetor4[i];
                    }
                    System.out.println(sub);
                    System.out.println("\n");

                    System.out.println("A multiplicação de todos os valores desse vetor:");
                    
                    float multi = vetor4[0];
                    // declarando a variavel como a primeira posição do vetor inves de 0
                    // para nao começar fazendo 0 * primeira posição, mesma coisa com divisão
                    for(int i = 0; i < vetor4.length; i++)
                    {
                        multi *= vetor4[i];
                    }
                    System.out.println(multi);
                    System.out.println("\n");

                    System.out.println("A divisão de todos os valores desse vetor:");
                    float div = vetor4[0];
                    for(int i = 0; i < vetor4.length; i++)
                    {
                        if(vetor4[i] == 0)
                        {
                            temZero = true;
                        }
                    }

                    if(temZero == true)
                    {
                        System.out.println("\n");
                        System.out.println("Impossivel aplicar a divisão! Valor 0 foi inserido");
                    }
                    else
                    {
                        for(int i = 1; i < vetor4.length; i++)
                        {
                            div /= vetor4[i];
                        }

                        System.out.println(div);
                        System.out.println("\n");
                    }

                    break;
                case 17:
                    // dois [] pq é linha e coluna
                    // assim que declara a matriz e os valores fixos dela:
                    int [] [] matriz = {{1,2,3}, {4,5,6}, {7,8,9}};
                    System.out.println("\nVocê escolheu mostrar uma matriz 3x3!\n");

                    for(int i = 0; i < 3; i++)
                    {
                        for(int j = 0; j < 3; j++)
                        {
                            System.out.print(matriz[i] [j] + " ");
                        }
                        System.out.println("\n");
                    }

                    break;
                case 18:
                    int [] [] matriz1 = new int[3][3];
                    System.out.println("\nVocê escolheu pedir 9 números e criar uma matriz 3x3!\n");

                    for(int i = 0; i < matriz1.length; i++)
                    {
                        for(int j = 0; j < matriz1[i].length; j++)
                        {
                            System.out.print("Informe os números da linha " + (i + 1) + " e da coluna " + (j + 1) + " : ");
                            matriz1[i][j] = scanner.nextInt();
                        }
                    }

                    System.out.println("\nMatriz com os valores informados:\n");

                    for(int i = 0; i < matriz1.length; i++)
                    {
                        for(int j = 0; j < matriz1[i].length; j++)
                        {
                            System.out.print(matriz1[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 19:
                    int [] [] matriz2 = new int [3][3];
                    int soma2 = 0;
                    System.out.println("\nVocê escolheu pedir 9 números, soma-los e mostrar em forma de matriz!\n");

                    for(int i = 0; i < matriz2.length; i++)
                    {
                        for(int j = 0; j < matriz2[i].length; j++)
                        {
                            System.out.print("Informe os números da linha " + (i + 1) + " e da coluna " + (j + 1) + " : ");
                            matriz2[i][j] = scanner.nextInt();
                            soma2 += matriz2[i][j];
                        }
                    }

                    System.out.println("\nResultado da soma dos valores da matriz: " + soma2);
                    break;
                case 20:
                    String [] [] matriz3 = new String[3][2];

                    System.out.println("\nVocê escolheu criar uma matriz 3x2 armazenando o nome e a categoria de um produto!\n");

                    for(int i = 0; i < matriz3.length; i++)
                    {
                        for(int j = 0; j < matriz3[i].length; j++)
                        {
                            System.out.print("Informe o nome do produto da linha " + (i + 1) + " e da categoria " + (j + 1) + " : ");
                            matriz3[i][j] = scanner.nextLine();
                        }
                    }
                    System.out.println("\nResultado da matriz com o nome e a categoria dos produtos inseridos:\n");
                    for(int i = 0; i < matriz3.length; i++)
                    {
                        for(int j = 0; j < matriz3[i].length; j++)
                        {
                            System.out.println(matriz3[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 21:
                    int [] [] matriz4 = new int[3][3];
                    // boolean = verdadeiro ou falso
                    boolean semNumero = false;

                    System.out.println("\nVocê escolheu criar uma matriz 3x3, pedindo um valor e verificando se ele existe na matriz!\n");

                    // pedindo os valores da matriz e guardando eles nela
                    for(int i = 0; i < matriz4.length; i++)
                    {
                        for(int j = 0; j < matriz4[i].length; j++)
                        {
                            System.out.print("Informe o número da linha " + (i + 1) + " e da coluna " + (j + 1) + " : ");
                            matriz4[i][j] = scanner.nextInt();
                        }
                    }

                    // pedindo o numero
                    System.out.print("\nInforme um número que deseja verificar se existe na matriz: ");
                    numero1 = scanner.nextInt();
                    
                    // usando o for da linha e da coluna e um if pra se nao tiver o numero da matriz 
                    // a variavel boolean fica true
                    for(int i = 0; i < matriz4.length; i++)
                    {
                        for(int j = 0; j < matriz4[i].length; j++)
                        {
                            if(matriz4[i][j] != numero1)
                            {
                                semNumero = true;
                                
                            }
                        }
                        System.out.println();
                    }

                    //if else pra dizer se tem o numero ou nao atraves da variavel boolean e depois mostrando a matriz
                    if(semNumero == true)
                    {
                        System.out.println("O número " + numero1 + " não está na matriz!");
                    }
                    else
                    {
                        System.out.println("O número " + numero1 + " está na matriz!");
                    }

                    System.out.println("\nMatriz completa:\n");

                    for(int i = 0; i < matriz4.length; i++)
                    {
                        for(int j = 0; j < matriz4[i].length; j++)
                        {
                            System.out.print(matriz4[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 22:
                    int [][] matriz5 = new int[3][3];
                    int i = 0;
                    int j = 0;
                    // linha = i
                    int linha = 0;
                    // coluna = j
                    int coluna = 0;

                    System.out.println("\nVocê escolheu criar uma matriz 3x3, mostrar so as linhas e depois so as colunas!\n");
                    
                    while(j < matriz5.length)
                    {
                        System.out.print("Informe os valores da linha: ");
                        matriz5[linha][j] = scanner.nextInt();
                        j++;
                    }

                    System.out.println("\nOs valores da linha da matriz:");
                    for(j = 0; j < matriz5[linha].length; j++)
                    {
                        System.out.println(matriz5[linha][j] + " ");
                    }

                    // deixando a linha em 0 para inserir deboa nela
                    i = 0;
                    while(i < matriz5.length)
                    {
                        System.out.print("\nInforme os valores da coluna: ");
                        matriz5[i][coluna] = scanner.nextInt();
                        i++;
                    }

                    System.out.println("\nOs valores da coluna da matriz:");
                    for(i = 0; i < matriz5.length; i++)
                    {
                        System.out.println(matriz5[i][coluna] + " ");
                    }
                    break;
                case 23:
                    // criando a instancia de toda a função node com o nome lista
                    Node lista = new Node();
                    System.out.println("\nVocê escolheu mostrar uma lista ligada simples com nomes de produtos!\n");

                    // inserindo
                    // por ser valores do tipo texto é preciso do ""
                    lista.inserir("Mouse");
                    lista.inserir("Teclado");
                    lista.inserir("Computador");

                    // excluindo
                    lista.excluir("Teclado");

                    // buscando
                    lista.buscar("Teclado");

                    // mostrando tudo
                    lista.listar();
                    break;
                case 24:
                    ListaDupla listaDupla = new ListaDupla();
                    System.out.println("\nVocê escolheu mostrar uma lista duplamente ligada com nomes e gêneros de jogos!\n");

                    // inserindo
                    listaDupla.inserir("God of War", "Ação");
                    listaDupla.inserir("Resident Evil", "Terror");
                    listaDupla.inserir("Minecraft", "Aventura");

                    // excluindo
                    listaDupla.excluir("Minecraft");

                    // buscando
                    listaDupla.buscar("Minecraft");

                    // mostrando tudo
                    listaDupla.listar();
                    break;
                case 25:
                    TabelaHash tabelaHash = new TabelaHash();
                    System.out.println("\nVocê escolheu criar uma tabela hash com encandeamento separado adicionando números de salas aos indices!\n");

                    // inserindo
                    // por ser valores inteiro eles sao inseridos assim sem os "":
                    tabelaHash.inserir(401);
                    tabelaHash.inserir(202);
                    tabelaHash.inserir(300);
                    tabelaHash.inserir(92);

                    // excluindo
                    tabelaHash.excluir(401);

                    // buscando uma sala expecifica
                    tabelaHash.buscar(300);

                    // mostrando a tabela inteira
                    tabelaHash.listar();
                    break;
                default:
                    System.out.println("\nEscolha uma opção válida!\n");
            }
        }while(opcao != 0);
        scanner.close();
    }
}
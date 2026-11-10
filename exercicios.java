// scanner é pra ler o que foi inserido pelo usuario
// scanner pra texto: scanner.nextLine(); inteiro: scanner.nextInt(); float: scanner.nextFloat()
import java.util.Scanner;

public class exercicios
{
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
                default:
                    System.out.println("\nEscolha uma opção válida!\n");
            }
        }while(opcao != 0);
        scanner.close();
    }
}
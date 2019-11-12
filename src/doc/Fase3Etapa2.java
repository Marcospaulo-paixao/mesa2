//package bolodepote;
package doc;

// Random para teste
import java.util.Random;
import java.util.Scanner;

public class Fase3Etapa2 {

    public static void main(String[] args) {
        // Variaveis
        Scanner input = new Scanner(System.in);
        String massaBolo[] = {"Açucar", "Margarina Gelada", "Ovos", "Farinha de Trigo com Fermento"}; // Vetor String: Nome dos Ingredientes Massa do bolo
        String recheioMorango[] = {"Leite Condensado", "Creme de leite", "Leite Ninho", "Morangos"};  // Vetor String: Nome dos Ingredientes Recheio e Cobertura
        String recheioDoisCoracao[] = {"Leite Condensado", "Creme de leite", "Chocolate em Pó"};      // Vetor String: Nome dos Ingredientes Recheio e Cobertura
        String recheioMaracuja[] = {"Amido de Milho", "Maracujá",};                                   // Vetor String: Nome dos Ingredientes Recheio e Cobertura
        double[] qntMassa = new double[4];       // Vetor double:Quantidade dos Ingredientes Massa do bolo
        double[] qntMorango = new double[4];     // Vetor double:Quantidade dos Ingredientes Recheio e Cobertura
        double[] qntDoisCoracao = new double[3]; // Vetor double:Quantidade dos Ingredientes Recheio e Cobertura
        double[] qntMaracuja = new double[2];    // Vetor double:Quantidade dos Ingredientes Recheio e Cobertura
        double[] vlMassa = new double[4];       // Vetor double:Valor dos Ingredientes Massa do bolo
        double[] vlMorango = new double[4];     // Vetor double:Valor dos Ingredientes Recheio e Cobertura
        double[] vlDoisCoracao = new double[3]; // Vetor double:Valor dos Ingredientes Recheio e Cobertura
        double[] vlMaracuja = new double[2];    // Vetor double:Valor dos Ingredientes Recheio e Cobertura
        boolean sair = false; // bollean: Para sair do laço de repetição
        String respostaContinue = ""; // Sring: Rospsta Informar uma nova receita
        do { // fase 2 etapa 2 // TESTE/TESTE/TESTE/TESTE            
            String opcaoreceita[] = {"Morango", "Dois Amores", "Maracujá"}; // Vetor String: Random Opções Sabores            
            String opcaoReceita = opcaoreceita[sorteia()];                  // String: Opção Receita
            // fase 2 etapa 2 // TESTE/TESTE/TESTE/TESTE        
            if (opcaoReceita.equals("Morango")) { // Condição: Para cada opção de  sabor valores diferentes serão atribuidos ao Método fase3etapa2
                fase3etapa2(opcaoReceita, massaBolo, recheioMorango, qntMassa, qntMorango, vlMassa, vlMorango); // Morango
            }
            if (opcaoReceita.equals("Dois Amores")) {
                fase3etapa2(opcaoReceita, massaBolo, recheioDoisCoracao, qntMassa, qntDoisCoracao, vlMassa, vlDoisCoracao); // Dois Amores
            }
            if (opcaoReceita.equals("Maracujá")) {
                fase3etapa2(opcaoReceita, massaBolo, recheioMaracuja, qntMassa, qntMaracuja, vlMassa, vlMaracuja); // Maracujá
            }
            // Repetição: Nova receita SIM ou NÃO(Finaliza)
            do {
                System.out.printf("\nDeseja informar uma nova receita [S]-[N] ?");
                respostaContinue = input.next();
                if (respostaContinue.equalsIgnoreCase("s")) {
                    sair = true;
                } else if (respostaContinue.equalsIgnoreCase("n")) {
                    sair = true;
                } else {
                    System.out.println("Erro: Opção invalida!\t");
                    sair = false;
                }
            } while (!sair);
            sair = !respostaContinue.equalsIgnoreCase("s"); // RespostaContinue == S (sair = true) // RespostaContinue == N (sair = false)
            System.out.printf("\n");
        } while (!sair);
    }

    public static void fase3etapa2(String str, String[] vetorS1, String[] vetorS2, double[] vetor1, double[] vetor2, double[] valor1, double[] valor2) {
        // **********************************
        // Fase 3 Etapa 2
        // **********************************

        // Teste
        System.out.printf("%s\n\n", str);

        // Variaveis
        Scanner input = new Scanner(System.in);
        int opcaoMenu = 0; // int: Opção Menu
        boolean sair = false; // boolean: Finalizar laço Menu

        // Pocessamento: Menu
        do {
            do {
                System.out.printf("Digite a opção desejada.\n"
                        + "-------------------------------\n"
                        + "(1) - Simular\n"
                        + "(2) - Ver Ingredientes\n\n"
                        + "(3) - Escolher uma nova receita\n"
                        + "(0) - Sair\n");
                System.out.printf("-------------------------------\n");
                opcaoMenu = validaNumeroInt(); // Opção menu 0 - 1 - 2 - 3
                // if: Caso opção inválida
                if (opcaoMenu < 0 || opcaoMenu > 3) {
                    System.out.printf("\n");
                    System.out.printf("Opção Inválida!\n");

                    // if(3): Mostra Ingredientes, Quantidade, valores
                } else if (opcaoMenu == 2) {
                    imprIngredientes(str, vetorS1, vetorS2, vetor1, vetor2, valor1, valor2); // Método Imprimi Ingredientes, Quantidade, valores
                }
                System.out.printf("\n");
            } while (opcaoMenu < 0 || opcaoMenu > 3);

            // if(1): Informar Ingredientes, Quantidade, valores
            switch (opcaoMenu) {
                case 1:
                    informaQntValor(str, vetorS1, vetorS2, vetor1, vetor2, valor1, valor2); // Método Informa Ingredientes, Quantidade, valores
                    break;
                case 3:
                    // ***************************************************************************************************
                    System.out.printf("Morango | Dois Amores | Maracujá\n"); // fase 2 etapa 2
                    // ***************************************************************************************************
                    break;
                case 0:
                    // sair do laço fase 3 etapa 2
                    sair = true;
                    break;
                default:
                    break;
            }
            System.out.printf("\n");
        } while (!sair);
    }

    public static void mostraCodigoIngredientes(String str, String[] vetorS1, String[] vetorS2, double[] vetor1, double[] vetor2, double[] valor1, double[] valor2) {
        // ***************************************************
        // Fase 3 Etapa 2: Método Imprimir codigo dos produtos
        // ***************************************************
        System.out.printf("Para a massa do bolo:\n"); // Imprimir(Para a massa do bolo): Código, Nome, Quantidade, Valores
        for (int i = 0; i < vetorS1.length; i++) {
            switch (i) {
                case 0:
                    System.out.printf("[%d] - %s:. . . . . . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                            i + 1, vetorS1[i], (int) vetor1[i], ((vetor1[i] - (int) vetor1[i]) * 100), valor1[i]);
                    break;
                case 1:
                    System.out.printf("[%d] - %s:. . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                            i + 1, vetorS1[i], (int) vetor1[i], ((vetor1[i] - (int) vetor1[i]) * 100), valor1[i]);
                    break;
                case 2:

                    System.out.printf("[%d] - %s:. . . . . . . . . . . . . .%03d   (und). .R$ %.2f\n",
                            i + 1, vetorS1[i], (int) vetor1[i], valor1[i]);
                    break;
                case 3:
                    System.out.printf("[%d] - %s: .%03d,%.0f (g). . .R$ %.2f\n",
                            i + 1, vetorS1[i], (int) vetor1[i], ((vetor1[i] - (int) vetor1[i]) * 100), valor1[i]);
                    break;
                default:
                    break;
            }
        }
        System.out.printf("\n");
        System.out.printf("Recheios e Coberturas(%s):\n", str);
        if (str.equals("Morango")) { // Imprimir(Morango): Código, Nome, Quantidade, Valores
            for (int i = 0; i < vetorS2.length; i++) {
                switch (i) {
                    case 0:
                        System.out.printf("[%d] - %s:. . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                i + 5, vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 1:
                        System.out.printf("[%d] - %s:. . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                i + 5, vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 2:

                        System.out.printf("[%d] - %s: . . . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                i + 5, vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 3:
                        System.out.printf("[%d] - %s:. . . . . . . . . . . .%03d   (und). .R$ %.2f\n",
                                i + 5, vetorS2[i], (int) vetor2[i], valor2[i]);
                        break;
                    default:
                        break;
                }
            }
        }
        if (str.equals("Dois Amores")) { // Imprimir(Dois Amores): Código, Nome, Quantidade, Valores

            for (int i = 0; i < vetorS2.length; i++) {
                switch (i) {
                    case 0:
                        System.out.printf("[%d] - %s:. . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                i + 5, vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 1:
                        System.out.printf("[%d] - %s:. . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                i + 5, vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 2:
                        System.out.printf("[%d] - %s: . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                i + 5, vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    default:
                        break;
                }
            }
        }
        if (str.equals("Maracujá")) {// Imprimir(Maracujá): Código, Nome, Quantidade, Valores
            for (int i = 0; i < 2; i++) {
                switch (i) {
                    case 0:
                        System.out.printf("[%d] - %s:. . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                i + 5, vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 1:
                        System.out.printf("[%d] - %s:. . . . . . . . . . . .%03d,%.0f (ml) . .R$ %.2f\n",
                                i + 5, vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;

                    default:
                        break;
                }
            }
        }
        System.out.printf("\n");
    }

    public static void imprIngredientes(String str, String[] vetorS1, String[] vetorS2, double[] vetor1, double[] vetor2, double[] valor1, double[] valor2) {
        // *********************************************************
        // Fase 3 Etapa 2: Método Imprimir Nome Quantidade e valores
        // *********************************************************
        System.out.printf("Para a massa do bolo:\n");// Imprimir(Para a massa do bolo): Nome, Quantidade, Valores
        for (int i = 0; i < vetorS1.length; i++) {
            switch (i) {
                case 0:
                    System.out.printf("%s:. . . . . . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                            vetorS1[i], (int) vetor1[i], ((vetor1[i] - (int) vetor1[i]) * 100), valor1[i]);
                    break;
                case 1:
                    System.out.printf("%s:. . . . . . . .%03d,%.0f (g). . .R$ %.2f\n", vetorS1[i],
                            (int) vetor1[i], ((vetor1[i] - (int) vetor1[i]) * 100), valor1[i]);
                    break;
                case 2:

                    System.out.printf("%s:. . . . . . . . . . . . . .%03d   (und). .R$ %.2f\n",
                            vetorS1[i], (int) vetor1[i], valor1[i]);
                    break;
                case 3:
                    System.out.printf("%s: .%03d,%.0f (g). . .R$ %.2f\n",
                            vetorS1[i], (int) vetor1[i], ((vetor1[i] - (int) vetor1[i]) * 100), valor1[i]);
                    break;
                default:
                    break;
            }
        }
        System.out.printf("\n");
        System.out.printf("Recheios e Coberturas(%s):\n", str);
        if (str.equals("Morango")) {// Imprimir(Morango): Nome, Quantidade, Valores
            for (int i = 0; i < vetorS2.length; i++) {
                switch (i) {
                    case 0:
                        System.out.printf("%s:. . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 1:
                        System.out.printf("%s:. . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 2:
                        System.out.printf("%s: . . . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 3:
                        System.out.printf("%s:. . . . . . . . . . . .%03d   (und). .R$ %.2f\n",
                                vetorS2[i], (int) vetor2[i], valor2[i]);
                        break;
                    default:
                        break;
                }
            }
        }
        if (str.equals("Dois Amores")) { // Imprimir(Dois Amores): Nome, Quantidade, Valores        
            for (int i = 0; i < vetorS2.length; i++) {
                switch (i) {
                    case 0:
                        System.out.printf("%s:. . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 1:
                        System.out.printf("%s:. . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 2:
                        System.out.printf("%s: . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    default:
                        break;
                }
            }
        }
        if (str.equals("Maracujá")) { // Imprimir(Maracujá): Nome, Quantidade, Valores
            for (int i = 0; i < 2; i++) {
                switch (i) {
                    case 0:
                        System.out.printf("%s:. . . . . . . . .%03d,%.0f (g). . .R$ %.2f\n",
                                vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    case 1:
                        System.out.printf("%s:. . . . . . . . . . . .%03d,%.0f (ml) . .R$ %.2f\n",
                                vetorS2[i], (int) vetor2[i], ((vetor2[i] - (int) vetor2[i]) * 100), valor2[i]);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.printf("\n");
    }

    public static double informaQntValor(String str1, String[] vetorS1, String[] vetorS2, double[] vetor1, double[] vetor2, double[] valor1, double[] valor2) {
        // **************************************************
        // Fase 3 Etapa 2: Método Entrada: Quantidade e Valor
        // **************************************************
        boolean sair = false; // Variaveis // boolean: Sair do informaQntValor
        do { // Processamento
            int verifVetorCheio1 = vetor1.length; // Variaveis de Verificicação: se os vetores MassaBoolo estão totalmente preenchido 
            int verifVetorCheio2 = vetor2.length;// Variaveis de Verificicação: se os vetores RecheiosCobertura estão totalmente preenchido 
            mostraCodigoIngredientes(str1, vetorS1, vetorS2, vetor1, vetor2, valor1, valor2);// Imprimir: Códiogo, Nome, Quantidade e Valores
            System.out.printf("[0] - Informar uma nova receita\n\nDigite o código do ingrediente: ");
            switch (validaNumeroInt()) {
                case 0:// Caso 0: O programa finaliza o laço "Informe a Quantidade" e vai para o menu.
                    sair = true;
                    break;
                case 1:// Caso 1: Pede a QNT, VLR do Açucar
                    do {
                        System.out.printf("Informe a quantidade de Açúcar(g): ");
                        vetor1[0] = validaNumeroDoub(); // Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.(valor >= 300) 
                        if (vetor1[0] < 300) {
                            System.out.printf("\n<<<A quantidade mínima de Açucar\npara uma receita é (300)gramas!>>>\n\n");
                        }
                    } while (vetor1[0] < 300);
                    do {
                        System.out.printf("Informe o valor pago em %.1f gramas de Açúcar: ", vetor1[0]);
                        valor1[0] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                        if (valor1[0] < 0) {
                            System.out.printf("\nO valor informado é inválido!\n\n");
                        }
                    } while (valor1[0] < 0);
                    break;
                case 2:// Caso 2: Pede a QNT, VLR da Margarina Gelada
                    do {
                        System.out.printf("Informe a quantidade da Margarina Gelada(g): ");

                        vetor1[1] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.(valor >= 300) 
                        if (vetor1[1] < 300) {
                            System.out.printf("\n<<<A quantidade mínima da Margarina Gelada\npara uma receita é (300)gramas!>>>\n\n");
                        }
                    } while (vetor1[1] < 300);
                    do {
                        System.out.printf("Informe o valor pago em %.1f gramas de Margarina Gelada: ", vetor1[1]);
                        valor1[1] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                        if (valor1[1] < 0) {
                            System.out.printf("\nO valor informado é inválido!\n\n");
                        }
                    } while (valor1[1] < 0);
                    break;
                case 3:// Caso 3: Pede a QNT, VLR do Ovo
                    do {
                        System.out.printf("Informe a quantidade de Ovos: ");

                        vetor1[2] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.(valor >= 4) 
                        if (vetor1[2] < 4) {
                            System.out.printf("\n<<<A quantidade mínima de Ovos\npara uma receita é (4)unidades!>>>\n\n");
                        }
                    } while (vetor1[2] < 4);
                    do {
                        System.out.printf("Informe o valor pago em %.0f unidades de Ovos: ", vetor1[2]);
                        valor1[2] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                        if (valor1[2] < 0) {
                            System.out.printf("\nO valor informado é inválido!\n\n");
                        }
                    } while (valor1[2] < 0);
                    break;
                case 4:// Caso 4: Pede a QNT, VLR da Farinha de Trigo Com Fermento
                    do {
                        System.out.printf("Informe a quantidade da Farinha de Trigo com Fermento(g): ");
                        vetor1[3] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.valor >= 300) 
                        if (vetor1[3] < 300) {
                            System.out.printf("\n<<<A quantidade mínima da Farinha de Trigo com Fermento\npara uma receita é (300)gramas!>>>\n\n");
                        }
                    } while (vetor1[3] < 300);
                    do {
                        System.out.printf("Informe o valor pago em %.1f gramas de Farinha de Trigo: ", vetor1[3]);
                        valor1[3] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                        if (valor1[3] < 0) {
                            System.out.printf("\nO valor informado é inválido!\n\n");
                        }
                    } while (valor1[3] < 0);
                    break;
                case 5:// Caso 5: Pede a QNT, VLR do Morango, Dois Amores ou Maracujá
                    if ((str1.equals("Morango")) || (str1.equals("Dois Amores"))) {
                        do {
                            System.out.printf("Informe a quantidade do Leite Condensado(g): ");
                            vetor2[0] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.valor >= 600) 
                            if (vetor2[0] < 600) {
                                System.out.printf("\n<<<A quantidade mínima do Leite Condensado\npara uma receita é 02 latas (300 g cada)!>>>\n\n");
                            }
                        } while (vetor2[0] < 600);
                        do {
                            System.out.printf("Informe o valor pago em %.1f gramas de Leite Condensado: ", vetor2[0]);
                            valor2[0] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                            if (valor2[0] < 0) {
                                System.out.printf("\nO valor informado é inválido!\n\n");
                            }
                        } while (valor2[0] < 0);
                    } else if (str1.equals("Maracujá")) {
                        do {
                            System.out.printf("Informe a quantidade do Amido de Milho(g): ");

                            vetor2[0] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.valor >= 5)  
                            if (vetor2[0] < 5) {
                                System.out.printf("\n<<<A quantidade mínima do Amido de Milho\npara uma receita é 04 colheres (5 g cada)!>>>\n\n");
                            }
                        } while (vetor2[0] < 5);
                        do {
                            System.out.printf("Informe o valor pago em %.1f gramas de Amido de Milho: ", vetor2[0]);
                            valor2[0] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                            if (valor2[0] < 0) {
                                System.out.printf("\nO valor informado é inválido!\n\n");
                            }
                        } while (valor2[0] < 0);
                    }
                    break;
                case 6:// Caso 6: Pede a QNT, VLR do Morango, Dois Amores ou Maracujá
                    if ((str1.equals("Morango")) || (str1.equals("Dois Amores"))) {
                        do {
                            System.out.printf("Informe a quantidade do Creme de Leite(g): ");
                            vetor2[1] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.valor >= 300) 
                            if (vetor2[1] < 300 * 2) {
                                System.out.printf("\n<<<A quantidade mínima de Creme de Leite\npara uma receita é 02 latas (300 g cada)!>>>\n\n");
                            }
                        } while (vetor2[1] < 300 * 2);
                        do {
                            System.out.printf("Informe o valor pago em %.1f gramas de Creme de Leite: ", vetor2[1]);
                            valor2[1] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                            if (valor2[1] < 0) {
                                System.out.printf("\nO valor informado é inválido!\n\n");
                            }
                        } while (valor2[1] < 0);
                    } else {
                        do {
                            System.out.printf("Informe a quantidade de Maracujá(ml): ");

                            vetor2[1] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.valor >= 240) 
                            if (vetor2[1] < 240 * 2) {
                                System.out.printf("\n<<<A quantidade mínima de Maracujá\npara uma receita é 02 xícaras (240 ml cada)!>>>\n\n");
                            }
                        } while (vetor2[1] < 240 * 2);
                        do {
                            System.out.printf("Informe o valor pago em %.1f mililitros de Maracujá: ", vetor2[1]);
                            valor2[1] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                            if (valor2[1] < 0) {
                                System.out.printf("\nO valor informado é inválido!\n\n");
                            }
                        } while (valor2[1] < 0);
                    }
                    break;
                case 7:// Caso 7: Pede a QNT, VLR do Morango, Dois Amores
                    if (str1.equals("Morango")) {
                        do {
                            System.out.printf("Informe a quantidade de Leite Ninho(g): ");
                            vetor2[2] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.(valor >= 600) 
                            if (vetor2[2] < 600) {
                                System.out.printf("\n<<<A quantidade mínima de Leite Ninho\npara uma receita é 06 colheres (100 g cada)!>>>\n\n");
                            }
                        } while (vetor2[2] < 600);
                        do {
                            System.out.printf("Informe o valor pago em %.1f gramas de Leite Ninho: ", vetor2[2]);
                            valor2[2] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                            if (valor2[2] < 0) {
                                System.out.printf("\nO valor informado é inválido!\n\n");
                            }
                        } while (valor2[2] < 0);
                    }
                    if (str1.equals("Dois Amores")) {
                        do {
                            System.out.printf("Informe a quantidade do Chocolate em Pó(g): ");
                            vetor2[2] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.(valor >= 100) 

                            if (vetor2[2] < 100 * 6) {
                                System.out.printf("\n<<<A quantidade mínima de Chocolate em Pó\npara uma receita é 06 colheres (100 g cada)!>>>\n\n");
                            }
                        } while (vetor2[2] < 100 * 6);
                        do {
                            System.out.printf("Informe o valor pago em %.1f gramas de Chocolate em Pó: ", vetor2[2]);
                            valor2[2] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                            if (valor2[2] < 0) {
                                System.out.printf("\nO valor informado é inválido!\n\n");
                            }
                        } while (valor2[2] < 0);
                    }
                    break;
                case 8:// Caso 8: Pede a QNT, VLR do Morango, Dois Amores
                    do {
                        System.out.printf("Informe a quantidade de Morangos: ");
                        vetor2[3] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.(valor >= 20) 

                        if (vetor2[3] < 20) {
                            System.out.printf("\n<<<A quantidade mínima de Morangos\npara uma receita é 20 unidades!>>>\n\n");
                        }
                    } while (vetor2[3] < 20);
                    do {
                        System.out.printf("Informe o valor pago em %.0f unidades de Morangos: ", vetor2[3]);
                        valor2[3] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0)
                        if (valor2[3] < 0) {
                            System.out.printf("\nO valor informado é inválido!\n\n");
                        }
                    } while (valor2[3] < 0);
                    break;
                default:
                    System.out.printf("Código Inválido!\n");
            }
            System.out.printf("\n");
            for (int i = 0; i < vetor1.length; i++) {//Verificicação: se os vetores MassaBoolo estão totalmente preenchido 
                if (vetor1[i] != 0) {
                    verifVetorCheio1--;// Decremento:caso ElementoMassaBolo != 0
                }
            }
            for (int i = 0; i < vetor2.length; i++) {//Verificicação: se os vetores RecheiosCobertura estão totalmente preenchido 
                if (vetor2[i] != 0) {
                    verifVetorCheio2--;// Decremento:caso ElementoRecheioCobertura != 0
                }
            }
            if (verifVetorCheio1 == 0 && verifVetorCheio2 == 0) {// if(vetores == Cheios)>> verificar os vetore
                if (str1.equals("Maracujá")) {// if(opcaoReceita == Maracujá)>>verivicar se a opcao bolo é maracujá
                    if (vetor1[0] < 500) {// if(QNTaçucar < ((200+300)=500))>> verificar se quantidade de açucar é menor do que 
                        //                   500((300)gramas de ovos para a massa e (200)gramas para o Recheio e Cobertura)
                        System.out.printf("<<<A quantidade de Açucar é insuficiente para calcular a receita de Maracujá>>>\n"
                                + "<<<                  (300)gramas de Açucar para a massa                     >>>\n"
                                + "<<<          (200)gramas de Açucar para o Recheio e Cobertura               >>>\n\n");
                        do {
                            System.out.printf("Informe a quantidade de Açúcar(g): ");
                            vetor1[0] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.(valor >= 500) 
                            if (vetor1[0] < 500) {
                                System.out.printf("<<<A quantidade de Açucar é insuficiente para calcular a receita de Maracujá>>>\n"
                                        + "<<<                  (300)gramas de Açucar para a massa                     >>>\n"
                                        + "<<<          (200)gramas de Açucar para o Recheio e Cobertura               >>>\n\n");
                            }
                        } while (vetor1[0] < 500);
                        do {
                            System.out.printf("Informe o valor pago em %.1f gramas de Açúcar: ", vetor1[0]);
                            valor1[0] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0) 
                            if (valor1[0] < 0) {
                                System.out.printf("\nO valor informado é inválido!\n\n");
                            }
                        } while (valor1[0] < 0);
                    }
                    System.out.printf("\n");
                    if (vetor1[2] < 10) {// if(QNTovo < ((04+06)=10))>> verificar se quantidade de ovos é menor do que
                        //                  10((04)unidades de ovos para a massa e (06)unidades de ovos ara o Recheio e Cobertura)
                        System.out.printf("<<<A quantidade de Ovos é insuficiente para calcular a receita de Maracujá>>>\n"
                                + "<<<                  (04)unidades de ovos para a massa                    >>>\n"
                                + "<<<           (06)unidades de ovos para o Recheio e Cobertura:            >>>\n\n");
                        do {
                            System.out.printf("Informe a quantidade de Ovos: ");

                            vetor1[2] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorQNT um valor informado.(valor >= 10) 
                            if (vetor1[2] < 10) {// senao((QNTovo < ((04+06)=10)))
                                System.out.printf("<<<A quantidade de Ovos é insuficiente para calcular a receita de Maracujá>>>\n"
                                        + "<<<                  (04)unidades de ovos para a massa                    >>>\n"
                                        + "<<<           (06)unidades de ovos para o Recheio e Cobertura:            >>>\n\n");
                            }
                        } while (vetor1[2] < 10);
                        do {
                            System.out.printf("Informe o valor pago em %.0f unidades de Ovos: ", vetor1[2]);
                            valor1[2] = validaNumeroDoub();// Método Valida NumDouble: Atribui ao 1º elemento do vetorVLR um valor informado.(valor > 0) 
                            if (valor1[2] < 0) {
                                System.out.printf("\nO valor informado é inválido!\n\n");
                            }
                        } while (valor1[2] < 0);
                    }
                    sair = true;// Sair do Laço ao validar Açucar e ovoerificar se quantidade de açucar é menor do que 
                } else {// senao(opcaoReceita == Maracujá)>> Sair do Laço
                    sair = true;
                }
            }// senao (vetores == Cheios)>> repete o Laço QNT/VLR 
        } while (!sair);
        System.out.printf("\n");
        imprIngredientes(str1, vetorS1, vetorS2, vetor1, vetor2, valor1, valor2);
        return (0);
    }

    public static int validaNumeroInt() {
        Scanner input = new Scanner(System.in);// Valida Entrada Num Inteiro
        int N = 0;
        boolean Num = false;
        do {
            try {
                N = Integer.parseInt(input.nextLine());
                Num = true;
            } catch (Exception e) {
                System.out.printf("O Número digitado não é válido.\n");
            }
        } while (!Num);
        return (N);
    }

    public static double validaNumeroDoub() {
        Scanner input = new Scanner(System.in);// Valida Entrada Num Double
        double N = 0;
        boolean Num = false;
        do {
            try {
                N = Double.parseDouble(input.nextLine());
                Num = true;
            } catch (Exception e) {
                System.out.printf("O Número digitado não é válido.\n");
            }
        } while (!Num);
        return (N);
    }

    // Sorteia para teste
    public static int sorteia() {
        int limiteInferior = 0;
        int limiteSuperior = 2;
        Random rd = new Random();
        return rd.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
    }

}

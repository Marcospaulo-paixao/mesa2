/*
 * A licença MIT
 *
 * Copyright 2019 Viniciusalopes Tecnologia <suporte@viniciusalopes.com.br>.
 *
 * É concedida permissão, gratuitamente, a qualquer pessoa que obtenha uma cópia
 * deste software e dos arquivos de documentação associados (o "Software"), para
 * negociar o Software sem restrições, incluindo, sem limitação, os direitos de uso,
 * cópia, modificação e fusão, publicar, distribuir, sublicenciar e/ou vender cópias
 * do Software, e permitir que as pessoas a quem o Software é fornecido o façam,
 * sujeitas às seguintes condições:
 *
 * O aviso de copyright acima e este aviso de permissão devem ser incluídos em
 * todas as cópias ou partes substanciais do Software.
 *
 * O SOFTWARE É FORNECIDO "NO ESTADO EM QUE SE ENCONTRA", SEM NENHUM TIPO DE GARANTIA,
 * EXPRESSA OU IMPLÍCITA, INCLUINDO, MAS NÃO SE LIMITANDO ÀS GARANTIAS DE COMERCIALIZAÇÃO,
 * ADEQUAÇÃO A UM FIM ESPECÍFICO E NÃO VIOLAÇÃO. EM NENHUMA CIRCUNSTÂNCIA, OS AUTORES
 * OU PROPRIETÁRIOS DE DIREITOS DE AUTOR PODERÃO SER RESPONSABILIZADOS POR QUAISQUER
 * REIVINDICAÇÕES, DANOS OU OUTRAS RESPONSABILIDADES, QUER EM AÇÃO DE CONTRATO,
 * DELITO OU DE OUTRA FORMA, DECORRENTES DE, OU EM CONEXÃO COM O SOFTWARE OU O USO
 * OU OUTRAS NEGOCIAÇÕES NO PROGRAMAS.
 * ------------------------------------------------------------------------------------------
 * Projeto   : Projeto Bolo no Pote - Matemática e Estatística - ADS1/2019 - Grupo A1
 * Criado em : 07/11/2019
 * Autores   : Anisberto
 *             Calebe
 *             Jhonathan dos Reis
 *             Marcos Paulo
 *             Vinicius Araujo Lopes
 *             
 * Finalidade: Projeto Bolos no Pote
 
    Muitas receitas de bolos no pote não gastam mais do que R$ 30 para fazer uma receita para 15 unidades.
    E essa é uma das maiores vantagens em começar a vender bolos no pote. Inclusive, com a chegada do natal, 
    você pode até mesmo apostar em bolos para essa época do ano!
    Assim, foram reunidas três de receitas de coberturas, de bolos no pote.
    Desenvolver um software, onde:
    DESAFIO
    Desenvolver um software que ao digitar os valores dos ingredientes com suas respectivas medidas, devolva para o 
    usuário qual/quais receita(s) ele poderá fazer dentro do limite de gasto proposto na contextualização.
    1. Resolva a situação problema proposta. Com as três receitas. Os dados podem ser fictícios (valores e medidas).
    2. Calcule automaticamente o valor de custo de cada bolo no pote (incluso o valor da embalagem);
    3. Calcule quanto o usuário irá ter de lucro (em R$ e em %), dado um valor de venda.
    4. O software pode ser rodado no console.
    5. O software deverá ser apresentado para o(s) professor(es) da(s) disciplina(s) participante(s). “Rodando”.

    Para a massa do bolo:
    Ingredientes:
    • 300 g de açúcar
    • 300 g de margarina gelada
    • 4 ovos médios
    • 300 g de farinha de trigo com fermento
    Recheios e Coberturas:

    1. Leite ninho com morangos:

    • 2 latas de leite condensado (300 gramas cada)
    • 2 latas de creme de leite (300 gramas cada)
    • 6 colheres (de sopa) de leite ninho (100 gramas cada)
    • 20 morangos

    2. Dois amores:

    • 2 latas de leite condensado (300 gramas cada)
    • 2 latas de creme de leite (300 gramas cada)
    • 6 colheres de chocolate em pó (100 gramas cada)

    3. Maracujá:

    • 2 xícaras de suco de maracujá (240 ml)
    • 4 colheres de amido de milho (5 gramas cada)
    • 6 gemas
    • 1 xícara de água (250 ml)
    • 1 e 1/2 xícara de açúcar (200 gramas)

 

 * ------------------------------------------------------------------------------------------
 */
package app;

import java.util.Scanner;

public class Principal {

    // Fase1_Etapa_1 - Variáveis - Vinicius --------------------------------------------------------
    private static Scanner input = new Scanner(System.in);
    private static boolean sair = false; // boolean: Para sair do laço de repetição
    private static int opcaoMenu = 0; // int: Opção Menu
    private static int numeroReceita = -1;
    private static String opcao;
    private static String[] receitas = {"Leite ninho com Morangos", "Dois Amores", "Maracujá"};
    private static String[] opcoesReceitas = {"Morango", "Dois Amores", "Maracujá"}; // Vetor String: Opções Sabores       
    private static String opcaoReceita;

    private static int rendimento = 0;
    private static double custo_maximo = 0.0;
    private static double custo_total;
    private static double custo_unitario;
    private static double preco_venda_unitario;
    private static double lucro_unitario_valor;
    private static double lucro_unitario_percent;

    private static String massaBolo[] = {"Açúcar", "Margarina Gelada", "Ovos", "Farinha de Trigo com Fermento"}; // Vetor String: Nome dos Ingredientes Massa do bolo
    private static String recheioMorango[] = {"Leite Condensado", "Creme de leite", "Leite Ninho", "Morangos", "Pote 200ml"};  // Vetor String: Nome dos Ingredientes Recheio e Cobertura
    private static String recheioDoisAmores[] = {"Leite Condensado", "Creme de leite", "Chocolate em Pó", "Pote 200ml"};      // Vetor String: Nome dos Ingredientes Recheio e Cobertura
    private static String recheioMaracuja[] = {"Suco de Maracujá", "Amido de Milho", "Ovos", "Água", "Açúcar", "Leite", "Manteiga", "Pote 200ml"};  // Vetor String: Nome dos Ingredientes Recheio e Cobertura

    private static double[] qntMassa = new double[massaBolo.length];                // Vetor double:Quantidade dos Ingredientes Massa do bolo
    private static double[] qntMorango = new double[recheioMorango.length];         // Vetor double:Quantidade dos Ingredientes Recheio e Cobertura + potes
    private static double[] qntDoisAmores = new double[recheioDoisAmores.length];   // Vetor double:Quantidade dos Ingredientes Recheio e Cobertura + potes
    private static double[] qntMaracuja = new double[recheioMaracuja.length];       // Vetor double:Quantidade dos Ingredientes Recheio e Cobertura + potes

    private static double[] vlMassa = new double[massaBolo.length];                 // Vetor double:Valor dos Ingredientes Massa do bolo
    private static double[] vlMorango = new double[recheioMorango.length];          // Vetor double:Valor dos Ingredientes Recheio e Cobertura + potes
    private static double[] vlDoisAmores = new double[recheioDoisAmores.length];    // Vetor double:Valor dos Ingredientes Recheio e Cobertura + potes
    private static double[] vlMaracuja = new double[recheioMaracuja.length];        // Vetor double:Valor dos Ingredientes Recheio e Cobertura + potes

    private static String str_ingredientes[];
    private static double valores[][];

    // FIM Fase1_Etapa_1 - Variáveis - Vinicius --------------------------------------------------------
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        do {
            menu_receitas();
            sair = (numeroReceita == 0) ? true : false;
        } while (!sair);
    }

    private static void menu_receitas() {
        // Fase2_Etapa_1 - Lista de Receitas - Anisberto --------------------------------------------------------
        imprime_cabecalho();
        System.out.println("Informe a receita: \n");
        System.out.println(" 1. Leite ninho com morangos\n"
                + " 2. Dois amores:\n"
                + " 3. Maracujá\n\n"
                + " 0. Sair");
        System.out.print("> ");
        // FIM Fase2_Etapa_1 - Lista de Receitas - Anisberto --------------------------------------------------------

        // Fase2_Etapa_2 - Loop Receita - Jhonathan / Vinicius --------------------------------------------
        // A lógica do Jhonathan foi aproveitada, mas o Vinicius implementou outro tipo de validação.
        opcao = input.nextLine();
        if (int_no_intervalo(opcao, 0, 3)) {
            numeroReceita = Integer.parseInt(opcao);

            // Testa a resposta
            if (numeroReceita > 0) {
                ver_receita();
                custo_rendimento_preco();
                opcaoReceita = opcoesReceitas[numeroReceita - 1];
                menu_ingredientes();
                analisa_receita();
//                exibe_resultados();
            }
        } else {
            System.out.println("Opção inválida!\n");
            numeroReceita = -1;
        }
        // FIM Fase2_Etapa_2 - Loop Receita - Jhonathan / Vinicius --------------------------------------------
    }

    private static void analisa_receita() {
        custo_total = 0.0;
        int qtd_ingredientes = 9;   // 4 para massa + 4 para ninho com morango + 1 do pote
        int lin; // Linha em valores[][]
        double qtd; // Quantidade do ingrediente

        // Dimensiona matriz de calculo do custo
        if (numeroReceita == 2) {
            qtd_ingredientes -= 1; // 1 ingrediente a menos que a de ninho com morango
        }

        if (numeroReceita == 3) {
            qtd_ingredientes += 2; // 2 ingredientes a mais que a de ninho, 2 ingredientes a menos que já estão na massa (Ovos e Açúcar)
        }

        str_ingredientes = new String[qtd_ingredientes];
        valores = new double[qtd_ingredientes][4];
        /*
        ingrediente1 [qtd][valor][receita][custo]
        ingrediente2 [qtd][valor][receita][custo]
        ingrediente3 [qtd][valor][receita][custo]
        ingredienteN [qtd][valor][receita][custo]
         */

        // Popula matriz de cálculo do custo
        // Massa
        qtd = 300.0; // Quantidade do ingrediente
        for (lin = 0; lin < qntMassa.length; lin++) {
            valores[lin][0] = qntMassa[lin];
            valores[lin][1] = vlMassa[lin];

            if (lin == 2) {
                qtd = 4.0;  // Só muda a quantidade de ovos
            }
            valores[lin][2] = qtd;
            valores[lin][3] = (valores[lin][1] / valores[lin][0]) * valores[lin][2];
            custo_total += valores[lin][3]; // Soma os ingredientes
        }

        qtd = 600.0; // Quantidade do ingrediente

        if (numeroReceita == 1) {
            for (int i = 0; i < qntMorango.length; i++) {
                valores[lin + i][0] = qntMorango[i];
                valores[lin + i][1] = vlMorango[i];

                if (lin + i == 3) {
                    qtd = 20.0; // Só muda a quantidade de morangos
                }
                valores[lin + i][2] = qtd;
                valores[lin + i][3] = (valores[lin + i][1] / valores[lin + i][0]) * valores[lin + i][2];
                custo_total += valores[lin + i][3]; // Soma os ingredientes

            }
        } else if (numeroReceita == 2) {
            for (int i = 0; i < qntDoisAmores.length; i++) {
                valores[lin + i][0] = qntDoisAmores[i];
                valores[lin + i][1] = vlDoisAmores[i];
                valores[lin + i][2] = qtd;
                valores[lin + i][3] = (valores[lin + i][1] / valores[lin + i][0]) * valores[lin + i][2];
                custo_total += valores[lin + i][3]; // Soma os ingredientes

            }
        } else {
            double[] qtds = {240.0, 20.0, 6.0, 250.0, 200.0};

            for (int i = 0; i < qntMaracuja.length; i++) {
                valores[lin + i][0] = qntMaracuja[i];
                valores[lin + i][1] = vlMaracuja[i];
                valores[lin + i][2] = qtds[i];
                valores[lin + i][3] = (valores[lin + i][1] / valores[lin + i][0]) * valores[lin + i][2];
                custo_total += valores[lin + i][3]; // Soma os ingredientes
            }
        }

        custo_unitario = custo_total / rendimento;
        lucro_unitario_valor = preco_venda_unitario - custo_unitario;
        lucro_unitario_percent = (lucro_unitario_valor / preco_venda_unitario) * 100;

    }

    private static void ver_receita() {
        // Fase2_Etapa_2 - Loop Receita - Jhonathan / Calebe / Vinicius --------------------------------------------
        // A lógica do Jhonathan foi implementada pelo Vinicius, utilizando o método de impressão do Calebe
        imprime_selecionado(receitas, numeroReceita - 1);

        System.out.println("Para a massa do bolo:");
        imprimeVetor(massaBolo());
        System.out.println();

        System.out.println("Recheio e Cobertura:");
        if (numeroReceita == 1) {
            imprimeVetor(recheioNinho());
        } else if (numeroReceita == 2) {
            imprimeVetor(recheioDoisAmores());
        } else {
            imprimeVetor(recheioMaracuja());
        }
        System.out.println();
        // FIM Fase2_Etapa_2 - Loop Receita - Jhonathan / Calebe / Vinicius --------------------------------------------
    }

    private static void menu_ingredientes() {
        do {
            if (opcaoReceita.equals("Morango")) { // Condição: Para cada opção de sabor valores diferentes serão atribuidos ao Método fase3etapa2
                fase3etapa2(opcaoReceita, massaBolo, recheioMorango, qntMassa, qntMorango, vlMassa, vlMorango); // Morango
            }
            if (opcaoReceita.equals("Dois Amores")) {
                fase3etapa2(opcaoReceita, massaBolo, recheioDoisAmores, qntMassa, qntDoisAmores, vlMassa, vlDoisAmores); // Dois Amores
            }
            if (opcaoReceita.equals("Maracujá")) {
                fase3etapa2(opcaoReceita, massaBolo, recheioMaracuja, qntMassa, qntMaracuja, vlMassa, vlMaracuja); // Maracujá
            }
        } while (!sair);
    }

    public static void fase3etapa2(String str, String[] vetorS1, String[] vetorS2, double[] vetor1, double[] vetor2, double[] valor1, double[] valor2) {
        // **********************************
        // Fase 3 Etapa 2
        // **********************************

        // Pocessamento: Menu
        do {
            System.out.printf("Digite a opção desejada.\n"
                    + "-------------------------------\n"
                    + "(1) - Simular\n"
                    + "(2) - Ver Ingredientes\n"
                    + "(3) - Ver Receita\n\n"
                    + "(0) - Escolher outra receita\n"
                    + "-------------------------------\n"
                    + "> "
            );

            opcaoMenu = validaNumeroInt(); // Opção menu 0 - 1 - 2 - 3
            // if: Caso opção inválida
            if (opcaoMenu < 0 || opcaoMenu > 3) {
                System.out.printf("\n");
                System.out.printf("Opção Inválida!\n");

                // if(3): Mostra Ingredientes, Quantidade, valores
            } else {
                switch (opcaoMenu) {
                    case 1:
                        // Informar Ingredientes, Quantidade, valores
                        informaQntValor(str, vetorS1, vetorS2, vetor1, vetor2, valor1, valor2); // Método Informa Ingredientes, Quantidade, valores
                        break;
                    case 2:
                        imprIngredientes(str, vetorS1, vetorS2, vetor1, vetor2, valor1, valor2); // Método Imprimi Ingredientes, Quantidade, valores
                        break;
                    case 3:
                        ver_receita();
                        break;
                    default:
                        sair = true;
                        break;
                }
            }
            System.out.println();
        } while (opcaoMenu < 0 || opcaoMenu > 3);

        System.out.printf("\n");
    }

    public static void mostraCodigoIngredientes(String str, String[] vetorS1, String[] vetorS2, double[] vetor1, double[] vetor2, double[] valor1, double[] valor2) {
        // ***************************************************
        // Fase 3 Etapa 2: Método Imprimir codigo dos produtos
        // ***************************************************
        System.out.printf("\nPara a massa do bolo:\n"); // Imprimir(Para a massa do bolo): Código, Nome, Quantidade, Valores
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
        System.out.printf("\nPara a massa do bolo:\n");// Imprimir(Para a massa do bolo): Nome, Quantidade, Valores
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
            System.out.printf("[0] - Escolher outra receita\n\nDigite o código do ingrediente: ");
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
                System.out.printf("O Número digitado não é válido.\nDigite novamente > ");
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
                System.out.printf("O Número digitado não é válido.\nDigite novamente > ");
            }
        } while (!Num);
        return (N);
    }

    private static void imprime_cabecalho() {
        // Fase2_Etapa_1 - Lista de Receitas - Anisberto --------------------------------------------------------

        String projeto = "| PROJETO MATH - BOLO NO POTE |";

        // Formatação Inicio
        for (int i = 0;
                i < projeto.length();
                i++) {
            System.out.print("-");
        }

        System.out.println();

        System.out.println(projeto);

        for (int i = 0;
                i < projeto.length();
                i++) {
            System.out.print("-");
        }

        System.out.println(
                "\n");
        // Formatação Fim
        // FIM Fase2_Etapa_1 - Lista de Receitas - Anisberto --------------------------------------------------------
    }

    private static void imprime_selecionado(String array[], int posicao) {
        // Fase2_Etapa_1 - Lista de Receitas - Anisberto --------------------------------------------------------

        String convert = array[posicao];

        System.out.println("\nVocê Selecionou:");
        for (int i = 0; i < convert.length(); i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.println(array[posicao]);

        for (int i = 0; i < convert.length(); i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        // FIM Fase2_Etapa_1 - Lista de Receitas - Anisberto --------------------------------------------------------

    }

    private static void custo_rendimento_preco() {

        // Fase2_Etapa3 - Custo, Rendimento e Preço - Vinicius ----------------------------------------------------------------------
        do {
            System.out.print("Custo máximo por receita: R$ ");
            opcao = input.nextLine();

            if (double_valido(opcao)) {
                custo_maximo = Double.parseDouble(opcao);
                if (custo_maximo <= 0.0) {
                    System.out.println("Valor inválido para o custo.");
                }
            } else {
                System.out.println("Custo inválido!");
            }

        } while (custo_maximo <= 0.0);
        System.out.println();

        do {
            System.out.print("Rendimento por receita (unidades): ");
            opcao = input.nextLine();

            if (int_valido(opcao)) {
                rendimento = Integer.parseInt(opcao);
                if (rendimento <= 0.0) {
                    System.out.println("Quantidade inválida para o rendimento.");
                }
            } else {
                System.out.println("Quantidade inválida!");
            }

        } while (rendimento <= 0.0);
        System.out.println();

        do {
            System.out.print("Preço de venda (unitário): R$ ");
            opcao = input.nextLine();

            if (int_valido(opcao)) {
                preco_venda_unitario = Integer.parseInt(opcao);
                if (preco_venda_unitario <= 0.0) {
                    System.out.println("Valor inválido para o preço de venda.");
                }
            } else {
                System.out.println("Preço inválido!");
            }

        } while (preco_venda_unitario <= 0.0);
        System.out.println();

        // FIM Fase2_Etapa3 - Custo, Rendimento e Preço - Vinicius ----------------------------------------------------------------------
    }
    // Fase3_Etapa_2 - Marcos Paulo --------------------------------------------------------

    // Fase3_Etapa_1 - Calebe --------------------------------------------------------
    public static String[] massaBolo() {
        String[] massa = new String[4];
        massa[0] = "300 g de açucar";
        massa[1] = "300 g de margarina gelada";
        massa[2] = "4 ovos médios";
        massa[3] = "300 g de farinha de trigo com formento";
        return (massa);
    }

    public static String[] recheioNinho() {
        String[] ninho = new String[4];
        ninho[0] = "2 latas de leite condensado (300g cada)";
        ninho[1] = "2 latas de creme de leite (300g cada) ";
        ninho[2] = "6 colheres (de sopa) de leite ninho (100g cada)";
        ninho[3] = "20 morangos";
        return (ninho);
    }

    public static String[] recheioDoisAmores() {
        String[] doisAmores = new String[3];
        doisAmores[0] = "2 latas de leite condensado (300g cada)";
        doisAmores[1] = "2 latas de creme de leite (300g cada) ";
        doisAmores[2] = "6 colheres de chocolate em pó (100g cada)";
        return (doisAmores);

    }

    public static String[] recheioMaracuja() {
        String[] maracuja = new String[7];
        maracuja[0] = "2 xícaras de suco de maracujá (240 ml cada)";
        maracuja[1] = "4 colheres de amido de milho (5 gramas cada)";
        maracuja[2] = "6 gemas";
        maracuja[3] = "1 xícara de água (250 ml)";
        maracuja[4] = "1 e 1/2 xícara de açúcar (200 gramas)";
        maracuja[5] = "200 ml de leite";
        maracuja[6] = "1 colher (de sopa) de manteiga. (50 gramas)";
        return (maracuja);
    }

    public static void imprimeVetor(String[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("• " + vetor[i]);
        }
    }
    // FIM Fase3_Etapa_1 - Calebe --------------------------------------------------------

    /**
     * Verifica se o texto é uma string vazia (Sem caracteres válidos).
     *
     * O caractere de espaço ' ' _é considerado inválido.
     *
     * @param texto Texto a ser analisado.
     * @return true: string vazia; false: string não-vazia.
     */
    public static boolean string_vazia(String texto) {

        texto = texto.trim();

        if (texto.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se o texto é uma string não-vazia que possa ser convertida para
     * um número inteiro válido.
     *
     * @param texto Texto a ser analisado.
     * @return true: válido; false: inválido.
     */
    public static boolean int_valido(String texto) {

        texto = texto.trim();

        if (string_vazia(texto)) {
            return false;
        }

        try {
            Integer.parseInt(texto);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Verifica se o texto é uma string não-vazia que possa ser convertido para
     * um número inteiro, e se é uma opção válida.
     *
     * @param texto Texto a ser analisado.
     * @param opcoes Vetor de opções válidas.
     * @return true: opção válida; false: opção inválida.
     */
    public static boolean int_opcao_valida(String texto, int[] opcoes) {

        if (!int_valido(texto)) {
            return false;
        }

        if (opcoes.length > 0) {
            for (int i = 0; i < opcoes.length; i++) {
                if (Integer.parseInt(texto) == opcoes[i]) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /**
     * Verifica se o texto é uma string não-vazia que possa ser convertido para
     * um número inteiro, e se o valor está contido em um intervalo.
     *
     * @param texto Texto a ser analisado.
     * @param minimo Menor valor válido.
     * @param maximo Maior valor válido.
     * @return true: no intervalo; false: fora do intervalo.
     */
    public static boolean int_no_intervalo(String texto, int minimo, int maximo) {

        if (!int_valido(texto)) {
            return false;
        }

        if (Integer.parseInt(texto) < minimo || Integer.parseInt(texto) > maximo) {
            return false;
        }

        return true;
    }

    /**
     * Verifica se o texto é uma string não-vazia que possa ser convertida para
     * um número decimal válido do tipo double.
     *
     * @param texto Texto a ser analisado.
     * @return true: válido; false: inválido.
     */
    public static boolean double_valido(String texto) {

        texto = texto.trim();

        if (string_vazia(texto)) {
            return false;
        }

        try {
            Double.parseDouble(texto);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}

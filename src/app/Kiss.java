/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;

/**
 *
 * @author vovoubuntu
 */
public class Kiss {

    private static Scanner sc = new Scanner(System.in);
    private static boolean sair = false;
    private static boolean invalida = true;
    private static String opcao;
    private static int num_receita;
    private static String[][] ingredientes;
    private static double[][] valores;
    private static String linha = "---------------------------------------------------------------";

    /*
        valores_receita[0] = custo_total
        valores_receita[1] = rendimento
        valores_receita[2] = preco_de_venda
        valores_receita[3] = venda_total
        valores_receita[4] = lucro_receita_valor
        valores_receita[5] = lucro_percent_receita
        valores_receita[6] = custo_unitario
        valores_receita[7] = lucro_unitario_valor
     */
    private static double[] valores_receita = new double[8];

    private static String[] receitas_nomes = {
        "Leite ninho com morangos",
        "Dois Amores",
        "Maracujá"
    };

    private static String[][] receitas = {
        {
            "300 g de açúcar",
            "300 g de margarina gelada",
            "4 ovos médios",
            "300 g de farinha de trigo com fermento"
        },
        {
            "2 latas de leite condensado (300 gramas cada)",
            "2 latas de creme de leite (300 gramas cada)",
            "6 colheres (de sopa) de leite ninho (100 gramas cada)",
            "20 morangos"
        },
        {
            "2 latas de leite condensado (300 gramas cada)",
            "2 latas de creme de leite (300 gramas cada)",
            "6 colheres de chocolate em pó (100 gramas cada)"
        },
        {
            "2 xícaras de suco de maracujá (240 ml cada)",
            "4 colheres de amido de milho (5 gramas cada)",
            "6 gemas",
            "1 xícara de água (250 ml)",
            "1 e 1/2 xícara de açúcar (200 gramas)",
            "200 ml de leite",
            "1 colher (de sopa) de manteiga. (50 gramas)"
        }
    };

    private static String[][] ingred_ninho = {
        {"Açúcar", "g"},
        {"Margarina", "g"},
        {"Ovos", "un"},
        {"Farinha de trigo com fermento", "g"},
        {"Creme de Leite", "g"},
        {"Leite Condensado", "g"},
        {"Leite Ninho", "g"},
        {"Morangos", "un"},
        {"Pote 200ml", "un"}
    };
    private static double[][] valores_ninho = {
        {300.0, 300.0, 4.0, 300.0, 600.0, 600.0, 600.0, 20.0, 15.0},
        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
    };

    private static String[][] ingred_dois = {
        {"Açúcar", "g"},
        {"Margarina", "g"},
        {"Ovos", "un"},
        {"Farinha de trigo com fermento", "g"},
        {"Creme de Leite", "g"},
        {"Leite Condensado", "g"},
        {"Chocolate em pó", "g"},
        {"Pote 200ml", "un"}
    };

    private static double[][] valores_dois = {
        {300.0, 300.0, 4.0, 300.0, 600.0, 600.0, 600.0, 15.0},
        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
    };

    private static String[][] ingred_marac = {
        {"Açúcar", "g"},
        {"Margarina", "g"},
        {"Ovos", "un"},
        {"Farinha de trigo com fermento", "g"},
        {"Suco de Maracujá", "ml"},
        {"Amido de milho", "g"},
        {"Água", "ml"},
        {"Leite", "ml"},
        {"Manteiga", "g"},
        {"Pote 200ml", "un"}

    };

    private static double[][] valores_marac = {
        {500.0, 300.0, 10.0, 300.0, 480.0, 20.0, 250.0, 200.0, 50.0, 15.0},
        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
    };

    public static void main(String[] args) {
        do {
            menu_receitas();
            if (!sair) {
                set_receita();
                mostra_receita();
                quantidades_e_valores();
                if (!opcao.equalsIgnoreCase("m")) {
                    exibe_custo_ingredientes();
                    processa_resultado();
                    exibe_resultado();
                }
            }
        } while (!sair);
    }

    private static void menu_receitas() {
        do {

            System.out.println("\n" + linha + "\nBOLO NO POTE (K.I.S.S.)\n\nReceitas:");
            for (int i = 0; i < receitas_nomes.length; i++) {
                System.out.printf(" %d - %s\n", (i + 1), receitas_nomes[i]);
            }
            System.out.print(" 0 - Sair\nDigite o número da receita > ");

            opcao = sc.nextLine();

            if (int_no_intervalo(opcao, 0, 3)) {
                invalida = false;
                num_receita = Integer.parseInt(opcao);
                sair = (num_receita == 0) ? true : false;
            } else {
                System.out.println("Receita inválida!\n\n");
            }
        } while (invalida);

    }

    private static void set_receita() {
        if (num_receita == 1) {
            ingredientes = ingred_ninho;
            valores = valores_ninho;
        } else if (num_receita == 2) {
            ingredientes = ingred_dois;
            valores = valores_dois;
        } else {
            ingredientes = ingred_marac;
            valores = valores_marac;
        }
    }

    private static void mostra_receita() {
        System.out.println(linha + "\nINGREDIENTES:\n\nPara a massa do bolo:");

        // Massa
        for (int i = 0; i < receitas[0].length; i++) {
            System.out.println("• " + receitas[0][i]);
        }

        System.out.println("\nRecheio e cobertura:");

        // Recheio e cobertura
        for (int i = 0; i < receitas[num_receita].length; i++) {
            System.out.println("• " + receitas[num_receita][i]);
        }
        System.out.println();

    }

    private static void quantidades_e_valores() {
        System.out.println(linha + "\nSIMULAÇÃO DE VALORES DE COMPRA:\n"
                + "* Digite a letra 'M' a qualquer momento para voltar ao menu.\n");
        valores_receita[0] = 0.0;
        for (int i = 0; i < ingredientes.length; i++) {
            if (opcao.equalsIgnoreCase("m")) {
                break;
            }
            do {
                invalida = true;
                System.out.print("Quantidade de " + ingredientes[i][0] + " (" + ingredientes[i][1] + "): ");
                opcao = sc.nextLine();
                if (opcao.equalsIgnoreCase("m")) {
                    break;
                }
                if (double_valido(opcao)) {
                    valores[1][i] = Double.parseDouble(opcao);
                    if (valores[1][i] < valores[0][i]) {
                        System.out.printf("Quantidade mínima: %.2f %s. Digite novamente...\n", valores[0][i], ingredientes[i][1]);
                    } else {
                        invalida = false;
                    }
                } else {
                    System.out.println("Quantidade inválida!");
                }
            } while (invalida);
            if (opcao.equalsIgnoreCase("m")) {
                break;
            } else {
                do {
                    invalida = true;
                    System.out.printf("Preço de %.2f " + ingredientes[i][1] + " de " + ingredientes[i][0] + ": ", valores[1][i]);
                    opcao = sc.nextLine();
                    if (opcao.equalsIgnoreCase("m")) {
                        break;
                    }
                    if (double_valido(opcao)) {
                        valores[2][i] = Double.parseDouble(opcao);
                        if (valores[2][i] < 0.0) {
                            System.out.println("Valor inválido para o preço!");
                        } else {
                            invalida = false;
                        }
                    } else {
                        System.out.println("Preço inválido!");
                    }
                } while (invalida);
                valores[3][i] = (valores[2][i] / valores[1][i]) * valores[0][i];
                valores_receita[0] += valores[3][i];

                System.out.println();
            }
        }

        if (!opcao.equalsIgnoreCase("m")) {
            do {
                System.out.print("Rendimento da receita (unidades): ");
                opcao = sc.nextLine();
                if (opcao.equalsIgnoreCase("m")) {
                    break;
                }
                if (int_valido(opcao)) {
                    valores_receita[1] = Double.parseDouble(opcao);
                    if (valores_receita[1] <= 0.0) {
                        System.out.println("Valor inválido para a quantidade.");
                    }
                } else {
                    System.out.println("Quantidade inválida!");
                }
            } while (valores_receita[1] <= 0.0);

            do {
                System.out.print("Preço de venda (unitário): R$ ");
                opcao = sc.nextLine();
                if (opcao.equalsIgnoreCase("m")) {
                    break;
                }
                if (double_valido(opcao)) {
                    valores_receita[2] = Double.parseDouble(opcao);
                    if (valores_receita[2] <= 0.0) {
                        System.out.println("Valor inválido para o preço de venda.");
                    }
                } else {
                    System.out.println("Preço inválido!");
                }

            } while (valores_receita[2] <= 0.0);
        }
    }

    private static void exibe_custo_ingredientes() {

        System.out.printf("\n" + linha + "\nRECEITA: %s\n\nCusto unitário dos ingredientes:\n", receitas_nomes[num_receita - 1]);
        for (int i = 0; i < ingredientes.length; i++) {
            int tamanho = ingredientes[i][0].length();
            int espaco = (30 - tamanho) / 2;
            String alinhamento = repete(". ", espaco + 2);
            System.out.printf("%s" + ((tamanho % 2 != 0)
                    ? (" " + alinhamento)
                    : alinhamento)
                    + ": R$ %.2f\n", ingredientes[i][0], valores[3][i]);
        }
    }

    private static void processa_resultado() {
        // venda_total     = preco_de_venda    * rendimento
        valores_receita[3] = valores_receita[2] * valores_receita[1];

        // lucro_receita_valor  = venda_total - custo_total
        valores_receita[4] = valores_receita[3] - valores_receita[0];

        // lucro_percent_receita   = (lucro_receita_valor / custo_total) *100
        valores_receita[5] = (valores_receita[4] / valores_receita[0]) * 100;

        // custo_unitario = custo_total / rendimento
        valores_receita[6] = valores_receita[0] / valores_receita[1];

        // lucro_unitario_valor = preco_de_venda - custo_unitario
        valores_receita[7] = valores_receita[2] - valores_receita[6];

    }

    private static void exibe_resultado() {


        /*
        valores_receita[0] = custo_total
        valores_receita[1] = rendimento
        valores_receita[2] = preco_de_venda
        valores_receita[3] = venda_total
        valores_receita[4] = lucro_receita_valor
        valores_receita[5] = lucro_percent_receita
        valores_receita[6] = custo_unitario
        valores_receita[7] = lucro_unitario_valor
         */
        System.out.println("\nANÁLISE DE VIABILIDADE:\n");

        System.out.printf("Rendimento  . . . . . . : %.0f unidades\n\n", valores_receita[1]);
        System.out.printf("Preço de venda total. . : R$ %.2f\n", valores_receita[3]);
        System.out.printf("Custo total da receita. : R$ %.2f\n", valores_receita[0]);
        System.out.printf("Lucro por receita . . . : R$ %.2f\n\n", valores_receita[4]);
        System.out.printf("Preço de venda unitário : R$ %.2f\n", valores_receita[2]);
        System.out.printf("Custo unitário  . . . . : R$ %.2f\n", valores_receita[6]);
        System.out.printf("Lucro unitário. . . . . : R$ %.2f\n\n", valores_receita[7]);
        System.out.printf("Lucro por receita . . . : %.2f%%\n", valores_receita[5]);

        String saida = "\nRESULTADO:\nDados os valores, a receita é ";
        if (valores_receita[4] <= 0.0) {
            saida += "IN";
        }
        saida += "VIÁVEL!\n";
        System.out.println(saida);

        System.out.println("\n---------------------------------------------------------------");
    }

// UTIL ------------------------------------------------------------------------
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

    public static String repete(String texto, int quantidade) {
        String ret = "";
        for (int i = 0; i < quantidade; i++) {
            ret += texto;
        }
        return ret;
    }
}

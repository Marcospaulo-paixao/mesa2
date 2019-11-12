package doc;

import java.util.Scanner;

/**
 * @author anisberto
 */
public class Mesa2 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String[] receitas = new String[1];
        int receitasNumeros;
        String projeto = "| PROJETO MATH - BOLO DE POTE |";
        int sair;

        // Formatação Inicio
        for (int i = 0; i < projeto.length(); i++) {
            System.out.print("-");
        }

        System.out.println();
        System.out.println(projeto);

        for (int i = 0; i < projeto.length(); i++) {
            System.out.print("-");
        }

        System.out.println("\n");
        // Formatação Fim

        // Inicio loop
        System.out.println("Deseja iniciar a Seleção de Receitas? \n\n 0 - SIM || 1 - NÃO ");
        sair = input.nextInt();
        System.out.println();

        while (sair < 0 || sair > 1) {
            System.out.println("Informe uma opção Valida!\nDeseja iniciar a Seleção de Receitas? \n\n 0 - SIM || 1 - NÃO ");
            sair = input.nextInt();
            System.out.println();
        }

        while (sair == 0) {
            // Entrada receitas
            for (int i = 0; i < receitas.length; i++) {

                System.out.println("Informe a receita: \n");
                System.out.println(" 2. Leite ninho com morangos |\n 3. Dois amores: |\n 4. Maracujá |");
                receitasNumeros = input.nextInt();

                // Validação receitas
                while (receitasNumeros < 2 || receitasNumeros > 4) {
                    System.out.println("Informe uma receita valida: \n");
                    System.out.println(" 2. Leite ninho com morangos |\n 3. Dois amores: |\n 4. Maracujá |");
                    receitasNumeros = input.nextInt();
                }

                // Seleção receitas
                if (receitasNumeros == 2) {
                    receitas[i] = "Leite ninho com morangos";
                } else if (receitasNumeros == 3) {
                    receitas[i] = "Dois amores";
                } else if (receitasNumeros == 4) {
                    receitas[i] = "Maracujá";
                }

                // Fim inclusão Receitas
                System.out.println("Deseja Finalizar a Seleção de Receitas? \n\t\n 1 - SIM || 0 - NÃO ");
                sair = input.nextInt();

                while (sair < 0 || sair > 1) {
                    System.out.println("Informe uma opção valida!\nDeseja Finalizar a Seleção de Receitas? \n\t\n 1 - SIM || 0 - NÃO ");
                    sair = input.nextInt();
                    System.out.println();
                }

            }
            impresao(receitas);
        }
    }

    // imprimir vetor e formatar
    public static void impresao(String array[]) {
        String convert = array[0];

        System.out.println("\nVocê Selecionou: \n");
        for (int i = 0; i < convert.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
        for (int i = 0; i < convert.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

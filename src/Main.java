import classes.ArquivoTextoEscrita;
import classes.ArquivoTextoLeitura;
import classes.Jogador;
import classes.SortingMethods;

import java.util.Scanner;

public class Main {

    private static final int MAX_PLAYERS = 4000;
    private static final int MAX_PLAYERS_TO_SORT = 464;
    private static final String DATA_BASE_FILE_PATH = "tmp/jogadores.txt"; /*Para enviar ao VERDE, utilizar caminho /tmp/jogadores.txt*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogador[] jogadores = new Jogador[MAX_PLAYERS];
        Jogador[] jogadoresParaOrdenar = new Jogador[MAX_PLAYERS_TO_SORT];
        ArquivoTextoLeitura arqLeitura = new ArquivoTextoLeitura(DATA_BASE_FILE_PATH);
        int id, altura, peso, anoNascimento, i = 0, j = 0, k = 0;
        String nome, universidade, cidadeNascimento, estadoNascimento;
        String input = arqLeitura.ler();

        /*Criacao do arquivo referencia para a base de dados*/
        while (input != null) {
            String[] infoJogador = input.split(",", -1);

            id = Integer.parseInt(infoJogador[0]);
            nome = !infoJogador[1].isEmpty() ? infoJogador[1] : "nao informado";
            altura = Integer.parseInt(infoJogador[2]);
            peso = Integer.parseInt(infoJogador[3]);
            universidade = !infoJogador[4].isEmpty() ? infoJogador[4] : "nao informado";
            anoNascimento = Integer.parseInt(infoJogador[5]);
            cidadeNascimento = !infoJogador[6].isEmpty() ? infoJogador[6] : "nao informado";
            estadoNascimento = !infoJogador[7].isEmpty() ? infoJogador[7] : "nao informado";
            jogadores[i++] = new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
            input = arqLeitura.ler();
        }

        /*Criacao de vetor apenas com os IDs contidos na entrada padrao*/
        input = scanner.nextLine();
        while (!input.equals("FIM")) {
            jogadoresParaOrdenar[j++] = jogadores[Integer.parseInt(input)];
            input = scanner.nextLine();
        }
        scanner.close();
        arqLeitura.fecharArquivo();

        // SortingMethods.bubblesort(jogadoresParaOrdenar);
        // String OUTPUT_FILE_PATH = "jogadoresOrdenados-Bubblesort.txt";
        // ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita(OUTPUT_FILE_PATH);

        // SortingMethods.heapsort(jogadoresParaOrdenar);
        // String OUTPUT_FILE_PATH = "jogadoresOrdenados-Heapsort.txt";
        // ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita(OUTPUT_FILE_PATH);

        SortingMethods.chamaMergesort(jogadoresParaOrdenar);
        String OUTPUT_FILE_PATH = "jogadoresOrdenados-Mergesort.txt";
        ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita(OUTPUT_FILE_PATH);

        /*Imprimir valores no arquivo jogadoresOrdenados*/
        for (i = 0; i < jogadoresParaOrdenar.length; i++) {
            String resultado = String.format("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]", jogadoresParaOrdenar[k].getId(), jogadoresParaOrdenar[k].getNome(),
                    jogadoresParaOrdenar[k].getAltura(), jogadoresParaOrdenar[k].getPeso(), jogadoresParaOrdenar[k].getAnoNascimento(), jogadoresParaOrdenar[k].getUniversidade(),
                    jogadoresParaOrdenar[k].getCidadeNascimento(), jogadoresParaOrdenar[k].getEstadoNascimento());
            arqEscrita.escrever(resultado);
            k++;
        }

        arqEscrita.fecharArquivo();
    }
}
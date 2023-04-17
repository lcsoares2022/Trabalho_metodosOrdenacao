package classes;

public class SortingMethods {
    static int comparacoes = 0, trocas = 0;
    static String log;
    static long inicioExecucao, fimExecucao, tempoExecucao;

    public static void bubblesort(Jogador[] jogadores) {
        String LOG_FILE_PATH = "968722_bolha.txt";
        ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita(LOG_FILE_PATH);
        boolean troca = true;

        inicioExecucao = System.currentTimeMillis();
        for (int i = jogadores.length - 1; i > 0 && troca; i--) {
            if (jogadores[i] == null) continue;
            troca = false;
            for (int j = 0; j < i; j++) {
                int comparacaoCidade = jogadores[j].getCidadeNascimento().compareTo(jogadores[j + 1].getCidadeNascimento());
                int comparacaoNome = jogadores[j].getNome().compareTo(jogadores[j + 1].getNome());

                comparacoes++;
                if (comparacaoCidade > 0) {
                    Jogador temp = jogadores[j];
                    jogadores[j] = jogadores[j + 1];
                    jogadores[j + 1] = temp;
                    trocas++;
                    troca = true;
                } else if (comparacaoNome > 0 && comparacaoCidade == 0) {
                    Jogador temp = jogadores[j];
                    jogadores[j] = jogadores[j + 1];
                    jogadores[j + 1] = temp;
                    trocas++;
                    troca = true;
                    comparacoes++;
                } else comparacoes++;
            }
        }
        fimExecucao = System.currentTimeMillis();
        tempoExecucao = fimExecucao - inicioExecucao;

        /*Imprimir informacoes no log*/
        log = String.format("968722\t%d\t%d\t%d", tempoExecucao, comparacoes, trocas);
        arqEscrita.escrever(log);
        arqEscrita.fecharArquivo();
    }

    public static void heapsort(Jogador[] jogadores) {

        String LOG_FILE_PATH = "968722_heapsort.txt";
        ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita(LOG_FILE_PATH);

        inicioExecucao = System.currentTimeMillis();
        for (int i = jogadores.length / 2 - 1; i >= 0; i--) {
            maxHeapify(jogadores, jogadores.length, i);
        }

        for (int i = jogadores.length - 1; i > 0; i--) {
            Jogador temp = jogadores[0];
            jogadores[0] = jogadores[i];
            jogadores[i] = temp;
            maxHeapify(jogadores, i, 0);
        }
        fimExecucao = System.currentTimeMillis();
        tempoExecucao = fimExecucao - inicioExecucao;

        /*Imprimir informacoes no log*/
        log = String.format("968722\t%d\t%d\t%d", tempoExecucao, comparacoes, trocas);
        arqEscrita.escrever(log);
        arqEscrita.fecharArquivo();
    }

    private static void maxHeapify(Jogador[] arr, int arrLength, int i) {
        int root = i, left = 2 * i + 1, right = 2 * i + 2;

        comparacoes += 2;
        if (left < arrLength && arr[left].getAltura() > arr[root].getAltura()) root = left;
        else if (left < arrLength && arr[left].getAltura() == arr[root].getAltura() && arr[left].getNome().compareTo(arr[root].getNome()) > 0) {
            root = left;
            comparacoes += 3;
        } else comparacoes += 3;

        comparacoes += 2;
        if (right < arrLength && arr[right].getAltura() > arr[root].getAltura()) root = right;
        else if (right < arrLength && arr[right].getAltura() == arr[root].getAltura() && arr[right].getNome().compareTo(arr[root].getNome()) > 0) {
            root = right;
            comparacoes += 3;
        } else comparacoes += 3;

        if (root != i) {
            Jogador temp = arr[i];
            arr[i] = arr[root];
            arr[root] = temp;
            trocas++;
            maxHeapify(arr, arrLength, root);
        }
    }
}

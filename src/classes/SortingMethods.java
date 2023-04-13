package classes;

public class SortingMethods {
    private static final String LOG_FILE_PATH = "968722_bolha.txt";

    public static void bubblesort(Jogador[] jogadores) {
        long inicioExecucao, fimExecucao, tempoExecucao;
        ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita(LOG_FILE_PATH);
        String log;
        int comparacoes = 0, trocas = 0;
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
                } else
                    comparacoes++;
            }
        }
        fimExecucao = System.currentTimeMillis();
        tempoExecucao = fimExecucao - inicioExecucao;

        log = String.format("968722\t%d\t%d\t%d", tempoExecucao, comparacoes, trocas);
        arqEscrita.escrever(log);
        arqEscrita.fecharArquivo();
    }
}

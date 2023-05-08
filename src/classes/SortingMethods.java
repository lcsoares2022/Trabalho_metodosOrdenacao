package classes;

public class SortingMethods {
    static int comparacoes = 0, trocas = 0;
    static String log;
    static long inicioExecucao, fimExecucao, tempoExecucao;

    // # MERGESORT
    public static Jogador[] chamaMergesort(Jogador[] jogadores) {
        String LOG_FILE_PATH = "1425177_mergesort.txt";
        ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita(LOG_FILE_PATH);

        inicioExecucao = System.currentTimeMillis();

        // * chamada do método mergesort
        
        mergesort(jogadores, 0, jogadores.length - 1);
        Jogador[] jogadoresOrdenados = jogadores;

        fimExecucao = System.currentTimeMillis();
        tempoExecucao = fimExecucao - inicioExecucao;

       // * imprimir informações no log
        log = String.format("1425177\t%d\t%d\t%d", tempoExecucao, comparacoes, trocas);
        arqEscrita.escrever(log);
        arqEscrita.fecharArquivo();

        // * eliminando valores nulos
        int contDiffNull = 0;
        for (Jogador jogador : jogadoresOrdenados) {
            if (jogador != null) contDiffNull++;
        }

        Jogador[] resultado = new Jogador[contDiffNull];
        int index = 0;
        for (Jogador jogador : jogadoresOrdenados) {
            if (jogador != null) {
                resultado[index++] = jogador;
            }
        }

        return resultado;
    }

     public static void mergesort(Jogador[] jogadores, int inicio, int fim){
         if(inicio < fim) {
             int meio = (inicio + fim) / 2;
             mergesort(jogadores, inicio, meio);
             mergesort(jogadores, meio + 1, fim);
             combinar(jogadores, inicio, meio, fim);
         }
    }

   
    public static void combinar(Jogador[] jogadores, int inicio, int meio, int fim) {
        int n1, n2, i, j, k;
    
        // Definindo tamanho dos subvetores
        n1 = meio - inicio + 1;
        n2 = fim - meio;
    
        // Criando subvetores temporários
        Jogador[] a1 = new Jogador[n1];
        Jogador[] a2 = new Jogador[n2];
    
        // Inicializando o primeiro subarray
        for (i = 0; i < n1; i++) {
            a1[i] = jogadores[inicio + i];
        }
    
        for (j = 0; j < n2; j++) {
            a2[j] = jogadores[meio + j + 1];
        }
    
        // Intercalação propriamente dita
        for (i = j = 0, k = inicio; (i < n1 && j < n2); k++) {
            int comparacaoUniversidade = a1[i].getUniversidade().compareTo(a2[j].getUniversidade());
            comparacoes++;
            if (comparacaoUniversidade < 0) {
                jogadores[k] = a1[i++];
                trocas++;
            } else if (comparacaoUniversidade > 0) {
                jogadores[k] = a2[j++];
                trocas++;
                comparacoes++;
            } else {
                int comparacaoNome = a1[i].getNome().compareTo(a2[j].getNome());
                comparacoes+=2; //*comparacao para o else-if de cima e comparacao para o próximo if
                if (comparacaoNome < 0) {
                    jogadores[k] = a1[i++];
                    trocas++;
                } else if (comparacaoNome > 0) {
                    jogadores[k] = a2[j++];
                    trocas++;
                    comparacoes++;
                }
                else 
                    comparacoes++;                  
            }
        }
    
        // Verificando se todos os elementos do subarray a1 foram intercalados
        while (i < n1) {
            jogadores[k++] = a1[i++];
        }
    
        // Verificando se todos os elementos do subarray a2 foram intercalados
        while (j < n2) {
            jogadores[k++] = a2[j++];
        }
    }
    
    



    
    
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

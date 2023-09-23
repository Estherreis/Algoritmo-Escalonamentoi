import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProcessoResource processoResource = new ProcessoResource();

        Scanner scan = new Scanner(System.in);

        System.out.println("------------------ PRIORIDADE COOPERATIVO ------------------");
        System.out.print("Digite a quantidade de processos que deseja executar: ");

        int quantidadeProcessos= scan.nextInt();

        processoResource.GerarProcessos(quantidadeProcessos);

        List<Processo> processos = processoResource.getProcessosParaExecucao();
        List<Processo> ordemCorreta = new ArrayList<>();

        int tempoExecucao = 0;

        for (int i = 0; i<processos.size(); i++) {

            if (i == 0) {
                tempoExecucao = processos.get(i).getArrivalTime();
            } else {
                tempoExecucao += ordemCorreta.get(ordemCorreta.size()-1).getBurstTime();
            }

            List<Processo> aux = processoResource.getMaxPriority(tempoExecucao, i);

            aux.forEach(processo -> {
                ordemCorreta.add(processo);
                processoResource.finishProcess(processo);
            });
        }

        System.out.println("------------------ EXECUÇÃO FINALIZADA ------------------\n");
        System.out.println("------------------ ORDEM DE EXECUÇÃO ------------------");

        final int[] countOrdemExecucao = {1};

        ordemCorreta.forEach(processo -> {
            System.out.println(countOrdemExecucao[0] + "º: " + processo);
            countOrdemExecucao[0]++;
        });

    }
}
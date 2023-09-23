import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProcessoResource {

    private static List<Processo> processosParaExecucao = new ArrayList<>();

    public Processo CreateProcess(int count) {

        List<Integer> aux = new ArrayList<>();

        return new Processo(
                count,
                GenerateRandomNumber(0, 15),
                GenerateRandomNumber(1, 25),
                GenerateRandomNumber(1, 5)
        );
    }

    public Integer GenerateRandomNumber(int firstInterval, int lastInterval, List<Integer> numbersGenerates) {
        Random random = new Random();
        int numeroAleatorio;

        do {
            numeroAleatorio = random.nextInt(lastInterval - firstInterval + 1) + firstInterval;
        } while (numbersGenerates.contains(numeroAleatorio));

        return numeroAleatorio;
    }

    public Integer GenerateRandomNumber(int firstInterval, int lastInterval) {
        Random random = new Random();
        return random.nextInt(lastInterval - firstInterval + 1) + firstInterval;
    }

    public void GerarProcessos(int quantidadeProcessos) {
        int count = 0;
        for(int i = 0; i < quantidadeProcessos; i++) {
            processosParaExecucao.add(this.CreateProcess(count));
            count++;
        }
        Collections.sort(processosParaExecucao);
    }

    public List<Processo> getMaxPriority(int executionTime, int index){
        List<Processo> aux = new ArrayList<>();

        processosParaExecucao.forEach(processo -> {
            if (processo.getArrivalTime() <= executionTime) {
                if (!aux.stream().map(x -> x.getArrivalTime()).toList().contains(processo.getArrivalTime())) {
                    aux.add(processo);
                }
            }
        });

        if (aux.isEmpty()) {
            aux.add(processosParaExecucao.get(index));
        }

        Collections.sort(aux, (processo1, processo2) -> processo2.compareToPriority(processo1));

        return aux;
    }

    public List<Processo> getProcessosParaExecucao() {
        return processosParaExecucao;
    }

    public void finishProcess (Processo process) {
        processosParaExecucao.remove(process);
    }
}

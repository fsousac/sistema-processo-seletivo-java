import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        String [] candidatos = selecaoCandidatos();
        ligacoes(candidatos);
//        analisarCandidato(1900);
//        analisarCandidato(2200);
//        analisarCandidato(2000);
    }

    static void ligacoes(String [] candidatos){
        for (String candidato: candidatos){
            int numTentativas = 0;
            while (numTentativas < 3){
                if (atender()){
                    if (numTentativas == 0){
                        System.out.println("O candidato " + candidato + " atendeu na primeira ligação.");
                    } else if (numTentativas == 1) {
                        System.out.println("O candidato " + candidato + " atendeu após " + numTentativas + " ligação.");
                    }else {
                        System.out.println("O candidato " + candidato + " atendeu após " + numTentativas + " ligações.");
                    }
                    break;
                }else {
                    numTentativas++;
                }
                if (numTentativas == 3){
                    System.out.println("O candidato " + candidato + " não atendeu as ligações.");
                }
            }

        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static String [] selecaoCandidatos(){

        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "MARCOS","RENATO", "ALFREDO","MARILIA","JORGE","MATHEUS","VITOR","LAIS"};
        int NumSelectedCandidatos = 0;
        int atualCanditado = 0;
        double baseSalary = 2000.0;
        String [] candidatosSelecionados = new String [5];

        while (NumSelectedCandidatos < 5){
            double salarioPretendido = valorPretendido();
            if (salarioPretendido<=baseSalary && atualCanditado < candidatos.length){
                candidatosSelecionados[NumSelectedCandidatos] = candidatos[atualCanditado];
                NumSelectedCandidatos++;
            } else if (atualCanditado+1 > candidatos.length) {
                break;
            }
            atualCanditado++;
        }
        System.out.println(Arrays.toString(candidatosSelecionados));
        return candidatosSelecionados;
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
    static void analisarCandidato (double salary){
        double baseSalary = 2000.0;
        if (baseSalary>salary){
            System.out.println("Ligar para o candidato.");
        } else if (baseSalary == salary) {
            System.out.println("Ligar para o canditado com contra proposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos.");
        }
    }
}

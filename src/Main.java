import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        System.out.println("Sistema de Processo Seletivo");

        System.out.println("Analisando candidatos. Aguarde...");
        selecionaCandidato();
    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1700, 2300);
    }

    public static boolean aceitaProposta() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static ArrayList<String> adicionaCandidato(String candidato) {
        ArrayList<String> candidatosAprovados = new ArrayList<>();
        candidatosAprovados.add(candidato);
        return candidatosAprovados;
    }

    public static boolean analisaCandidatos(double salarioPretendido, double salarioBase, String candidato) {
        if (salarioBase > salarioPretendido ) {
            System.out.println("Ligar para o Candidato");
            System.out.println("Candidato Selecionado");
            adicionaCandidato(candidato);
            return true;
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o Candidato com uma contra proposta");
            if (aceitaProposta()){
                System.out.println("Proposta Aceita. Candidato Selecionado");
                adicionaCandidato(candidato);
                return true;
            }
        } else {
            System.out.println("Aguardar o resultado dos demais candidatos.");
        }
        return false;
    }

    public static void selecionaCandidato() {
        System.out.println("Recebendo lista de candidatos.");
        String[] candidatos = {
                "Alice", "Bruno", "Carla", "Daniel", "Eduarda",
                "Fernando", "Gabriela", "Henrique", "Isabela", "João",
                "Karen", "Leonardo", "Mariana", "Natália", "Otávio"
        };

        double salarioBase = 2000.00;
        ArrayList<String> candidatosAprovados = new ArrayList<>();
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            for (String candidato: candidatos){
                System.out.println("Analisando o(a) candidato(a): " + candidato);
                double salarioPretendido = valorPretendido();
                if (analisaCandidatos(salarioPretendido, salarioBase, candidato)) {
                    candidatosAprovados.add(candidato);
                    candidatosSelecionados++;
                }

                candidatoAtual++;
            }
        }

        System.out.println("Candidatos Selecionados: " + candidatosAprovados);

    }

}
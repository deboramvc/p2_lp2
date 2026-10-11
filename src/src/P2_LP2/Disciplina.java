package P2_LP2;

import java.util.Arrays;

/**
 * A classe Disciplina representa uma disciplina acadêmica, onde é gerenciado
 * o nome, o número de horas de estudo, a quantidade de notas, as notas, os pesos
 * e calcula-se a média.
 *
 * @author Débora Marques Vieira Campos
 */
public class Disciplina {
    private String nomeDisciplina;
    private int numeroHorasEstudo;
    private double[] notas;
    private int[] pesos;
    private boolean usaMediaPonderada;

    /**
     * Construtor que inicializa somente com o nome da disciplina
     * como parametro, sem pesos. Por padrão, uma disciplina tem
     * previamente 4 notas.
     *
     * @param nomeDisciplina nome da disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.notas = new double[4];
        this.pesos = null;
        this.usaMediaPonderada = false;
    }

    /**
     * Construtor que inicializa com o nome da disciplina e a
     * quantidade de notas, sem pesos.
     *
     * @param nomeDisciplina nome da disciplina.
     * @param qtdeDeNotas quantidade de notas dessa disciplina.
     */
    public Disciplina(String nomeDisciplina, int qtdeDeNotas){
        this.nomeDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.notas = new double[qtdeDeNotas];
        this.pesos = null;
        this.usaMediaPonderada = false;
    }

    /**
     * Construtor que inicializa com todos os parametros personalizados.
     * Há necessidade de uma média ponderada.
     *
     * @param nomeDisciplina nome da disciplina.
     * @param numeroDeNotas quantidade de notas.
     * @param pesos Array de inteiros que representa os pesos de cada nota,
     * respectivamente.
     */
    public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos){
        this.nomeDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = pesos;
        this.usaMediaPonderada = true;
    }

    /**
     * Adiciona horas de estudo de forma acumulativa.
     *
     * @param horas quantidade de horas a serem somadas.
     */
    public void cadastraHoras(int horas){
        numeroHorasEstudo += horas;
    }

    /**
     * Cadastra qual a nota e o seu valor.
     *
     * @param nota o numero da nota, exemplo: (1º, 2º, 3º, 4º)
     * @param valorNota o valor da nota, exemplo: (10.0, 6.5)
     */
    public void cadastraNota(int nota, double valorNota){
        if (nota >= 1 && nota <= notas.length) {
            // nota - 1 representa o indice do array
            notas[nota-1] = valorNota;
        }
    }

    /**
     * Calcula a média com base na necessidade de média ponderada ou não.
     *
     * @return a media calculada.
     */
    public double calculaMedia() {
        double somaNotas = 0;
        int somaPesos = 0;

        if (usaMediaPonderada) {
            for (int i = 0; i < notas.length; i++) {
                somaNotas += notas[i] * pesos[i];
                somaPesos += pesos[i];
            }
        } else if (!usaMediaPonderada) {
            for (int i = 0; i < notas.length; i++) {
                somaNotas += notas[i];
            }
            return somaNotas / notas.length;
        }
        // evita a divisão por 0
        if (somaPesos == 0){
            return 0.0;
        }
        return somaNotas / somaPesos;
    }

    /**
     * Diz se o aluno foi aprovado ou não. Aprovado: média >= 7.0.
     *
     * @return true se aprovado, false se reprovado.
     */
    public boolean aprovado(){
        double media = calculaMedia();
        if (media>= 7.0){
            return true;
        }
        return false;
    }

    /**
     * Representação textual com os dados da disciplina.
     * formato: Nome da disciplina, horas de estudo, média, array das notas.
     *
     * @return String formatada dos dados.
     */
    public String toString(){
        double media = calculaMedia();
        return nomeDisciplina + " " + numeroHorasEstudo + " " +
                media + " " + Arrays.toString(this.notas);
    }
}

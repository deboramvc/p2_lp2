package P2_LP2;

/**
 * A classe Descanso define o status do aluno, se ele está ou não descansado.
 *
 * @author Débora Marques Vieira Campos
 */
public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;

    /**
     * O construtor inicializa com os dados zerados.
     */
    public Descanso(){
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    /**
     * Recebe as horas de descanso do aluno.
     *
     * @param valor horas de descanso.
     */
    public void defineHorasDescanso(int valor) {
        horasDescanso = valor;
    }

    /**
     * Recebe o número de semanas dedicadas.
     *
     * @param valor numero de semanas.
     */
    public void defineNumeroSemanas(int valor) {
        numeroSemanas = valor;
    }

    /**
     * Aluno tem status "descansado" quando a média de horas por semana é maior/igual a 26.
     *
     * @return o status do aluno.
     */
    public String getStatusGeral(){
        if (numeroSemanas == 0 || horasDescanso == 0){
            return "cansado";
        }
        double media = (double) horasDescanso / numeroSemanas;

        if (media >= 26){
            return "descansado";
        } else {
            return "cansado";
        }
    }
}

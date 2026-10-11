package P2_LP2;

/**
 * A classe RegistraTempoOnline representa o tempo dedicado pelo usuario
 * a determinada disciplina. Toda disciplina tem um tempo online esperado.
 *
 * @author Débora Marques Vieira Campos
 */
public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoOnlineEsperado;

    /**
     * O construtor inicializa somente com o nome da disciplina como
     * parametro, sem tempo esperado. Por padrão, quando não declarado,
     * o tempo esperado deve ser de 120hrs.
     *
     * @param nomeDisciplina nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnline = 0;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * O construtor inicializa com o nome da disciplina e o tempo online
     * esperado personalizado pelo usuário.
     *
     * @param nomeDisciplina nome da disciplina.
     * @param tempoOnlineEsperado tempo online esperado.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnline = 0;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Adiciona o tempo online de forma acumulativa.
     *
     * @param tempo tempo online.
     */
    public void adicionaTempoOnline(int tempo){
        tempoOnline += tempo;
    }

    /**
     * Declara se a meta de tempo esperado já foi atingida.
     *
     * @return true se atingiu a meta, false se não.
     */
    public boolean atingiuMetaTempoOnline() {
        return tempoOnline >= tempoOnlineEsperado;
    }

    /**
     * Representação textual dos dados de tempo da disciplina.
     * Formato: nome, tempo online / tempo online esperado
     *
     * @return String de dados formatado.
     */
    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
    }
}
package P2_LP2;

/**
 * Representa um resumo individual com tema e conteudo próprio.
 *
 * @author Débora Marques Vieira Campos
 */
public class Resumo {
    private String tema;
    private String conteudo;

    /**
     * Construtor que inicializa o resumo com um tema e um conteúdo definidos.
     *
     * @param tema tema do resumo.
     * @param conteudo conteúdo do resumo.
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorno o tema associado ao resumo.
     *
     * @return tema do resumo.
     */
    public String getTema() {
        return this.tema;
    }

    /**
     * Retorna o conteudo associado ao resumo.
     *
     * @return conteudo do resumo
     */
    public String getConteudo(){
        return this.conteudo;
    }

    /**
     * Altera o conteudo do resumo individualmente.
     *
     * @param conteudo conteudo do resumo.
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Altera p tema do resumo individualmente.
     *
     * @param tema tema do resumo.
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * Retorna uma representação textual do resumo.
     * Formato "tema:conteudo".
     *
     * @return Uma string formatada.
     */
    @Override
    public String toString() {
        return this.tema + ":" + this.conteudo;
    }
}

package P2_LP2;

/**
 * A classe RegistroResumos representa e gerencia os temas e os conteúdos de resumos.
 * Permite controlar o armazenamento e a quantidade de resumos cadastrados.
 *
 * @author Débora Marques Vieira Campos
 */
public class RegistroResumos {
        private String[] temas;
        private String[] conteudos;
        private int quantidadeResumosExistentes;
        private int proximo;

    /**
     * Construtor que inicializa com o número máximo de resumos que podem ser cadastrados.
     * O array de temas e de conteudos terá o tamanho baseado nesse número.
     *
     * @param numeroDeResumos numero de resumos a serem cadastrados.
     */
    public RegistroResumos(int numeroDeResumos) {
            temas = new String[numeroDeResumos];
            conteudos = new String[numeroDeResumos];
            quantidadeResumosExistentes = 0;
            proximo = 0;
        }

    /**
     * Adiciona o tema e o conteudo em seus respectivos Arrays.
     *
     * @param tema tema.
     * @param conteudo conteudo.
     */
    public void adiciona(String tema, String conteudo) {

        // se o tema já existir, ele não é adicionado e a metodo para.
        if (temResumo(tema)) {
            return;
        }

        temas[proximo] = tema;
        conteudos[proximo] = conteudo;

        // Verifica a quantidade de resumos que já foram adicionados
        if (quantidadeResumosExistentes < temas.length) {
            quantidadeResumosExistentes++;
        }

        // Indica o indice, onde o próximo tema será inserido no Array, zera se chegar ao seu máx.
        proximo++;
        if (proximo == temas.length) {
            proximo = 0;
        }
    }

    /**
     * O metodo serve para "concatenar" o tema ao seu conteudo. Cria um novo Array com tamanho
     * igual a quantidade de resumos que foram adicionados, em cada indice "tema : conteudo".
     *
     * @return Array de resumos.
     */
    public String[] pegaResumos() {
        String[] resumos = new String[quantidadeResumosExistentes];
        for (int i = 0; i < quantidadeResumosExistentes; i++) {
            resumos[i] = temas[i] + ": " + conteudos[i];
        }
        return resumos;
    }

    /**
     * Representação textual dos dados cadastrados.
     * Formato: quantidade de resumos cadastrados. \n temas (separados por '|').
     *
     * @return String formatada dos dados.
     */
    public String imprimeResumos() {
        String resultado = "- " + quantidadeResumosExistentes + " resumo(s) cadastrado(s)\n";
        resultado += "- ";
        for (int i = 0; i < quantidadeResumosExistentes; i++) {
            resultado += temas[i];

            // evita que no ultimo tema seja adicionado " | "
            if (i < quantidadeResumosExistentes - 1) {
                resultado += " | ";
            }
        }
        return resultado;
    }

    /**
     * @return a quantidade de resumos cadastrados.
     */
    public int conta() {
        return quantidadeResumosExistentes;
    }

    /**
     * Confere se o tema passado como parametro já existe no Array de temas,
     * evitando que seja adicionado duas vezes.
     *
     * @param tema tema a ser analisado.
     * @return true se já adicionado antes, false se não.
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidadeResumosExistentes; i++) {
            if (temas[i].equals(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Recebe uma palavra, para cada conteudo de um tema que essa palavra é
     * encontrada, salva-se o tema em resultado em um array do tamanho da quantidade
     * de resumos cadastrados.
     *
     * @param chaveDeBusca palavra a ser procurada.
     * @return Array de respostas.
     */
    public String[] busca(String chaveDeBusca){
        String chave = chaveDeBusca.toLowerCase();
        String[] resultado = new String[quantidadeResumosExistentes];
        int contador = 0;

        for (int i = 0; i < this.quantidadeResumosExistentes; i ++) {
            if (conteudos[i].toLowerCase().contains(chave)) {
                resultado[contador] = temas[i];
                contador++;
            }
        }
        //* O Array "resposta" garante que não haverá espaços "null"
        String[] resposta = new String[contador];
        for (int i = 0; i < contador; i++){
            resposta[i] = resultado[i];
        }

        java.util.Arrays.sort(resposta);
        return resposta;
    }
}

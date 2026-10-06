package P2_LP2;

    public class RegistroResumos {

         private String[] temas;
        private String[] conteudos;
        private int quantidade;
        private int proximo;

        public RegistroResumos(int numeroDeResumos) {
            temas = new String[numeroDeResumos];
            conteudos = new String[numeroDeResumos];
            quantidade = 0;
            proximo = 0;
        }

        public void adiciona(String tema, String conteudo) {

            if (temResumo(tema)) {
                return;
            }
            temas[proximo] = tema;
            conteudos[proximo] = conteudo;
            if (quantidade < temas.length) {
                quantidade++;
            }
            proximo++;
            if (proximo == temas.length) {
                proximo = 0;
            }
        }

        public String[] pegaResumos() {
            String[] resumos = new String[quantidade];
            for (int i = 0; i < quantidade; i++) {
                resumos[i] = temas[i] + ": " + conteudos[i];
            }
            return resumos;
        }

        public String imprimeResumos() {
            String resultado = "- " + quantidade + " resumo(s) cadastrado(s)\n";
            resultado += "- ";
            for (int i = 0; i < quantidade; i++) {
                resultado += temas[i];

                if (i < quantidade - 1) {
                    resultado += " | ";
                }
            }
            return resultado;
        }

        public int conta() {
            return quantidade;
        }

        public boolean temResumo(String tema) {

            for (int i = 0; i < quantidade; i++) {
                if (temas[i].equals(tema)) {
                    return true;
                }
            }
            return false;
        }
    }
}

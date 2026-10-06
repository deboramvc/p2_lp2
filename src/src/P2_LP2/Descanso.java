package P2_LP2;

public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;

    public void defineHorasDescanso(int valor) {
        horasDescanso = valor;
    }

    public void defineNumeroSemanas(int valor){
        numeroSemanas = valor;
    }

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

package P2_LP2;

import java.util.ArrayList;
import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int numeroHorasEstudo;
    private double[] notas;
    private int[] pesos;
    private boolean usaMediaPonderada;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.notas = new double[4];
        this.pesos = null;
        this.usaMediaPonderada = false;
    }

    public Disciplina(String nomeDisciplina, int qtdeDeNotas){
        this.nomeDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.notas = new double[qtdeDeNotas];
        this.pesos = null;
        this.usaMediaPonderada = false;
    }

    public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos){
        this.nomeDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = pesos;
        this.usaMediaPonderada = true;
    }

    public void cadastraHoras(int horas){
        numeroHorasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota){
        if (nota >= 1 && nota <= notas.length) {
            notas[nota-1] = valorNota;
        }
    }

    public double calculaMedia() {
        double somaNotas = 0;
        int somaPesos = 0;

        if (usaMediaPonderada) {
            for (int i = 0; i < this.notas.length; i++) {
                somaNotas += notas[i] * pesos[i];
                somaPesos += pesos[i];
            }
        } else if (!usaMediaPonderada) {
            for (int i = 0; i < this.notas.length; i++) {
                somaNotas += notas[i];
            }
            return somaNotas / notas.length;
        }
        if (somaPesos == 0){
            return 0.0;
        }
        return somaNotas / somaPesos;
    }

    public boolean aprovado(){
        double media = calculaMedia();
        if (media>= 7.0){
            return true;
        }
        return false;
    }

    public String toString(){
        double media = calculaMedia();
        return nomeDisciplina + " " + numeroHorasEstudo + " " +
                media + " " + Arrays.toString(this.notas);
    }
}

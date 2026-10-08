package P2_LP2;

public class Disciplina {
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private String nomeDisciplina;
    private int numeroHorasEstudo;
    private int numeroDeNotas;
    private int[] pesos;
    private double mediaPonderada;

    // fazer um array das novas com até então, tamanho 4, até ser especificada quantas notas existem

    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
        this.nota4 = 0;
    }

    public Disciplina(int qtdeDeNotas){
        this.numeroDeNotas = qtdeDeNotas;
    }

    public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos){
    }

    public void cadastraHoras(int horas){
        numeroHorasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota){
        if (nota == 1){
            this.nota1 = valorNota;
        } else if (nota == 2){
            this.nota2 = valorNota;
        } else if (nota == 3){
            this.nota3 = valorNota;
        } else if (nota == 4){
            this.nota4 = valorNota;
        }
        // aqui se vc usar um array fica melhor para evitar esses if
    }

    public boolean aprovado(){
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        if (media >= 7) {
            return true;
        }
        return false;
    }

    public String toString(){
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        return nomeDisciplina + " " + numeroHorasEstudo + " " + media + " " +
                "[" + " " + nota1 + ", " + nota2 + ", " + nota3 + ", " + nota4 + " "
                + "]";
        //aqui compensa vc botar , entre as notas pq na saída ta com ,
    }


}

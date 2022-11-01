import javax.swing.*;
import java.util.Random;

public class Corredor implements Runnable {

    private String nome;
    private int tempoEspera, distancia, velocidade;
    private int distanciaPercorrida = 0;
    private JProgressBar progresso;
    private double porcentagemAvanco;

    public Corredor(String nome, int tempoEspera, int distancia, int velocidade, JProgressBar progresso) {
        this.nome = nome;
        this.tempoEspera = tempoEspera;
        this.distancia = distancia;
        this.velocidade = velocidade;
        this.progresso = progresso;
    }

    @Override
    public synchronized void run() {
        Random random = new Random();
        try {
            Thread.sleep(this.tempoEspera);
            while (InterfaceCorrida.executar) {
                this.velocidade = random.nextInt(10);
                this.distanciaPercorrida += this.velocidade;
                this.porcentagemAvanco += ((this.velocidade) / (this.distancia / 100));
                this.progresso.setValue((int) Math.round(this.porcentagemAvanco * 100) / 100);
                System.out.println("\n\nJogador " + this.nome + "\nVelocidade: " + this.velocidade + "\nDistancia percorrida: " + this.distanciaPercorrida);
                Thread.sleep(this.tempoEspera);
                if (Math.round(this.porcentagemAvanco * 100) / 100 >= 100) {
                    InterfaceCorrida.executar = false;
                    JOptionPane.showMessageDialog(null, "O " + this.nome + " ganhou!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

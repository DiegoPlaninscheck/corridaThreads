import java.util.Random;

public class Corredor implements Runnable {

    private String nome;
    private int tempoEspera, distancia, velocidade;
    private int distanciaPercorrida;

    public Corredor(String nome, int tempoEspera, int distancia, int velocidade) {
        this.nome = nome;
        this.tempoEspera = tempoEspera;
        this.distancia = distancia;
        this.velocidade = velocidade;
    }

    @Override
    public synchronized void run() {
        Random random = new Random();
        try {
            Thread.sleep((long) Math.random() * 30000);
            while (true) {
                int velo = random.nextInt(10);
                this.velocidade = velo;
                System.out.println("Velocidade do " + this.nome + ": " + velo);
                this.distanciaPercorrida += velo;
                Thread.sleep((long) Math.random() * 50000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.util.Random;
import java.util.Scanner;

public class Corrida {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Quantos corredores: 1 a 15");
        int numero = sc.nextInt();
        System.out.println("Tempo de espera: ");
        int tempo = sc.nextInt();
        System.out.println("Distancia: ");
        int distancia = sc.nextInt();
        Random random = new Random();
        for (int i = 1; i <= numero; i++) {
            int velocidade = random.nextInt(10);
            new Thread(new Corredor("Corredor " + i, tempo, distancia, velocidade), "Corredor " + i).start();
        }
    }
}

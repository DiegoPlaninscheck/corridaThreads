import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterfaceCorrida extends JFrame implements Runnable {
    private JTextField qtdJogadoresInput;
    private JTextField esperaInput;
    private JTextField distanciaInput;
    private JButton botaoIniciar;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    private JProgressBar progressBar5;
    private JProgressBar progressBar6;
    private JProgressBar progressBar7;
    private JProgressBar progressBar8;
    private JProgressBar progressBar9;
    private JProgressBar progressBar10;
    private JProgressBar progressBar11;
    private JProgressBar progressBar12;
    private JProgressBar progressBar13;
    private JProgressBar progressBar14;
    private JProgressBar progressBar15;
    private JPanel corrida;

    private static ArrayList<Thread> listaThreads = new ArrayList<>();
    public static boolean executar = true;
    private static List<JProgressBar> listaProgressos = new ArrayList<>();

    public InterfaceCorrida() {
        criarComponentes();
        botaoIniciar.addActionListener(e -> {
            if (!(qtdJogadoresInput.getText().equals("") || esperaInput.getText().equals("") || distanciaInput.getText().equals(""))) {
                Random random = new Random();
                for (int i = 1; i <= retornaQuantidadeJogadores(); i++) {
                    int velocidade = random.nextInt(10);
                    listaThreads.add(new Thread(new Corredor("Corredor " + i,
                            Integer.parseInt(esperaInput.getText()),
                            Integer.parseInt(distanciaInput.getText()), velocidade, listaProgressos.get(i)), "Corredor " + i));
                    for (int j = 1; j <= retornaQuantidadeJogadores(); j++) {
                        listaProgressos.get(j).setVisible(true);
                        listaProgressos.get(j).setSize(Integer.parseInt(distanciaInput.getText()), Integer.parseInt(distanciaInput.getText()));
                    }
                }
                for (int i = 0; i < listaThreads.size(); i++) {
                    listaThreads.get(i).start();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            }
        });
    }

    private int retornaQuantidadeJogadores() {
        switch (Integer.parseInt(qtdJogadoresInput.getText())) {
            case 1 -> {
                return 1;
            }
            case 2 -> {
                return 2;
            }
            case 3 -> {
                return 3;
            }
            case 4 -> {
                return 4;
            }
            case 5 -> {
                return 5;
            }
            case 6 -> {
                return 6;
            }
            case 7 -> {
                return 7;
            }
            case 8 -> {
                return 8;
            }
            case 9 -> {
                return 9;
            }
            case 10 -> {
                return 10;
            }
            case 11 -> {
                return 11;
            }
            case 12 -> {
                return 12;
            }
            case 13 -> {
                return 13;
            }
            case 14 -> {
                return 14;
            }
            case 15 -> {
                return 15;
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public void run() {
        if (!isVisible()) {
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "A janela ja esta aberta");
        }
    }

    private void criarComponentes() {
        listaProgressos.add(progressBar1);
        listaProgressos.add(progressBar2);
        listaProgressos.add(progressBar3);
        listaProgressos.add(progressBar4);
        listaProgressos.add(progressBar5);
        listaProgressos.add(progressBar6);
        listaProgressos.add(progressBar7);
        listaProgressos.add(progressBar8);
        listaProgressos.add(progressBar9);
        listaProgressos.add(progressBar10);
        listaProgressos.add(progressBar11);
        listaProgressos.add(progressBar12);
        listaProgressos.add(progressBar13);
        listaProgressos.add(progressBar14);
        listaProgressos.add(progressBar15);

        for (int i = 0; i < listaProgressos.size(); i++) {
            listaProgressos.get(i).setVisible(false);
        }

        setContentPane(corrida);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        run();
        pack();
    }

    public static void main(String[] args) {
        InterfaceCorrida telaBuffer = new InterfaceCorrida();
    }
}

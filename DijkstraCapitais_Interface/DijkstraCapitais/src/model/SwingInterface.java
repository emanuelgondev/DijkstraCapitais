package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SwingInterface {
    private final Grafo grafo;
    private JFrame frame;
    private JComboBox<String> regiaoOrigemComboBox;
    private JComboBox<String> regiaoDestinoComboBox;
    private JComboBox<String> origemComboBox;
    private JComboBox<String> destinoComboBox;
    private JLabel resultadoLabel;

    private final Map<String, String[]> regioesCapitais;

    public SwingInterface() {
        this.grafo = DistanciasCapitais.criarGrafoCapitais();
        this.regioesCapitais = criarRegioesCapitais();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Calculadora de Distâncias entre Capitais");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout(10, 10)); // Espaçamento entre os painéis

        // Título
        JLabel tituloLabel = new JLabel("Calculadora de Menor Caminho entre Capitais", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Painel central para seleção de capitais
        JPanel selecaoPanel = new JPanel(new GridLayout(6, 2, 5, 5)); // 6 linhas, 2 colunas, espaçamento de 5px
        selecaoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margens internas

        regiaoOrigemComboBox = new JComboBox<>(regioesCapitais.keySet().toArray(new String[0]));
        regiaoOrigemComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarCapitaisOrigem();
            }
        });

        regiaoDestinoComboBox = new JComboBox<>(regioesCapitais.keySet().toArray(new String[0]));
        regiaoDestinoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarCapitaisDestino();
            }
        });

        origemComboBox = new JComboBox<>();
        destinoComboBox = new JComboBox<>();
        atualizarCapitaisOrigem(); // Inicializa com a primeira região
        atualizarCapitaisDestino(); // Inicializa com a primeira região

        selecaoPanel.add(new JLabel("Selecione a região de origem:"));
        selecaoPanel.add(regiaoOrigemComboBox);
        selecaoPanel.add(new JLabel("Selecione a capital de origem:"));
        selecaoPanel.add(origemComboBox);
        selecaoPanel.add(new JLabel("Selecione a região de destino:"));
        selecaoPanel.add(regiaoDestinoComboBox);
        selecaoPanel.add(new JLabel("Selecione a capital de destino:"));
        selecaoPanel.add(destinoComboBox);

        frame.add(selecaoPanel, BorderLayout.CENTER);

        // Painel inferior para botão e resultado
        JPanel resultadoPanel = new JPanel(new BorderLayout(5, 5));
        resultadoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margens internas

        JButton calcularButton = new JButton("Calcular Menor Caminho");
        calcularButton.setFont(new Font("Arial", Font.PLAIN, 14));
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDistancia();
            }
        });

        resultadoLabel = new JLabel("Resultado: ", JLabel.CENTER);
        resultadoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultadoLabel.setForeground(Color.BLUE);

        resultadoPanel.add(calcularButton, BorderLayout.NORTH);
        resultadoPanel.add(resultadoLabel, BorderLayout.CENTER);

        frame.add(resultadoPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private Map<String, String[]> criarRegioesCapitais() {
        Map<String, String[]> regioes = new HashMap<>();
        regioes.put("Norte", new String[]{"Rio Branco", "Porto Velho", "Manaus", "Boa Vista", "Macapá", "Belém", "Palmas"});
        regioes.put("Nordeste", new String[]{"São Luís", "Teresina", "Fortaleza", "Natal", "João Pessoa", "Recife", "Maceió", "Aracaju", "Salvador"});
        regioes.put("Centro-Oeste", new String[]{"Brasília", "Goiânia", "Cuiabá", "Campo Grande"});
        regioes.put("Sudeste", new String[]{"Vitória", "Belo Horizonte", "Rio de Janeiro", "São Paulo"});
        regioes.put("Sul", new String[]{"Curitiba", "Florianópolis", "Porto Alegre"});
        return regioes;
    }

    private void atualizarCapitaisOrigem() {
        String regiaoSelecionada = (String) regiaoOrigemComboBox.getSelectedItem();
        String[] capitais = regioesCapitais.get(regiaoSelecionada);
        origemComboBox.setModel(new DefaultComboBoxModel<>(capitais));
    }

    private void atualizarCapitaisDestino() {
        String regiaoSelecionada = (String) regiaoDestinoComboBox.getSelectedItem();
        String[] capitais = regioesCapitais.get(regiaoSelecionada);
        destinoComboBox.setModel(new DefaultComboBoxModel<>(capitais));
    }

    private void calcularDistancia() {
        String origemNome = (String) origemComboBox.getSelectedItem();
        String destinoNome = (String) destinoComboBox.getSelectedItem();

        Vertice origem = grafo.getVerticePorNome(origemNome);
        Vertice destino = grafo.getVerticePorNome(destinoNome);

        if (origem == null || destino == null) {
            resultadoLabel.setText("Uma ou ambas as capitais informadas são inválidas!");
            return;
        }

        Dijkstra.ResultadoDijkstra resultado = Dijkstra.calcularMenorCaminho(grafo, origem, destino);

        if (resultado.getCaminho() == null) {
            resultadoLabel.setText("Não existe caminho entre " + origem.getNome() + " e " + destino.getNome());
        } else {
            StringBuilder caminhoStr = new StringBuilder("<html>Menor caminho: <br>");
            for (Vertice vertice : resultado.getCaminho()) {
                caminhoStr.append(vertice.getNome()).append(" -> ");
            }
            caminhoStr.setLength(caminhoStr.length() - 4); // Remove o último " -> "
            caminhoStr.append("<br>Distância total: ").append(resultado.getDistanciaTotal()).append(" km</html>");
            resultadoLabel.setText(caminhoStr.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingInterface::new);
    }
}
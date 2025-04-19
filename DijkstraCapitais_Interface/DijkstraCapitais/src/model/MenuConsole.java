package model;

import java.util.List;
import java.util.Scanner;

public class MenuConsole {
    private final Grafo grafo;
    private final Scanner scanner;

    public MenuConsole() {
        this.grafo = DistanciasCapitais.criarGrafoCapitais();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Sistema de Cálculo da Menor Distância entre Capitais Brasileiras");

        while (true) {
            System.out.println("\nCapitais disponíveis por região:");
            System.out.println("Região Norte:");
            System.out.println("1: Rio Branco");
            System.out.println("2: Porto Velho");
            System.out.println("3: Manaus");
            System.out.println("4: Boa Vista");
            System.out.println("5: Macapá");
            System.out.println("6: Belém");
            System.out.println("7: Palmas");
            System.out.println(); // Espaço entre regiões
            System.out.println("Região Nordeste:");
            System.out.println("8: São Luís");
            System.out.println("9: Teresina");
            System.out.println("10: Fortaleza");
            System.out.println("11: Natal");
            System.out.println("12: João Pessoa");
            System.out.println("13: Recife");
            System.out.println("14: Maceió");
            System.out.println("15: Aracaju");
            System.out.println("16: Salvador");
            System.out.println(); // Espaço entre regiões
            System.out.println("Região Centro-Oeste:");
            System.out.println("17: Brasília");
            System.out.println("18: Goiânia");
            System.out.println("19: Cuiabá");
            System.out.println("20: Campo Grande");
            System.out.println(); // Espaço entre regiões
            System.out.println("Região Sudeste:");
            System.out.println("21: Vitória");
            System.out.println("22: Belo Horizonte");
            System.out.println("23: Rio de Janeiro");
            System.out.println("24: São Paulo");
            System.out.println(); // Espaço entre regiões
            System.out.println("Região Sul:");
            System.out.println("25: Curitiba");
            System.out.println("26: Florianópolis");
            System.out.println("27: Porto Alegre");

            System.out.print("\nDigite o número da capital de origem (ou 'sair' para encerrar): ");
            String origemInput = scanner.nextLine();

            if (origemInput.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o número da capital de destino: ");
            String destinoInput = scanner.nextLine();

            Vertice origem = null;
            switch (origemInput) {
                case "1":
                    origem = grafo.getVerticePorNome("Rio Branco");
                    break;
                case "2":
                    origem = grafo.getVerticePorNome("Porto Velho");
                    break;
                case "3":
                    origem = grafo.getVerticePorNome("Manaus");
                    break;
                case "4":
                    origem = grafo.getVerticePorNome("Boa Vista");
                    break;
                case "5":
                    origem = grafo.getVerticePorNome("Macapá");
                    break;
                case "6":
                    origem = grafo.getVerticePorNome("Belém");
                    break;
                case "7":
                    origem = grafo.getVerticePorNome("Palmas");
                    break;
                case "8":
                    origem = grafo.getVerticePorNome("São Luís");
                    break;
                case "9":
                    origem = grafo.getVerticePorNome("Teresina");
                    break;
                case "10":
                    origem = grafo.getVerticePorNome("Fortaleza");
                    break;
                case "11":
                    origem = grafo.getVerticePorNome("Natal");
                    break;
                case "12":
                    origem = grafo.getVerticePorNome("João Pessoa");
                    break;
                case "13":
                    origem = grafo.getVerticePorNome("Recife");
                    break;
                case "14":
                    origem = grafo.getVerticePorNome("Maceió");
                    break;
                case "15":
                    origem = grafo.getVerticePorNome("Aracaju");
                    break;
                case "16":
                    origem = grafo.getVerticePorNome("Salvador");
                    break;
                case "17":
                    origem = grafo.getVerticePorNome("Brasília");
                    break;
                case "18":
                    origem = grafo.getVerticePorNome("Goiânia");
                    break;
                case "19":
                    origem = grafo.getVerticePorNome("Cuiabá");
                    break;
                case "20":
                    origem = grafo.getVerticePorNome("Campo Grande");
                    break;
                case "21":
                    origem = grafo.getVerticePorNome("Vitória");
                    break;
                case "22":
                    origem = grafo.getVerticePorNome("Belo Horizonte");
                    break;
                case "23":
                    origem = grafo.getVerticePorNome("Rio de Janeiro");
                    break;
                case "24":
                    origem = grafo.getVerticePorNome("São Paulo");
                    break;
                case "25":
                    origem = grafo.getVerticePorNome("Curitiba");
                    break;
                case "26":
                    origem = grafo.getVerticePorNome("Florianópolis");
                    break;
                case "27":
                    origem = grafo.getVerticePorNome("Porto Alegre");
                    break;
                default:
                    System.out.println("Capital de origem inválida!");
                    continue;
            }

            Vertice destino = null;
            switch (destinoInput) {
                case "1":
                    destino = grafo.getVerticePorNome("Rio Branco");
                    break;
                case "2":
                    destino = grafo.getVerticePorNome("Porto Velho");
                    break;
                case "3":
                    destino = grafo.getVerticePorNome("Manaus");
                    break;
                case "4":
                    destino = grafo.getVerticePorNome("Boa Vista");
                    break;
                case "5":
                    destino = grafo.getVerticePorNome("Macapá");
                    break;
                case "6":
                    destino = grafo.getVerticePorNome("Belém");
                    break;
                case "7":
                    destino = grafo.getVerticePorNome("Palmas");
                    break;
                case "8":
                    destino = grafo.getVerticePorNome("São Luís");
                    break;
                case "9":
                    destino = grafo.getVerticePorNome("Teresina");
                    break;
                case "10":
                    destino = grafo.getVerticePorNome("Fortaleza");
                    break;
                case "11":
                    destino = grafo.getVerticePorNome("Natal");
                    break;
                case "12":
                    destino = grafo.getVerticePorNome("João Pessoa");
                    break;
                case "13":
                    destino = grafo.getVerticePorNome("Recife");
                    break;
                case "14":
                    destino = grafo.getVerticePorNome("Maceió");
                    break;
                case "15":
                    destino = grafo.getVerticePorNome("Aracaju");
                    break;
                case "16":
                    destino = grafo.getVerticePorNome("Salvador");
                    break;
                case "17":
                    destino = grafo.getVerticePorNome("Brasília");
                    break;
                case "18":
                    destino = grafo.getVerticePorNome("Goiânia");
                    break;
                case "19":
                    destino = grafo.getVerticePorNome("Cuiabá");
                    break;
                case "20":
                    destino = grafo.getVerticePorNome("Campo Grande");
                    break;
                case "21":
                    destino = grafo.getVerticePorNome("Vitória");
                    break;
                case "22":
                    destino = grafo.getVerticePorNome("Belo Horizonte");
                    break;
                case "23":
                    destino = grafo.getVerticePorNome("Rio de Janeiro");
                    break;
                case "24":
                    destino = grafo.getVerticePorNome("São Paulo");
                    break;
                case "25":
                    destino = grafo.getVerticePorNome("Curitiba");
                    break;
                case "26":
                    destino = grafo.getVerticePorNome("Florianópolis");
                    break;
                case "27":
                    destino = grafo.getVerticePorNome("Porto Alegre");
                    break;
                default:
                    System.out.println("Capital de destino inválida!");
                    continue;
            }

            if (origem == null || destino == null) {
                System.out.println("Uma ou ambas as capitais informadas são inválidas!");
                continue;
            }

            Dijkstra.ResultadoDijkstra resultado = Dijkstra.calcularMenorCaminho(grafo, origem, destino);

            if (resultado.getCaminho() == null) {
                System.out.println("Não existe caminho entre " + origem.getNome() + " e " + destino.getNome());
            } else {
                System.out.println("\nMenor caminho:");
                List<Vertice> caminho = resultado.getCaminho();
                for (int i = 0; i < caminho.size(); i++) {
                    System.out.print(caminho.get(i).getNome());
                    if (i < caminho.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println("\nDistância total: " + resultado.getDistanciaTotal() + " km");
            }
        }

        System.out.println("Sistema encerrado. Até mais!");
        scanner.close();
    }
}
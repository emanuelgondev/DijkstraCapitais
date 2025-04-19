package model;

import java.util.*;

public class Dijkstra {
    public static ResultadoDijkstra calcularMenorCaminho(Grafo grafo, Vertice origem, Vertice destino) {
        Map<Vertice, Integer> distancias = new HashMap<>();
        Map<Vertice, Vertice> predecessores = new HashMap<>();
        PriorityQueue<Vertice> filaPrioridade = new PriorityQueue<>(
                Comparator.comparingInt(distancias::get)
        );

        // Inicialização
        for (Vertice vertice : grafo.getVertices()) {
            distancias.put(vertice, Integer.MAX_VALUE);
            predecessores.put(vertice, null);
        }
        distancias.put(origem, 0);
        filaPrioridade.add(origem);

        // Processamento
        while (!filaPrioridade.isEmpty()) {
            Vertice atual = filaPrioridade.poll();

            if (atual.equals(destino)) {
                break;
            }

            for (model.Aresta aresta : grafo.getArestasAdjacentes(atual)) {
                Vertice vizinho = (Vertice) aresta.getDestino();
                int distanciaAlternativa = distancias.get(atual) + aresta.getDistancia();

                if (distanciaAlternativa < distancias.get(vizinho)) {
                    distancias.put(vizinho, distanciaAlternativa);
                    predecessores.put(vizinho, atual);
                    filaPrioridade.add(vizinho);
                }
            }
        }

        // Reconstrução do caminho
        List<Vertice> caminho = new ArrayList<>();
        Integer distanciaTotal = distancias.get(destino);

        if (predecessores.get(destino) == null && !origem.equals(destino)) {
            return new ResultadoDijkstra(null, null); // Caminho não existe
        }

        Vertice passo = destino;
        while (passo != null) {
            caminho.add(0, passo);
            passo = predecessores.get(passo);
        }

        return new ResultadoDijkstra(caminho, distanciaTotal);
    }

    public static class ResultadoDijkstra {
        private final List<Vertice> caminho;
        private final Integer distanciaTotal;

        public ResultadoDijkstra(List<Vertice> caminho, Integer distanciaTotal) {
            this.caminho = caminho;
            this.distanciaTotal = distanciaTotal;
        }

        public List<Vertice> getCaminho() {
            return caminho;
        }

        public Integer getDistanciaTotal() {
            return distanciaTotal;
        }
    }
}
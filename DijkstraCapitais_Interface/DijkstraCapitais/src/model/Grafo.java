package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private List<Vertice> vertices;
    private List<model.Aresta> arestas;
    private Map<Vertice, List<model.Aresta>> adjacencias;

    public Grafo() {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
        adjacencias = new HashMap<>();
    }

    public void adicionarVertice(Vertice vertice) {
        vertices.add(vertice);
        adjacencias.put(vertice, new ArrayList<>());
    }

    public void adicionarAresta(model.Aresta aresta) {
        arestas.add(aresta);
        adjacencias.get(aresta.getOrigem()).add(aresta);
        // Para grafos não direcionados, adicionar a aresta inversa também
        adjacencias.get(aresta.getDestino()).add(
                new model.Aresta(aresta.getDestino(), aresta.getOrigem(), aresta.getDistancia())
        );
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<model.Aresta> getArestas() {
        return arestas;
    }

    public List<model.Aresta> getArestasAdjacentes(Vertice vertice) {
        return adjacencias.get(vertice);
    }

    public Vertice getVerticePorNome(String nome) {
        for (Vertice v : vertices) {
            if (v.getNome().equalsIgnoreCase(nome)) {
                return v;
            }
        }
        return null;
    }
}
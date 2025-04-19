package model;

public class Aresta {
    private Vertice origem;
    private Vertice destino;
    private int distancia;

    public Aresta(Object origem, Object destino, int distancia) {
        this.origem = (Vertice) origem;
        this.destino = (Vertice) destino;
        this.distancia = distancia;
    }

    public Object getOrigem() {
        return origem;
    }

    public Object getDestino() {
        return destino;
    }

    public int getDistancia() {
        return distancia;
    }
}
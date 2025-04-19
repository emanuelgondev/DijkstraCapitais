package model;

public class DistanciasCapitais {
    public static Grafo criarGrafoCapitais() {
        Grafo grafo = new Grafo();

        // Criando todos os vértices (capitais)
        // Região Norte
        Vertice rioBranco = new Vertice("Rio Branco"); //OK - DISTANCIAS AJUSTADAS E CORRETAS
        Vertice portoVelho = new Vertice("Porto Velho");
        Vertice manaus = new Vertice("Manaus");
        Vertice boaVista = new Vertice("Boa Vista");
        Vertice macapa = new Vertice("Macapá");
        Vertice belem = new Vertice("Belém");
        Vertice palmas = new Vertice("Palmas");

        // Região Nordeste
        Vertice saoLuis = new Vertice("São Luís");
        Vertice teresina = new Vertice("Teresina");
        Vertice fortaleza = new Vertice("Fortaleza");
        Vertice natal = new Vertice("Natal");
        Vertice joaoPessoa = new Vertice("João Pessoa");
        Vertice recife = new Vertice("Recife");
        Vertice maceio = new Vertice("Maceió");
        Vertice aracaju = new Vertice("Aracaju");
        Vertice salvador = new Vertice("Salvador");

        // Região Centro-Oeste
        Vertice brasilia = new Vertice("Brasília");
        Vertice goiania = new Vertice("Goiânia");
        Vertice cuiaba = new Vertice("Cuiabá");
        Vertice campoGrande = new Vertice("Campo Grande");

        // Região Sudeste
        Vertice vitoria = new Vertice("Vitória");
        Vertice beloHorizonte = new Vertice("Belo Horizonte");
        Vertice rioDeJaneiro = new Vertice("Rio de Janeiro");
        Vertice saoPaulo = new Vertice("São Paulo");

        // Região Sul
        Vertice curitiba = new Vertice("Curitiba");
        Vertice florianopolis = new Vertice("Florianópolis");
        Vertice portoAlegre = new Vertice("Porto Alegre");

        // Adicionando todos os vértices ao grafo
        // Região Norte
        grafo.adicionarVertice(rioBranco);
        grafo.adicionarVertice(portoVelho);
        grafo.adicionarVertice(manaus);
        grafo.adicionarVertice(boaVista);
        grafo.adicionarVertice(macapa);
        grafo.adicionarVertice(belem);
        grafo.adicionarVertice(palmas);

        // Região Nordeste
        grafo.adicionarVertice(saoLuis);
        grafo.adicionarVertice(teresina);
        grafo.adicionarVertice(fortaleza);
        grafo.adicionarVertice(natal);
        grafo.adicionarVertice(joaoPessoa);
        grafo.adicionarVertice(recife);
        grafo.adicionarVertice(maceio);
        grafo.adicionarVertice(aracaju);
        grafo.adicionarVertice(salvador);

        // Região Centro-Oeste
        grafo.adicionarVertice(brasilia);
        grafo.adicionarVertice(goiania);
        grafo.adicionarVertice(cuiaba);
        grafo.adicionarVertice(campoGrande);

        // Região Sudeste
        grafo.adicionarVertice(vitoria);
        grafo.adicionarVertice(beloHorizonte);
        grafo.adicionarVertice(rioDeJaneiro);
        grafo.adicionarVertice(saoPaulo);

        // Região Sul
        grafo.adicionarVertice(curitiba);
        grafo.adicionarVertice(florianopolis);
        grafo.adicionarVertice(portoAlegre);

        // CONEXÕES NORTE X NORTE
        grafo.adicionarAresta(new Aresta(rioBranco, manaus, 1135));
        grafo.adicionarAresta(new Aresta(rioBranco, portoVelho, 462));
        grafo.adicionarAresta(new Aresta(portoVelho, manaus, 753));
        grafo.adicionarAresta(new Aresta(manaus, boaVista, 666));
        grafo.adicionarAresta(new Aresta(manaus, cuiaba, 1440));
        grafo.adicionarAresta(new Aresta(manaus, belem, 1289));
        grafo.adicionarAresta(new Aresta(macapa, belem, 335));
        grafo.adicionarAresta(new Aresta(belem, palmas, 995));
        grafo.adicionarAresta(new Aresta(cuiaba, palmas, 1122));
        grafo.adicionarAresta(new Aresta(brasilia, palmas, 616));
        grafo.adicionarAresta(new Aresta(salvador, palmas, 1000));
        grafo.adicionarAresta(new Aresta(saoLuis, palmas, 924));
        grafo.adicionarAresta(new Aresta(boaVista, belem, 1445));

        // CONEXÕES NORDESTE X NORDESTE
        grafo.adicionarAresta(new Aresta(saoLuis, teresina,297));
        grafo.adicionarAresta(new Aresta(teresina, fortaleza, 464));
        grafo.adicionarAresta(new Aresta(joaoPessoa, fortaleza, 543));
        grafo.adicionarAresta(new Aresta(recife, fortaleza, 630));
        grafo.adicionarAresta(new Aresta(teresina, salvador, 992));
        grafo.adicionarAresta(new Aresta(teresina, recife, 929));
        grafo.adicionarAresta(new Aresta(fortaleza, natal, 431));
        grafo.adicionarAresta(new Aresta(natal, joaoPessoa, 156));
        grafo.adicionarAresta(new Aresta(joaoPessoa, recife, 100));
        grafo.adicionarAresta(new Aresta(recife, maceio, 203));
        grafo.adicionarAresta(new Aresta(maceio, aracaju, 204));
        grafo.adicionarAresta(new Aresta(aracaju, salvador, 275));

        // CONEXÕES CENTRO-OESTE X CENTRO-OESTE
        grafo.adicionarAresta(new Aresta(brasilia, goiania, 179));
        grafo.adicionarAresta(new Aresta(goiania, cuiaba, 745));
        grafo.adicionarAresta(new Aresta(cuiaba, campoGrande, 555));
        grafo.adicionarAresta(new Aresta(goiania, campoGrande, 707));

        // CONEXÕES SUDESTE X SUDESTE
        grafo.adicionarAresta(new Aresta(vitoria, beloHorizonte, 384));
        grafo.adicionarAresta(new Aresta(vitoria, rioDeJaneiro, 516));
        grafo.adicionarAresta(new Aresta(beloHorizonte, rioDeJaneiro, 411));
        grafo.adicionarAresta(new Aresta(rioDeJaneiro, saoPaulo, 365));
        grafo.adicionarAresta(new Aresta(beloHorizonte, saoPaulo, 494));

        // CONEXÕES SUL X SUL
        grafo.adicionarAresta(new Aresta(curitiba, florianopolis, 245));
        grafo.adicionarAresta(new Aresta(florianopolis, portoAlegre, 375));

        // CONEXÕES NORTE X CENTRO-OESTE
        grafo.adicionarAresta(new Aresta(belem, cuiaba, 1790));
        grafo.adicionarAresta(new Aresta(portoVelho, cuiaba, 1142));
        grafo.adicionarAresta(new Aresta(palmas, goiania, 710));

        // CONEXÕES NORTE X NORDESTE
        grafo.adicionarAresta(new Aresta(salvador, palmas, 1104));
        grafo.adicionarAresta(new Aresta(belem, saoLuis, 523));
        grafo.adicionarAresta(new Aresta(teresina, palmas, 800));

        // CONEXÕES NORDESTE X SUDESTE
        grafo.adicionarAresta(new Aresta(salvador, vitoria, 869));
        grafo.adicionarAresta(new Aresta(salvador, beloHorizonte, 1015));
        grafo.adicionarAresta(new Aresta(salvador, brasilia, 1137));

        // CONEXÕESNORDESTE X CENTRO-OESTE
        grafo.adicionarAresta(new Aresta(goiania, salvador, 1309));

        // CONEXÕES CENTRO-OESTE X SUDESTE
        grafo.adicionarAresta(new Aresta(brasilia, beloHorizonte, 614));
        grafo.adicionarAresta(new Aresta(campoGrande, saoPaulo, 1014));
        grafo.adicionarAresta(new Aresta(beloHorizonte, campoGrande, 1110));
        grafo.adicionarAresta(new Aresta(beloHorizonte, goiania, 662));

        // CONEXÕES SUDESTE X SUL
        grafo.adicionarAresta(new Aresta(saoPaulo, curitiba, 337));

        // CONEXÕES SUL X CENTRO-OESTE
        grafo.adicionarAresta(new Aresta(curitiba, campoGrande, 774));

        return grafo;
    }
}
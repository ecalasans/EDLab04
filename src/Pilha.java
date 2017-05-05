/**
 * Created by ericcalasans on 05/05/17.
 */

import java.util.LinkedList;

public class Pilha<Tipo> {
    private LinkedList<Tipo> conteudo;

    public Pilha(){
        this.conteudo = new LinkedList<>();
    }

    public boolean estaVazia(){
        return this.conteudo.isEmpty();
    }

    public void empilha(Tipo e){
        this.conteudo.addFirst(e);
    }

    public Tipo desempilha(){
        return this.conteudo.pop();
    }

    public Tipo topo(){
        return this.conteudo.getFirst();
    }
}

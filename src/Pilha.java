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

    public String toString(){
        return conteudo.toString();
    }

    public void reinicialize(){
        this.conteudo.clear();
    }

    public String toStringInverse(){
        Pilha<Tipo> temp = new Pilha<Tipo>();

        for (Tipo t: this.conteudo) {
            temp.empilha(t);
        }

        String resultado = "[";

        for(int i = 0; i < this.conteudo.size(); i++){
            if(i < (this.conteudo.size() - 1)){
                resultado += resultado + temp.desempilha() + ",";
            } else {
                resultado += "]";
            }

        }
        return resultado;
    }
}

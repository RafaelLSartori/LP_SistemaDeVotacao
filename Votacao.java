package lp;

public class Votacao {
    int secao;
    int candidato;
    
    Votacao(){
        this(0, 0);
    }
    
    Votacao(int secao, int candidato){
        this.secao = secao;
        this.candidato = candidato;
    }
}

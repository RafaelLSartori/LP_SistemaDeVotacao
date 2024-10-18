
package lp;
import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class Metodos {
    
    Random random = new Random();
    int qtdEleitores[] = new int[11];
    int votoCandidato[] = new int[301];
    
    public Votacao[] fCadastra(Votacao[] votacao){
        for (int i = 0; i < 200; i++){
            votacao[i].secao = random.nextInt(11);
            votacao[i].candidato = random.nextInt(301);
            System.out.println("secao:" +votacao[i].secao +" candidato:"+votacao[i].candidato);
        }
        return votacao;
    }
    
    public Votacao[] fClassificaSecao(Votacao[] votacao){
        Votacao aux;
        for (int i = 0; i < 199; i++){
            for (int j = (i+1); j < 200; j++){
                if (votacao[i].secao > votacao[j].secao){
                    aux = votacao[i];
                    votacao[i] =  votacao[j];
                    votacao[j] = aux;
                    
                }
            }
        }
        for (int i = 0; i < 200; i++){
            System.out.println("secao:" +votacao[i].secao +" candidato:"+votacao[i].candidato);
        }
        JOptionPane.showMessageDialog(null, "Dados classificados!");
        return votacao;
    }
    
    public Votacao[] fGrava(Votacao[] votacao) throws IOException{
        
        String fileName = "Votacao2021.txt";
        
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        
        for (int i = 0; i < 200; i++){
            gravar.write(Integer.toString(votacao[i].secao));
            gravar.newLine();
            gravar.write(Integer.toString(votacao[i].candidato));
            gravar.newLine();
        }
        gravar.close();
        JOptionPane.showMessageDialog(null, "Arquivo Gerado!");
        
        return votacao;
    }
    
    public void fMenu(Votacao[] votacao){
        int opc = 0;
        
        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Eleitores por secao \n2 - > e < secao n eleitores\n3 - Votos p candidato\n4 - Dez mais votados"));
            switch(opc){
                case 1: eleitorPorSecao(votacao);
                    break;                    
                case 2: secaoMaiorMenorEleitores(votacao);
                    break;
                case 3: votosPorCandidato(votacao);
                    break;
                //case 4: dezMaisVotados(votacao);
                //    break;*/
                case 9: JOptionPane.showMessageDialog(null, "FIM");
                    break;
                default: JOptionPane.showMessageDialog(null, "INVALIDO");
            }
        }
    }
    
    public void eleitorPorSecao(Votacao[] votacao){
        for (int i = 0; i < 200; i++){
            qtdEleitores[votacao[i].secao]++;
        }
        for (int i = 0; i < 11; i++){
            System.out.println("Quantidade de eleitores na secao "+ i + ": "+qtdEleitores[i]);
        }
    }
    
    public void secaoMaiorMenorEleitores(Votacao[] votacao){
        
        for (int i = 0; i < 10; i++){
            for (int j = (i+1); j < 11; j++){
                if (qtdEleitores[i] > qtdEleitores[j]){
                    int aux = qtdEleitores[i];
                    qtdEleitores[i] = qtdEleitores[j];
                    qtdEleitores[j] = aux;
                }
            }
        }
        System.out.println("Menor: "+qtdEleitores[0]);
        System.out.print("Maior: "+qtdEleitores[10]);
    }
    
    public void votosPorCandidato(Votacao[] votacao){
        for (int i = 0; i < 200; i++){
            votoCandidato[votacao[i].candidato]++;
        }
        for (int i = 0; i < 301; i++){
            System.out.println("Quantidade de votos no candidato "+ i + ": "+votoCandidato[i]);
        }
    }
    
}    
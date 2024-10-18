
package lp;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) throws IOException{
        
        Metodos m = new Metodos();
         
        Votacao votacao[] = new Votacao[200];
        for(int i = 0; i < 200; i++){
            votacao[i] = new Votacao();
        }
        
        int opc = 0;
        
        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastra \n2 - Classifica\n3 - Grava\n4 - Menu Indicadores"));
            switch(opc){
                case 1: votacao = m.fCadastra(votacao);
                    break;
                case 2: votacao = m.fClassificaSecao(votacao);
                    break;
                case 3: votacao = m.fGrava(votacao);
                    break;
                case 4: m.fMenu(votacao);
                    break;
                case 9: JOptionPane.showMessageDialog(null, "FIM");
                    break;
                default: JOptionPane.showMessageDialog(null, "INVALIDO");
            }
        }
    }    
}

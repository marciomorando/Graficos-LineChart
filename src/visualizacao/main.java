/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visualizacao;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import projetolinechart.dados.LineChart;



/**
 *
 * @author marcio.morando
 */
public class main {
    public static void main(String args[]){
         JFrame janela = new JFrame();
        LineChart lc = new LineChart();
        BorderLayout layout = new BorderLayout();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(800, 450);
        janela.setLayout(layout);  
        janela.setResizable(false);
        janela.setVisible(true);
        janela.add(lc);
        janela.setLocationRelativeTo(null);
    }
}

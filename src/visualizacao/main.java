/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visualizacao;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import projetolinechart.dados.LineChart;
import projetolinechart.dao.LineChartDAO;



/**
 *
 * @author marcio.morando
 */
public class main {
    public static void main(String args[]){
        
         
         JFrame janela = new JFrame();
         
        LineChart lc = new LineChart();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(800, 450); 
        janela.setResizable(false);
        janela.setVisible(true);
        janela.add(lc);
        janela.setLocationRelativeTo(null);
        
        LineChart lcNovo = new LineChartDAO().getLineChart(1);
        lc.setTitulo(lcNovo.getTitulo());
        lc.setEixoX(lcNovo.getValoresX());
        lc.setEixoY(lcNovo.getValoresY());
        lc.setLabelX(lcNovo.getLabelX());
        lc.setLabelY(lcNovo.getLabelY());
        lc.adicionarSerie(lcNovo.getPontos(), lcNovo.getCor());
        lc.atualizaGrafico();
    }
}
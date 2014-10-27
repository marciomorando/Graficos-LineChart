package projetolinechart.dao;

import projetolinechart.conexao.Conecta;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetolinechart.dados.LineChart;


public class LineChartDAO {

    public LineChart getLineChart(int id) {
        LineChart lineChart = null;

        Conecta c = new Conecta();

        if ("sucesso".equals(c.getMsg())) {

            // Vamos preparar o comando SQL:
            String sql = "SELECT TITULO, LABELX, LABELY FROM LINECHART WHERE ID = 1;";
            String sql2 = "select rotulo from rotulosx where id_linechart = 1;";
            String sql3 = "select rotulo from rotulosy where id_linechart = 1;";
            String sql4 = "select x, y from pontos where id_linechart = 1;";

            // Definido o Statement, executamos o comando no banco de dados.
            ResultSet rs;

            try {
                rs = c.getStm().executeQuery(sql);

                // caso existir resultados, percorremos a lista.
                while (rs.next()) {
                        //leitura dos campos da tabela em vari�veis

                    String titulo = rs.getString("titulo");
                    String rotulox = rs.getString("labelX");
                    String rotuloy = rs.getString("labelY");

                    lineChart = new LineChart();
                    lineChart.setTitulo(titulo);
                    lineChart.setLabelX(rotulox);
                    lineChart.setLabelY(rotuloy);

                    
                }
                
                rs = c.getStm().executeQuery(sql2);
                ArrayList<String> rotulosX = new ArrayList<>();
                while (rs.next()) {
                     rotulosX.add(rs.getString("rotulo"));    
                }
                
                lineChart.setEixoX(rotulosX);
                
                rs = c.getStm().executeQuery(sql3);
                ArrayList<String> rotulosY = new ArrayList<>();
                while (rs.next()) {
                     rotulosY.add(rs.getString("rotulo"));    
                }
                
                lineChart.setEixoY(rotulosY);
                
                rs = c.getStm().executeQuery(sql4);
                ArrayList<Point2D> pontos = new ArrayList<>();
                while (rs.next()) {
                    int x = Integer.parseInt(rs.getString("x"));
                    int y = Integer.parseInt(rs.getString("y"));
                    
                    Point2D ponto = new Point(x, y);
                    pontos.add(ponto);    
                }
                
                lineChart.adicionarSerie(pontos, Color.BLUE);

            } catch (SQLException ex) {
                Logger.getLogger(LineChartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lineChart;
        }
        return lineChart;

    }

}

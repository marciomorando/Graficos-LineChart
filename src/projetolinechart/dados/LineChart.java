package projetolinechart.dados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import projetolinechart.dao.LineChartDAO;

/**
 *
 * @author marcio.morando
 */

public class LineChart extends JPanel implements InterfaceChart{
    
    Graphics2D g2d;
    String titulo;
    String labelX;
    String labelY;
    ArrayList<String> valoresX;
    ArrayList<String> valoresY;
  
    JLabel labelTitulo;
    JLabel label_eixoX;    
    JLabel label_eixoY;
    ArrayList<JLabel> labelsX ;
    ArrayList<Point2D> pontos;
    Color cor;
    ArrayList<JLabel> labelsY;
    
    
    public LineChart() {
        this.labelTitulo =  new JLabel("LabelTitulo");
        this.labelTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
        this.labelTitulo.setBounds(420, 10, 200, 20);
        this.add(labelTitulo);
        
        this.label_eixoX = new JLabel("Eixo MX");
        this.label_eixoX.setFont(new Font("Arial", Font.PLAIN, 20));
        this.label_eixoX.setBounds(420, 390, 100, 20);
        this.add(label_eixoX);
        
        this.label_eixoY = new JLabel("Eixo MY");
        this.label_eixoY.setFont(new Font("Arial", Font.PLAIN, 20));
        this.label_eixoY.setBounds(10, 200, 100, 20);
        this.add(label_eixoY);
        
  
       
        labelsX = new ArrayList<>();
        labelsX.add(new JLabel("x1"));
        labelsX.add(new JLabel("x2"));
        labelsX.add(new JLabel("x3"));
        labelsX.add(new JLabel("x4"));
      
        labelsY = new ArrayList<>();
        labelsY.add(new JLabel("y1"));
        labelsY.add(new JLabel("y2"));
        labelsY.add(new JLabel("y3"));
        
        pontos = new ArrayList<>();
        pontos.add(new Point2D.Double(120, 800));
       /* pontos.add(new Point2D.Double(250, 300));
        pontos.add(new Point2D.Double(300, 300));
        pontos.add(new Point2D.Double(400, 300));
        pontos.add(new Point2D.Double(500, 300));*/
        
      
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        LineChartDAO d = new LineChartDAO();
        d.getLineChart(1);
        
        
      g.drawRect(120, 50, 650, 300); 
      g.drawLine(120, 125, 770, 125);
      g.drawLine(120, 200, 770, 200);
      g.drawLine(120, 275, 770, 275);
      
      labelTitulo.setBounds(380, 10, 200, 20);
      label_eixoX.setBounds(400, 390, 100, 20);
      label_eixoY.setBounds(10, 200, 100, 20);
      
 
      
      
       float n = (float) 0.95;
        int largura = (int) (650/(labelsX.size()-n));
        int temp = 0;
          for (int i = 0; i < labelsX.size(); i++) {

            labelsX.get(i).setText(valoresX.get(i));
        }
        for (JLabel labelsX1 : labelsX) {
            labelsX1.setBounds(120 + temp, 350, largura, 20);
            temp = temp + largura;
            this.add(labelsX1);
            
              float a = (float) 0.95; 
      int altura = (int) (300/(labelsY.size()-a));
      int temp1 = 0;
              for (int i = 0; i < labelsY.size(); i++) {
           labelsY.get(i).setText(valoresY.get(i));
        }
              for(JLabel labelsY1 : labelsY){
                  labelsY1.setBounds(95, 270+temp1, 30, altura);
                  temp1 = temp1 - altura;
                  this.add(labelsY1);
              }
   

        g2d = (Graphics2D) g;
        g2d.setColor(new Color(255,255,255));        
        g2d.setColor(new Color(0, 0, 0));
        
            
            for (int i = 1; i <= pontos.size(); i++) {
                
                
               g2d.drawLine((int) pontos.get(i - 1).getX(),
                             (int) pontos.get(i - 1).getY(), 
                             (int) pontos.get(i).getX(),
                             (int) pontos.get(i).getY());
                if (i == (pontos.size() - 1)) {
                    break;
                }
            }
     
    }
}
    
    
    @Override
            public void adicionarSerie(ArrayList<Point2D> pontos, Color cor) {
            this.pontos = pontos;
            this.cor = cor;
    }

    @Override
    public void setEixoX(ArrayList<String> valores) {
        this.valoresX = valores;
        
    }

    @Override
    public void setEixoY(ArrayList<String> valores) {

        this.valoresY = valores;
        
    }

    @Override
    public void setLabelX(String labelX) {
        
        this.labelX = labelX;

    }

    @Override
    public void setLabelY(String labelY) {
        
        this.labelY = labelY;

       
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void atualizaGrafico(){
        labelTitulo.setText(this.titulo);
        label_eixoX.setText(this.labelX);
        label_eixoY.setText(this.labelY);
        
        
         
    }
    

    public Graphics2D getG2d() {
        return g2d;
    }

    public String getTitulo() {
        return titulo;
    }

    public JLabel getLabelTitulo() {
        return labelTitulo;
    }

    public String getLabelX() {
        return labelX;
    }

    public String getLabelY() {
        return labelY;
    }

    public Color getCor() {
        return cor;
    }

    public ArrayList<Point2D> getPontos() {
        return pontos;
    }

    public ArrayList<String> getValoresX() {
        return valoresX;
    }

    public ArrayList<String> getValoresY() {
        return valoresY;
    }

    
}
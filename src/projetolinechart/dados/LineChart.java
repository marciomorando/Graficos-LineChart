package projetolinechart.dados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author marcio.morando
 */

public class LineChart extends JPanel implements InterfaceChart{
    
    Graphics2D g2d;
    String titulo;
    String labelX;
    String labelY;
    Color cor;
    ArrayList<Point2D> pontos;
    ArrayList<String> valoresX;
    ArrayList<String> valoresY;
    
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
      g.drawRect(120, 50, 650, 300); 
      g.drawLine(120, 125, 770, 125);
      g.drawLine(120, 200, 770, 200);
      g.drawLine(120, 275, 770, 275);
     
        g2d = (Graphics2D) g;
        this.setTitulo("Titulo 1");
        this.setLabelX("Eixo x");
        this.setLabelY("Eixo y");
        g2d.setColor(new Color(255,255,255));
        
        
        g2d.setColor(new Color(0, 0, 0));
        ArrayList<String> x = new ArrayList<>();
        x.add("0.0");
        x.add("4.0");
        x.add("8.0");
        x.add("12.0");
        
        ArrayList<String> y = new ArrayList<>();
        y.add("0.0");
        y.add("5.0");
        y.add("10.0");
       
    
    this.setEixoX(x);
    this.setEixoY(y);
    
    ArrayList<Point2D> pontos = new ArrayList<Point2D>(); 
    pontos.add(new Point2D.Double(120, 500)); 
    pontos.add(new Point2D.Double(200, 200)); 
    pontos.add(new Point2D.Double(300, 400)); 
    pontos.add(new Point2D.Double(425, 125)); 
    pontos.add(new Point2D.Double(600, 400)); 
    pontos.add(new Point2D.Double(680, 120));
    this.adicionarSerie(pontos, new Color(10,10,10));
        
    }
    
    
    
    @Override
    public void adicionarSerie(ArrayList<Point2D> serie, Color cor) {

    }

    @Override
    public void setEixoX(ArrayList<String> valores) {
        float n = (float) 0.95;
        int largura = (int) (650/(valores.size()-n));
        int temp = 0;
        for(int i = 0; i < valores.size(); i ++){
            JLabel x = new JLabel(valores.get(i));
                x.setBounds(120+temp, 350, largura, 20);
                temp = temp + largura;
                this.add(x);
            }
    }

    @Override
    public void setEixoY(ArrayList<String> valores) {
        float n = (float) 0.95;
        int altura = (int) (300/(valores.size()-n));
        int temp = 0;
        for(int i = 0; i < valores.size() ; i++){
            JLabel y = new JLabel(valores.get(i));
            y.setBounds(95, 270+temp, 30, altura);
            //g2d.drawLine(120, 520+temp, 770, 520+temp);
            temp = temp - altura;
            this.add(y);
        }
    }

    @Override
    public void setLabelX(String labelX) {
        JLabel x = new JLabel(labelX);
        x.setFont(new Font("Arial", Font.PLAIN, 20));
        x.setBounds(420, 390, 100, 20);
        this.add(x);
    }

    @Override
    public void setLabelY(String labelY) {
        JLabel y = new JLabel(labelY);
        y.setFont(new Font("Arial", Font.PLAIN, 20));
        y.setBounds(10, 200, 100, 20);
        this.add(y);
        
      //g2d.rotate(Math.PI / -2.0);
      //g2d.drawString("Eixo Y", -220, 190 - 170);
      //g2d.setBackground(Color.black);
       
    }

    @Override
    public void setTitulo(String titulo) {
         JLabel j = new JLabel(titulo);
        j.setFont(new Font("Arial", Font.PLAIN, 20));
        j.setBounds(420, 10, 200, 20);
        this.add(j);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolinechart.dados;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author marcio.morando
 */


public interface InterfaceChart {

    public void adicionarSerie(ArrayList<Point2D> serie, Color cor);

    public void setEixoX(ArrayList<String> valores);

    public void setEixoY(ArrayList<String> valores);

    public void setLabelX(String nome);

    public void setLabelY(String nome);

    public void setTitulo(String titulo);

}

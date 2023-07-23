/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IGU;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Usuario
 */
public interface ConstantesApariencia {
    public static final Color FONDO_TEMA_OSCURO = new Color(70,70,70);
    public static final Color FONDO_TEMA_CLARO = new Color(217,217,217);
    public static final Color COLOR_COMPONENTES_TO = new Color(  92, 254, 0  );
    public static final Color COLOR_COMPONENTES_TC = new Color( 237, 48, 2 );
    public static final Color FONDO_CUADRO_TEXTO_TO = new Color( 14, 14, 14 ); 
    public static final Color FONDO_CUADRO_TEXTO_TC = new Color( 223, 185, 33 );
    public static final Color LINEA_TO = new Color(255, 210, 25);
    public static final Color LINEA_TC = new  Color( 25, 50, 255 );
    public static final Border BORDE_EVENTO_MOUSE_TO = BorderFactory.createLineBorder(LINEA_TO);
    public static final Border BORDE_EVENTO_MOUSE_TC = BorderFactory.createLineBorder(LINEA_TC);
    public static final Border BORDE_EVENTO_ENFOQUE_TO = BorderFactory.createMatteBorder(2,2,2,2,LINEA_TO);
    public static final Border BORDE_EVENTO_ENFOQUE_TC = BorderFactory.createMatteBorder(2,2,2,2,LINEA_TC);
    public static final short anchoComponente = 120;
    public static final short alturaComponente = 30;
    public static final short distanciaABorde = 10;
    public static final short anchoBoton = (2*anchoComponente)+(distanciaABorde);
    public static final short distanciaVertical = (distanciaABorde*2)+alturaComponente;
    public static final short anchoVentana = (anchoComponente*4)+(distanciaABorde*7);
    public static final short alturaVentana = (short)(alturaComponente*3.5)+(distanciaABorde*3);
    //public static final Font fuente = new Font();
}

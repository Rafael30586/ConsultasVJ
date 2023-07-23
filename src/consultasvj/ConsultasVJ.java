/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consultasvj;

import IGU.ConstantesApariencia;
import IGU.Panel;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class ConsultasVJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        Panel panel = new Panel();
        
        ventana.setBounds(50,50,ConstantesApariencia.anchoVentana,ConstantesApariencia.alturaVentana);//w=original 400  h=150
        ventana.setResizable(false);
        
        ventana.add(panel);
        
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

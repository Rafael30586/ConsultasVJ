
package IGU;

import DAO.ProductoDAO;
import entidades.Producto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Panel extends JPanel implements ActionListener {

    
    //Clases internas
    private class Boton extends JButton {
        
    }
    
    private class CuadroTexto extends JTextField implements FocusListener{
        
        CuadroTexto(){
            this.setBorder(null);
            this.addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if(temaOscuro){
                this.setBorder(ConstantesApariencia.BORDE_EVENTO_ENFOQUE_TO);
                this.setBackground(ConstantesApariencia.FONDO_TEMA_OSCURO);
                this.setForeground(ConstantesApariencia.COLOR_COMPONENTES_TO);
            }else if(!temaOscuro){
                this.setBorder(ConstantesApariencia.BORDE_EVENTO_ENFOQUE_TC);
                this.setBackground(ConstantesApariencia.FONDO_TEMA_CLARO);
                this.setForeground(ConstantesApariencia.COLOR_COMPONENTES_TC);
            }
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            this.setBorder(null);
            if(temaOscuro){
                this.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TO);
                this.setForeground(Color.white);
            
            }else if(!temaOscuro){
                this.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TC);
                this.setForeground(ConstantesApariencia.FONDO_TEMA_OSCURO);
            
            }
            
        }
    
    }
    
    private class Desplegable extends JComboBox{
    
    }
    
    private class Servicio{
        ProductoDAO dao = new ProductoDAO();
        char opcion;
        LinkedList<Producto> juegos;
        
        public LinkedList<Producto> guardarResultados() throws Exception{
            if(menuNombreProducto.getSelectedItem().equals("Empieza con...")){
                opcion = 'e';
            }else if(menuNombreProducto.getSelectedItem().equals("Contiene...")){
                opcion = 'c';
            }else if(menuNombreProducto.getSelectedItem().equals("Termina con...")){
                opcion = 't';
            }
            
            if(menuPlataforma.getSelectedItem().equals("Todas")){
                juegos = dao
                        .listarProductos(opcion, cuadroNombreProducto
                                .getText(), menuOrden
                                        .getSelectedItem().toString());
            
            }else{
                juegos = dao
                        .listarJuegosPlataforma(opcion, cuadroNombreProducto
                                .getText(), menuPlataforma
                                        .getSelectedItem().toString(), menuOrden
                                                .getSelectedItem().toString());
            
            }
            return juegos;
        }
        
        public void mostrarResultados() throws Exception{//método incompleto
            
            LinkedList<Producto> juegos = guardarResultados();
            
            for(Producto j : juegos){
            
            }
        
        }
        
    }
    
    //Atributos de clase
    
    private final Desplegable menuNombreProducto = new Desplegable();
    private final CuadroTexto cuadroNombreProducto = new CuadroTexto();
    private final Desplegable menuPlataforma = new Desplegable();
    private final Desplegable menuOrden = new Desplegable();
    private final Boton botonConsulta = new Boton();
    private final Boton botonApariencia = new Boton();
    private final JFrame ventanaResultados = new JFrame(); // todavía sin usar
    private final JPanel panelResultados = new JPanel(); // todavía sin usar
    private boolean temaOscuro = true;
    
   
    //Constructor
    
    public Panel(){
        this.setLayout(null);
        this.setBackground(ConstantesApariencia.FONDO_TEMA_OSCURO);
        
        //menuNombreProducto = new Desplegable();
        menuNombreProducto.setBounds(ConstantesApariencia.distanciaABorde, ConstantesApariencia.distanciaABorde, ConstantesApariencia.anchoComponente, ConstantesApariencia.alturaComponente);
        menuNombreProducto.addItem("Empieza con...");
        menuNombreProducto.addItem("Contiene...");
        menuNombreProducto.addItem("Termina con...");
        menuNombreProducto.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TO);
        menuNombreProducto.setForeground(Color.white);
        this.add(menuNombreProducto);
        
        //cuadroNombreProducto = new CuadroTexto();
        cuadroNombreProducto.setBounds(((ConstantesApariencia.distanciaABorde*2)+ConstantesApariencia.anchoComponente), ConstantesApariencia.distanciaABorde, ConstantesApariencia.anchoComponente, ConstantesApariencia.alturaComponente);
        cuadroNombreProducto.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TO);
        cuadroNombreProducto.setForeground(Color.white);
        this.add(cuadroNombreProducto);
        
        //menuPlataforma = new Desplegable();
        menuPlataforma.setBounds(((ConstantesApariencia.distanciaABorde*3)+(ConstantesApariencia.anchoComponente*2)), ConstantesApariencia.distanciaABorde, ConstantesApariencia.anchoComponente, ConstantesApariencia.alturaComponente);
        menuPlataforma.addItem("Todas");
        menuPlataforma.addItem("Nintendo Switch");
        menuPlataforma.addItem("PC");
        menuPlataforma.addItem("Playstation");
        menuPlataforma.addItem("Xbox");
        menuPlataforma.addItem("Playstation 4");
        menuPlataforma.addItem("Playstation 5");
        menuPlataforma.addItem("Xbox One");
        menuPlataforma.addItem("Xbox Series");
        menuPlataforma.addItem("Móviles");
        menuPlataforma.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TO);
        menuPlataforma.setForeground(Color.white);        
        this.add(menuPlataforma);
        
        //menuOrden = new Desplegable();
        menuOrden.setBounds(((ConstantesApariencia.distanciaABorde*4)+(ConstantesApariencia.anchoComponente*3)), ConstantesApariencia.distanciaABorde, ConstantesApariencia.anchoComponente, ConstantesApariencia.alturaComponente);
        menuOrden.addItem("Alfabético");
        menuOrden.addItem("Plataforma");
        menuOrden.addItem("Desarrolladora");
        menuOrden.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TO);
        menuOrden.setForeground(Color.white);         
        this.add(menuOrden);
        
        //botonConsulta = new Boton();
        botonConsulta.setBounds(ConstantesApariencia.distanciaABorde, ConstantesApariencia.distanciaVertical, ConstantesApariencia.anchoBoton, ConstantesApariencia.alturaComponente);
        botonConsulta.setBackground(ConstantesApariencia.COLOR_COMPONENTES_TO);
        botonConsulta.setText("Resultados");
        botonConsulta.setForeground(ConstantesApariencia.FONDO_TEMA_OSCURO);
        botonConsulta.setHorizontalTextPosition((int)CENTER_ALIGNMENT);
        //botonConsulta.setBorder(null);
        this.add(botonConsulta);
        
        //botonApariencia = new Boton();
        botonApariencia.setBounds(((ConstantesApariencia.distanciaABorde*3)+(ConstantesApariencia.anchoComponente*2)), ConstantesApariencia.distanciaVertical, ConstantesApariencia.anchoBoton, ConstantesApariencia.alturaComponente);
        botonApariencia.setBackground(ConstantesApariencia.COLOR_COMPONENTES_TO);
        botonApariencia.setText("Apariencia");
        botonApariencia.setForeground(ConstantesApariencia.FONDO_TEMA_OSCURO);
        botonApariencia.setHorizontalTextPosition((int)CENTER_ALIGNMENT); 
        //botonApariencia.setBorder(null);
        this.add(botonApariencia);
        botonApariencia.addActionListener(this);
        
    
    }
    
    //Métodos
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonApariencia){
            if(temaOscuro){
                botonConsulta.setBackground(ConstantesApariencia.COLOR_COMPONENTES_TC);
                botonApariencia.setBackground(ConstantesApariencia.COLOR_COMPONENTES_TC);
                cuadroNombreProducto.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TC);
                cuadroNombreProducto.setForeground(ConstantesApariencia.FONDO_TEMA_OSCURO);
                menuNombreProducto.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TC);
                menuNombreProducto.setForeground(ConstantesApariencia.FONDO_TEMA_OSCURO);
                menuPlataforma.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TC);
                menuPlataforma.setForeground(ConstantesApariencia.FONDO_TEMA_OSCURO);
                menuOrden.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TC);
                menuOrden.setForeground(ConstantesApariencia.FONDO_TEMA_OSCURO);
                this.setBackground(ConstantesApariencia.FONDO_TEMA_CLARO);
                botonConsulta.setForeground(Color.white);
                botonApariencia.setForeground(Color.white);
                
                temaOscuro = false;
            }
            else if(!temaOscuro){
                botonConsulta.setBackground(ConstantesApariencia.COLOR_COMPONENTES_TO);
                botonApariencia.setBackground(ConstantesApariencia.COLOR_COMPONENTES_TO);
                cuadroNombreProducto.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TO);
                cuadroNombreProducto.setForeground(Color.white);
                menuNombreProducto.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TO);
                menuNombreProducto.setForeground(Color.white);
                menuPlataforma.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TO);
                menuPlataforma.setForeground(Color.white);
                menuOrden.setBackground(ConstantesApariencia.FONDO_CUADRO_TEXTO_TO); 
                menuOrden.setForeground(Color.white);
                this.setBackground(ConstantesApariencia.FONDO_TEMA_OSCURO);
                botonConsulta.setForeground(ConstantesApariencia.FONDO_TEMA_OSCURO);
                botonApariencia.setForeground(ConstantesApariencia.FONDO_TEMA_OSCURO);
                
                temaOscuro = true;
            
            }
            
        
        }else if(e.getSource()==botonConsulta){
        
        }
    }
    
}


package IGU;

import DAO.ProductoDAO;
import consultasvj.ConsultasVJ;
import entidades.Producto;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTable;
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
        String tercerParametro;
        
        public LinkedList<Producto> guardarResultados() throws Exception{
            if(menuNombreProducto.getSelectedItem().equals("Empieza con...")){
                opcion = 'e';
            }else if(menuNombreProducto.getSelectedItem().equals("Contiene...")){
                opcion = 'c';
            }else if(menuNombreProducto.getSelectedItem().equals("Termina con...")){
                opcion = 't';
            }
            
            if(menuOrden.getSelectedItem().toString().equals("Alfabético")){
                tercerParametro = "vj.nombre";
            }else if(menuOrden.getSelectedItem().toString().equals("Plataforma")){
                tercerParametro = "p.nombre";
            }else{
                tercerParametro = "ds.nombre";
            }
            
            if(menuPlataforma.getSelectedItem().equals("Todas")){
                juegos = dao
                        .listarProductos(opcion, cuadroNombreProducto
                                .getText(), tercerParametro);
            
            }else{
                juegos = dao
                        .listarJuegosPlataforma(opcion, cuadroNombreProducto
                                .getText(), menuPlataforma
                                        .getSelectedItem().toString(),tercerParametro);
            
            }
            return juegos;
        }
        
        public void mostrarResultados() throws Exception{
            
            LinkedList<Producto> juegos = guardarResultados();
            
            resultados = new JTable(juegos.size(),5);
            //resultados.setFont(cuadroNombreProducto.getFont());
            
            System.out.println("Tamaño de juegos: "+juegos.size());
            
            for(int i=0;i<juegos.size();i++){
                
                for(int j=0;j<5;j++){
                    switch(j){
                        case 0: resultados.setValueAt(String.valueOf(juegos.get(i).getId()).toUpperCase(),i,j);break;
                        case 1: resultados.setValueAt(juegos.get(i).getNombre().toUpperCase(), i, j);break;
                        case 2: resultados.setValueAt(String.valueOf(juegos.get(i).getPrecio()).toUpperCase(),i,j);break;
                        case 3: resultados.setValueAt(juegos.get(i).getDesarrolladora(), i, j);break;
                        case 4: resultados.setValueAt(juegos.get(i).getPlataforma(), i, j);break;     
                    
                    }
                    
                }
            }
            /*
            resultados.getColumnModel().getColumn(0).setPreferredWidth(2);
            resultados.getColumnModel().getColumn(1).setPreferredWidth(15);
            resultados.getColumnModel().getColumn(2).setPreferredWidth(4);
            resultados.getColumnModel().getColumn(3).setPreferredWidth(10);
            resultados.getColumnModel().getColumn(4).setPreferredWidth(10);
            resultados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
           
        }
        
    }
    
    //Atributos de clase
    
    private final Desplegable menuNombreProducto = new Desplegable();
    private final CuadroTexto cuadroNombreProducto = new CuadroTexto();
    private final Desplegable menuPlataforma = new Desplegable();
    private final Desplegable menuOrden = new Desplegable();
    private final Boton botonConsulta = new Boton();
    private final Boton botonApariencia = new Boton();
    private JFrame ventanaResultados = new JFrame(); 
    private final JPanel panelResultados = new JPanel(); 
    private JTable resultados; // Configurar maunalmente el ancho de las columnas
    private boolean temaOscuro = true;//
    
   
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
        botonConsulta.addActionListener(this);
        
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
            Servicio servicio = new Servicio();
            ventanaResultados = new JFrame();
            Rectangle r = ConsultasVJ.ventana.getBounds();
            ventanaResultados.setBounds((int)r.getX(),(int)r.getY()+((int)r.getHeight()),((int)r
                    .getWidth()+300),400); //la altura dependerá de los resultados obtenidos
            ventanaResultados.setResizable(true);
            //panelResultados.setBackground(this.getBackground());
            //panelResultados.setForeground(botonConsulta.getBackground());
            //ventanaResultados.add(panelResultados);
            //ventanaResultados.remove(resultados); da error
            
            try {
                servicio.mostrarResultados();
            } catch (Exception ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            resultados.setBackground(this.getBackground());
            resultados.setForeground(botonConsulta.getBackground());//blanco para tema oscuro...
                                                                       //...negro para tema claro
            ventanaResultados.add(resultados);
            
            ventanaResultados.setVisible(true);
        
        }
    }
    
}

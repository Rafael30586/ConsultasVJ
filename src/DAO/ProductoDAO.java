/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entidades.DesarrolladoraFabricante;
import entidades.Plataforma;
import entidades.Producto;
import java.util.LinkedList;


public final class ProductoDAO extends DAO{
    public LinkedList<Producto> listarJuegosPlataforma(char opcion, String letras, String filtro, String orden) throws Exception{
        String sql=" ";
        Producto videoJuego;
        DesarrolladoraFabricante desarrolladora;
        Plataforma plataforma;
        LinkedList<Producto> juegos = new LinkedList();
        
        if(opcion=='e'){
        sql="Select vj.id, vj.nombre, vj.precio, p.nombre, ds.nombre "
        + "from plataforma as p inner join producto as vj on p.id = vj.id_plataforma "
        + "inner join desarrolladora_fabricante as ds on ds.id = vj.id_desarrolladora "
        + "where vj.nombre LIKE '"
        +letras+"%' and p.nombre LIKE '"+filtro+"%'"
        + "order by "+orden; //orden tiene que aceptar vj.nombre,p.nombre o ds.nombre
        
        }else if(opcion=='c'){
        sql="Select vj.id, vj.nombre, vj.precio, p.nombre, ds.nombre "
        + "from plataforma as p inner join producto as vj on p.id = vj.id_plataforma "
        + "inner join desarrolladora_fabricante as ds on ds.id = vj.id_desarrolladora "
        + "where vj.nombre LIKE '%"
        +letras+"%' and p.nombre LIKE '"+filtro+"%'"
        + "order by "+orden;
        
        }else if(opcion=='t'){
        sql="Select vj.id, vj.nombre, vj.precio, p.nombre, ds.nombre "
        + "from plataforma as p inner join producto as vj on p.id = vj.id_plataforma "
        + "inner join desarrolladora_fabricante as ds on ds.id = vj.id_desarrolladora "
        + "where vj.nombre LIKE '%"
        +letras+"' and p.nombre LIKE '"+filtro+"%'"
        + "order by "+orden;
        
        }else{
            System.out.println("Ha ocurrido un error");
        
        }
        
        consultarBase(sql);
        
        while(resultado.next()){
            videoJuego = new Producto();
            plataforma = new Plataforma();
            desarrolladora = new DesarrolladoraFabricante();
            videoJuego.setId(resultado.getInt(1));
            videoJuego.setNombre(resultado.getString(2));
            videoJuego.setPrecio(resultado.getDouble(3));
            plataforma.setNombre(resultado.getString(4));
            desarrolladora.setNombre(resultado.getString(5));
            videoJuego.setPlataforma(plataforma);
            videoJuego.setDesarrolladora(desarrolladora);
            
            juegos.add(videoJuego);
        
        }
        
        desconectarBase();
     
        return juegos;
    
    }
    
    public LinkedList<Producto> listarProductos(char opcion,String letras, String orden) throws Exception{
        String sql=" ";
        Producto videoJuego;
        DesarrolladoraFabricante desarrolladora;
        Plataforma plataforma;
        LinkedList<Producto> juegos = new LinkedList();
        
        if(opcion=='e'){
        sql="Select vj.id, vj.nombre, vj.precio, p.nombre, ds.nombre "
        + "from plataforma as p inner join producto as vj on p.id = vj.id_plataforma "
        + "inner join desarrolladora_fabricante as ds on ds.id = vj.id_desarrolladora "
        + "where vj.nombre LIKE '"
        +letras+"%' "
        + "order by "+orden;
        
        }else if(opcion=='c'){
        sql="Select vj.id, vj.nombre, vj.precio, p.nombre, ds.nombre "
        + "from plataforma as p inner join producto as vj on p.id = vj.id_plataforma "
        + "inner join desarrolladora_fabricante as ds on ds.id = vj.id_desarrolladora "
        + "where vj.nombre LIKE '%"
        +letras+"%' "
        + "order by "+orden;
        
        }else if(opcion=='t'){
        sql="Select vj.id, vj.nombre, vj.precio, p.nombre, ds.nombre "
        + "from plataforma as p inner join producto as vj on p.id = vj.id_plataforma "
        + "inner join desarrolladora_fabricante as ds on ds.id = vj.id_desarrolladora "
        + "where vj.nombre LIKE '%"
        +letras+"' "
        + "order by "+orden;
        
        }else{
            System.out.println("Ha ocurrido un error");
        
        }
        
        consultarBase(sql);
        
        while(resultado.next()){
            videoJuego = new Producto();
            plataforma = new Plataforma();
            desarrolladora = new DesarrolladoraFabricante();
            videoJuego.setId(resultado.getInt(1));
            videoJuego.setNombre(resultado.getString(2));
            videoJuego.setPrecio(resultado.getDouble(3));
            plataforma.setNombre(resultado.getString(4));
            desarrolladora.setNombre(resultado.getString(5));
            videoJuego.setPlataforma(plataforma);
            videoJuego.setDesarrolladora(desarrolladora);
            
            juegos.add(videoJuego);
        
        }
        
        desconectarBase();
 
        return juegos;
    }
    
}

package compi1.tarea4_201313720;

import Analizadores.Lexico;
import Analizadores.Nodo;
import Analizadores.Sintactico;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.JTextArea;


/**
 *
 * @author jose
 */
public class Compilador 
{
    
    
    
    int idcrear;
    String nom;
    String apecrear;
    String passcrear;
    String telcrear;
    String emailcrear;
    String dircrear;
    
    public Compilador()
    {        
    }
    
    public void analizar(String entrada)
    {     
        try 
        {
            Reader reader = new StringReader(entrada);
            Lexico analizador_lexico =  new Lexico(reader);
            Sintactico analizador_sintactico = new Sintactico(analizador_lexico);

            //analizador_lexico.Lista_errores = reporte.Lista_errores;
            //.Lista_crearUsuarios = reporte.Lista_crearUsuarios;
            
            analizador_sintactico.parse();
            
            JOptionPane.showMessageDialog(null, "Analisis Completo","Servidor",1);
            //reporte.Reporte_Errores();
            
            Graficador1 g = new Graficador1();
            g.graficarAST(analizador_sintactico.raiz);
            
            this.recorrido(analizador_sintactico.raiz);
            //return analizador_sintactico.resultado;
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un grave problema","Ejemplo",2);
            
            //return "hay errores revice bien cerote";
        }        
        
    }
    
    
    
     public void recorrido(Nodo nodoactual)
    {
        switch (nodoactual.valor) {
            case "Log":
                for(Nodo hijo:nodoactual.hijos.get(0).hijos){
                    this.recorrido(hijo);
                }
                break;
                
            case "Id\n" +"del\n"+ "Usuario":
                int idus = Integer.valueOf(nodoactual.hijos.get(0).valor);
                break;
                
            case "Password\n" +"del\n"+ "Usuario":
                int pasus = Integer.valueOf(nodoactual.hijos.get(0).valor);
                break;
            
                
            /***EN CASO QUE VENGA REGISTRAR UN USUARIO****/    
                
            case "Crear Usuario":
                for(Nodo hijo:nodoactual.hijos){
                    this.recorrido(hijo);
                }
                //Lista_crearUsuarios.add(new Usuarios(idcrear,nom,apecrear,passcrear,telcrear,emailcrear,dircrear));
                //Lista_crearUsuarios.add(u);
                //hash.put(nuevo)
                break;
                
            case "Parametros Usuario":
                
                for(Nodo hijo:nodoactual.hijos.get(0).hijos)
                {
                    this.recorrido(hijo);
                }  
                
                break;
                
            case "Id \n Usuario Creado":
                
                idcrear = Integer.valueOf(nodoactual.hijos.get(0).valor);
               
                
                break;
                
            case "Nombre \n Usuario Creado":
                 nom = nodoactual.hijos.get(0).valor;
                
                break;
                
            case "Apellido \n Usuario Creado":
                 apecrear = nodoactual.hijos.get(0).valor;
                
                break;
                
            case "Password \n Usuario Creado":
                 passcrear = nodoactual.hijos.get(0).valor;
                
                break;
                
            case "Telefono \n Usuario Creado":
                 telcrear = nodoactual.hijos.get(0).valor;
                 
                break;
                
            case "Email \n Usuario Creado":
                 emailcrear = nodoactual.hijos.get(0).valor;
                 
                break;
            
            case "Direccion \n Usuario Creado":
                 dircrear = nodoactual.hijos.get(0).valor;
                 
                break;
                
            /***EN CASO QUE VENGA REGISTRAR UN USUARIO****/        
            
            case "Crear Tienda":
                for(Nodo hijo:nodoactual.hijos)
                {
                    this.recorrido(nodoactual);
                }
                break;
                
            case "Paramtros \n de \n Tienda":
                for(Nodo hijo:nodoactual.hijos.get(0).hijos)
                {
                    this.recorrido(nodoactual);
                }
                break;
                
            case "Codigo \n de \n Tienda":
                int codtienda = Integer.valueOf(nodoactual.hijos.get(0).valor);
                break;
            
            case "Propietario \n de \n Tienda":
                int proptienda = Integer.valueOf(nodoactual.hijos.get(0).valor);
                break;
                
            case "Nombre \n de \n Tienda":
                String nomtienda = nodoactual.hijos.get(0).valor;
                break;
             
            case "Direccion \n de \n Tienda":
                String dirtienda = nodoactual.hijos.get(0).valor;
                break;
            
            case "Telefono \n de \n Tienda":
                int teltienda = Integer.valueOf(nodoactual.hijos.get(0).valor);
                break;
                
            case "Imagen \n de \n Tienda":
                String imgtienda = nodoactual.hijos.get(0).valor;
                break;
                
            /***EN CASO QUE VENGA REGISTRAR UN PRODUCTO****/
            
            case "Crear Producto":
                for(Nodo hijo:nodoactual.hijos)
                {
                    this.recorrido(nodoactual);
                }
            
                break;
                
            case "Parametros \n de \n Producto":
                for(Nodo hijo:nodoactual.hijos.get(0).hijos)
                {
                    this.recorrido(nodoactual);
                }
                break;
                
            case "Codigo \n del producto \n creado":
                int codpro = Integer.valueOf(nodoactual.hijos.get(0).valor);
                break;
                
            case "Nombre \n del producto \n creado":
                String nompro = nodoactual.hijos.get(0).valor;
                break;
                
            case "Cantidad \n del producto \n creado":
                int cantpro = Integer.valueOf(nodoactual.hijos.get(0).valor);
                break;
                
            case "Marca \n del producto \n creado":
                String marpro = nodoactual.hijos.get(0).valor;
                break;
                
            case "Color \n del producto \n creado":
                String colpro = nodoactual.hijos.get(0).valor;
                break;
                
            case "Tamaño \n del producto \n creado":
                int tampro = Integer.valueOf(nodoactual.hijos.get(0).valor);
                break;
                
            case "Imagen \n del producto \n creado":
                String imgpro = nodoactual.hijos.get(0).valor;
                break;
                
            case "Sucursal \n del producto \n creado":
                int sucurpro = Integer.valueOf(nodoactual.hijos.get(0).valor);
                break;
                
           
            default:
                //throw new AssertionError();
        }
    }
    
    
    
    public Object evaluarExpresion(Nodo nodoactual)
    {
        if(nodoactual.hijos.size()==2)
        {
            Object izq = this.evaluarExpresion(nodoactual.hijos.get(0));
            Object der = this.evaluarExpresion(nodoactual.hijos.get(1));
            
            switch (nodoactual.valor) 
            {
                case "+":
                    return Integer.valueOf(izq.toString()) + Integer.valueOf(der.toString());
                case "-":
                    return Integer.valueOf(izq.toString()) - Integer.valueOf(der.toString());
                case "*":
                    return Integer.valueOf(izq.toString()) * Integer.valueOf(der.toString());
                default:
                    return 1;
            }
            
        }
        else//solo los que tienen 1 hijos
        {           
            switch (nodoactual.valor) 
            {                   
                case "numero":   
                    Object valor3 = nodoactual.hijos.get(0).valor;
                    Integer val_int =Integer.valueOf(valor3.toString());
                    return val_int;
                         
                default:
                   return 1;
            }
        }
    }
    
}

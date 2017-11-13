/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;
import java.sql.Connection;//Paso 10: iNecesario para conexion con MySQL
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author LAB01
 */
public class ConexionBD 
{
   //PASO 11 : Dclarando objetos para la conexion
  private static Connection conex; // Objeto tipo conexion
  private static final String DRIVER="com.mysql.jdbc.Drive";
  private static final String USER="root";
  private static final String PASS="";
  private static final String URL="jdbc:mysql://localhost:330/conexion";// lleva el nombre de la base de dato creada
  
  
  //PASO 12: CONSTRUCTOR DE LA CLASE
  public ConexionBD()
  {
      
      conex=null;// INICIALIZAMOS LA VARIABLE
      
      try 
      {
       Class.forName(DRIVER);
       conex=DriverManager.getConnection(URL, USER, PASS);
       if (conex !=null)
       {
         System.out.println("Conexion Establecida");
           
       }
      }
      
      // METODO PARA MANEJAR EXCEPCIONES
      catch(ClassNotFoundException | SQLException e)
      { 
        System.out.println("Error en la Conexion");
          
      }
  }
  
  //PASO 13: DEFINICION METODOS PARA CONECTAR Y DESCONECTAR
  public Connection conectar()
  {
    return conex;// RETORNA EL OBJETO CONEX
    
  }
  public void desconectar() 
  {
      
      conex= null;
      if (conex==null)
      {
       System.out.println("Conexion Finalizada");
          
      }
  }
}

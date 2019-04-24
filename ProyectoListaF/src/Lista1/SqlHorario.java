/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static Lista1.Lista.conn;

/**
 *
 * @author Luis Angel Olivo Martinez
 */
public class SqlHorario implements DaoHorario{

    @Override
    public List<String> getDatos2() throws SQLException{//(4) este metodo es el que devuelve la lista
        List<String> listaDatos=new ArrayList<>();
        Statement s;
        Connection conn=null;
        conn=new Conexion().getConnection();//(5) este metodo conecta a la bd
        ResultSet rs = null;
        String sQuery="select*from horariomateria;";
        try
        {
            s=conn.createStatement();
            //s1 = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs=s.executeQuery (sQuery);
            System.out.println("Ejecutó la consulta");
            SqlMateria aux=new SqlMateria();
            
            //llenamos la lista
            while (rs!=null && rs.next()) {
                int idMateria=0;
                idMateria=(rs.getInt("idMateria"));
                String materia=aux.sacarNombre(idMateria);
                listaDatos.add(materia);
                listaDatos.add(rs.getString("salon"));
                int numDia=rs.getInt("dia");
                String diaS="indef";
                switch(numDia){
                    case 1:{
                        diaS="lunes";
                    }break;
                    case 2:{
                        diaS="martes";
                    }break;
                    case 3:{
                        diaS="miercoles";
                    }break;
                    case 4:{
                        diaS="jueves";
                    }break;
                    case 5:{
                        diaS="viernes";
                    }break;
                    case 6:{
                        diaS="sabado";
                    }break;
                    case 7:{
                        diaS="domingo";
                    }break;
                    default:{
                        diaS="indef";
                    }break;
                }
                listaDatos.add(diaS);
                listaDatos.add(rs.getString("horaInicio"));
                listaDatos.add(rs.getString("horaFin"));
            }
        }
        catch (SQLException e)
        {
            System.err.println ("Error: " + e.getMessage () + "\n" + e.getErrorCode ());
        }
        finally{
            conn.close();
        }
        return listaDatos;
    }
      
    @Override
    public int borrarDatos2() throws SQLException{
       String sentencia;
       sentencia="delete from horariomateria;";     
       System.out.println(sentencia);
           try  {                 
               conn=new Conexion().getConnection();
               Statement s = conn.createStatement (); 	       
               //updtae para sentencias INSERT, UPDATE O DELETE, que no regresan un conjunto de resultados 	       
               return s.executeUpdate(sentencia); //regresa 0 o el número de filas afectadas  si todo ok
 	   }
 	   catch (SQLException e)
 	   {
 	       System.err.println ("Error: " + e.getMessage () + "\n" + e.getErrorCode ());
 	   }
           finally{
              conn.close();
           }
           //si llegó a este punto quiere decir que lanzó una excepción
 	   return -1;  //regresar -1 si hay error
    }

    @Override
    public int agregarDatos2(int idMateria,String salon,int dia,String horaInicio,String horaFin) throws SQLException{
       String sentencia;
       //el id es autoincremental
       //Iterator<String> it = datos.iterator(); 
       //while(it.hasNext()){
           sentencia="insert into horariomateria (idMateria,salon,dia,horaInicio,horaFin) values ('"+idMateria+"','"+salon+"','"+dia+"','"+horaInicio+"','"+horaFin+"');";     
       System.out.println(sentencia);
           try  {                 
               conn=new Conexion().getConnection();
               Statement s = conn.createStatement (); 	       
               //updtae para sentencias INSERT, UPDATE O DELETE, que no regresan un conjunto de resultados 	       
               return s.executeUpdate(sentencia); //regresa 0 o el número de filas afectadas  si todo ok
 	   }
 	   catch (SQLException e)
 	   {
 	       System.err.println ("Error: " + e.getMessage () + "\n" + e.getErrorCode ());
 	   }
           finally{
              conn.close();
           }
     //  }
       
           //si llegó a este punto quiere decir que lanzó una excepción
 	   return -1;  //regresar -1 si hay error
    }

    public List<String> getMateriasH(int x) throws SQLException {
        List<String> listaDatos=new ArrayList<>();
        Statement s;
        Connection conn=null;
        conn=new Conexion().getConnection();//(5) este metodo conecta a la bd
        ResultSet rs = null;
        String sQuery="select*from horariomateria where idMateria="+x+";";
        try
        {
            s=conn.createStatement();
            //s1 = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs=s.executeQuery (sQuery);
            System.out.println("Ejecutó la consulta");
            SqlMateria aux=new SqlMateria();
            
            //llenamos la lista
            while (rs!=null && rs.next()) {
                int idMateria=0;
                idMateria=(rs.getInt("idMateria"));
                String materia=aux.sacarNombre(idMateria);
                listaDatos.add(materia);
                listaDatos.add(rs.getString("salon"));
                int numDia=rs.getInt("dia");
                String diaS="indef";
                switch(numDia){
                    case 1:{
                        diaS="lunes";
                    }break;
                    case 2:{
                        diaS="martes";
                    }break;
                    case 3:{
                        diaS="miercoles";
                    }break;
                    case 4:{
                        diaS="jueves";
                    }break;
                    case 5:{
                        diaS="viernes";
                    }break;
                    case 6:{
                        diaS="sabado";
                    }break;
                    case 7:{
                        diaS="domingo";
                    }break;
                    default:{
                        diaS="indef";
                    }break;
                }
                listaDatos.add(diaS);
                listaDatos.add(rs.getString("horaInicio"));
                listaDatos.add(rs.getString("horaFin"));
            }
        }
        catch (SQLException e)
        {
            System.err.println ("Error: " + e.getMessage () + "\n" + e.getErrorCode ());
        }
        finally{
            conn.close();
        }
        return listaDatos;
    }

    List<String> getMateriasHorarios() throws SQLException {
        List<String> listaDatos=new ArrayList<>();
        Statement s;
        Connection conn=null;
        conn=new Conexion().getConnection();//(5) este metodo conecta a la bd
        ResultSet rs = null;
        String sQuery="select* from horariomateria order by idMateria;";
        try
        {
            s=conn.createStatement();
            //s1 = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs=s.executeQuery (sQuery);
            System.out.println("Ejecutó la consulta");
            SqlMateria aux=new SqlMateria();
            //llenamos la lista
            //int idM=rs.getInt("idMateria");
            while (rs!=null && rs.next()) {
                boolean b=true;
                int idM=rs.getInt("idMateria");
                String materia=aux.sacarNombre(idM);
                listaDatos.add(materia);
                /////////////////////////////////////////////////////////////////////////////
                int numDia=rs.getInt("dia");
                String diaS="indef";
                switch(numDia){
                    case 1:{
                        diaS="hora inicio: "+rs.getString("horaInicio")+" hora fin: "+rs.getString("horaFin")+"\n salon: "+rs.getString("salon");
                        listaDatos.add(diaS);
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        
                    }break;
                    case 2:{
                        diaS="hora inicio: "+rs.getString("horaInicio")+" hora fin: "+rs.getString("horaFin")+"\n salon: "+rs.getString("salon");
                        
                        listaDatos.add("");listaDatos.add(diaS);
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                    }break;
                    case 3:{
                        diaS="hora inicio: "+rs.getString("horaInicio")+" hora fin: "+rs.getString("horaFin")+"\n salon: "+rs.getString("salon");
                        
                        listaDatos.add("");
                        listaDatos.add("");listaDatos.add(diaS);
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                    }break;
                    case 4:{
                        diaS="hora inicio: "+rs.getString("horaInicio")+" hora fin: "+rs.getString("horaFin")+"\n salon: "+rs.getString("salon");
                        
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");listaDatos.add(diaS);
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                    }break;
                    case 5:{
                        diaS="hora inicio: "+rs.getString("horaInicio")+" hora fin: "+rs.getString("horaFin")+"\n salon: "+rs.getString("salon");
                        
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");listaDatos.add(diaS);
                        listaDatos.add("");
                        listaDatos.add("");
                    }break;
                    case 6:{
                        diaS="hora inicio: "+rs.getString("horaInicio")+" hora fin: "+rs.getString("horaFin")+"\n salon: "+rs.getString("salon");
                        
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");listaDatos.add(diaS);
                        listaDatos.add("");
                    }break;
                    case 7:{
                        diaS="hora inicio: "+rs.getString("horaInicio")+" hora fin: "+rs.getString("horaFin")+"\n salon: "+rs.getString("salon");
                        
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");listaDatos.add(diaS);
                    }break;
                    default:{
                        diaS="";
                        listaDatos.add(diaS);
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                        listaDatos.add("");
                    }break;
                }   
                ////////////////////////////////////////////////////////////////////////////
                rs.next();
                int id1=rs.getInt("idMateria");
                if(idM==id1){
                    b=false;
                }
                if(b==false){
                    rs.previous();
                }
                while(idM==id1){
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println ("Error: " + e.getMessage () + "\n" + e.getErrorCode ());
        }
        finally{
            conn.close();
        }
        return listaDatos;
    }

    public List<String> getIDCM() throws SQLException {
        List<String> listaDatos=new ArrayList<>();
        Statement s;
        Connection conn=null;
        conn=new Conexion().getConnection();//(5) este metodo conecta a la bd
        ResultSet rs = null;
        String sQuery="select* from horariomateria group by idMateria;";
        try
        {
            s=conn.createStatement();
            //s1 = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs=s.executeQuery (sQuery);
            System.out.println("Ejecutó la consulta");
            SqlMateria aux=new SqlMateria();
            
            //llenamos la lista
            while (rs!=null && rs.next()) {
                int idMateria=0;
                idMateria=(rs.getInt("idMateria"));
                String materia=aux.sacarNombre(idMateria);
                listaDatos.add(materia);
            }
        }
        catch (SQLException e)
        {
            System.err.println ("Error: " + e.getMessage () + "\n" + e.getErrorCode ());
        }
        finally{
            conn.close();
        }
        return listaDatos;
    
    }
        public List<String> getMateriasHEsp(int x) throws SQLException {
        List<String> listaDatos=new ArrayList<>();
        Statement s;
        Connection conn=null;
        conn=new Conexion().getConnection();//(5) este metodo conecta a la bd
        ResultSet rs = null;
        String sQuery="select*from horariomateria where idMateria="+x+";";
        try
        {
            s=conn.createStatement();
            //s1 = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs=s.executeQuery (sQuery);
            System.out.println("Ejecutó la consulta");
            SqlMateria aux=new SqlMateria();
            
            //llenamos la lista
            while (rs!=null && rs.next()) {
                /*int idMateria=0;
                idMateria=(rs.getInt("idMateria"));
                String materia=aux.sacarNombre(idMateria);*/
                //listaDatos.add(materia);
                
                int numDia=rs.getInt("dia");
                String diaS="indef";
                switch(numDia){
                    case 1:{
                        diaS="lunes";
                    }break;
                    case 2:{
                        diaS="martes";
                    }break;
                    case 3:{
                        diaS="miercoles";
                    }break;
                    case 4:{
                        diaS="jueves";
                    }break;
                    case 5:{
                        diaS="viernes";
                    }break;
                    case 6:{
                        diaS="sabado";
                    }break;
                    case 7:{
                        diaS="domingo";
                    }break;
                    default:{
                        diaS="indef";
                    }break;
                }
                listaDatos.add(diaS);
                listaDatos.add(rs.getString("salon"));
                listaDatos.add(rs.getString("horaInicio"));
                listaDatos.add(rs.getString("horaFin"));
            }
        }
        catch (SQLException e)
        {
            System.err.println ("Error: " + e.getMessage () + "\n" + e.getErrorCode ());
        }
        finally{
            conn.close();
        }
        return listaDatos;
    }

    List<String> consultarIDMaterias() throws SQLException {
    List<String> listaIDMaterias = new ArrayList<String>();
    Statement s;
    Connection conn = null;
    conn = new Conexion().getConnection();
    ResultSet rs = null;
    String sQuery = "select idmateria from horarioMateria group by idmateria order by idmateria;";
    try {
      s = conn.createStatement();
      rs = s.executeQuery(sQuery);
      while (rs != null && rs.next()) {
        listaIDMaterias.add(String.valueOf(rs.getInt("idmateria")));
      }
    } catch (SQLException e) {
      System.err.println("Error al consultar: " + e.getMessage() + "\n" + e.getErrorCode());
    } finally {
      conn.close();
    }
    return listaIDMaterias; 
    }

    List<String> consultarHorariosMaterias(int idmateria) throws SQLException {
    List<String> listaHorariosMaterias = new ArrayList<String>();
    Statement s;
    Connection conn = null;
    conn = new Conexion().getConnection();
    ResultSet rs = null;
    /*String sQuery = "select idhorarioMateria, idmateria, dia, salon, horaEntrada, horaSalida from "
            + "horarioMateria where idmateria="+idmateria+" order by dia;";*/
    String sQuery = "select id, idmateria, dia, salon, horaInicio, horaFin from "
            + "horarioMateria where idmateria="+idmateria+" order by dia;";
    try {
      s = conn.createStatement();
      rs = s.executeQuery(sQuery);
      while (rs != null && rs.next()) {
        listaHorariosMaterias.add(String.valueOf(rs.getInt("id")));
        listaHorariosMaterias.add(String.valueOf(rs.getInt("idmateria")));
        listaHorariosMaterias.add(rs.getString("dia"));
        listaHorariosMaterias.add(rs.getString("salon"));
        listaHorariosMaterias.add(rs.getString("horaInicio"));
        listaHorariosMaterias.add(rs.getString("horaFin"));
      }
    } catch (SQLException e) {
      System.err.println("Error al consultar: " + e.getMessage() + "\n" + e.getErrorCode());
    } finally {
      conn.close();
    }
    return listaHorariosMaterias; 
    }

}
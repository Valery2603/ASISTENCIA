/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Database.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Modelo.Alumno;

/**
 *
 * @author A07
 */
public class AlumnoDAO {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    Alumno obja = new Alumno();
    
    public AlumnoDAO(){
        CON=Conexion.getInstancia();
    }
   
    public List<Alumno> listar(String texto) {
        List<Alumno> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM ALUMNO WHERE nombres LIKE ?");
            ps.setString(1,"%" + texto +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Alumno(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
     public List<Alumno> buscar(String texto) {
        List<Alumno> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM ALUMNO WHERE nombres LIKE ?");
            ps.setString(1,"%" + texto +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Alumno(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
}

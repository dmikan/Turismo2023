package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Clase ConsultasDestino para realizar operaciones CRUD en la tabla producto.
 */
public class ConsultasDestino extends Conexion {

    public ConsultasDestino(){
    }
    // tabla
    public void mostrarRegistros(JTable tbl_destiny) {
        Conexion objetoConexion = new Conexion();
        DefaultTableModel tmodel = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter(tmodel);
        tbl_destiny.setRowSorter(OrdenarTabla);
        
        // Método para consultas en la tabla
        String sql = "";
        tmodel.addColumn("Id");
        tmodel.addColumn("Nombre");
        tmodel.addColumn("Codigo");
        tmodel.addColumn("Precio");
        tmodel.addColumn("Destino");
        
        tbl_destiny.setModel(tmodel);
        
        sql = "SELECT * FROM destino";
        String[] datos = new String[5];
        PreparedStatement tb = null;
        Conexion conexion = new Conexion(); // Crear una instancia
        Connection con = conexion.getConexion(); // Llamar al método en esa instancia
        ResultSet rs = null;
        try {
            tb = con.prepareStatement(sql);
            rs = tb.executeQuery();
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                
                tmodel.addRow(datos);
                tbl_destiny.setModel(tmodel);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
        }
    }    

    
    // Método para registrar un nuevo destino
    public boolean registrar(Destino p) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO destino (codigo, nombre, precio, destino) VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setFloat(3, p.getPrecio());
            ps.setString(4, p.getDestino());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }
    }

    // Método para modificar un destino existente
    public boolean modificar(Destino p) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE destino SET codigo = ?, nombre = ?, precio = ?, destino = ? WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setFloat(3, p.getPrecio());
            ps.setInt(5, p.getId());
            ps.setString(4, p.getDestino());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    // Método para eliminar un destino
    public boolean eliminar(Destino p) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM destino WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    // Método para buscar un destino por su id
    public boolean buscar(Destino p) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "SELECT * FROM destino WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                /*p.setPrecio(Integer.parseInt(rs.getString("precio")));*/
                p.setPrecio(rs.getFloat("precio"));
                p.setDestino(rs.getString("destino"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }
    }
}





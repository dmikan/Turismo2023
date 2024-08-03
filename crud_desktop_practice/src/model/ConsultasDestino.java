package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Clase ConsultasDestino para realizar operaciones CRUD en la tabla producto.
 */
public class ConsultasDestino extends Conexion {

    // Método para registrar un nuevo destino
    public boolean registrar(Destino p) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO producto (codigo, nombre, precio) VALUES (?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getPrecio());
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
        String sql = "UPDATE producto SET codigo = ?, nombre = ?, precio = ? WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getPrecio());
            ps.setInt(4, p.getId());
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
        String sql = "DELETE FROM producto WHERE id = ?";

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
        String sql = "SELECT * FROM producto WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(Integer.parseInt(rs.getString("precio")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }
    }
}





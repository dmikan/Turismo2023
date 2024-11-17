/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Principal;
import controller.ControllerDestino;
import view.ViewDestino;
import com.mysql.cj.xdevapi.Statement;
import model.ConsultasDestino;
import model.Destino;
import model.Conexion;
import view.ViewDestino;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author djper
 */
public class ControllerDestino implements ActionListener {

    private Destino pro;
    private ViewDestino frmpro;
    private ConsultasDestino proC;
    private Principal frmpri;

    public ControllerDestino(Destino pro, ViewDestino frmpro, ConsultasDestino proC, Principal frmpri) {
        this.pro = pro;
        this.frmpro = frmpro;
        this.frmpri = frmpri;
        this.proC = proC;
        this.frmpro.btn_create.addActionListener((ActionListener) this);
        this.frmpro.btn_update.addActionListener((ActionListener) this);
        this.frmpro.btn_clean.addActionListener((ActionListener) this);
        this.frmpro.btn_read.addActionListener((ActionListener) this);
        this.frmpro.btn_delete.addActionListener((ActionListener) this);
        this.frmpro.btn_principal.addActionListener((ActionListener) this);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        /////// boton agregar//////
        if (e.getSource() == frmpro.btn_create) {
            pro.setCodigo(frmpro.txt_code.getText());
            pro.setNombre(frmpro.txt_name.getText());
            pro.setPrecio(Integer.parseInt(frmpro.txt_price.getText()));
            pro.setDestino(frmpro.txt_destiny.getText());
            if (proC.registrar(pro)) {
                JOptionPane.showMessageDialog(null, "Producto agregado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar");
                limpiar();
            }

        }
        /////// fin agregar //////                
        /////// boton modificar //////
        if (e.getSource() == frmpro.btn_update) {
            pro.setId(Integer.parseInt(frmpro.txt_id.getText()));
            pro.setCodigo(frmpro.txt_code.getText());
            pro.setNombre(frmpro.txt_name.getText());
            pro.setPrecio(Integer.parseInt(frmpro.txt_price.getText()));
            pro.setDestino(frmpro.txt_destiny.getText());
            if (proC.modificar(pro)) {
                JOptionPane.showMessageDialog(null, "Producto modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        /////// boton eliminar //////
        if (e.getSource() == frmpro.btn_delete) {
            pro.setId(Integer.parseInt(frmpro.txt_id.getText()));
            if (proC.eliminar(pro)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        /////// boton buscar //////
        if (e.getSource() == frmpro.btn_read) {
            pro.setId(Integer.parseInt(frmpro.txt_id.getText()));
            if (proC.buscar(pro)) {
                frmpro.txt_id.setText(String.valueOf(pro.getId()));
                frmpro.txt_code.setText(pro.getCodigo());
                frmpro.txt_name.setText(pro.getNombre());
                frmpro.txt_price.setText(String.valueOf(pro.getPrecio()));
                frmpro.txt_destiny.setText(pro.getDestino());
            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar");
                limpiar();
            }
        }// fin buscar/////

        ///Limpiar
        if (e.getSource() == frmpro.btn_clean) {
            limpiar();
        }
        // fin limpiar 
        
        //método para ir a principal
        if(e.getSource()==frmpro.btn_principal){
            frmpri.setVisible(true);
            frmpro.dispose();
        }    
        
    }        

    private void limpiar() {
        frmpro.txt_code.setText(null);
        frmpro.txt_id.setText(null);
        frmpro.txt_name.setText(null);
        frmpro.txt_price.setText(null);
        frmpro.txt_destiny.setText(null);
    }



    //public void actionPerformedPrincipal(ActionEvent e) {
    //    if(e.getSource()==frmpro.btn_principal){
    //        frmpri.setVisible(true);
    //        frmpro.dispose();
    //    }
    //    
    //    if(e.getSource()==frmpri.btn_exit){
    //    System.exit(0);
    //}
    //}    
    
}


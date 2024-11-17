/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Principal;
import view.ViewDestino;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/**
 *
 * @author djper
 */
public class ControllerPrincipal implements ActionListener {
    private Principal frmPri;
    private ViewDestino frmPro;

    public ControllerPrincipal(Principal frmPri, ViewDestino frmPro) {
        this.frmPri = frmPri;
        this.frmPro = frmPro;
        this.frmPri.btn_destiny.addActionListener(this);
        this.frmPri.btn_exit.addActionListener(this);        
    }
public void inicar(){
    frmPro.setTitle("Destino");
    frmPri.setTitle("Principal");
    frmPri.setLocationRelativeTo(null);
    frmPro.setLocationRelativeTo(null);
    
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frmPri.btn_destiny){
            frmPro.setVisible(true);
            //frmPri.dispose();
        }
        
        if(e.getSource()==frmPri.btn_exit){
        System.exit(0);
    }
    }
    

}

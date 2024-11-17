/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud_desktop;


import controller.ControllerPrincipal;
import controller.ControllerDestino;
import model.ConsultasDestino;
import model.Destino;
import view.Principal;
import view.ViewDestino;
import model.Conexion;

/**
 *
 * @author djper
 */
public class Crud_desktop {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here        
        Destino pro =new Destino();
        ConsultasDestino proC = new ConsultasDestino();
        ViewDestino frmPro = new ViewDestino();
        Principal frmPri =new  Principal();
        ControllerDestino ctrlPro = new   ControllerDestino(pro,frmPro,proC, frmPri);   
        ControllerPrincipal ctrlPri = new ControllerPrincipal (frmPri,frmPro);
        ctrlPri.inicar();
        frmPri.setVisible(true);     
              
        

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.MetodosClientes;
import vista.FRM_VentanaPrincipalMigracion;

/**
 *
 * @author Carlos
 */
public class Controlador_FRM_VentanaPrincipalMigracion implements ActionListener {
    
    MetodosClientes metodosClientes;
    FRM_VentanaPrincipalMigracion frm_VentanaPrincipalMigracion;

    public Controlador_FRM_VentanaPrincipalMigracion(FRM_VentanaPrincipalMigracion frm_VentanaPrincipalMigracion) {
        
        this.frm_VentanaPrincipalMigracion=frm_VentanaPrincipalMigracion;
        metodosClientes= new MetodosClientes();
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equalsIgnoreCase("Consultar")) {
            if(metodosClientes.consultar(frm_VentanaPrincipalMigracion.devolverCedula())) {
                frm_VentanaPrincipalMigracion.mostrarInformacion(metodosClientes.getArregloInformacion());
                frm_VentanaPrincipalMigracion.habilitarEdicion();
                frm_VentanaPrincipalMigracion.habilitarModificar();
                frm_VentanaPrincipalMigracion.habilitarCancelar();
            }else {
                frm_VentanaPrincipalMigracion.habilitarEdicion();
                frm_VentanaPrincipalMigracion.habilitarRegistrar();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Registrar")) {
            metodosClientes.agregar(frm_VentanaPrincipalMigracion.devolverInformacion());
            frm_VentanaPrincipalMigracion.resetearGUI();
        }
        if(e.getActionCommand().equalsIgnoreCase("Modificar")) {
            metodosClientes.modificar(frm_VentanaPrincipalMigracion.devolverInformacion());
            frm_VentanaPrincipalMigracion.resetearGUI();
        }
        if(e.getActionCommand().equalsIgnoreCase("Cancelar")) {
            metodosClientes.cancelar(frm_VentanaPrincipalMigracion.devolverCedula());
            frm_VentanaPrincipalMigracion.resetearGUI();
        }
        if(e.getActionCommand().equalsIgnoreCase("Atender")) {
            if(metodosClientes.devolverInfoPrimero()!=null) {
                frm_VentanaPrincipalMigracion.mostrarAtencionCliente(metodosClientes.devolverInfoPrimero());
                metodosClientes.eliminarPrimero();
            }
            else {
                JOptionPane.showMessageDialog(null,"No existen clientes en espera");
                frm_VentanaPrincipalMigracion.mostrarAtencionCliente("");
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Reporte")) {
            if(metodosClientes.devolverInfoPrimero()!=null) {
                frm_VentanaPrincipalMigracion.mostrarReporte(metodosClientes.devolverLista(),""+metodosClientes.devolverCantidadNodos(),""+metodosClientes.promedioEdad());
            }
            else {
                JOptionPane.showMessageDialog(null,"No existen clientes registrados");
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("<")) {
        }
        if(e.getActionCommand().equalsIgnoreCase(">")) {
        }
        if(e.getActionCommand().equalsIgnoreCase("Normal")) {
            frm_VentanaPrincipalMigracion.definirPrioridad("Normal");
        }
        if(e.getActionCommand().equalsIgnoreCase("7600")) {
            frm_VentanaPrincipalMigracion.definirPrioridad("7600");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Carlos
 */
public class NodoCliente {
    
    String cedula,nombre,edad,fecha,prioridad;
    NodoCliente siguiente;

    public NodoCliente(String cedula, String nombre, String edad, String fecha, String prioridad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.siguiente=null;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    public NodoCliente getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    } 
}

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
public class MetodosClientes {
    
    NodoCliente primero;
    String arregloInformacion[];

    public MetodosClientes() {
        
        primero=null;
        arregloInformacion= new String[4];
    }
    
    public String devolverLista() {
        
        NodoCliente auxiliar=primero;
        String valores="";
        
        while(auxiliar!=null) {
            
            valores+=auxiliar.getCedula()+"\n"+auxiliar.getNombre()+"\n"+auxiliar.getEdad()+"\n"+
                     auxiliar.getFecha()+"\n"+auxiliar.getPrioridad()+"\n\n";
            
            auxiliar=auxiliar.getSiguiente();
        }
        
        return valores;
    }
    public String devolverInfoPrimero() {
        
        if(primero!=null) {
            String atendiendo="Atendiendo a:\n\n";
        
            atendiendo+=primero.getCedula()+"\n"+primero.getNombre()+"\n"+primero.getEdad()+"\n"+
                        primero.getFecha()+"\n"+primero.getPrioridad()+"\n\n";
        
            return atendiendo;
        }
        else {
            return null;
        }
    }
    public boolean consultar(String cedula) {
        
        boolean encontrado=false;
        NodoCliente auxiliar=primero;
        while(auxiliar!=null) {
            if(auxiliar.getCedula().equalsIgnoreCase(cedula)) {
                arregloInformacion[0]=auxiliar.getNombre();
                arregloInformacion[1]=auxiliar.getEdad();
                arregloInformacion[2]=auxiliar.getFecha();
                arregloInformacion[3]=auxiliar.getPrioridad();
                encontrado=true;
            }
            auxiliar=auxiliar.getSiguiente();
        }
        return encontrado;
    }
    public void agregar(String arreglo[]) {
        
        NodoCliente auxiliar;
        
        if(arreglo[4].equalsIgnoreCase("7600")) {
            auxiliar= new NodoCliente(arreglo[0],arreglo[1],arreglo[2],arreglo[3],arreglo[4]);
            auxiliar.setSiguiente(primero);
            primero=auxiliar;
        }
        else {
            if(primero!=null) {
                auxiliar= devolverUltimo();
                auxiliar.setSiguiente(new NodoCliente(arreglo[0],arreglo[1],arreglo[2],arreglo[3],arreglo[4]));
            }
            else {
                auxiliar= new NodoCliente(arreglo[0],arreglo[1],arreglo[2],arreglo[3],arreglo[4]);
                auxiliar.setSiguiente(primero);
                primero=auxiliar;
            }
        }
    }
    public void modificar(String informacion[]) {
        
        NodoCliente auxiliar=primero;
        while(auxiliar!=null) {
            if(auxiliar.getCedula().equals(informacion[0])) {
                auxiliar.setNombre(informacion[1]);
                auxiliar.setEdad(informacion[2]);
                auxiliar.setFecha(informacion[3]);
                auxiliar.setPrioridad(informacion[4]);
            }
            auxiliar=auxiliar.getSiguiente();
        }
    }
    public void cancelar(String cedula)
    {
        NodoCliente auxiliar=primero;
        boolean haEliminado=false;
        
        if(auxiliar.getCedula().equalsIgnoreCase(cedula)) {
            primero=primero.getSiguiente();
            haEliminado=true;
        }
        else {
            auxiliar=devolverUltimo();
            if(auxiliar.getCedula().equalsIgnoreCase(cedula)) {
                auxiliar=devolverAntepenultimoNodo();
                auxiliar.setSiguiente(null);
                haEliminado=true;
            }
        }
        if(!haEliminado) {
            NodoCliente temporal=null;
            while(auxiliar!=null) {
                if(auxiliar.getCedula().equals(cedula)) {
                    temporal.setSiguiente(auxiliar.getSiguiente());
                }
                temporal=auxiliar;
                auxiliar=auxiliar.getSiguiente();
            }
        }
    }
    public NodoCliente devolverAntepenultimoNodo()
    {
        NodoCliente auxiliar=primero;
        while(auxiliar.getSiguiente().getSiguiente()!=null)
        {
            auxiliar=auxiliar.getSiguiente();
        }
        return auxiliar;
    }
    public NodoCliente devolverUltimo() {
        
        NodoCliente auxiliar=primero;
        while(auxiliar.getSiguiente()!=null) {
            auxiliar=auxiliar.getSiguiente();
        }
        return auxiliar;
    }
    public void eliminarPrimero() {
        if(primero!=null)
            primero=primero.getSiguiente();
    }
    public double promedioEdad() {
        
        int sumaTotal=0;
        double promedio=0;
        
        NodoCliente auxiliar=primero;
        while(auxiliar!=null) {
            sumaTotal+=Integer.parseInt(auxiliar.getEdad());
            auxiliar=auxiliar.getSiguiente();
        }
        
        promedio=sumaTotal/devolverCantidadNodos();
        
        return promedio;
    }
    public void ordenarMenorAMayor() {
        
        int cantidadNodos=devolverCantidadNodos();
        String cedulaTemporal,nombreTemporal,edadTemporal,fechaTemporal,prioridadTemporal;
        NodoCliente auxiliar;
        
        for(int contador=0;contador<cantidadNodos;contador++) {
            
            auxiliar=primero;
            while(auxiliar.getSiguiente()!=null) {
                
                if(Integer.parseInt(auxiliar.getEdad())>Integer.parseInt(auxiliar.getSiguiente().getEdad())) {
                    
                    cedulaTemporal=auxiliar.getCedula();
                    nombreTemporal=auxiliar.getNombre();
                    edadTemporal=auxiliar.getEdad();
                    fechaTemporal=auxiliar.getFecha();
                    prioridadTemporal=auxiliar.getPrioridad();
                    
                    auxiliar.setCedula(auxiliar.getSiguiente().getCedula());
                    auxiliar.setNombre(auxiliar.getSiguiente().getNombre());
                    auxiliar.setEdad(auxiliar.getSiguiente().getEdad());
                    auxiliar.setFecha(auxiliar.getSiguiente().getFecha());
                    auxiliar.setPrioridad(auxiliar.getSiguiente().getPrioridad());
                    
                    auxiliar.getSiguiente().setCedula(cedulaTemporal);
                    auxiliar.getSiguiente().setNombre(nombreTemporal);
                    auxiliar.getSiguiente().setEdad(edadTemporal);
                    auxiliar.getSiguiente().setFecha(fechaTemporal);
                    auxiliar.getSiguiente().setPrioridad(prioridadTemporal);
                }
                auxiliar=auxiliar.getSiguiente();
            }
        }
    }
    public void ordenarMayorAMenor() {
        
        int cantidadNodos=devolverCantidadNodos();
        String cedulaTemporal,nombreTemporal,edadTemporal,fechaTemporal,prioridadTemporal;
        NodoCliente auxiliar;
        
        for(int contador=0;contador<cantidadNodos;contador++) {
            
            auxiliar=primero;
            while(auxiliar.getSiguiente()!=null) {
                
                if(Integer.parseInt(auxiliar.getEdad())<Integer.parseInt(auxiliar.getSiguiente().getEdad())) {
                    
                    cedulaTemporal=auxiliar.getCedula();
                    nombreTemporal=auxiliar.getNombre();
                    edadTemporal=auxiliar.getEdad();
                    fechaTemporal=auxiliar.getFecha();
                    prioridadTemporal=auxiliar.getPrioridad();
                    
                    auxiliar.setCedula(auxiliar.getSiguiente().getCedula());
                    auxiliar.setNombre(auxiliar.getSiguiente().getNombre());
                    auxiliar.setEdad(auxiliar.getSiguiente().getEdad());
                    auxiliar.setFecha(auxiliar.getSiguiente().getFecha());
                    auxiliar.setPrioridad(auxiliar.getSiguiente().getPrioridad());
                    
                    auxiliar.getSiguiente().setCedula(cedulaTemporal);
                    auxiliar.getSiguiente().setNombre(nombreTemporal);
                    auxiliar.getSiguiente().setEdad(edadTemporal);
                    auxiliar.getSiguiente().setFecha(fechaTemporal);
                    auxiliar.getSiguiente().setPrioridad(prioridadTemporal);
                }
                auxiliar=auxiliar.getSiguiente();
            }
        }
    }
    public int devolverCantidadNodos() {
        
        int contador=1;
        NodoCliente auxiliar=primero;
        while(auxiliar.getSiguiente()!=null)
        {
            contador++;
            auxiliar=auxiliar.getSiguiente();
        }
        
        return contador;
    }
    public String[] getArregloInformacion() {
        return arregloInformacion;
    }
}

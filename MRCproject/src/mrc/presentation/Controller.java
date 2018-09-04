package mrc.presentation;

import mrc.logic.Actividad;

/**
 * @author Esteban Espinoza Fallas 402290345
 * @author Carlos Vargas Alfaro 402170927
 */
public class Controller {
    
    // <editor-fold desc="Atributos" defaultstate="collapsed">
    Model model;
    VentanaMRC view;
    // </editor-fold>

    // <editor-fold desc="Constructor" defaultstate="collapsed">
    public Controller(Model model, VentanaMRC view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    // </editor-fold>
    
    // <editor-fold desc="Acciones de los Menus" defaultstate="collapsed">
    public void abrirarchivo(String ruta) throws Exception{
        model.abrirArchivo(ruta);
    }
    
    public void guardarArchivo(String ruta){
       model.guardarArchivo(ruta);
    }
    
    public void limpiarProyecto(){
        model.limpiarProyecto();
    }
    // </editor-fold>
    
    // <editor-fold desc="Manipulacion del grafo" defaultstate="collapsed">
    public void agregarActividad(String id,int duracion,int x,int y) throws Exception{
        Actividad a = new Actividad(id, duracion, x, y);
        model.agregarActividad(a);
    }
    
    public void relacionar(String a, String b) throws Exception{
        model.relacionar(a, b);
    }
    
    public void moveractividad(String a, int x,int y){
        model.moveractividad(a, x, y);
    }
    
    public void eliminar(Actividad a){
        model.eliminar(a);
    }
    // </editor-fold>
}

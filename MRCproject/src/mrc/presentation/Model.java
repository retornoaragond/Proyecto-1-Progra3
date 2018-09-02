package mrc.presentation;

import java.util.Observable;
import java.util.Observer;
import mrc.data.Archivos;
import mrc.logic.Actividad;
import mrc.logic.Proyecto;

/**
 * @author Esteban Espinoza Fallas 402290345
 * @author Carlos Vargas Alfaro 402170927
 */
public class Model extends Observable {

    // <editor-fold desc="Atributos" defaultstate="collapsed">
    Proyecto proyecto;
    // </editor-fold>

    // <editor-fold desc="Constructores" defaultstate="collapsed">
    public Model() {
        proyecto = new Proyecto();
    }
    // </editor-fold>
    
    // <editor-fold desc="Sets y Gets" defaultstate="collapsed">
    public void setP(Proyecto p) {
        this.proyecto = p;
        this.setChanged();
        notifyObservers(null);
    }

    public Proyecto getPoryect() {
        return proyecto;
    }
    // </editor-fold>
    
    // <editor-fold desc="Observer" defaultstate="collapsed">
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(null);
    }
    // </editor-fold>
    
    // <editor-fold desc="Acciones de los Menus" defaultstate="collapsed">

    public void abrirArchivo(String ruta) throws Exception {
        Proyecto p = new Proyecto(new Archivos().carga(ruta));
        this.setP(p);
        System.out.print("\n" + p.rutaCritica() + "\n\n");// se imprime lo cargado
        System.out.print(p.toString());// se imprime lo cargado
    }
    
    public void guardarArchivo(String ruta){
        new Archivos().generar(ruta, proyecto.getActividades());
    }
    
    public void limpiarProyecto(){
        this.proyecto = new Proyecto();
        setChanged();
        notifyObservers(null);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="Acciones sobre el grafo" defaultstate="collapsed">
    public void agregarActividad(Actividad a) throws Exception {
        proyecto.agregarActividad(a);
        System.out.print("\n" + proyecto.rutaCritica() + "\n\n");// se imprime lo cargado
        System.out.print(proyecto.toString());// se imprime lo cargado
        setChanged();
        notifyObservers(null);
    }
    
    public void relacionar(String a, String b) throws Exception{
        this.proyecto.relacionar(a, b);
        setChanged();
        notifyObservers(null);
        System.out.print("\n" + proyecto.rutaCritica() + "\n\n");// se imprime lo cargado
        System.out.print(proyecto.toString());// se imprime lo cargado
    }
    
    public void moveractividad(String a, int x,int y){
        this.proyecto.getActividades().get(a).setX(x);
        this.proyecto.getActividades().get(a).setY(y);
        setChanged();
        notifyObservers(null);
    }
    // </editor-fold>
}

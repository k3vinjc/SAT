/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author kevinj
 */
public class Linea {

    public int cod_linea;
    public String nombre;
    public double factor;
    public Marca marca;
    private String txt_error;
    
    private static final double FACTOR_DEFECTO = 400;

    public Linea(String nombre, Marca marca) {
        txt_error = "";
        this.cod_linea=0;
        this.nombre = nombre.toUpperCase().trim();
        buscarLinea(this.nombre);
    }

    /*
        retorno 0: Error
     */
    private boolean buscarLinea(String nombre) {
        java.util.ArrayList<Object[]> consulta;
        DB db=new DB();
        if(marca.cod_marca==0){
            txt_error="La marca no existe. Tiene código \"0\" nombre: \""+marca.nombre+"\".";
        }else if ((consulta = db.select("cod_linea,factor", "linea", "marca='" + marca.cod_marca + "' and nombre='" + nombre + "'",new int[]{DB.INT,DB.DOUBLE})) == null) {
            txt_error = "Error de ejecución de consulta de linea \""+nombre+"\".\n SQL Error: "+db.getError();
        } else if (consulta.size() > 1) {
            txt_error = "Linea encontrada dos veces con el mismo nombre \""+nombre+"\".";
        } else if (consulta.isEmpty()) {
            return ((this.cod_linea=crearLinea(nombre,FACTOR_DEFECTO, marca))!=0);
        } else {
            try {
                cod_linea = (int)consulta.get(0)[0];
                this.factor = (double)consulta.get(0)[1];
                return cod_linea!=0;
            } catch (IndexOutOfBoundsException ex) {
                txt_error = "Indexación incorrecta en la consulta del código de liea y el factor.";
            }
        }
        return false;
    }

    private int crearLinea(String nombre, double factor, Marca marca) {
        java.util.ArrayList<Object[]> consulta;
        DB db=new DB();
        if(marca.cod_marca==0){
            txt_error="El codigo de marca para crear nueva linea es \"0\".";
        }else if (!db.insert("nombre,factor,marca", "marca", "'" + nombre + "',"+factor+","+marca.cod_marca)) {
            txt_error = "No se pudo agregar la linea \"" + nombre + "\" para la marca \""+marca.nombre+"\".\nSQL error: "+db.getError();
        } else if ((consulta = db.select("cod_linea", "linea", "nombre = '" + nombre + "' and marca="+marca.cod_marca,new int[]{DB.INT})) == null) {
            txt_error = "Error de ejecución de consulta de marca posterior.\n SQL Error: "+db.getError();
        } else if (consulta.size() > 1) {
            txt_error = "Existen dos lineas con el mismo nombre \"" + nombre + "\" para la marca \""+marca.nombre+"\".";
        } else if (consulta.isEmpty()) {
            txt_error = "No se creó la linea\"" + nombre + "\" para la marca \""+marca.nombre+"\".";
        } else {
            try {
                cod_linea = (int)consulta.get(0)[0];
                this.factor = factor;
                return cod_linea;
            } catch (Exception ex) {
                txt_error = "Campo \"cod_linea\" incorrecto o no encontrado en consulta posterior a supuesta creación de Linea.";
            }
        }
        return 0;
    }
    
    public String getError(){
        return txt_error;
    }
    
    @Override
    public String toString(){
        return nombre.isEmpty()?"Error":nombre;
    }
}

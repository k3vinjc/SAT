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
public class Marca {

    public int cod_marca;
    public String nombre;
    private String txt_error;

    public Marca(String nombre) {
        txt_error = "";
        this.nombre = nombre.toUpperCase().trim();
        buscarMarca(this.nombre);
    }

    /*
        retorno 0: Error
     */
    private boolean buscarMarca(String nombre) {
        java.util.ArrayList consulta;
        if ((consulta = DB.select("cod_marca", "marca", "nombre = '" + nombre + "'")) == null) {
            txt_error = "Error de ejecución de consulta de marca \""+nombre+"\".";
            return false;
        } else if (consulta.size() > 1) {
            txt_error = "Existen dos marcas con el mismo nombre \""+nombre+"\".";
            return false;
        } else if (consulta.isEmpty()) {
            //NO ENCONTRADO, SE CREA ENTONCES
            return (this.cod_marca=crearMarca(nombre))!=0;
        }else{
            try {
                cod_marca = ((java.sql.ResultSet) (consulta.get(0))).getInt("cod_marca");
                return cod_marca!=0;
            } catch (Exception ex) {
                txt_error = "Campo \"cod_marca\" incorrecto o no encontrado en consulta posterior a supuesta creación.";
                ex.printStackTrace();
            }
        }
        return false;
    }

    private int crearMarca(String nombre) {
        java.util.ArrayList consulta;
        if (!DB.insert("nombre", "marca", "'" + nombre + "'")) {
            txt_error = "No se pudo agregar la marca \"" + nombre + "\".";
        } else if ((consulta = DB.select("cod_marca", "marca", "nombre = '" + nombre + "'")) == null) {
            txt_error = "Error de ejecución de consulta de marca posterior.";
        } else if (consulta.size() > 1) {
            txt_error = "Existen dos marcas con el mismo nombre.";
        } else if (consulta.isEmpty()) {
            txt_error = "No se creó la marca " + nombre + ".";
        } else {
            try {
                return ((java.sql.ResultSet) (consulta.get(0))).getInt("cod_marca");
            } catch (Exception ex) {
                txt_error = "Campo \"cod_marca\" incorrecto o no encontrado en consulta posterior a supuesta creación de Marca.";
                ex.printStackTrace();
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

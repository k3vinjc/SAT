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
public class Manifiesto {

    public int cod_manifiesto;
    public Marca marca;
    public Linea linea;
    public int modelo;
    public String fecha_entrada;
    public String pais_origen;

    private String txt_error;

    public Manifiesto(String marca, String linea, int modelo, String fecha_entrada, String pais_origen) {
        txt_error = "";
        this.cod_manifiesto = 0;
        this.modelo = modelo;
        this.fecha_entrada = fecha_entrada.trim();
        this.pais_origen = pais_origen.trim();
        if (validarMarcaLinea(marca, linea)) {
            this.cod_manifiesto = crearManifiesto();
        }
    }

    private boolean validarMarcaLinea(String marca, String linea) {
        boolean validado = true;
        Marca m = null;
        Linea l = null;
        if (((m = new Marca(marca)).cod_marca == 0)) {
            validado = false;
            txt_error = m.getError();
        } else if ((l = new Linea(linea, m)).cod_linea == 0) {
            validado = false;
            txt_error = l.getError();
        } else {
            this.marca = m;
            this.linea = l;
        }
        return validado;
    }

    private int crearManifiesto() {
        //VALIDANDO FORMATO DE FECHA
        if (!validarFormatoFecha()) {
            return 0;
        }
        DB db = new DB();
        java.util.ArrayList<Object[]> consulta;
        if (!db.insert("marca, linea, modelo, fecha_entrada, pais_origen", "manifiesto", marca.cod_marca + "," + linea.cod_linea + "," + modelo + ",'" + fecha_entrada + "','" + pais_origen + "'")) {
            txt_error = "No se pudo agregar el manifiesto con los datos: \nMarca: " + marca.cod_marca + "\nLinea: " + linea.cod_linea + "\nModelo: " + modelo + "\nFecha:'" + fecha_entrada + "'\nPais Origen:'" + pais_origen + "'" + ".\nSQL: " + db.getError();
        } else if ((consulta = db.select("max(cod_manifiesto) as codman", "manifiesto", "", new int[]{DB.INT})) == null) {
            txt_error = "Error de ejecución de consulta de manifiesto después de crearlo" + ".\nSQL: " + db.getError();
        } else if (consulta.isEmpty()) {
            txt_error = "No se creó la el manifiesto con los datos:  \nMarca: " + marca.cod_marca + "\nLinea: " + linea.cod_linea + "\nModelo: " + modelo + "\nFecha:'" + fecha_entrada + "'\nPais Origen:'" + pais_origen + "'";
        } else {
            try {
                cod_manifiesto = (int) consulta.get(0)[0];
                return cod_manifiesto;
            } catch (Exception ex) {
                txt_error = "Campo 'cod_linea' o 'factor' incorrecto o no encontrado en consulta posterior a supuesta creación de Linea.\nError: " + ex.getMessage();
            }
        }
        return 0;
    }

    public String getError() {
        return txt_error;
    }

    @Override
    public String toString() {
        return this.cod_manifiesto == 0 ? "Error" : this.marca.nombre + " " + this.linea.nombre + " " + this.fecha_entrada;
    }

    /*
        El formato de fecha debe ser yyyy-mm-dd
     */
    private boolean validarFormatoFecha() {
        String split[] = this.fecha_entrada.split("/");
        String fechaFormatoCorrecto = "";
        String string = "";
        if (split.length != 3) {
            txt_error = "El formato correcto para la fecha es: dd/mm/yyy, por ejemplo: 28/02/2017";
            return false;
        }
        try {
            for (int i = 0; i < split.length; i++) {
                string = split[i];
                int entero = Integer.parseInt(string);
                switch (i) {
                    case 0://DIA
                        if (entero > 31 || entero < 1) {
                            txt_error = "El número de día es incorrecto: '" + entero + "'";
                            return false;
                        } else {
                            fechaFormatoCorrecto = string;
                        }
                        break;
                    case 1:
                        if (entero > 12 || entero < 1) {
                            txt_error = "El número de mes es incorrecto: '" + entero + "'";
                            return false;
                        } else {
                            fechaFormatoCorrecto = string + "-" + fechaFormatoCorrecto;
                        }
                        break;
                    case 2:
                        if (entero > 3000 || entero < 1900) {
                            txt_error = "El número de año es no es verídico: '" + entero + "'";
                            return false;
                        } else {
                            fechaFormatoCorrecto = string + "-" + fechaFormatoCorrecto;
                        }
                        break;
                    default:
                        break;
                }
            }
            this.fecha_entrada = fechaFormatoCorrecto;
        } catch (NumberFormatException nfe) {
            txt_error = "Formato del número de " + string + "' es incorrecto. Debe ser: dd/mm/yyyy, por ejemplo: 28/02/2017";
            return false;
        }
        return true;
    }

}

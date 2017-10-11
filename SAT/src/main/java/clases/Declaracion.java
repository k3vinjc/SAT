/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author kevinj
 */
public class Declaracion {

    public int cod_declaracion;
    public Marca marca;
    public Linea linea;
    public int modelo;
    public double precio;
    public String fecha_declaracion;

    private String txt_error;

    public Declaracion(String marca, String linea, int modelo, double precio, String fecha_declaracion) {
        this.cod_declaracion = 0;
        txt_error = "";
        if (modelo < 1900) {
            txt_error = "El modelo debe ser un año verídico; se proporcionó '" + modelo + "'";
        } else if (precio < 0) {
            txt_error = "El precio debe ser un valor positivo; se proporcionó '" + modelo + "'";
        } else {
            this.modelo = modelo;
            this.precio = precio;
            this.fecha_declaracion = fecha_declaracion.trim();
            if (validarMarcaLinea(marca, linea)) {
                this.cod_declaracion = crearDeclaracion();
            }
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

    private int crearDeclaracion() {
        //VALIDANDO FORMATO DE FECHA
        if (!validarFormatoFecha()) {
            return 0;
        }
        DB db = new DB();
        ArrayList<Object[]> consulta;
        if (!db.insert("marca, linea, modelo, fecha_declaracion, precio", "declaracion", marca.cod_marca + "," + linea.cod_linea + "," + modelo + ",'" + fecha_declaracion + "'," + precio)) {
            txt_error = "No se pudo agregar la declaración con los datos: \nMarca: " + marca.cod_marca + "\nLinea: " + linea.cod_linea + "\nModelo: " + modelo + "\nFecha:'" + fecha_declaracion + "'\nPrecio: " + precio + ".\nSQL: " + db.getError();
        } else if ((consulta = db.select("max(cod_declaracion) as coddec", "declaracion", "", new int[]{DB.INT})) == null) {
            txt_error = "Error de ejecución de consulta de declaración después de crearlo." + "\nSQL: " + db.getError();
        } else if (consulta.isEmpty()) {
            txt_error = "No se creó la declaración con los datos: \nMarca: " + marca.cod_marca + "\nLinea: " + linea.cod_linea + "\nModelo: " + modelo + "\nFecha:'" + fecha_declaracion + "'\nPrecio: " + precio;
        } else {
            try {
                cod_declaracion = (int) consulta.get(0)[0];
                return cod_declaracion;
            } catch (Exception ex) {
                txt_error = "Campo 'codman' incorrecto en consulta posterior a supuesta creación de Manifiesto. Error: " + ex.getMessage();
            }
        }
        return 0;
    }

    public String getError() {
        return txt_error;
    }

    @Override
    public String toString() {
        return this.cod_declaracion == 0 ? "Error" : this.marca.nombre + " " + this.linea.nombre + " " + this.fecha_declaracion;
    }

    /*
        El formato de fecha debe ser yyyy-mm-dd
     */
    private boolean validarFormatoFecha() {
        String split[] = this.fecha_declaracion.split("/");
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
                            fechaFormatoCorrecto= string;
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
            this.fecha_declaracion=fechaFormatoCorrecto;
        } catch (NumberFormatException nfe) {
            txt_error = "Formato del número de " + string + "' es incorrecto. Debe ser: dd/mm/yyyy, por ejemplo: 28/02/2017";
            return false;
        }
        return true;
    }

}

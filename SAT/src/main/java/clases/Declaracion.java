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
        if (modelo < 1900) {
            txt_error = "El modelo debe ser un año verídico; se proporcionó \"" + modelo + "\"";
        } else if (precio < 0) {
            txt_error = "El precio debe ser un valor positivo; se proporcionó \"" + modelo + "\"";
        }else
        {
            this.modelo = modelo;
            this.fecha_declaracion = fecha_declaracion.trim();
            validarMarcaLinea(marca, linea);
            txt_error = "";
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

        java.util.ArrayList consulta;
        if (!DB.insert("marca, linea, modelo, fecha_declaracion, precio",
                "declaracion", 
                marca.cod_marca + "," + linea.cod_linea + "," + modelo + ",'" + fecha_declaracion + "'," + precio)) {
            txt_error = "No se pudo agregar el manifiesto con los datos: \nMarca: " + marca.cod_marca + "\nLinea: " + linea.cod_linea + "\nModelo: " + modelo + "\nFecha:'" + fecha_declaracion + "'\nPrecio: " + precio;
        } else if ((consulta = DB.select("max(cod_manifiesto) as codman", "manifiesto", "")) == null) {
            txt_error = "Error de ejecución de consulta de manifiesto después de crearlo.";
        } else if (consulta.isEmpty()) {
            txt_error = "No se creó la el manifiesto con los datos:  \nMarca: " + marca.cod_marca + "\nLinea: " + linea.cod_linea + "\nModelo: " + modelo + "\nFecha:'" + fecha_declaracion + "'\nPais Origen:'" + pais_origen + "'";
        } else {
            try {
                cod_declaracion = ((java.sql.ResultSet) (consulta.get(0))).getInt("codman");
                return cod_declaracion;
            } catch (Exception ex) {
                txt_error = "Campo \"cod_linea\" o \"factor\" incorrecto o no encontrado en consulta posterior a supuesta creación de Linea.";
                ex.printStackTrace();
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

    private boolean validarFormatoFecha() {
        String split[] = this.fecha_declaracion.split("-");
        String tipo[] = {"dia", "mes", "año"};
        String string = "";
        if (split.length != 3) {
            return false;
        }
        try {
            for (int i = 0; i < split.length; i++) {
                string = split[i];
                int entero = Integer.parseInt(string);
                switch (i) {
                    case 0://DIA
                        if (entero > 31 || entero < 1) {
                            txt_error = "El número de día es incorrecto: \"" + entero + "\"";
                            return false;
                        }
                        break;
                    case 1:
                        if (entero > 12 || entero < 1) {
                            txt_error = "El número de mes es incorrecto: \"" + entero + "\"";
                            return false;
                        }
                        break;
                    case 2:
                        if (entero > 3000 || entero < 1900) {
                            txt_error = "El número de mes es no es verídico: \"" + entero + "\"";
                            return false;
                        }
                        break;
                    default:
                        break;

                }
            }
        } catch (NumberFormatException nfe) {
            txt_error = "Formato del número de " + string + "\" es incorrecto";
            return false;
        }
        return true;
    }

}

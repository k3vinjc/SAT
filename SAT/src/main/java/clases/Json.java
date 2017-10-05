/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author kevinj
 */
public class Json {

    ObjectMapper mapper;
    JsonNode rootNode;

    JSONObject data;

    public Json() {
        mapper = new ObjectMapper();
        rootNode = mapper.createObjectNode();
        data = null;
    }

    public Json(String jsonText) {
        data = new JSONObject(jsonText);
        mapper = null;
        rootNode = null;
    }

    public Object getField(String tag, int tipo) {
        if (data == null) {
            return null;
        }
        Object o = data.get(tag);
        switch (tipo) {
            case DB.INT:
                o = (int) o;
                break;
            case DB.DOUBLE:
                o = (double) o;
                break;
            case DB.STRING:
                o = (String) o;
                break;
            case DB.DATE:
                o = (java.util.Date) o;
                break;
        }
        return o;
    }

    public boolean addField(String campo, Object valor, byte tipo) {
        if (mapper == null) {
            return false;
        } else {
            switch (tipo) {
                case DB.INT:
                    ((ObjectNode) rootNode).put(campo, (int) valor);
                    break;
                case DB.DOUBLE:
                    ((ObjectNode) rootNode).put(campo, (double) valor);
                    break;
                case DB.DATE:
                    ((ObjectNode) rootNode).put(campo, valor.toString());
                    break;
                case DB.STRING:
                    ((ObjectNode) rootNode).put(campo, valor.toString());
                    break;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        try {

            return mapper == null ? "Reader" : mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        } catch (JsonProcessingException ex) {
        }
        return "{\"Error\": \"Json no generado\"}";
    }
}

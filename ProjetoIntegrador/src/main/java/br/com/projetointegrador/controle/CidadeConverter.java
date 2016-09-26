/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetointegrador.controle;

import br.com.projetointegrador.modelo.dao.DAOGenerico;
import br.com.projetointegrador.modelo.entidade.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author igorr
 */
@FacesConverter(value = "converterCidade")
public class CidadeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            DAOGenerico dao = new DAOGenerico();
            return dao.buscarPorId(Cidade.class, Long.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Cidade) {
            Cidade municipio = (Cidade) value;
            return String.valueOf(municipio.getId());
        }
        return "";
    }

}

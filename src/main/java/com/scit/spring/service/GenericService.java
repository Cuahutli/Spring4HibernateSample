/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.service;

import com.scit.spring.utils.Estructuras;
import com.scit.spring.utils.Pagina;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cuahutli
 */
public interface GenericService<T, PK extends Serializable> {

    public void ins(T instancia);
    public void upd(T instancia);
    public T sel (PK id);
    public void del(PK id);
    public List<T> selTodo();
    public List<T> selTodo(String colOrder);
    public Pagina selPagina(int pag);
    public Pagina selPagina(int pag, String colOrder, Estructuras.Orden orden);
    public Pagina selPagina2(int pag, String colQuery, String query, String colOrder, Estructuras.Orden orden);
    
}

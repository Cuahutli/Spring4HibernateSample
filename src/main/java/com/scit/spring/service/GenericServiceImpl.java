/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.service;

import com.scit.spring.dao.GenericDAO;
import java.io.Serializable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.scit.spring.utils.Pagina;
import com.scit.spring.utils.Estructuras;
/**
 *
 * @author cuahutli
 */
@Service
@Transactional
public abstract class GenericServiceImpl<T, PK extends Serializable> 
        implements GenericService<T, PK> {

    private GenericDAO<T, PK> dao;

    public GenericServiceImpl() {
        
    }
    
    public GenericServiceImpl(GenericDAO<T, PK> dao) {
        this.dao = dao;
    }
    
    @Override
    public void ins(T instancia) {
        dao.ins(instancia);
    }

    @Override
    public void upd(T instancia) {
        dao.upd(instancia);
    }

    @Override
    public T sel(PK id) {
        return dao.sel(id);
    }

    @Override
    public void del(PK id) {
        dao.del(id);
    }

    @Override
    public List<T> selTodo() {
        return dao.selTodo();
    }
    
    @Override
    public List<T> selTodo(String colOrder) {
        return dao.selTodo(colOrder);
    }

    @Override
    public Pagina selPagina(int pag) {
        return dao.selPagina(pag);
    }

    @Override
    public Pagina selPagina(int pag, String colOrder, Estructuras.Orden orden) {
        return dao.selPagina(pag, colOrder, orden);
    }

    @Override
    public Pagina selPagina2(int pag, String colQuery, String query, String colOrder, Estructuras.Orden orden) {
        return dao.selPagina2(pag, colQuery, query, colOrder, orden);
    }
    
}

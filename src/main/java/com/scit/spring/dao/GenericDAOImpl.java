/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.dao;

import com.scit.spring.utils.Estructuras;
import com.scit.spring.utils.Pagina;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.Table;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cuahutli
 */
@Repository
public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {
    @Autowired
    private SessionFactory sessionFactory;
    private static final int MAX_RENGLONES = 10;
    private Class<? extends T> clazz;
    private String nombreTabla;
    
    public GenericDAOImpl(){
        Type t = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clazz = (Class) pt.getActualTypeArguments()[0];
        Table table = clazz.getAnnotation(Table.class);
        nombreTabla = table.name();
    }
    
    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void ins(T instancia) {
        getCurrentSession().save(instancia);
    }

    @Override
    public void upd(T instancia) {
        getCurrentSession().update(instancia);
    }

    @Override
    public T sel(PK id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @Override
    public void del(PK id) {
        T aux = sel(id);
        if (aux != null) {
            getCurrentSession().delete(aux);
        }
    }

    @Override
    public List<T> selTodo() {
        return getCurrentSession().createQuery(String.format("from %s", clazz.getName())).list();
    }
    
    @Override
    public List<T> selTodo(String colOrder) {
        return getCurrentSession().createQuery(String.format("from %s order by %s", clazz.getName(), colOrder)).list();
    }

    @Override
    public Pagina selPagina(int pag) {
        return selPagina(pag, "", null);
    }

    @Override
    public Pagina selPagina(int pag, String colOrder, Estructuras.Orden orden) {
        Criteria c = getCurrentSession().createCriteria(clazz);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        if (!colOrder.equals("") && orden != null) {
            switch (orden) {
                case asc:
                    c.addOrder(Order.asc(colOrder));
                    break;
                case desc:
                    c.addOrder(Order.desc(colOrder));
                    break;
            }
        }
        return calcular(c, pag);
    }

    @Override
    public Pagina selPagina2(int pag, String colQuery, String query, String colOrder, Estructuras.Orden orden) {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz)
                .add(Restrictions.like(colQuery, query, MatchMode.ANYWHERE));
        Criteria c = dc.getExecutableCriteria(getCurrentSession());
        if (!colOrder.equals("") && orden != null) {
            switch (orden) {
                case asc:
                    c.addOrder(Order.asc(colOrder));
                    break;
                case desc:
                    c.addOrder(Order.desc(colOrder));
                    break;
            }
        }
        return calcular(c, pag);
    }
    
    public Pagina calcular(Criteria c, int pag) {
        int total = c.list().size();
        int primero = total == 0 ? 0 : (pag - 1) * MAX_RENGLONES + 1;
        int ultimo = primero - 1 + MAX_RENGLONES > total ? total : primero - 1 + MAX_RENGLONES;
        double auxMod = total % MAX_RENGLONES;
        int numPags = (int)(total / MAX_RENGLONES) + (auxMod == 0D ? 0 : 1);
        c.setMaxResults(MAX_RENGLONES);
        c.setFirstResult(primero - 1);
        return new Pagina(
                (List<T>) c.list(), 
                total, 
                numPags, 
                primero, 
                ultimo, 
                pag
        );
    }
    
    
    
}

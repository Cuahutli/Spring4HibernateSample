/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.utils;

import java.util.List;
/**
 *
 * @author cuahutli
 */
public class Pagina {
    private List datos;
    private int total;
    private int numPags;
    private int primero;
    private int ultimo;
    private int pag;
    
    public Pagina() {
        
    }

    public Pagina(List datos, int total, int numPags, int primero, int ultimo, int pag) {
        this.datos = datos;
        this.total = total;
        this.numPags = numPags;
        this.primero = primero;
        this.ultimo = ultimo;
        this.pag = pag;
    }

    public List<Object> getDatos() {
        return datos;
    }

    public void setDatos(List<Object> datos) {
        this.datos = datos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumPags() {
        return numPags;
    }

    public void setNumPags(int numPags) {
        this.numPags = numPags;
    }

    public int getPrimero() {
        return primero;
    }

    public void setPrimero(int primero) {
        this.primero = primero;
    }

    public int getUltimo() {
        return ultimo;
    }

    public void setUltimo(int ultimo) {
        this.ultimo = ultimo;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }
    
}

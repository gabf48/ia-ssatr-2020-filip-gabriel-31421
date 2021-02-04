/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pool;

/**
 *
 * @author Gabriel
 */
public class CustomersEntity {

    private String nume;
    private long timpIntrare;

    public CustomersEntity(String nume, long timpIntrare) {
        this.nume = nume;
        this.timpIntrare = timpIntrare;
    }

    public CustomersEntity(String nume) {
        this.nume = nume;
    }
    
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public long getTimpIntrare() {
        return timpIntrare;
    }

    public void setTimpIntrare(long timpIntrare) {
        this.timpIntrare = timpIntrare;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + nume + ", entryTime=" + timpIntrare + '}';
    }

}

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
public class ProfitEntity {

    double ron;

    public double getRon() {
        return ron;
    }

    public void setRon(double ron) {
        this.ron = ron;
    }

    public ProfitEntity(double ron) {
        this.ron = ron;
    }

    @Override
    public String toString() {
        return "ProfitEntity{" + "ron=" + ron + '}';
    }

}

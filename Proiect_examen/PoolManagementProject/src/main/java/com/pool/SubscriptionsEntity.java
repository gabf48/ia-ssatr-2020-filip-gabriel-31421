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
public class SubscriptionsEntity {
    String subscriptionType;
    double price;

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SubscriptionsEntity(String subscriptionType, double price) {
        this.subscriptionType = subscriptionType;
        this.price = price;
    }

    public SubscriptionsEntity(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class BankAccount {
    //attribute
    private String owner;
    private int balance;
    
    //constructori
    BankAccount(String owner, int balance){
        this.owner = owner;
        this.balance = balance;
    }
    
    public String getOwner(){
    return owner;
    }
    
    public int getBalance(){
    return balance;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class AccountsManager {
    BankAccount[] list = new BankAccount[10];
    
    void addAccount(BankAccount a){
    for(int i=0; i<list.length; i++){
    if(list[i]==null) {
    list[i] = a;
    System.out.println("New account added");
    return;}}
    System.out.println("No empty position fonud");
    }
 
    int getTotalBalance(){
        int b = 0;
        int k = 0;
        for(BankAccount a: list) {
            if(a!=null) {
            b+=a.getBalance();
            k++;
       
            }
        }
        return b/k;
    }
    
    int getGradeByName(String bankAccount){
        
    for(BankAccount a: list){
    if(a!=null && a.getOwner().equals(bankAccount))
        return a.getBalance();}
    return -1;
    } 
}
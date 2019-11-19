/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Currency;
import exception.NoCashException;
import java.util.Map;

/**
 *
 * @author student1
 */
public abstract class Node {

    protected int numberOfBanktnotes;
    protected Node next;

    public void setNext(Node cvor) {
        next = cvor;
    }

    public Node getNext() {
        return next;
    }

    public int getNumberOfBanktnotes() {
        return numberOfBanktnotes;
    }

    public void addBanknote(int numberOfBanktnotes) {
        this.numberOfBanktnotes = this.numberOfBanktnotes + numberOfBanktnotes;
    }

    public abstract void getCurrency(Currency currency, Map<String, Integer> map) throws NoCashException;

    //public abstract boolean enoughChange(Currency currency);
    @Override
    public String toString() {
        return this.getClass() + "  " + numberOfBanktnotes;
    }

}

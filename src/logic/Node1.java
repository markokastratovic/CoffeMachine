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
public class Node1 extends Node {

    @Override
    public void getCurrency(Currency currency, Map<String, Integer> map) throws NoCashException {
        if (currency.getAmount() >= 1) {
            if (currency.getAmount() <= numberOfBanktnotes) {
                map.put("1", currency.getAmount());
                numberOfBanktnotes -= currency.getAmount();
            } else {
                System.err.println(currency.getAmount() + "   " + numberOfBanktnotes);
                map.put("1", numberOfBanktnotes);
                numberOfBanktnotes = 0;
                throw new NoCashException("The machine does not have enough change! Call service! " + (currency.getAmount() - map.get("1")) + " rsd is missing");
            }
        } else {
            map.put("1", 0);
        }
    }

}

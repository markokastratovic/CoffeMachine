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
public class Node20 extends Node {

    @Override
    public void getCurrency(Currency currency, Map<String, Integer> map) throws NoCashException {
        if (currency.getAmount() >= 20) {
            int a = currency.getAmount() / 20;
            int b = currency.getAmount() % 20;
            if (a < numberOfBanktnotes) {
                map.put("20", a);
                numberOfBanktnotes -= a;
            } else {
                map.put("20", numberOfBanktnotes);
                b += (a - numberOfBanktnotes) * 20;
                numberOfBanktnotes = 0;
            }
            if (b != 0 && next != null) {
                next.getCurrency(new Currency(b), map);
            }
        } else {
            map.put("20", 0);
            if (next != null) {
                next.getCurrency(currency, map);
            }
        }
    }

}

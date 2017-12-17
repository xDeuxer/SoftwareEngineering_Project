/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hesham
 */
public class PaymentModel {
    public boolean pay(payment p)
    {
        if(p.checkout())
            return true;
        return false;
        
    }
}

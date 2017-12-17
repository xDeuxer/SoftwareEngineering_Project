


import java.util.*;

public class online extends payment {

    public online(String cardType, String cardNumber, String expiredDate) {
        this.cardType=cardType;
        this.cardNumber=cardNumber;
        this.expiredDate=expiredDate;
        type="online";
    }

    
    
    private String cardType;
    private String cardNumber;
    private String expiredDate;

    @Override
    boolean checkout() {
        if(cardType.equals("debit card") || cardType.equals("credit card"))
            return true;
        return false;
    }
    
    


}


import java.util.*;


public class onDelivery extends payment {
    private String address;
    public onDelivery(String address) {
        this.address=address;
    }

    @Override
    boolean checkout() {
        if(address.contains("egypt"))
        {
            return true;
        }
        return false;
    }

}
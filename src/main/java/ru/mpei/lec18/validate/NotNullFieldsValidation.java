package ru.mpei.lec18.validate;

import ru.mpei.lec10.Bean;
import ru.mpei.lec18.Order;

@Bean
public class NotNullFieldsValidation implements OrderValidation{
    @Override
    public boolean check(Order o) {
        if (o.getItems()== null || o.getItems().isEmpty()){
            return false;
        }
        if (o.getSum() == null || o.getSum() <= 0 ){
            return false;
        }
        return true;
    }
}

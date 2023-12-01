package ru.mpei.lec18.validate;

import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec18.Order;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CommonValidator {

    private List<OrderValidation> checkers = new ArrayList<>();

    public boolean perform(Order o){
        log.info("started check");
        boolean res = true;
        for (OrderValidation checker : checkers) {
            boolean check = checker.check(o);
            res = res && check;
        }
        return  res;
    }

    public CommonValidator() {
        checkers.add(new NotNullFieldsValidation());
    }
}

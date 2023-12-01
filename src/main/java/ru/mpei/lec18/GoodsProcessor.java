package ru.mpei.lec18;

import ru.mpei.lec18.notification.NotificationService;
import ru.mpei.lec18.notification.NotyType;
import ru.mpei.lec18.repository.OrderDbRepo;
import ru.mpei.lec18.validate.CommonValidator;

public class GoodsProcessor {
    private CommonValidator validator;
    private OrderDbRepo orderDbRepo;
    private NotificationService notyService;
    public void process(Order o, NotyType type){
//        if (this.validate(o)){
        if (validator.perform(o)){
            if (orderDbRepo.save(o)){
//                this.sendEmailConfirmation(o);
                notyService.perform(o, type);
            } else {
                //DELETE
            }
        }
    }

//    private boolean validate(Order o){
//        if (o.getItems() != null && !o.getItems().isEmpty() && o.getSum() > 0){
//            return true;
//        } else {
//            return false;
//        }
//    }

//    private boolean save(Order o){
//        //TODO: save to DB
//        return true;
//    }

//    private void sendEmailConfirmation(Order o){
//        //TODO: send email
//    }


}

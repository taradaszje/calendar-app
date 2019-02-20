package com.components;

import com.controller.Controller;

public interface DateOperation {
    static void addPeriod(ViewType viewType) {
        Controller controller = Controller.getInstance();
        if(viewType == ViewType.Week){
            controller.setDate(controller.getDate().plusDays(7));
        }
        else if(viewType == ViewType.Month){
            controller.setDate(controller.getDate().plusMonths(1));
        }
    }
    static void subPeriod(ViewType viewType){
        Controller controller = Controller.getInstance();
        if(viewType == ViewType.Week){
            controller.setDate(controller.getDate().minusDays(7));
        }
        else if(viewType == ViewType.Month){
            controller.setDate(controller.getDate().minusMonths(1));
        }
    }

}

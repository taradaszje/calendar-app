package com.navigation;

import com.components.ViewType;
import com.controller.Controller;
import javax.swing.*;

public class View extends JComboBox {

    public View() {
        addItem(ViewType.WEEK);
        addItem(ViewType.MONTH);
        addActionListener(actionEvent -> {
            Controller controller = Controller.getInstance();
            controller.setViewType(ViewType.valueOf(getSelectedItem().toString())); //powiadomić calendarView o zmianie widoku
            controller.notifyAboutDateChange(controller.getDate());
        });
    }
}

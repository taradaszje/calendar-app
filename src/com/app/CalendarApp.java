package com.app;

import com.navigation.DateObserverTextField;
import com.navigation.Next;
import com.navigation.Previous;
import com.navigation.View;
import com.views.CalendarViewObserver;
import com.views.NotesView;

import javax.swing.*;
import java.awt.*;

public class CalendarApp extends JFrame {

    private CalendarApp() {
        super("Zajebisty kalendarz");
        JPanel upperPanel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        upperPanel.add(new Previous());
        upperPanel.add(new DateObserverTextField());
        upperPanel.add(new Next());
        upperPanel.add(new View());

        add(upperPanel, BorderLayout.PAGE_START);
        add(new CalendarViewObserver(), BorderLayout.CENTER);
        add(new NotesView(), BorderLayout.PAGE_END);
        setSize(740, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(CalendarApp::new);
    }
}

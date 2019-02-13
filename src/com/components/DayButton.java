package com.components;

import com.controller.Controller;

import javax.swing.*;
import javax.swing.plaf.synth.ColorType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// stworzyc button spełniający wymagane założenia tj.
// po kliknieciu w niego ma zapisac notatke
// zmienić focus
// zmienić date w textfildzie

public class DayButton extends JButton implements ChangeDate {

    public DayButton(String title){
        super(title);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    for(DayButton b : Controller.getInstance().getCalendarView().getDays()){
                        b.setBackground(new JButton().getBackground());
                    }
                    setBackground(Color.GRAY);
                    updateDate(Controller.getInstance().getDate(),
                            Controller.getInstance().getView().getSelectedItem().toString());

            }
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if(SwingUtilities.isRightMouseButton(mouseEvent)){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(getText(), formatter);

                    String note = JOptionPane.showInputDialog("New note");
                    List<String> notes = new ArrayList<String>();

                    if(!Controller.getInstance().getNotes().containsKey(date)) {

                        notes.add(note);
                        Controller.getInstance().getNotes().put(date, notes);
                    }
                    else{
                        notes = Controller.getInstance().getNotes().get(date);

                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }

    @Override
    public void updateDate(LocalDate date, String view) {
        Controller.getInstance().getDateTextField().setText(this.getText());

    }

}

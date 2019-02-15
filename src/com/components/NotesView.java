package com.components;
//TODO coś z enumami
//TODO ogarnąć utility z date formaterem
//TODO ogarnąć dodawanie i wyswietlanie notatek
//TODO i w sumie to poczekać na code review
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class NotesView extends JTable implements NotesMap{

    private DefaultTableModel model = new DefaultTableModel();

    public NotesView(){
        this.setModel(model);
        model.setColumnIdentifiers(new String[]{"Date", "Number of notes"});
    }

    @Override
    public DefaultTableModel getModel() {
        return model;
    }

    @Override
    public void updateTable(LocalDate date, int number) {
        model.fireTableDataChanged();

    }
}

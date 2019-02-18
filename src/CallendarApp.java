import com.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class CallendarApp extends JFrame {


    BorderLayout borderLayout = new BorderLayout();

    CallendarApp(){
        super("Zajebisty kalendarz");
        JPanel upperPanel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(borderLayout);
        Controller controller = Controller.getInstance();
        upperPanel.add(controller.getPrevious());
        upperPanel.add(controller.getDateTextField());
        upperPanel.add(controller.getNext());
        upperPanel.add(controller.getView());

        add(upperPanel, BorderLayout.PAGE_START);
        add(controller.getCalendarView(), BorderLayout.CENTER);
        add(controller.getNotesView(), BorderLayout.PAGE_END );
        setSize(300,300);

        setVisible(true);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new CallendarApp());


    }
}

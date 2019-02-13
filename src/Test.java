import com.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {


    BorderLayout borderLayout = new BorderLayout();

    Test(){
        super("Zajebisty kalendarz");
        JPanel upperPanel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(borderLayout);
        upperPanel.add(Controller.getInstance().getPrevious());
        upperPanel.add(Controller.getInstance().getDateTextField());
        upperPanel.add(Controller.getInstance().getNext());
        upperPanel.add(Controller.getInstance().getView());

        add(upperPanel, borderLayout.PAGE_START);
        add(Controller.getInstance().getCalendarView(), borderLayout.CENTER);
        setSize(300,300);

        setVisible(true);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });


    }
}

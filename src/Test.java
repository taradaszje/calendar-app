import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {


    BorderLayout borderLayout = new BorderLayout();

    Test(){
        super("Zajebisty kalendarz");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(borderLayout);
        add(Controller.getInstance().previous, borderLayout.PAGE_END);
        add(Controller.getInstance().dateTextField, borderLayout.PAGE_START);
        add(Controller.getInstance().calendarView, borderLayout.CENTER);
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

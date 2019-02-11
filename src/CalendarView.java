import javax.swing.*;
import java.awt.*;

public class CalendarView extends JFrame {

    protected BorderLayout borderLayout = new BorderLayout();
    protected Container pane;
    protected Button left;
    protected Button right;
    protected TextField timeText;
    protected JCheckBox calendarType;
    CalendarView(){
        super("Hello World");
        pane = new Container();
        left = new Button("<");
        right = new Button(">");
        timeText = new TextField(":)");
        calendarType = new JCheckBox();


        pane.add(left,borderLayout.PAGE_START);
        pane.add(timeText,borderLayout.PAGE_START);
        pane.add(right, borderLayout.PAGE_START);
        pane.add(calendarType, borderLayout.PAGE_START);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}

import javax.swing.*;
import java.time.LocalDate;

public class DateTextField extends JTextField implements ChangeDate {

    DateTextField(){
        this.setText(LocalDate.now().toString());

    }
    @Override
    public void updateDate(LocalDate date, View view) {

    }
}

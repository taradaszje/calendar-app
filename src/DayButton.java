import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

// stworzyc button spełniający wymagane założenia tj.
// po kliknieciu w niego ma zapisac notatke
// zmienić focus
// zmienić date w textfildzie

public class DayButton extends JButton implements ChangeDate {

    DayButton(String s){
        super(s);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                    System.out.println("ss");
                    setBackground(Color.GRAY);
                    updateDate(Controller.getInstance().getDate(), Controller.getInstance().getView());

            }
        });
    }

    @Override
    public void updateDate(LocalDate date, View view) {
        Controller.getInstance().dateTextField.setText(this.getText());
    }

}

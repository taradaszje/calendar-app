import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Observable;
import java.util.Observer;

public class Previous extends JButton implements ChangeDate  {

    Previous(){
        setText("<");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updateDate(Controller.getInstance().getDate(),Controller.getInstance().getView());
            }
        });
        setVisible(true);
    }

    @Override
    public void updateDate(LocalDate date, View view) {

        if(view.getSelectedItem().equals("Month")){
            subOneMonth(date);
        }
        else
            subOneWeek(date);
    }
    public void subOneWeek(LocalDate date){
        date = date.minusDays(7);

    }
    public void subOneMonth(LocalDate date){
        if(date.getMonthValue()%2 == 1 || date.getMonthValue()==8) {
            date = date.minusDays(31);
        }
        else if(date.getMonthValue() == 2 && date.getMonthValue()%2 == 0 ){
            date = date.minusDays(28);
        }
        else if(date.getMonthValue() == 2 && date.getYear()%4==0 && date.getYear()%100!=0){
            date = date.minusDays(29);
        }
        else{
            date = date.minusDays(30);
        }

    }


}


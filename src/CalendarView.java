import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;



public class CalendarView extends JPanel implements ChangeDate{


    CalendarView(){

        DayButton days[] = new DayButton[7] ;
        LocalDate date = LocalDate.now();
        LocalDate temp = date;
        for(int i=0 ; i<7 ; i++){
            temp = date.plusDays(i);
            days[i] = new DayButton(temp.toString());
            this.add(days[i]);
        }
        days[0].setBackground(Color.GRAY);
    }

    void createButtons(LocalDate date,int count){
        DayButton days[] = new DayButton[count];
        for(int i=0 ; i<count ; i++){
            date=date.plusDays(i);
            days[i] = new DayButton(date.toString());
            this.add(days[i]);
        }
    }



    @Override
    public void updateDate(LocalDate date, View view) {
        boolean check = true;
        if(view.getSelectedItem().equals("Month"))
            check = true;
        else
            check = false;

        if(check && (date.getMonthValue()%2 == 1 || date.getMonthValue()==8)) {
            createButtons(date,31);
        }
        else if(date.getMonthValue() == 2 && date.getMonthValue()%2 == 0 ){
            createButtons(date,28);
        }
        else if(date.getMonthValue() == 2 && date.getYear()%4==0 && date.getYear()%100!=0){
            createButtons(date,29);
        }
        else{
            createButtons(date,30);
        }
    }
}

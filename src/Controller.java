import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Controller ourInstance = new Controller();

    public static Controller getInstance() {
        return ourInstance;
    }

    LocalDate date = LocalDate.now();

    List<ChangeDate> dateList = new ArrayList();
    List<ChangeView> viewList = new ArrayList();
    View view = new View();
    Previous previous = new Previous();
    DateTextField dateTextField = new DateTextField();
    CalendarView calendarView = new CalendarView();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    private Controller() {
        dateList.add(previous);
        dateList.add(dateTextField);
        dateList.add(calendarView);
    }
}

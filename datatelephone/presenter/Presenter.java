package datatelephone.presenter;

import datatelephone.model.Gender;
import datatelephone.view.View;
import java.time.LocalDate;

public class Presenter {
    private View mView;
    private Service mService;

    public Presenter(View view) {
        mView = view;
        mService = new Service();
    }
    public void addHuman(String name, String surname, LocalDate bdate, Gender.Type gender, String telephone) {
        mService.addHum(name, surname, bdate, gender, telephone);
    }
    public void getList() {
        mService.getListHuman();
    }
    public void deleteHuman(String name) {
        mService.deleteHuman(name);
    }

}

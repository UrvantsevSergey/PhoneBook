package datatelephone.presenter;

import datatelephone.model.Gender;
import java.time.LocalDate;

public interface ServiceInterface {
    void addHum(String name, String surname, LocalDate bdate, Gender.Type gender, String telephone);
    void getListHuman();
    void deleteHuman(String name);
}

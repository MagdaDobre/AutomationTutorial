package modelObject;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PracticeFormModel extends BaseModel {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String gender;
    private String mobileNumber;
    private String month;
    private String year;
    private String day;
    private List<String> subjects;
    private List<String> hobbies;
    private String currentAddress;
    private String state;
    private String city;
    private String pathFile;

    public PracticeFormModel(String jsonFilePath) {
        super(jsonFilePath);
    }

}

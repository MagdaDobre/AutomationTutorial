package modelObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebTableModel extends BaseModel {
    // User details
    private String firstName;
    private String lastName;
    private String userEmail;
    private String age;
    private String salary;
    private String department;

    // Edited user details
    private String editFirstName;
    private String editLastName;
    private String editEmail;
    private String editAge;
    private String editSalary;
    private String editDepartment;

    public WebTableModel(String jsonFilePath) {
        super(jsonFilePath);
    }
}


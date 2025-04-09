package model;

import java.util.Date;
import java.util.List;

public record Student(String idNumber,
                      String firstName,
                      String lastName,
                      Date registrationDate,
                      List<Course> courses) {
}

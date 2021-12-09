package ru.vzezj.EmployeeAssesment.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class CreateInterviewResultsRequest {
    private Integer skills;
    private Integer communication;
    private Integer intellect;
    private Date passedDate;
    private CreateUserRequest user;
}

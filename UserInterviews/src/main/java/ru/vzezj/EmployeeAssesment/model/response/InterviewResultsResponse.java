package ru.vzezj.EmployeeAssesment.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class InterviewResultsResponse {
    private Integer skills;
    private Integer communication;
    private Integer intellect;
    private Date passedDate;
    private UserResponse userResponse;
}

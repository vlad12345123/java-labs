package ru.vzezj.EmployeeAssesment.Service;

import com.sun.istack.NotNull;
import ru.vzezj.EmployeeAssesment.model.request.CreateInterviewResultsRequest;
import ru.vzezj.EmployeeAssesment.model.response.InterviewResultsResponse;
import ru.vzezj.EmployeeAssesment.model.response.UserResponse;

public interface InterviewResultsService {

    @NotNull
    InterviewResultsResponse createInterviewResults(@NotNull CreateInterviewResultsRequest request);
    @NotNull
    InterviewResultsResponse findById(@NotNull Integer interviewId);
}

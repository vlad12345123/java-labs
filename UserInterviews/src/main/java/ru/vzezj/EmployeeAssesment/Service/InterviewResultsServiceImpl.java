package ru.vzezj.EmployeeAssesment.Service;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vzezj.EmployeeAssesment.domain.InterviewResults;
import ru.vzezj.EmployeeAssesment.domain.User;
import ru.vzezj.EmployeeAssesment.model.request.CreateInterviewResultsRequest;
import ru.vzezj.EmployeeAssesment.model.request.CreateUserRequest;
import ru.vzezj.EmployeeAssesment.model.response.InterviewResultsResponse;
import ru.vzezj.EmployeeAssesment.model.response.UserResponse;
import ru.vzezj.EmployeeAssesment.repository.InterviewResultsRepository;
import sun.jvm.hotspot.debugger.Address;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor

public class InterviewResultsServiceImpl implements InterviewResultsService {

    private InterviewResultsRepository interviewResultsRepository;

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public InterviewResultsResponse createInterviewResults(@NotNull CreateInterviewResultsRequest request){
        InterviewResults interviewResults = buildInterviewRequest(request);
        return buildUserResponse(interviewResultsRepository.save(interviewResults));
    }

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public InterviewResultsResponse findById(@NotNull Integer interviewId) {
        return InterviewResultsRepository.findById(interviewId)
                .map(this::buildInterviewResponse)
                .orElseThrow(() -> new EntityNotFoundException("InterviewResult " + interviewId + " is not found"));
    }

    @NotNull
    private InterviewResults buildInterviewRequest(@NotNull CreateInterviewResultsRequest request) {
        return new InterviewResults()
                .getCommunication(request.getCommunication())
                .getSkills(request.getSkills())
                .getIntellect(request.getIntellect())
                .getPassedDate(request.getPassedDate());
    }

    @NotNull
    private InterviewResultsResponse buildInterviewResponse(@NotNull User user) {
        return new InterviewResultsResponse()
                .getCommunication(request.getCommunication())
                .getSkills(request.getSkills())
                .getIntellect(request.getIntellect())
                .getPassedDate(request.getPassedDate());
    }
}

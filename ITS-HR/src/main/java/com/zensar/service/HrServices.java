package com.zensar.service;

import java.util.List;

import com.zensar.dto.CandidateDto;
import com.zensar.dto.InterviewDto;

public interface HrServices {
	
	public List<CandidateDto> viewInterviewMembers();
	public InterviewDto giveRating(id, interviewDto);
	public CandidateDto viewCandidatesById(int id);

}

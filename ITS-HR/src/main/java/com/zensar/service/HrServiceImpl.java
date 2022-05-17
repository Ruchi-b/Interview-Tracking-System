package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.CandidateDto;
import com.zensar.dto.InterviewDto;
import com.zensar.entity.CandidatesEntity;
import com.zensar.repo.CandidateRepo;
import com.zensar.repo.InterviewRepo;

@Service
public class HrServiceImpl implements HrServices{

	@Autowired
	CandidateRepo candidateRepo;
	
	@Autowired
	InterviewRepo interviewRepo;
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public List<CandidateDto> viewInterviewMembers() {
		List<CandidatesEntity> candidateEntity= candidateRepo.findAll();
		List<CandidateDto> candidateDto= new ArrayList<>();
		for(CandidatesEntity candidate: candidateEntity)
			candidateDto.add(convertCandidateEntityIntoDto(candidate));
		return candidateDto;
	}

	@Override
	public InterviewDto giveRating() {
		
		return null;
	}

	@Override
	public CandidateDto viewCandidatesById(int id) {
		Optional<CandidatesEntity> candidateId=candidateRepo.findById(id);
		if(candidateId.isPresent()) {
			return convertCandidateEntityIntoDto(candidateId.get());
			
		}
		return null;
	}
	
	 
	private CandidatesEntity convertCandidateDtoIntoEntity(CandidateDto candidate) {
		CandidatesEntity candidateEntity=modelMapper.map(candidate, CandidatesEntity.class);
		return candidateEntity;
		}

		private CandidateDto convertCandidateEntityIntoDto(CandidatesEntity candidateEntity) {
		CandidateDto candidate=modelMapper.map(candidateEntity, CandidateDto.class);
		return candidate;
		}

		/*private InterviewScheduleEntity convertInterviewScheduleDtoIntoEntity(InterviewSchedule interviewSchedule) {
		InterviewScheduleEntity interviewScheduleEntity=modelMapper.map(interviewSchedule,InterviewScheduleEntity.class);
		return interviewScheduleEntity;
		}

		private InterviewSchedule convertInterviewScheduleEntityIntoDto(InterviewScheduleEntity interviewScheduleEntity) {
		InterviewSchedule interviewSchedule=modelMapper.map(interviewScheduleEntity, InterviewSchedule.class);
		return interviewSchedule;
		} */
		
	
	

}

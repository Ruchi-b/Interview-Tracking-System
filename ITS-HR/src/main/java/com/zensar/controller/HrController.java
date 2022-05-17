package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.CandidateDto;
import com.zensar.dto.InterviewDto;
import com.zensar.service.HrServices;


@RestController
@RequestMapping("/hr")
@CrossOrigin(origins="*")
public class HrController {
	
	@Autowired
	HrServices hrService;
	
	//15
	@GetMapping(value="/candidates",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<CandidateDto> viewInterviewMembers(){
		return hrService.viewInterviewMembers();
		
	}
	
	//16
	@PutMapping(value="/interview/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public InterviewDto giveRating(@PathVariable("id") int id, @RequestBody InterviewDto interviewDto) {
		return hrService.giveRating();
	}
	
	//17
	@GetMapping(value="/candidates/{id}",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public CandidateDto viewCandidatesById(@PathVariable("id") int id) {
		return hrService.viewCandidatesById(id);
		
	}

}

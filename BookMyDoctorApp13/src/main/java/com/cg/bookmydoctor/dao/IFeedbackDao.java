package com.cg.bookmydoctor.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;

public interface IFeedbackDao extends CrudRepository<FeedBack, Integer> {

	/*public FeedBack addFeedback(FeedBack fdb);
	public FeedBack getFeedback(FeedBack fdb);
	public List<FeedBack> getAllFeedback(Doctor doc);*/
	
	
}

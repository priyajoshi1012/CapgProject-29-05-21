package com.cg.bookmydoctor.service;
import java.util.ArrayList; 
import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.dao.IFeedbackDao;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService { 


	@Autowired
	private IFeedbackDao fbDao;
	FeedBack fb;

	@Override
	public FeedBack addFeedback(FeedBack fdb) {
		//Optional<FeedBack> findById = fbDao.findById(fdb.getRatingId());
		if(fdb != null) {
			return fbDao.save(fdb);
		}  else {
			throw new FeedBackException("Parsed object is null");
		}

	}

	@Override
	public FeedBack getFeedback(FeedBack fdb) {
		Optional<FeedBack> feedbackDB = fbDao.findById(fdb.getRatingId());
		return feedbackDB.get();
	}

	@Override
	public List<FeedBack> getAllFeedback(Doctor doc) {
		Optional<FeedBack> docId = fbDao.findById(doc.getDoctorId());
		List<FeedBack> list = new ArrayList<>();
		if(doc == null) {
			throw new FeedBackException("Null object is passed");
		} else {
			return null;
		}
	}
}
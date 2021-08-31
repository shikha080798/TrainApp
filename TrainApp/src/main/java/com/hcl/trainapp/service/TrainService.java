package com.hcl.trainapp.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.hcl.trainapp.dto.TrainResponseDto;
import com.hcl.trainapp.exception.TrainNotFoundException;
import com.hcl.trainapp.exception.UserDefinedException;
import com.hcl.trainapp.model.Train;

public interface TrainService {

	List<Train> getTrainsList(String fromsource, String todestination, String date) throws TrainNotFoundException;

}

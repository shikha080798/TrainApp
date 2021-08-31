package com.hcl.trainapp.serviceimpl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trainapp.dto.TrainResponseDto;
import com.hcl.trainapp.exception.TrainNotFoundException;
import com.hcl.trainapp.exception.UserDefinedException;
import com.hcl.trainapp.model.Train;
import com.hcl.trainapp.repository.TrainRepository;
import com.hcl.trainapp.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {
	@Autowired
	private TrainRepository trainRepository;

// get details of ticket booking
	@Override
	public List<Train> getTrainsList(String fromsource, String todestination, String date)
			throws TrainNotFoundException {

		List<Train> trainsList = trainRepository.findByFromsourceAndTodestinationAndDate(fromsource, todestination,
				date);
		String date1 = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		if ((fromsource.equalsIgnoreCase(todestination))) {
			throw new TrainNotFoundException("destination and source are same");
		}
//		} else if (date.compareTo(date1) < 0) {
//			throw new TrainNotFoundException("give proper future date");
		 else {
			if (!trainsList.isEmpty()) {
				return trainsList;

			} else {
				throw new TrainNotFoundException("no trains avaliable");
			}

		}
	}
}

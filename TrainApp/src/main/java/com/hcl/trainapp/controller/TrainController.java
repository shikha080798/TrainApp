package com.hcl.trainapp.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainapp.dto.TrainResponseDto;
import com.hcl.trainapp.exception.TrainNotFoundException;
import com.hcl.trainapp.exception.UserDefinedException;
import com.hcl.trainapp.model.Train;
import com.hcl.trainapp.service.TrainService;

@RestController
public class TrainController {
	@Autowired
	private TrainService trainService;

	// get train list
	@GetMapping("/trainlist")
	public ResponseEntity<Map<String, List<Train>>> getTrainList(@Valid @RequestParam String fromsource,
			@RequestParam String todestination, @RequestParam String date) throws TrainNotFoundException {
		Map<String, List<Train>> responseMap = new HashMap<>();
		List<Train> trainList = trainService.getTrainsList(fromsource, todestination, date);
		responseMap.put(trainList.size() + "Trains found", trainList);
		return new ResponseEntity<Map<String, List<Train>>>(responseMap, HttpStatus.OK);
	}
}

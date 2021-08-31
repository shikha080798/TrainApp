package com.hcl.trainapp.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trainapp.dto.TrainResponseDto;
import com.hcl.trainapp.model.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

	List<Train> findByFromsourceAndTodestinationAndDate(String fromsource, String todestination, String date);

	Train findByTrainNumber(int trainNumber);

	Train findByTrainId(long trainId);

}

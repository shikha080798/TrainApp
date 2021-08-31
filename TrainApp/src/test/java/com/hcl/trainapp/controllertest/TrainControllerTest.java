package com.hcl.trainapp.controllertest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.trainapp.controller.BookingController;
import com.hcl.trainapp.controller.TrainController;
import com.hcl.trainapp.exception.TrainNotFoundException;
import com.hcl.trainapp.model.Train;
import com.hcl.trainapp.repository.TrainRepository;
import com.hcl.trainapp.service.TrainService;
import com.hcl.trainapp.serviceimpl.TrainServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TrainControllerTest {
	@Mock
	TrainService trainService;
	@InjectMocks
	TrainController trainController;
	static Train trains;

	@BeforeAll
	public static void setUp() {
		trains = new Train();
		trains.setTrainId(200);
		trains.setTrainName("Shatabdi Special");
		trains.setTrainNumber(66666);
		trains.setFromsource("goa");
		trains.setTodestination("chennai");
		trains.setSeats(30);
		trains.setDate(LocalDate.now());
		trains.setCost_single_seats(350);
	}

	@Test
	@Order(1)
	@DisplayName("Get trains list : Positive Scenario")
	public void getTrainsList() throws TrainNotFoundException {
		List<Train> trainsList = new ArrayList<Train>();
		trainsList.add(trains);
		when(trainService.getTrainsList("goa", "chennai", "01-09-2021")).thenReturn(trainsList);
		ResponseEntity<Map<String, List<Train>>> result = trainController.getTrainList("goa", "chennai", "01-09-2021");
		Map<String, List<Train>> responseMap = new HashMap<>();
		responseMap.put(trainsList.size() + "Trains found", trainsList);
		verify(trainService).getTrainsList("goa", "chennai", "01-09-2021");
		assertEquals(responseMap, result.getBody());
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	@Order(2)
	@DisplayName("Get trains list : Negative Scenario")
	public void getTrainsList1() throws TrainNotFoundException {
		List<Train> trainsList = new ArrayList<Train>();
		when(trainService.getTrainsList("goa", "chennai", "01-09-2021")).thenThrow(TrainNotFoundException.class);
		assertTrue(trainsList.size() == 0);
		assertThrows(TrainNotFoundException.class, () -> trainController.getTrainList("goa", "chennai", "01-09-2021"));
	}
}
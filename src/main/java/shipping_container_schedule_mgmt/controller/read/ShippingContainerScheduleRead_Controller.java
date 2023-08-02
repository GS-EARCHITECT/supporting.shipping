package shipping_container_schedule_mgmt.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shipping_container_schedule_mgmt.model.dto.ShippingContainerSchedule_DTO;
import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedulePK;
import shipping_container_schedule_mgmt.services.read.I_ShippingContainerSchedulesRead_Service;

@RestController
@RequestMapping("/shippingContainerScheduleReadMgmt")
public class ShippingContainerScheduleRead_Controller {
	@Autowired
	private I_ShippingContainerSchedulesRead_Service shippingContainerSchedulesReadService;

	@GetMapping(value = "/getAllConsignmentShippingContainerSchedules", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> getAllConsignmentShippingContainerSchedules() {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> shippingContainerSchedule_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerSchedule_DTO> shippingContainerScheduleList = null;
		try {
			shippingContainerSchedule_DTOs = shippingContainerSchedulesReadService.getAllShippingContainerSchedules();
			shippingContainerScheduleList = shippingContainerSchedule_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerScheduleList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingContainerSchedules", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> getSelectShippingContainerSchedules(
			@RequestBody CopyOnWriteArrayList<ShippingContainerSchedulePK> shippingContainerSchedulePKs) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> shippingContainerSchedule_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerSchedule_DTO> shippingContainerScheduleList = null;
		try {
			shippingContainerSchedule_DTOs = shippingContainerSchedulesReadService
					.getSelectShippingContainerSchedules(shippingContainerSchedulePKs);
			shippingContainerScheduleList = shippingContainerSchedule_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerScheduleList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingContainerScheduleBySchedules", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> getSelectShippingContainerScheduleForPartiesFrom(
			@RequestBody CopyOnWriteArrayList<Long> sids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> shippingContainerSchedule_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerSchedule_DTO> shippingContainerScheduleList = null;
		try {
			shippingContainerSchedule_DTOs = shippingContainerSchedulesReadService
					.getSelectShippingContainerSchedulesBySchedules(sids);
			shippingContainerScheduleList = shippingContainerSchedule_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerScheduleList, HttpStatus.OK);
	}

}
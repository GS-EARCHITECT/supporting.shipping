package shipping_container_schedule_mgmt.controller.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shipping_container_schedule_mgmt.model.dto.ShippingContainerSchedule_DTO;
import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedulePK;
import shipping_container_schedule_mgmt.services.cud.I_ShippingContainerSchedulesCUD_Service;

@RestController
@RequestMapping("/shippingContainerSchedulesCUDMgmt")
public class ShippingContainerSchedulesCUD_Controller {
	@Autowired
	private I_ShippingContainerSchedulesCUD_Service shippingContainerSchedulesCUDService;

	@PostMapping("/newShippingContainerSchedule")
	public ResponseEntity<ShippingContainerSchedule_DTO> newShippingContainerSchedule(
			@RequestBody ShippingContainerSchedule_DTO shippingContainerSchedule_DTO) {
		CompletableFuture<ShippingContainerSchedule_DTO> future = null;
		ShippingContainerSchedule_DTO shippingContainerSchedule_DTO2 = null;
		try {
			future = shippingContainerSchedulesCUDService.newShippingContainerSchedule(shippingContainerSchedule_DTO);
			shippingContainerSchedule_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerSchedule_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updShippingContainerSchedule")
	public void updShippingContainerSchedule(@RequestBody ShippingContainerSchedule_DTO shippingContainerSchedule_DTO) {
		shippingContainerSchedulesCUDService.updShippingContainerSchedule(shippingContainerSchedule_DTO);
		return;
	}

	@DeleteMapping("/delSelectShippingContainerSchedules")
	public void delSelectShippingContainerSchedules(@RequestBody CopyOnWriteArrayList<ShippingContainerSchedulePK> shippingContainerSchedulePKs)
	{
		shippingContainerSchedulesCUDService.delSelectShippingContainerSchedules(shippingContainerSchedulePKs);
		return;
	}
	
	@DeleteMapping("/delSelectShippingContainerSchedulesBySchedules")
	public void delSelectShippingContainerSchedulesForPartiesFrom(@RequestBody CopyOnWriteArrayList<Long> sids) 
	{
		shippingContainerSchedulesCUDService.delSelectShippingContainerSchedulesBySchedules(sids);
		return;
	}

	
	@DeleteMapping("/delAllShippingContainerSchedules")
	public void delAllShippingContainerSchedules()
	{
		shippingContainerSchedulesCUDService.delAllShippingContainerSchedules();
		return;
	}

}
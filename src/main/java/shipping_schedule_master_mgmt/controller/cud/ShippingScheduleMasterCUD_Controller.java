package shipping_schedule_master_mgmt.controller.cud;

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
import shipping_schedule_master_mgmt.model.dto.ShippingScheduleMaster_DTO;
import shipping_schedule_master_mgmt.services.cud.I_ShippingScheduleMasterCUD_Service;

@RestController
@RequestMapping("/shippingScheduleMasterCUDMgmt")
public class ShippingScheduleMasterCUD_Controller {
	@Autowired
	private I_ShippingScheduleMasterCUD_Service shippingScheduleMasterCUDService;

	@PostMapping("/newShippingScheduleMaster")
	public ResponseEntity<ShippingScheduleMaster_DTO> newShippingScheduleMaster(
			@RequestBody ShippingScheduleMaster_DTO shippingScheduleMaster_DTO) {
		CompletableFuture<ShippingScheduleMaster_DTO> future = null;
		ShippingScheduleMaster_DTO shippingScheduleMaster_DTO2 = null;
		try {
			future = shippingScheduleMasterCUDService.newShippingScheduleMaster(shippingScheduleMaster_DTO);
			shippingScheduleMaster_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleMaster_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updShippingScheduleMaster")
	public void updShippingScheduleMaster(@RequestBody ShippingScheduleMaster_DTO shippingScheduleMaster_DTO) {
		shippingScheduleMasterCUDService.updShippingScheduleMaster(shippingScheduleMaster_DTO);
		return;
	}

	@DeleteMapping("/delSelectShippingScheduleMasters")
	public void delSelectShippingScheduleMasters(@RequestBody CopyOnWriteArrayList<Long> pids) {
		shippingScheduleMasterCUDService.delSelectShippingScheduleMasters(pids);
		return;
	}

	@DeleteMapping("/delAllShippingScheduleMasters")
	public void delAllShippingScheduleMasters()
	{
		shippingScheduleMasterCUDService.delAllShippingScheduleMasters();
		return;
	}

}
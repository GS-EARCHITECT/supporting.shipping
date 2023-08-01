package shipping_schedule_master_mgmt.controller.read;

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
import shipping_schedule_master_mgmt.model.dto.ShippingScheduleMaster_DTO;
import shipping_schedule_master_mgmt.services.read.I_ShippingScheduleMasterRead_Service;

@RestController
@RequestMapping("/shippingScheduleMasterReadMgmt")
public class ShippingScheduleMasterRead_Controller {
	@Autowired
	private I_ShippingScheduleMasterRead_Service shippingScheduleMasterReadServ;

	@GetMapping(value = "/getAllConsignmentShippingScheduleMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> getAllConsignmentShippingScheduleMasters() {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> shippingScheduleMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleMaster_DTO> shippingScheduleMasterList = null;
		try {
			shippingScheduleMaster_DTOs = shippingScheduleMasterReadServ.getAllShippingScheduleMasters();
			shippingScheduleMasterList = shippingScheduleMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingScheduleMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> getSelectShippingScheduleMasters(
			@RequestBody CopyOnWriteArrayList<Long> shippingScheduleMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> shippingScheduleMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleMaster_DTO> shippingScheduleMasterList = null;
		try {
			shippingScheduleMaster_DTOs = shippingScheduleMasterReadServ
					.getSelectShippingScheduleMasters(shippingScheduleMasterSeqNos);
			shippingScheduleMasterList = shippingScheduleMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleMasterList, HttpStatus.OK);
	}

}
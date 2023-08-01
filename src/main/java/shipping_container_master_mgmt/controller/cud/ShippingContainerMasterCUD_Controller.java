package shipping_container_master_mgmt.controller.cud;

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
import shipping_container_master_mgmt.model.dto.ShippingContainerMaster_DTO;
import shipping_container_master_mgmt.services.cud.I_ShippingContainerMasterCUD_Service;

@RestController
@RequestMapping("/shippingContainerMasterCUDMgmt")
public class ShippingContainerMasterCUD_Controller {
	@Autowired
	private I_ShippingContainerMasterCUD_Service shippingContainerMasterCUDService;

	@PostMapping("/newShippingContainerMaster")
	public ResponseEntity<ShippingContainerMaster_DTO> newShippingContainerMaster(
			@RequestBody ShippingContainerMaster_DTO shippingContainerMaster_DTO) {
		CompletableFuture<ShippingContainerMaster_DTO> future = null;
		ShippingContainerMaster_DTO shippingContainerMaster_DTO2 = null;
		try {
			future = shippingContainerMasterCUDService.newShippingContainerMaster(shippingContainerMaster_DTO);
			shippingContainerMaster_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerMaster_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updShippingContainerMaster")
	public void updShippingContainerMaster(@RequestBody ShippingContainerMaster_DTO shippingContainerMaster_DTO) {
		shippingContainerMasterCUDService.updShippingContainerMaster(shippingContainerMaster_DTO);
		return;
	}

	@DeleteMapping("/delSelectShippingContainerMasters")
	public void delSelectShippingContainerMasters(@RequestBody CopyOnWriteArrayList<Long> pids) {
		shippingContainerMasterCUDService.delSelectShippingContainerMasters(pids);
		return;
	}

	@DeleteMapping("/delSelectShippingContainerMastersForContainers")
	public void delSelectShippingContainerMastersForContainers(@RequestBody CopyOnWriteArrayList<Long> cids) {
		shippingContainerMasterCUDService.delSelectShippingContainerMastersForContainers(cids);
		return;
	}

	@DeleteMapping("/delSelectShippingContainerMastersByContainerIds")
	public void delSelectShippingContainerMastersByContainerIds(@RequestBody CopyOnWriteArrayList<String> cids) {
		shippingContainerMasterCUDService.delSelectShippingContainerMastersByContainerIds(cids);
		return;
	}

}
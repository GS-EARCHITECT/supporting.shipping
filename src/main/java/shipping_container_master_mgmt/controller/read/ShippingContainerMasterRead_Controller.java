package shipping_container_master_mgmt.controller.read;

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
import shipping_container_master_mgmt.model.dto.ShippingContainerMaster_DTO;
import shipping_container_master_mgmt.services.read.I_ShippingContainerMasterRead_Service;

@RestController
@RequestMapping("/shippingContainerMasterReadMgmt")
public class ShippingContainerMasterRead_Controller {
	@Autowired
	private I_ShippingContainerMasterRead_Service shippingContainerMasterReadService;

	@GetMapping(value = "/getAllConsignmentShippingContainerMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getAllConsignmentShippingContainerMasters() {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> shippingContainerMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerMaster_DTO> shippingContainerMasterList = null;
		try {
			shippingContainerMaster_DTOs = shippingContainerMasterReadService.getAllShippingContainerMasters();
			shippingContainerMasterList = shippingContainerMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingContainerMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getSelectShippingContainerMasters(
			@RequestBody CopyOnWriteArrayList<Long> shippingContainerMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> shippingContainerMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerMaster_DTO> shippingContainerMasterList = null;
		try {
			shippingContainerMaster_DTOs = shippingContainerMasterReadService
					.getSelectShippingContainerMasters(shippingContainerMasterSeqNos);
			shippingContainerMasterList = shippingContainerMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingContainerMastersForContainers", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getSelectShippingContainerMastersForContainers(
			@RequestBody CopyOnWriteArrayList<Long> cids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> shippingContainerMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerMaster_DTO> shippingContainerMasterList = null;
		try {
			shippingContainerMaster_DTOs = shippingContainerMasterReadService
					.getSelectShippingContainerMastersForContainers(cids);
			shippingContainerMasterList = shippingContainerMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingContainerMastersByByContainerIds", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getSelectShippingContainerMastersByByContainerIds(
			@RequestBody CopyOnWriteArrayList<String> ids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> shippingContainerMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerMaster_DTO> shippingContainerMasterList = null;
		try {
			shippingContainerMaster_DTOs = shippingContainerMasterReadService
					.getSelectShippingContainerMastersByContainerIds(ids);
			shippingContainerMasterList = shippingContainerMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerMasterList, HttpStatus.OK);
	}

}
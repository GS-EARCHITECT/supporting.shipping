package shipping_container_details_mgmt.controller.read;

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
import shipping_container_details_mgmt.model.dto.ShippingContainerDetail_DTO;
import shipping_container_details_mgmt.model.master.ShippingContainerDetailPK;
import shipping_container_details_mgmt.services.read.I_ShippingContainerDetailsRead_Service;

@RestController
@RequestMapping("/shippingContainerDetailsReadMgmt")
public class ShippingContainerDetailsRead_Controller {
	@Autowired
	private I_ShippingContainerDetailsRead_Service shippingContainerDetailsReadService;

	@GetMapping(value = "/getAllConsignmentShippingContainerDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getAllConsignmentShippingContainerDetails() {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> shippingContainerDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerDetail_DTO> shippingContainerDetailList = null;
		try {
			shippingContainerDetail_DTOs = shippingContainerDetailsReadService.getAllShippingContainerDetails();
			shippingContainerDetailList = shippingContainerDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingContainerDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetails(
			@RequestBody CopyOnWriteArrayList<ShippingContainerDetailPK> shippingContainerDetailPKs) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> shippingContainerDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerDetail_DTO> shippingContainerDetailList = null;
		try {
			shippingContainerDetail_DTOs = shippingContainerDetailsReadService
					.getSelectShippingContainerDetails(shippingContainerDetailPKs);
			shippingContainerDetailList = shippingContainerDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingContainerDetailsBySchedules", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsForPartiesFrom(
			@RequestBody CopyOnWriteArrayList<Long> sids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> shippingContainerDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerDetail_DTO> shippingContainerDetailList = null;
		try {
			shippingContainerDetail_DTOs = shippingContainerDetailsReadService
					.getSelectShippingContainerDetailsBySchedules(sids);
			shippingContainerDetailList = shippingContainerDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingContainerDetailsForConsignments", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsForConsignments(
			@RequestBody CopyOnWriteArrayList<Long> cids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> shippingContainerDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingContainerDetail_DTO> shippingContainerDetailList = null;
		try {
			shippingContainerDetail_DTOs = shippingContainerDetailsReadService
					.getSelectShippingContainerDetailsForConsignments(cids);
			shippingContainerDetailList = shippingContainerDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerDetailList, HttpStatus.OK);
	}

}
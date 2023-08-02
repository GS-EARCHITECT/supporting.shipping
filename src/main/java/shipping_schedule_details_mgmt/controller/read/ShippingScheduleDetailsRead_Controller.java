package shipping_schedule_details_mgmt.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shipping_schedule_details_mgmt.model.dto.ShippingScheduleDetail_DTO;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetailPK;
import shipping_schedule_details_mgmt.services.read.I_ShippingScheduleDetailsRead_Service;

@RestController
@RequestMapping("/shippingScheduleDetailsReadMgmt")
public class ShippingScheduleDetailsRead_Controller 
{
	@Autowired
	private I_ShippingScheduleDetailsRead_Service shippingScheduleDetailsReadService;

	@GetMapping(value = "/getAllConsignmentShippingScheduleDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getAllConsignmentShippingScheduleDetails() {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> shippingScheduleDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleDetail_DTO> shippingScheduleDetailList = null;
		try {
			shippingScheduleDetail_DTOs = shippingScheduleDetailsReadService.getAllShippingScheduleDetails();
			shippingScheduleDetailList = shippingScheduleDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingScheduleDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetails(
			@RequestBody CopyOnWriteArrayList<ShippingScheduleDetailPK> shippingScheduleDetailPKs) {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> shippingScheduleDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleDetail_DTO> shippingScheduleDetailList = null;
		try {
			shippingScheduleDetail_DTOs = shippingScheduleDetailsReadService
					.getSelectShippingScheduleDetails(shippingScheduleDetailPKs);
			shippingScheduleDetailList = shippingScheduleDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingScheduleDetailsBySchedules", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsForPartiesFrom(
			@RequestBody CopyOnWriteArrayList<Long> sids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> shippingScheduleDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleDetail_DTO> shippingScheduleDetailList = null;
		try {
			shippingScheduleDetail_DTOs = shippingScheduleDetailsReadService
					.getSelectShippingScheduleDetailsBySchedules(sids);
			shippingScheduleDetailList = shippingScheduleDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingScheduleDetailsByCarriers", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsByCarriers(
			@RequestBody CopyOnWriteArrayList<Long> cids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> shippingScheduleDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleDetail_DTO> shippingScheduleDetailList = null;
		try {
			shippingScheduleDetail_DTOs = shippingScheduleDetailsReadService
					.getSelectShippingScheduleDetailsByCarriers(cids);
			shippingScheduleDetailList = shippingScheduleDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleDetailList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectShippingScheduleDetailsByLocFrom", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsByLocFrom(
			@RequestBody CopyOnWriteArrayList<Long> fids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> shippingScheduleDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleDetail_DTO> shippingScheduleDetailList = null;
		try {
			shippingScheduleDetail_DTOs = shippingScheduleDetailsReadService
					.getSelectShippingScheduleDetailsByLocFrom(fids);
			shippingScheduleDetailList = shippingScheduleDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingScheduleDetailsByLocTo", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsByLocTo(
			@RequestBody CopyOnWriteArrayList<Long> tids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> shippingScheduleDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleDetail_DTO> shippingScheduleDetailList = null;
		try {
			shippingScheduleDetail_DTOs = shippingScheduleDetailsReadService
					.getSelectShippingScheduleDetailsByLocTo(tids);
			shippingScheduleDetailList = shippingScheduleDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getShippingScheduleDetailsBetweenETimes/{fr}/{to}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getShippingScheduleDetailsBetweenETimes(
			@PathVariable String fr, @PathVariable String to)
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> shippingScheduleDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleDetail_DTO> shippingScheduleDetailList = null;
		try {
			shippingScheduleDetail_DTOs = shippingScheduleDetailsReadService
					.getShippingScheduleDetailsBetweenETimes(fr, to);
			shippingScheduleDetailList = shippingScheduleDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getShippingScheduleDetailsBetweenATimes/{fr}/{to}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getShippingScheduleDetailsBetweenATimes(
			@PathVariable String fr, @PathVariable String to)
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> shippingScheduleDetail_DTOs = null;
		CopyOnWriteArrayList<ShippingScheduleDetail_DTO> shippingScheduleDetailList = null;
		try {
			shippingScheduleDetail_DTOs = shippingScheduleDetailsReadService
					.getShippingScheduleDetailsBetweenATimes(fr, to);
			shippingScheduleDetailList = shippingScheduleDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleDetailList, HttpStatus.OK);
	}

	
	
}
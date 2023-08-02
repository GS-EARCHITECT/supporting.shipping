package shipping_master_mgmt.controller.read;

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
import shipping_master_mgmt.model.dto.ShippingMaster_DTO;
import shipping_master_mgmt.services.read.I_ShippingMasterRead_Service;

@RestController
@RequestMapping("/shippingMasterReadMgmt")
public class ShippingMasterRead_Controller
{
	@Autowired
	private I_ShippingMasterRead_Service shippingMasterReadService;

	@GetMapping(value = "/getAllConsignmentShippingMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getAllConsignmentShippingMasters() {
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getAllShippingMasters();
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectShippingMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMasters(
			@RequestBody CopyOnWriteArrayList<Long> shippingMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMasters(shippingMasterSeqNos);
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingMastersForPartiesFrom", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersForPartiesFrom(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMastersForPartiesFrom(pids);
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingMastersForPartiesTo", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersForPartiesTo(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMastersForPartiesTo(pids);
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	
	@GetMapping(value = "/getSelectShippingMastersByShippingIds", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersByShippingIds(
			@RequestBody CopyOnWriteArrayList<String> ids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMastersByShippingIds(ids);
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingMastersPending()", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMastersPending();
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}


	@GetMapping(value = "/getSelectShippingMastersDelivered", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersByParents()
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMastersDelivered();
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectWorksBetweenETimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectWorksBetweenETimes(@PathVariable String fr, @PathVariable String to)
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectWorksBetweenETimes(fr, to);
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectWorksBetweenATimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectWorksBetweenATimes(@PathVariable String fr, @PathVariable String to)
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectWorksBetweenATimes(fr, to);
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingMastersComingIn", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersComingIn()
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMastersComingIn();
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingMastersGoingOut", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersGoingOut()
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMastersGoingOut();
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingMastersCanBeProcessed", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersCanBeProcessed()
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMastersCanBeProcessed();
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectShippingMastersCannotBeProcessed", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersCannotBeProcessed()
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> shippingMaster_DTOs = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingMasterList = null;
		try {
			shippingMaster_DTOs = shippingMasterReadService.getSelectShippingMastersCannotBeProcessed();
			shippingMasterList = shippingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMasterList, HttpStatus.OK);
	}

	
	
}
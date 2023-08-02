package shipping_schedule_details_mgmt.controller.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shipping_schedule_details_mgmt.model.dto.ShippingScheduleDetail_DTO;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetailPK;
import shipping_schedule_details_mgmt.services.cud.I_ShippingScheduleDetailsCUD_Service;

@RestController
@RequestMapping("/shippingScheduleDetailsCUDMgmt")
public class ShippingScheduleDetailsCUD_Controller {
	@Autowired
	private I_ShippingScheduleDetailsCUD_Service shippingScheduleDetailsCUDService;

	@PostMapping("/newShippingScheduleDetail")
	public ResponseEntity<ShippingScheduleDetail_DTO> newShippingScheduleDetail(
			@RequestBody ShippingScheduleDetail_DTO shippingScheduleDetail_DTO) {
		CompletableFuture<ShippingScheduleDetail_DTO> future = null;
		ShippingScheduleDetail_DTO shippingScheduleDetail_DTO2 = null;
		try {
			future = shippingScheduleDetailsCUDService.newShippingScheduleDetail(shippingScheduleDetail_DTO);
			shippingScheduleDetail_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingScheduleDetail_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updShippingScheduleDetail")
	public void updShippingScheduleDetail(@RequestBody ShippingScheduleDetail_DTO shippingScheduleDetail_DTO) {
		shippingScheduleDetailsCUDService.updShippingScheduleDetail(shippingScheduleDetail_DTO);
		return;
	}

	@DeleteMapping("/delSelectShippingScheduleDetails")
	public void delSelectShippingScheduleDetails(@RequestBody CopyOnWriteArrayList<ShippingScheduleDetailPK> shippingScheduleDetailPKs)
	{
		shippingScheduleDetailsCUDService.delSelectShippingScheduleDetails(shippingScheduleDetailPKs);
		return;
	}
	
	@DeleteMapping("/delSelectShippingScheduleDetailsBySchedules")
	public void delSelectShippingScheduleDetailsForPartiesFrom(@RequestBody CopyOnWriteArrayList<Long> sids) 
	{
		shippingScheduleDetailsCUDService.delSelectShippingScheduleDetailsBySchedules(sids);
		return;
	}

	@DeleteMapping("/delSelectShippingScheduleDetailsByCarriers")
	public void delSelectShippingScheduleDetailsByCarriers(@RequestBody CopyOnWriteArrayList<Long> cids) 
	{
		shippingScheduleDetailsCUDService.delSelectShippingScheduleDetailsByCarriers(cids);
		return;
	}
	
	@DeleteMapping("/delSelectShippingScheduleDetailsByLocFrom")
	public void delSelectShippingScheduleDetailsByLocFrom(@RequestBody CopyOnWriteArrayList<Long> fids) 
	{
		shippingScheduleDetailsCUDService.delSelectShippingScheduleDetailsByLocFrom(fids);
		return;
	}

	@DeleteMapping("/delSelectShippingScheduleDetailsByLocTo")
	public void delSelectShippingScheduleDetailsByLocTo(@RequestBody CopyOnWriteArrayList<Long> tids) 
	{
		shippingScheduleDetailsCUDService.delSelectShippingScheduleDetailsByLocTo(tids);
		return;
	}
	
	@DeleteMapping("/delShippingScheduleDetailsBetweenETimes/{fr}/{to}")
	public void delShippingScheduleDetailsBetweenETimes(@PathVariable String fr, @PathVariable String to) 
	{
		shippingScheduleDetailsCUDService.delShippingScheduleDetailsBetweenETimes(fr, to);
		return;
	}
	
	@DeleteMapping("/delShippingScheduleDetailsBetweenATimes/{fr}/{to}")
	public void delShippingScheduleDetailsBetweenATimes(@PathVariable String fr, @PathVariable String to) 
	{
		shippingScheduleDetailsCUDService.delShippingScheduleDetailsBetweenATimes(fr, to);
		return;
	}
	
	@DeleteMapping("/delAllShippingScheduleDetails")
	public void delAllShippingScheduleDetails()
	{
		shippingScheduleDetailsCUDService.delAllShippingScheduleDetails();
		return;
	}

}
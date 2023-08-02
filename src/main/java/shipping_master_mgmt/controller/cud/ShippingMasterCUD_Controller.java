package shipping_master_mgmt.controller.cud;

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
import shipping_master_mgmt.model.dto.ShippingMaster_DTO;
import shipping_master_mgmt.services.cud.I_ShippingMasterCUD_Service;

@RestController
@RequestMapping("/shippingMasterCUDMgmt")
public class ShippingMasterCUD_Controller {
	@Autowired
	private I_ShippingMasterCUD_Service shippingMasterCUDService;

	@PostMapping("/newShippingMaster")
	public ResponseEntity<ShippingMaster_DTO> newShippingMaster(
			@RequestBody ShippingMaster_DTO shippingMaster_DTO) {
		CompletableFuture<ShippingMaster_DTO> future = null;
		ShippingMaster_DTO shippingMaster_DTO2 = null;
		try {
			future = shippingMasterCUDService.newShippingMaster(shippingMaster_DTO);
			shippingMaster_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingMaster_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updShippingMaster")
	public void updShippingMaster(@RequestBody ShippingMaster_DTO shippingMaster_DTO) {
		shippingMasterCUDService.updShippingMaster(shippingMaster_DTO);
		return;
	}

	@PutMapping("/updShippingMasterOk/{scid}")
	public void updShippingMasterOk(@PathVariable Long scid)
	{
		shippingMasterCUDService.updShippingMasterOk(scid);
		return;
	}

	@PutMapping("/updShippingMasterOkStatus/{scid}/{st}")
	public void updShippingMasterOkStatus(@PathVariable Long scid, @PathVariable Character st)
	{
		shippingMasterCUDService.updShippingMasterOkStatus(scid, st);
		return;
	}

	@PutMapping("/updShippingMasterDone/{scid}")
	public void updShippingMasterDone(@PathVariable Long scid)
	{
		shippingMasterCUDService.updShippingMasterDone(scid);
		return;
	}

	@PutMapping("/updShippingMasterDoneStatus/{scid}/{st}")
	public void updShippingMasterDone(@PathVariable Long scid, @PathVariable Character st)
	{
		shippingMasterCUDService.updShippingMasterDoneStatus(scid, st);
		return;
	}
	
	@DeleteMapping("/delSelectShippingMasters")
	public void delSelectShippingMasters(@RequestBody CopyOnWriteArrayList<Long> pids) {
		shippingMasterCUDService.delSelectShippingMasters(pids);
		return;
	}
	
	@DeleteMapping("/delSelectShippingMastersForPartiesFrom")
	public void delSelectShippingMastersForPartiesFrom(@RequestBody CopyOnWriteArrayList<Long> pids) {
		shippingMasterCUDService.delSelectShippingMastersForPartiesFrom(pids);
		return;
	}

	@DeleteMapping("/delSelectShippingMastersForPartiesTo")
	public void delSelectShippingMastersForPartiesTo(@RequestBody CopyOnWriteArrayList<Long> pids) {
		shippingMasterCUDService.delSelectShippingMastersForPartiesTo(pids);
		return;
	}
	
	@DeleteMapping("/delSelectShippingMastersByShippingIds")
	public void delSelectShippingMastersByShippingIds(@RequestBody CopyOnWriteArrayList<String> sids) 
	{
		shippingMasterCUDService.delSelectShippingMastersByShippingIds(sids);
		return;
	}
	
	@DeleteMapping("/delSelectShippingMastersPending")
	public void delSelectShippingMastersPending(@RequestBody CopyOnWriteArrayList<Long> pids) {
		shippingMasterCUDService.delSelectShippingMastersPending();
		return;
	}

	@DeleteMapping("/delSelectShippingMastersDelivered")
	public void delSelectShippingMastersDelivered(@RequestBody CopyOnWriteArrayList<Long> pids) {
		shippingMasterCUDService.delSelectShippingMastersDelivered();
		return;
	}

	@DeleteMapping("/delSelectWorksBetweenETimes/{gr}/{to}")
	public void delSelectWorksBetweenETimes(@PathVariable String fr, @PathVariable String to)
	{
		shippingMasterCUDService.delSelectWorksBetweenETimes(fr,to);
		return;
	}

	@DeleteMapping("/delSelectWorksBetweenATimes/{gr}/{to}")
	public void delSelectWorksBetweenATimes(@PathVariable String fr, @PathVariable String to)
	{
		shippingMasterCUDService.delSelectWorksBetweenATimes(fr,to);
		return;
	}

	@DeleteMapping("/delAllShippingMasters")
	public void delAllShippingMasters()
	{
		shippingMasterCUDService.delAllShippingMasters();
		return;
	}

}
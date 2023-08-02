package shipping_container_details_mgmt.controller.cud;

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
import shipping_container_details_mgmt.model.dto.ShippingContainerDetail_DTO;
import shipping_container_details_mgmt.model.master.ShippingContainerDetailPK;
import shipping_container_details_mgmt.services.cud.I_ShippingContainerDetailsCUD_Service;

@RestController
@RequestMapping("/shippingContainerDetailsCUDMgmt")
public class ShippingContainerDetailsCUD_Controller {
	@Autowired
	private I_ShippingContainerDetailsCUD_Service shippingContainerDetailsCUDService;

	@PostMapping("/newShippingContainerDetail")
	public ResponseEntity<ShippingContainerDetail_DTO> newShippingContainerDetail(
			@RequestBody ShippingContainerDetail_DTO shippingContainerDetail_DTO) {
		CompletableFuture<ShippingContainerDetail_DTO> future = null;
		ShippingContainerDetail_DTO shippingContainerDetail_DTO2 = null;
		try {
			future = shippingContainerDetailsCUDService.newShippingContainerDetail(shippingContainerDetail_DTO);
			shippingContainerDetail_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(shippingContainerDetail_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updShippingContainerDetail")
	public void updShippingContainerDetail(@RequestBody ShippingContainerDetail_DTO shippingContainerDetail_DTO) {
		shippingContainerDetailsCUDService.updShippingContainerDetail(shippingContainerDetail_DTO);
		return;
	}
	
	@PutMapping("/updShippingContainerDetailOk/{scid}/{cid}")
	public void updShippingContainerDetailOk(@PathVariable Long scid, @PathVariable Long cid)
	{
		shippingContainerDetailsCUDService.updShippingContainerDetailOk(scid, cid);
		return;
	}

	@PutMapping("/updShippingContainerDetailOkStatus/{scid}/{cid}/{st}")
	public void updShippingContainerDetailOkStatus(@PathVariable Long scid, @PathVariable Long cid, @PathVariable Character st)
	{
		shippingContainerDetailsCUDService.updShippingContainerDetailOkStatus(scid, cid, st);
		return;
	}

	@PutMapping("/updShippingContainerDetailDone/{scid}/{cid}")
	public void updShippingContainerDetailDone(@PathVariable Long scid, @PathVariable Long cid)
	{
		shippingContainerDetailsCUDService.updShippingContainerDetailDone(scid, cid);
		return;
	}

	@PutMapping("/updShippingContainerDetailDoneStatus/{scid}/{cid}/{st}")
	public void updShippingContainerDetailDone(@PathVariable Long scid, @PathVariable Long cid, @PathVariable Character st)
	{
		shippingContainerDetailsCUDService.updShippingContainerDetailDoneStatus(scid, cid, st);
		return;
	}

	
	@DeleteMapping("/delSelectShippingContainerDetails")
	public void delSelectShippingContainerDetails(@RequestBody CopyOnWriteArrayList<ShippingContainerDetailPK> shippingContainerDetailPKs)
	{
		shippingContainerDetailsCUDService.delSelectShippingContainerDetails(shippingContainerDetailPKs);
		return;
	}
	
	@DeleteMapping("/delSelectShippingContainerDetailsBySchedules")
	public void delSelectShippingContainerDetailsForPartiesFrom(@RequestBody CopyOnWriteArrayList<Long> sids) 
	{
		shippingContainerDetailsCUDService.delSelectShippingContainerDetailsBySchedules(sids);
		return;
	}

	@DeleteMapping("/delSelectShippingContainerDetailsForConsignments")
	public void delSelectShippingContainerDetailsForConsignments(@RequestBody CopyOnWriteArrayList<Long> cids) 
	{
		shippingContainerDetailsCUDService.delSelectShippingContainerDetailsForConsignments(cids);
		return;
	}
	
	
	@DeleteMapping("/delAllShippingContainerDetails")
	public void delAllShippingContainerDetails()
	{
		shippingContainerDetailsCUDService.delAllShippingContainerDetails();
		return;
	}

}
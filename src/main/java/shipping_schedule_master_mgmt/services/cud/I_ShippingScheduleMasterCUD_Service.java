package shipping_schedule_master_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import shipping_schedule_master_mgmt.model.dto.ShippingScheduleMaster_DTO;

public interface I_ShippingScheduleMasterCUD_Service 
{	
	public CompletableFuture<ShippingScheduleMaster_DTO> newShippingScheduleMaster(ShippingScheduleMaster_DTO shippingMaster_DTO);
	public CompletableFuture<Void> updShippingScheduleMaster(ShippingScheduleMaster_DTO shippingMaster_DTO);
	public CompletableFuture<Void> delAllShippingScheduleMasters();
	public CompletableFuture<Void> delSelectShippingScheduleMasters(CopyOnWriteArrayList<Long> ids);
	
}
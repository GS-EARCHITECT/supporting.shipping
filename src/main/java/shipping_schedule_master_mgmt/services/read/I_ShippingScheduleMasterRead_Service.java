package shipping_schedule_master_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_schedule_master_mgmt.model.dto.ShippingScheduleMaster_DTO;

public interface I_ShippingScheduleMasterRead_Service 
{	
public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> getAllShippingScheduleMasters();
public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> getSelectShippingScheduleMasters(CopyOnWriteArrayList<Long> ids);	
}
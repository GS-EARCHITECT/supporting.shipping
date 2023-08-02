package shipping_container_schedule_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_container_schedule_mgmt.model.dto.ShippingContainerSchedule_DTO;
import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedulePK;

public interface I_ShippingContainerSchedulesRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> getAllShippingContainerSchedules();
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> getSelectShippingContainerSchedules(CopyOnWriteArrayList<ShippingContainerSchedulePK> shippingContainerSchedulePKs);
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> getSelectShippingContainerSchedulesBySchedules(CopyOnWriteArrayList<Long> ids);
	
}
package shipping_container_schedule_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import shipping_container_schedule_mgmt.model.dto.ShippingContainerSchedule_DTO;
import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedulePK;

public interface I_ShippingContainerSchedulesCUD_Service 
{	
	public CompletableFuture<ShippingContainerSchedule_DTO> newShippingContainerSchedule(ShippingContainerSchedule_DTO shippingContainerSchedule_DTO);
	public CompletableFuture<Void> updShippingContainerSchedule(ShippingContainerSchedule_DTO shippingContainerSchedule_DTO);
	public CompletableFuture<Void> delAllShippingContainerSchedules();
	public CompletableFuture<Void> delSelectShippingContainerSchedules(CopyOnWriteArrayList<ShippingContainerSchedulePK> shippingContainerSchedulePKs);
	public CompletableFuture<Void> delSelectShippingContainerSchedulesBySchedules(CopyOnWriteArrayList<Long> ids);

}
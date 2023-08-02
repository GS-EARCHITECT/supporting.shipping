package shipping_schedule_details_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_schedule_details_mgmt.model.dto.ShippingScheduleDetail_DTO;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetailPK;

public interface I_ShippingScheduleDetailsCUD_Service 
{	
	public CompletableFuture<ShippingScheduleDetail_DTO> newShippingScheduleDetail(ShippingScheduleDetail_DTO shippingScheduleDetail_DTO);
	public CompletableFuture<Void> updShippingScheduleDetail(ShippingScheduleDetail_DTO shippingScheduleDetail_DTO);
	public CompletableFuture<Void> delSelectShippingScheduleDetails(CopyOnWriteArrayList<ShippingScheduleDetailPK> scheduleDetailPKs);
	public CompletableFuture<Void> delSelectShippingScheduleDetailsBySchedules(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectShippingScheduleDetailsByCarriers(CopyOnWriteArrayList<Long> cids);
	public CompletableFuture<Void> delSelectShippingScheduleDetailsByLocFrom(CopyOnWriteArrayList<Long> fids);
	public CompletableFuture<Void> delSelectShippingScheduleDetailsByLocTo(CopyOnWriteArrayList<Long> tids);
	public CompletableFuture<Void> delShippingScheduleDetailsBetweenETimes(String frDtTm, String toDtTm);
	public CompletableFuture<Void> delShippingScheduleDetailsBetweenATimes(String frDtTm, String toDtTm);
	public CompletableFuture<Void> delAllShippingScheduleDetails();
}
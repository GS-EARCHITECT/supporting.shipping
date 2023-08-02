package shipping_schedule_details_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_schedule_details_mgmt.model.dto.ShippingScheduleDetail_DTO;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetailPK;

public interface I_ShippingScheduleDetailsRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getAllShippingScheduleDetails();
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetails(CopyOnWriteArrayList<ShippingScheduleDetailPK> shippingScheduleDetailPKs);
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsBySchedules(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsByCarriers(CopyOnWriteArrayList<Long> cids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsByLocFrom(CopyOnWriteArrayList<Long> fids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsByLocTo(CopyOnWriteArrayList<Long> tids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getShippingScheduleDetailsBetweenETimes(String frDtTm, String toDtTm);
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getShippingScheduleDetailsBetweenATimes(String frDtTm, String toDtTm);

}
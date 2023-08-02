package shipping_master_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_master_mgmt.model.dto.ShippingMaster_DTO;

public interface I_ShippingMasterRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getAllShippingMasters();
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersForPartiesFrom(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersForPartiesTo(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersByShippingIds(CopyOnWriteArrayList<String> sids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersPending();
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersDelivered();
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectWorksBetweenETimes(String frDtTm, String toDtTm);
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectWorksBetweenATimes(String frDtTm, String toDtTm);
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersComingIn();
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersGoingOut();
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersCanBeProcessed();
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersCannotBeProcessed();	
}
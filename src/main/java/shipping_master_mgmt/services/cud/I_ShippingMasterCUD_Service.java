package shipping_master_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_master_mgmt.model.dto.ShippingMaster_DTO;

public interface I_ShippingMasterCUD_Service 
{	
	public CompletableFuture<ShippingMaster_DTO> newShippingMaster(ShippingMaster_DTO shippingMaster_DTO);
	public CompletableFuture<Void> updShippingMaster(ShippingMaster_DTO shippingMaster_DTO);
	public CompletableFuture<Void> delAllShippingMasters();
	public CompletableFuture<Void> delSelectShippingMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectShippingMastersForPartiesFrom(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectShippingMastersForPartiesTo(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectShippingMastersByShippingIds(CopyOnWriteArrayList<String> sids);
	public CompletableFuture<Void> delSelectShippingMastersPending();
	public CompletableFuture<Void> delSelectShippingMastersDelivered();
	public CompletableFuture<Void> delSelectWorksBetweenETimes(String frDtTm, String toDtTm);
	public CompletableFuture<Void> delSelectWorksBetweenATimes(String frDtTm, String toDtTm);
	public CompletableFuture<Void> updShippingMasterDone(Long id);
	public CompletableFuture<Void> updShippingMasterDoneStatus(Long id, Character st);
	public CompletableFuture<Void> updShippingMasterOk(Long id);
	public CompletableFuture<Void> updShippingMasterOkStatus(Long id, Character st);
}
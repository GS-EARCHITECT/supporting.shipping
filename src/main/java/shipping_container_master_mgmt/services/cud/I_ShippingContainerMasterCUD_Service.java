package shipping_container_master_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_container_master_mgmt.model.dto.ShippingContainerMaster_DTO;

public interface I_ShippingContainerMasterCUD_Service 
{	
	public CompletableFuture<ShippingContainerMaster_DTO> newShippingContainerMaster(ShippingContainerMaster_DTO shippingMaster_DTO);
	public CompletableFuture<Void> updShippingContainerMaster(ShippingContainerMaster_DTO shippingMaster_DTO);
	public CompletableFuture<Void> delAllShippingContainerMasters();	
	public CompletableFuture<Void> delSelectShippingContainerMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectShippingContainerMastersForContainers(CopyOnWriteArrayList<Long> cids);
	public CompletableFuture<Void> delSelectShippingContainerMastersByContainerIds(CopyOnWriteArrayList<String> aids);
}
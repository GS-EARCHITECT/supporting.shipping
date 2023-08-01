package shipping_container_master_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_container_master_mgmt.model.dto.ShippingContainerMaster_DTO;

public interface I_ShippingContainerMasterRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getAllShippingContainerMasters();
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getSelectShippingContainerMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getSelectShippingContainerMastersForContainers(CopyOnWriteArrayList<Long> cids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getSelectShippingContainerMastersByContainerIds(CopyOnWriteArrayList<String> aids);
}
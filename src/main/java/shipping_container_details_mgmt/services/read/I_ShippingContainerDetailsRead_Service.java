package shipping_container_details_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_container_details_mgmt.model.dto.ShippingContainerDetail_DTO;
import shipping_container_details_mgmt.model.master.ShippingContainerDetailPK;

public interface I_ShippingContainerDetailsRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getAllShippingContainerDetails();
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetails(CopyOnWriteArrayList<ShippingContainerDetailPK> shippingContainerDetailPKs);
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsBySchedules(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsForConsignments(CopyOnWriteArrayList<Long> cids);
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingMastersPending();
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsDelivered();
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsCanBeProcessed();
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsCannotBeProcessed();
}
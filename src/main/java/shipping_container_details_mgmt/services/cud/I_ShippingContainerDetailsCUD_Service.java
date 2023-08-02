package shipping_container_details_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import shipping_container_details_mgmt.model.dto.ShippingContainerDetail_DTO;
import shipping_container_details_mgmt.model.master.ShippingContainerDetailPK;

public interface I_ShippingContainerDetailsCUD_Service 
{	
	public CompletableFuture<ShippingContainerDetail_DTO> newShippingContainerDetail(ShippingContainerDetail_DTO shippingContainerDetail_DTO);
	public CompletableFuture<Void> updShippingContainerDetail(ShippingContainerDetail_DTO shippingContainerDetail_DTO);
	public CompletableFuture<Void> updShippingConsignmentStatus(ShippingContainerDetail_DTO shippingContainerDetail_DTO);
	public CompletableFuture<Void> delAllShippingContainerDetails();
	public CompletableFuture<Void> delSelectShippingContainerDetails(CopyOnWriteArrayList<ShippingContainerDetailPK> shippingContainerDetailPKs);
	public CompletableFuture<Void> delSelectShippingContainerDetailsBySchedules(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectShippingContainerDetailsForConsignments(CopyOnWriteArrayList<Long> cids);

}
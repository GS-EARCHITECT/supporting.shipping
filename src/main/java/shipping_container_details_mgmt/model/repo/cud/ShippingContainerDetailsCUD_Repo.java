package shipping_container_details_mgmt.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_container_details_mgmt.model.master.ShippingContainerDetail;
import shipping_container_details_mgmt.model.master.ShippingContainerDetailPK;

@Repository("shippingContainerDetailsCUDRepo")
public interface ShippingContainerDetailsCUD_Repo extends JpaRepository<ShippingContainerDetail, ShippingContainerDetailPK> 
{

	@Query(value = "delete from Shipping_Container_Details where sc_SEQ_NO in :ids", nativeQuery = true)
	void delSelectShippingContainerDetailsBySchedules(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "delete from  Shipping_Container_Details where consignment_SEQ_NO in :cids", nativeQuery = true)
	void delSelectShippingContainerDetailsForConsignments(@Param("cids") CopyOnWriteArrayList<Long> cids);
	
}
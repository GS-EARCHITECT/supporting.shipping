package shipping_container_details_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_container_details_mgmt.model.master.ShippingContainerDetail;
import shipping_container_details_mgmt.model.master.ShippingContainerDetailPK;

@Repository("shippingContainerDetailsReadRepo")
public interface ShippingContainerDetailsRead_Repo extends JpaRepository<ShippingContainerDetail, ShippingContainerDetailPK> 
{

	@Query(value = "select * from Shipping_Container_Details where sc_SEQ_NO in :ids ORDER BY sc_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingContainerDetail> getSelectShippingContainerDetailsBySchedules(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Shipping_Container_Details where consignment_SEQ_NO in :cids ORDER BY sc_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingContainerDetail> getSelectShippingContainerDetailsForConsignments(@Param("cids") CopyOnWriteArrayList<Long> cids);
		
}
package shipping_container_master_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_container_master_mgmt.model.master.ShippingContainerMaster;

@Repository("shippingContainerMasterReadRepo")
public interface ShippingContainerMasterRead_Repo extends JpaRepository<ShippingContainerMaster, Long> 
{
	@Query(value = "select * from Shipping_Container_MASTER where sc_SEQ_NO in :ids ORDER BY sc_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingContainerMaster> getSelectShippingContainerMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Shipping_Container_MASTER where asset_SEQ_NO in :cids ORDER BY sc_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingContainerMaster> getSelectShippingContainerMastersForContainers(@Param("cids") CopyOnWriteArrayList<Long> cids);

	@Query(value = "SELECT * from  Shipping_Container_MASTER where upper(trim(asset_id)) in :aids ORDER BY sc_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingContainerMaster> getSelectShippingContainerMastersByContainerIds(@Param("aids") CopyOnWriteArrayList<String> aids);
	
}
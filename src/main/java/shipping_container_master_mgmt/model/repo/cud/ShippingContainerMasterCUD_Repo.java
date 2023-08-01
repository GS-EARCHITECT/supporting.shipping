package shipping_container_master_mgmt.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_container_master_mgmt.model.master.ShippingContainerMaster;

@Repository("shippingContainerMasterCUDRepo")
public interface ShippingContainerMasterCUD_Repo extends JpaRepository<ShippingContainerMaster, Long> 
{

	@Query(value = "delete from Shipping_Container_MASTER where sc_SEQ_NO in :ids", nativeQuery = true)
	void delSelectShippingContainerMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "delete from  Shipping_Container_MASTER where asset_SEQ_NO in :cids", nativeQuery = true)
	void delSelectShippingContainerMastersForContainers(@Param("cids") CopyOnWriteArrayList<Long> cids);

	@Query(value = "delete from  Shipping_Container_MASTER where upper(trim(asset_id)) in :aids", nativeQuery = true)
	void delSelectShippingContainerMastersByContainerIds(@Param("aids") CopyOnWriteArrayList<String> aids);
	
}
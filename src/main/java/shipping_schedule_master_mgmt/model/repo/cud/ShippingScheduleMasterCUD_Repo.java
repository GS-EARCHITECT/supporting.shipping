package shipping_schedule_master_mgmt.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_schedule_master_mgmt.model.master.ShippingScheduleMaster;

@Repository("shippingScheduleMasterCUDRepo")
public interface ShippingScheduleMasterCUD_Repo extends JpaRepository<ShippingScheduleMaster, Long> 
{
	@Query(value = "delete from Shipping_Schedule_MASTER where schedule_SEQ_NO in :ids", nativeQuery = true)
	void delSelectShippingScheduleMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
}
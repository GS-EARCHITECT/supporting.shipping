package shipping_schedule_master_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_schedule_master_mgmt.model.master.ShippingScheduleMaster;

@Repository("scheduleScheduleMasterReadRepo")
public interface ShippingScheduleMasterRead_Repo extends JpaRepository<ShippingScheduleMaster, Long> 
{
	@Query(value = "select * from Shipping_Schedule_MASTER where schedule_SEQ_NO in :ids ORDER BY schedule_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingScheduleMaster> getSelectShippingScheduleMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);
}
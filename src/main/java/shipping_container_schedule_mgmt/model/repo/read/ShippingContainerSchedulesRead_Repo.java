package shipping_container_schedule_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedule;
import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedulePK;

@Repository("shippingContainerSchedulesReadRepo")
public interface ShippingContainerSchedulesRead_Repo extends JpaRepository<ShippingContainerSchedule, ShippingContainerSchedulePK> 
{
	@Query(value = "select * from Shipping_Container_Schedules where schedule_SEQ_NO in :ids ORDER BY sc_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingContainerSchedule> getSelectShippingContainerSchedulesBySchedules(@Param("ids") CopyOnWriteArrayList<Long> ids);
}
package shipping_container_schedule_mgmt.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedule;
import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedulePK;

@Repository("shippingContainerSchedulesCUDRepo")
public interface ShippingContainerSchedulesCUD_Repo extends JpaRepository<ShippingContainerSchedule, ShippingContainerSchedulePK> 
{
	@Query(value = "delete from Shipping_Container_Schedules where schedule_SEQ_NO in :ids ", nativeQuery = true)
	void delSelectShippingContainerSchedulesBySchedules(@Param("ids") CopyOnWriteArrayList<Long> ids);
}
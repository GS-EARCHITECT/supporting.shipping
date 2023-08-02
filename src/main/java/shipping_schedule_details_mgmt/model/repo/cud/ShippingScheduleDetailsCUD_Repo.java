package shipping_schedule_details_mgmt.model.repo.cud;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetail;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetailPK;

@Repository("shippingScheduleDetailsCUDRepo")
public interface ShippingScheduleDetailsCUD_Repo extends JpaRepository<ShippingScheduleDetail, ShippingScheduleDetailPK> 
{

	@Query(value = "delete from Shipping_Schedule_Details where schedule_SEQ_NO in :ids ", nativeQuery = true)
	void delSelectShippingScheduleDetailsBySchedules(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Shipping_Schedule_Details where carrier_SEQ_NO in :cids ", nativeQuery = true)
	void delSelectShippingScheduleDetailsByCarriers(@Param("cids") CopyOnWriteArrayList<Long> cids);
		
	@Query(value = "SELECT * from  Shipping_Schedule_Details where FR_LOCATION_SEQ_NO in :fids ", nativeQuery = true)
	void delSelectShippingScheduleDetailsByLocFrom(@Param("fids") CopyOnWriteArrayList<Long> fids);

	@Query(value = "SELECT * from  Shipping_Schedule_Details where TO_LOCATION_SEQ_NO in :tids ", nativeQuery = true)
	void delSelectShippingScheduleDetailsByLocTo(@Param("fids") CopyOnWriteArrayList<Long> tids);

	@Query(value = "SELECT * FROM Shipping_MASTER where (ETD <= :frDtTm and ETA >= :toDtTm) ",nativeQuery = true)
	void delShippingScheduleDetailsBetweenETimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
		
	@Query(value = "SELECT * FROM Shipping_MASTER where (ATD <= :frDtTm and ATA >= :toDtTm)",nativeQuery = true)
	void delShippingScheduleDetailsBetweenATimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
}
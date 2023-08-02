package shipping_schedule_details_mgmt.model.repo.read;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetail;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetailPK;

@Repository("shippingScheduleDetailsReadRepo")
public interface ShippingScheduleDetailsRead_Repo extends JpaRepository<ShippingScheduleDetail, ShippingScheduleDetailPK> 
{

	@Query(value = "select * from Shipping_Schedule_Details where schedule_SEQ_NO in :ids ORDER BY schedule_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingScheduleDetail> getSelectShippingScheduleDetailsBySchedules(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Shipping_Schedule_Details where carrier_SEQ_NO in :cids ORDER BY schedule_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingScheduleDetail> getSelectShippingScheduleDetailsByCarriers(@Param("cids") CopyOnWriteArrayList<Long> cids);
		
	@Query(value = "SELECT * from  Shipping_Schedule_Details where FR_LOCATION_SEQ_NO in :fids ORDER BY schedule_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingScheduleDetail> getSelectShippingScheduleDetailsByLocFrom(@Param("fids") CopyOnWriteArrayList<Long> fids);

	@Query(value = "SELECT * from  Shipping_Schedule_Details where TO_LOCATION_SEQ_NO in :tids ORDER BY schedule_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingScheduleDetail> getSelectShippingScheduleDetailsByLocTo(@Param("fids") CopyOnWriteArrayList<Long> tids);

	@Query(value = "SELECT * FROM Shipping_MASTER where (ETD <= :frDtTm and ETA >= :toDtTm) ORDER BY shipping_sEQ_NO",nativeQuery = true)
	CopyOnWriteArrayList<ShippingScheduleDetail> getShippingScheduleDetailsBetweenETimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
		
	@Query(value = "SELECT * FROM Shipping_MASTER where (ATD <= :frDtTm and ATA >= :toDtTm) ORDER BY shipping_sEQ_NO",nativeQuery = true)
	CopyOnWriteArrayList<ShippingScheduleDetail> getShippingScheduleDetailsBetweenATimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);

}

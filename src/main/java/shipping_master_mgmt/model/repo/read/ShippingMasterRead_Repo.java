package shipping_master_mgmt.model.repo.read;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_master_mgmt.model.master.ShippingMaster;

@Repository("shippingMasterReadRepo")
public interface ShippingMasterRead_Repo extends JpaRepository<ShippingMaster, Long> 
{

	@Query(value = "select * from Shipping_MASTER where shipping_SEQ_NO in :ids ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Shipping_MASTER where fromparty_SEQ_NO in :pids ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMastersForPartiesFrom(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  Shipping_MASTER where toparty_SEQ_NO in :pids ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMastersForPartiesTo(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(shipping_id)) in :sids ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMastersByShippingIds(@Param("sids") CopyOnWriteArrayList<String> sids);
	
	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(doneflag)) <> 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMastersPending();
	
	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(doneflag)) = 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMastersDelivered();
	
	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(okflag)) <> 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMastersCanBeProcessed();
		
	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(okflag)) = 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMastersCannotBeProcessed();
		
	@Query(value = "SELECT * FROM Shipping_MASTER where (ETD <= :frDtTm and ETA >= :toDtTm) ORDER BY shipping_sEQ_NO",nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectWorksBetweenETimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
		
	@Query(value = "SELECT * FROM Shipping_MASTER where (ATD <= :frDtTm and ATA >= :toDtTm) ORDER BY shipping_sEQ_NO",nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectWorksBetweenATimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(inflag)) = 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMastersComingIn();

	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(inflag)) <> 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ShippingMaster> getSelectShippingMastersGoingOut();
}
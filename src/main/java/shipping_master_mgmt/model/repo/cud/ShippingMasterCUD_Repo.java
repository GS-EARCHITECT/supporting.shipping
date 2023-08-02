package shipping_master_mgmt.model.repo.cud;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_master_mgmt.model.master.ShippingMaster;

@Repository("shippingMasterCUDRepo")
public interface ShippingMasterCUD_Repo extends JpaRepository<ShippingMaster, Long> 
{

	@Query(value = "delete from Shipping_MASTER where shipping_SEQ_NO in :ids ", nativeQuery = true)
	void delSelectShippingMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Shipping_MASTER where fromparty_SEQ_NO in :pids ", nativeQuery = true)
	void delSelectShippingMastersForPartiesFrom(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  Shipping_MASTER where toparty_SEQ_NO in :pids ", nativeQuery = true)
	void delSelectShippingMastersForPartiesTo(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(shipping_id)) in :sids ", nativeQuery = true)
	void delSelectShippingMastersByShippingIds(@Param("sids") CopyOnWriteArrayList<String> sids);
	
	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(okflag)) <> 'Y' ", nativeQuery = true)
	void delSelectShippingMastersPending();
	
	@Query(value = "SELECT * from  Shipping_MASTER where upper(trim(okflag)) = 'Y' ", nativeQuery = true)
	void delSelectShippingMastersDelivered();
	
	@Query(value = "SELECT * FROM Shipping_MASTER where (ETD <= :frDtTm and ETA >= :toDtTm) ORDER BY shipping_sEQ_NO",nativeQuery = true)
	void delSelectWorksBetweenETimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
		
	@Query(value = "SELECT * FROM Shipping_MASTER where (ATD <= :frDtTm and ATA >= :toDtTm) ORDER BY shipping_sEQ_NO",nativeQuery = true)
	void delSelectWorksBetweenATimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Modifying
	@Query(value = "update Shipping_Master set doneflag = 'Y' where shipping_seq_no = :id", nativeQuery = true)
	void updShippingMasterDone(@Param("scid") Long id);
	
	@Modifying
	@Query(value = "update Shipping_Master set doneflag = :st where shipping_seq_no = :id", nativeQuery = true)
	void updShippingMasterDoneStatus(@Param("id") Long id, @Param("st") Character st);
		
	@Modifying
	@Query(value = "update Shipping_Master set okflag = 'Y' where shipping_seq_no = :id", nativeQuery = true)
	void updShippingMasterOk(@Param("id") Long id);
	
	@Modifying
	@Query(value = "update Shipping_Master set okflag = :st where shipping_seq_no = :id", nativeQuery = true)
	void updShippingMasterOkStatus(@Param("scid") Long scid, @Param("st") Character st);
	
}
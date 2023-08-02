package shipping_container_details_mgmt.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shipping_container_details_mgmt.model.master.ShippingContainerDetail;
import shipping_container_details_mgmt.model.master.ShippingContainerDetailPK;

@Repository("shippingContainerDetailsCUDRepo")
public interface ShippingContainerDetailsCUD_Repo extends JpaRepository<ShippingContainerDetail, ShippingContainerDetailPK> 
{

	@Query(value = "update Shipping_Container_Details set okflag= 'Y' where (sc_SEQ_NO = id and consignment_SEQ_NO = :cid)", nativeQuery = true)
	void updShippingConsignmentStatus(@Param("id") Long id, @Param("cid") Long cid);
	
	@Query(value = "delete from Shipping_Container_Details where sc_SEQ_NO in :ids", nativeQuery = true)
	void delSelectShippingContainerDetailsBySchedules(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "delete from  Shipping_Container_Details where consignment_SEQ_NO in :cids", nativeQuery = true)
	void delSelectShippingContainerDetailsForConsignments(@Param("cids") CopyOnWriteArrayList<Long> cids);

	@Modifying
	@Query(value = "update Shipping_Container_Details set doneflag = 'Y' where (sc_seq_no= :scid and consignment_SEQ_NO = :cid)", nativeQuery = true)
	void updShippingContainerDetailDone(@Param("scid") Long scid, @Param("cid") Long cid);
	
	@Modifying
	@Query(value = "update Shipping_Container_Details set doneflag = :st where (sc_seq_no= :scid and consignment_SEQ_NO = :cid)", nativeQuery = true)
	void updShippingContainerDetailDoneStatus(@Param("scid") Long scid, @Param("cid") Long cid, @Param("st") Character st);
		
	@Modifying
	@Query(value = "update Shipping_Container_Details set okflag = 'Y' where (sc_seq_no= :scid and consignment_SEQ_NO = :cid)", nativeQuery = true)
	void updShippingContainerDetailOk(@Param("scid") Long scid, @Param("cid") Long cid);
	
	@Modifying
	@Query(value = "update Shipping_Container_Details set okflag = :st where (sc_seq_no= :scid and consignment_SEQ_NO = :cid)", nativeQuery = true)
	void updShippingContainerDetailOkStatus(@Param("scid") Long scid, @Param("cid") Long cid, @Param("st") Character st);
}
package shipping_container_details_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shipping_container_details_mgmt.model.dto.ShippingContainerDetail_DTO;
import shipping_container_details_mgmt.model.master.ShippingContainerDetail;
import shipping_container_details_mgmt.model.master.ShippingContainerDetailPK;
import shipping_container_details_mgmt.model.repo.cud.ShippingContainerDetailsCUD_Repo;

@Service("shippingContainerDetailsCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingContainerDetailsCUD_Service implements I_ShippingContainerDetailsCUD_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ShippingContainerDetailService.class);

	@Autowired
	private ShippingContainerDetailsCUD_Repo shippingContainerDetailsCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<ShippingContainerDetail_DTO> newShippingContainerDetail(
			ShippingContainerDetail_DTO shippingContainerDetail_DTO) {
		CompletableFuture<ShippingContainerDetail_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			ShippingContainerDetail_DTO jcmDTO = null;
			ShippingContainerDetailPK shippingContainerDetailPK = new ShippingContainerDetailPK();
			shippingContainerDetailPK.setConsignmentSeqNo(shippingContainerDetail_DTO.getConsignmentSeqNo());
			shippingContainerDetailPK.setScSeqNo(shippingContainerDetail_DTO.getScSeqNo());
			if (!shippingContainerDetailsCUDRepo.existsById(shippingContainerDetailPK)) 
			{
				jcmDTO = this.getShippingContainerDetail_DTO(
						shippingContainerDetailsCUDRepo.save(this.setShippingContainerDetail_DTO(shippingContainerDetail_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updShippingContainerDetail(ShippingContainerDetail_DTO shippingContainerDetail_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			ShippingContainerDetail_DTO jcmDTO = null;
			ShippingContainerDetailPK shippingContainerDetailPK = new ShippingContainerDetailPK();
			shippingContainerDetailPK.setConsignmentSeqNo(shippingContainerDetail_DTO.getConsignmentSeqNo());
			shippingContainerDetailPK.setScSeqNo(shippingContainerDetail_DTO.getScSeqNo());

			if (shippingContainerDetailsCUDRepo.existsById(shippingContainerDetailPK)) 
			{
				shippingContainerDetailsCUDRepo.save(this.setShippingContainerDetail_DTO(shippingContainerDetail_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingContainerDetails(CopyOnWriteArrayList<ShippingContainerDetailPK> shippingContainerDetailPKs)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerDetailsCUDRepo.deleteAllById(shippingContainerDetailPKs);;
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingContainerDetailsBySchedules(CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerDetailsCUDRepo.delSelectShippingContainerDetailsBySchedules(ids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingContainerDetailsForConsignments(CopyOnWriteArrayList<Long> cids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerDetailsCUDRepo.delSelectShippingContainerDetailsForConsignments(cids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delAllShippingContainerDetails() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerDetailsCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	private synchronized ShippingContainerDetail_DTO getShippingContainerDetail_DTO(
			ShippingContainerDetail shippingContainerDetail2) {
		ShippingContainerDetail_DTO shippingContainerDetailDTO = new ShippingContainerDetail_DTO();
		shippingContainerDetailDTO.setConsignmentSeqNo(shippingContainerDetail2.getId().getConsignmentSeqNo());
		shippingContainerDetailDTO.setScSeqNo(shippingContainerDetail2.getId().getScSeqNo());
		return shippingContainerDetailDTO;
	}

	private synchronized ShippingContainerDetail setShippingContainerDetail_DTO(ShippingContainerDetail_DTO shippingContainerDetailDTO) 
	{
		ShippingContainerDetail shippingContainerDetail = new ShippingContainerDetail();
		ShippingContainerDetail_DTO jcmDTO = null;
		ShippingContainerDetailPK shippingContainerDetailPK = new ShippingContainerDetailPK();
		shippingContainerDetailPK.setConsignmentSeqNo(shippingContainerDetailDTO.getConsignmentSeqNo());
		shippingContainerDetailPK.setScSeqNo(shippingContainerDetailDTO.getScSeqNo()); 
		shippingContainerDetail.setId(shippingContainerDetailPK);
		return shippingContainerDetail;
	}

}
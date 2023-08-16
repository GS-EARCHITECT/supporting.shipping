package shipping_container_details_mgmt.services.read;

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
import shipping_container_details_mgmt.model.repo.read.ShippingContainerDetailsRead_Repo;

@Service("shippingContainerDetailsReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingContainerDetailsRead_Service implements I_ShippingContainerDetailsRead_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ShippingContainerDetailService.class);

	@Autowired
	private ShippingContainerDetailsRead_Repo shippingContainerDetailsReadRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getAllShippingContainerDetails() 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerDetail> shippingList = (CopyOnWriteArrayList<ShippingContainerDetail>) shippingContainerDetailsReadRepo.findAll();
					CopyOnWriteArrayList<ShippingContainerDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetails(
			CopyOnWriteArrayList<ShippingContainerDetailPK> shippingContainerDetailPKs) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerDetail> shippingList = (CopyOnWriteArrayList<ShippingContainerDetail>) shippingContainerDetailsReadRepo
							.findAllById(shippingContainerDetailPKs);
					CopyOnWriteArrayList<ShippingContainerDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsBySchedules(
			CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerDetail> shippingList = (CopyOnWriteArrayList<ShippingContainerDetail>) shippingContainerDetailsReadRepo
							.getSelectShippingContainerDetailsBySchedules(ids);
					CopyOnWriteArrayList<ShippingContainerDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsForConsignments(
			CopyOnWriteArrayList<Long> cids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerDetail> shippingList = (CopyOnWriteArrayList<ShippingContainerDetail>) shippingContainerDetailsReadRepo
							.getSelectShippingContainerDetailsForConsignments(cids);
					CopyOnWriteArrayList<ShippingContainerDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerDetail> shippingList = (CopyOnWriteArrayList<ShippingContainerDetail>) shippingContainerDetailsReadRepo
							.getSelectShippingMastersPending();
					CopyOnWriteArrayList<ShippingContainerDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsDelivered() 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerDetail> shippingList = (CopyOnWriteArrayList<ShippingContainerDetail>) shippingContainerDetailsReadRepo
							.getSelectShippingContainerDetailsDelivered();
					CopyOnWriteArrayList<ShippingContainerDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsCanBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerDetail> shippingList = (CopyOnWriteArrayList<ShippingContainerDetail>) shippingContainerDetailsReadRepo
							.getSelectShippingContainerDetailsCanBeProcessed();
					CopyOnWriteArrayList<ShippingContainerDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> getSelectShippingContainerDetailsCannotBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerDetail> shippingList = (CopyOnWriteArrayList<ShippingContainerDetail>) shippingContainerDetailsReadRepo
							.getSelectShippingContainerDetailsCannotBeProcessed();
					CopyOnWriteArrayList<ShippingContainerDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	
	private synchronized CopyOnWriteArrayList<ShippingContainerDetail_DTO> getShippingContainerDetail_DTOs(
			CopyOnWriteArrayList<ShippingContainerDetail> shippingContainerDetails) {
		ShippingContainerDetail_DTO shippingDTO = null;
		CopyOnWriteArrayList<ShippingContainerDetail_DTO> shippingDTOs = new CopyOnWriteArrayList<ShippingContainerDetail_DTO>();

		for (int i = 0; i < shippingContainerDetails.size(); i++) {
			shippingDTO = getShippingContainerDetail_DTO(shippingContainerDetails.get(i));
			shippingDTOs.add(shippingDTO);
		}
		return shippingDTOs;
	}

	private synchronized ShippingContainerDetail_DTO getShippingContainerDetail_DTO(
			ShippingContainerDetail shippingContainerDetail2) {
		ShippingContainerDetail_DTO shippingContainerDetailDTO = new ShippingContainerDetail_DTO();
		shippingContainerDetailDTO.setConsignmentSeqNo(shippingContainerDetail2.getId().getConsignmentSeqNo());
		shippingContainerDetailDTO.setScSeqNo(shippingContainerDetail2.getId().getScSeqNo());
		return shippingContainerDetailDTO;
	}

}
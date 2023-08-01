package shipping_container_master_mgmt.services.cud;

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
import shipping_container_master_mgmt.model.dto.ShippingContainerMaster_DTO;
import shipping_container_master_mgmt.model.master.ShippingContainerMaster;
import shipping_container_master_mgmt.model.repo.cud.ShippingContainerMasterCUD_Repo;

@Service("shippingContainerMasterCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingContainerMasterCUD_Service implements I_ShippingContainerMasterCUD_Service 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ShippingContainerMasterService.class);

	@Autowired
	private ShippingContainerMasterCUD_Repo shippingContainerMasterCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<ShippingContainerMaster_DTO> newShippingContainerMaster(
			ShippingContainerMaster_DTO shippingContainerMaster_DTO) {
		CompletableFuture<ShippingContainerMaster_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			ShippingContainerMaster_DTO jcmDTO = null;
			if (!shippingContainerMasterCUDRepo.existsById(shippingContainerMaster_DTO.getShippingSeqNo())) 
			{
				jcmDTO = this.getShippingContainerMaster_DTO(
						shippingContainerMasterCUDRepo.save(this.setShippingContainerMaster_DTO(shippingContainerMaster_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updShippingContainerMaster(ShippingContainerMaster_DTO shippingContainerMaster_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			if (shippingContainerMasterCUDRepo.existsById(shippingContainerMaster_DTO.getShippingSeqNo())) 
			{
				shippingContainerMasterCUDRepo.save(this.setShippingContainerMaster_DTO(shippingContainerMaster_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingContainerMasters(CopyOnWriteArrayList<Long> jcmSeqNos) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerMasterCUDRepo.delSelectShippingContainerMasters(jcmSeqNos);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingContainerMastersForContainers(CopyOnWriteArrayList<Long> cids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerMasterCUDRepo.delSelectShippingContainerMastersForContainers(cids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingContainerMastersByContainerIds(CopyOnWriteArrayList<String> cids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerMasterCUDRepo.delSelectShippingContainerMastersByContainerIds(cids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delAllShippingContainerMasters() 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerMasterCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	private synchronized ShippingContainerMaster_DTO getShippingContainerMaster_DTO(ShippingContainerMaster shippingContainerMaster2) 
	{
		ShippingContainerMaster_DTO shippingContainerMasterDTO = new ShippingContainerMaster_DTO();
		shippingContainerMasterDTO.setAssetId(shippingContainerMaster2.getAssetId());
		shippingContainerMasterDTO.setAssetSeqNo(shippingContainerMaster2.getAssetSeqNo());
		shippingContainerMasterDTO.setScSeqNo(shippingContainerMaster2.getScSeqNo());
		shippingContainerMasterDTO.setShippingSeqNo(shippingContainerMaster2.getShippingSeqNo());				
		return shippingContainerMasterDTO;
	}

	private synchronized ShippingContainerMaster setShippingContainerMaster_DTO(ShippingContainerMaster_DTO shippingContainerMasterDTO) 
	{
		ShippingContainerMaster shippingContainerMaster = new ShippingContainerMaster();
		shippingContainerMaster.setAssetId(shippingContainerMasterDTO.getAssetId());
		shippingContainerMaster.setAssetSeqNo(shippingContainerMasterDTO.getAssetSeqNo());
		shippingContainerMaster.setShippingSeqNo(shippingContainerMasterDTO.getShippingSeqNo());				
		return shippingContainerMaster;
	}

}
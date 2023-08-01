package shipping_container_master_mgmt.services.read;

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
import shipping_container_master_mgmt.model.repo.read.ShippingContainerMasterRead_Repo;

@Service("shippingContainerMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingContainerMasterRead_Service implements I_ShippingContainerMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(ShippingContainerMasterService.class);

	@Autowired
	private ShippingContainerMasterRead_Repo shippingContainerMasterReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getAllShippingContainerMasters()  
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingContainerMaster> shippingList = (CopyOnWriteArrayList<ShippingContainerMaster>) shippingContainerMasterReadRepo.findAll();
		CopyOnWriteArrayList<ShippingContainerMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingContainerMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getSelectShippingContainerMasters(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingContainerMaster> shippingList = (CopyOnWriteArrayList<ShippingContainerMaster>) shippingContainerMasterReadRepo.getSelectShippingContainerMasters(jcmSeqNos);
		CopyOnWriteArrayList<ShippingContainerMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingContainerMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getSelectShippingContainerMastersForContainers(CopyOnWriteArrayList<Long> cids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingContainerMaster> shippingList = (CopyOnWriteArrayList<ShippingContainerMaster>) shippingContainerMasterReadRepo.getSelectShippingContainerMastersForContainers(cids);
		CopyOnWriteArrayList<ShippingContainerMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingContainerMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> getSelectShippingContainerMastersByContainerIds(CopyOnWriteArrayList<String> cids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingContainerMaster> shippingList = (CopyOnWriteArrayList<ShippingContainerMaster>) shippingContainerMasterReadRepo.getSelectShippingContainerMastersByContainerIds(cids);
		CopyOnWriteArrayList<ShippingContainerMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingContainerMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
		
	private synchronized CopyOnWriteArrayList<ShippingContainerMaster_DTO> getShippingContainerMaster_DTOs(CopyOnWriteArrayList<ShippingContainerMaster> shippingContainerMasters) {
		ShippingContainerMaster_DTO shippingDTO = null;
		CopyOnWriteArrayList<ShippingContainerMaster_DTO> shippingDTOs = new CopyOnWriteArrayList<ShippingContainerMaster_DTO>();

		for (int i = 0; i < shippingContainerMasters.size(); i++) {
			shippingDTO = getShippingContainerMaster_DTO(shippingContainerMasters.get(i));
			shippingDTOs.add(shippingDTO);
		}
		return shippingDTOs;
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

}
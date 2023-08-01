package shipping_schedule_master_mgmt.services.read;

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
import shipping_schedule_master_mgmt.model.dto.ShippingScheduleMaster_DTO;
import shipping_schedule_master_mgmt.model.master.ShippingScheduleMaster;
import shipping_schedule_master_mgmt.model.repo.read.ShippingScheduleMasterRead_Repo;

@Service("shippingScheduleMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingScheduleMasterRead_Service implements I_ShippingScheduleMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(ShippingScheduleMasterService.class);

	@Autowired
	private ShippingScheduleMasterRead_Repo shippingScheduleMasterReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> getAllShippingScheduleMasters()  
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingScheduleMaster> shippingList = (CopyOnWriteArrayList<ShippingScheduleMaster>) shippingScheduleMasterReadRepo.findAll();
		CopyOnWriteArrayList<ShippingScheduleMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingScheduleMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> getSelectShippingScheduleMasters(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingScheduleMaster> shippingList = (CopyOnWriteArrayList<ShippingScheduleMaster>) shippingScheduleMasterReadRepo.getSelectShippingScheduleMasters(jcmSeqNos);
		CopyOnWriteArrayList<ShippingScheduleMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingScheduleMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	private synchronized CopyOnWriteArrayList<ShippingScheduleMaster_DTO> getShippingScheduleMaster_DTOs(CopyOnWriteArrayList<ShippingScheduleMaster> shippingScheduleMasters) {
		ShippingScheduleMaster_DTO shippingDTO = null;
		CopyOnWriteArrayList<ShippingScheduleMaster_DTO> shippingDTOs = new CopyOnWriteArrayList<ShippingScheduleMaster_DTO>();

		for (int i = 0; i < shippingScheduleMasters.size(); i++) {
			shippingDTO = getShippingScheduleMaster_DTO(shippingScheduleMasters.get(i));
			shippingDTOs.add(shippingDTO);
		}
		return shippingDTOs;
	}

	private synchronized ShippingScheduleMaster_DTO getShippingScheduleMaster_DTO(ShippingScheduleMaster shippingScheduleMaster2) 
	{
		ShippingScheduleMaster_DTO shippingScheduleMasterDTO = new ShippingScheduleMaster_DTO();
		shippingScheduleMasterDTO.setScheduleSeqNo(shippingScheduleMaster2.getScheduleSeqNo());
		shippingScheduleMasterDTO.setTripTemplateSeqNo(shippingScheduleMaster2.getTripTemplateSeqNo());
		return shippingScheduleMasterDTO;
	}

}
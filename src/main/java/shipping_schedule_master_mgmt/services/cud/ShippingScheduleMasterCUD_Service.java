package shipping_schedule_master_mgmt.services.cud;

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
import shipping_schedule_master_mgmt.model.repo.cud.ShippingScheduleMasterCUD_Repo;

@Service("shippingScheduleMasterCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingScheduleMasterCUD_Service implements I_ShippingScheduleMasterCUD_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ShippingScheduleMasterService.class);

	@Autowired
	private ShippingScheduleMasterCUD_Repo shippingScheduleMasterCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<ShippingScheduleMaster_DTO> newShippingScheduleMaster(
			ShippingScheduleMaster_DTO shippingScheduleMaster_DTO) {
		CompletableFuture<ShippingScheduleMaster_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			ShippingScheduleMaster_DTO jcmDTO = null;
			if (!shippingScheduleMasterCUDRepo.existsById(shippingScheduleMaster_DTO.getScheduleSeqNo())) 
			{
				jcmDTO = this.getShippingScheduleMaster_DTO(
						shippingScheduleMasterCUDRepo.save(this.setShippingScheduleMaster_DTO(shippingScheduleMaster_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updShippingScheduleMaster(ShippingScheduleMaster_DTO shippingScheduleMaster_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			if (shippingScheduleMasterCUDRepo.existsById(shippingScheduleMaster_DTO.getScheduleSeqNo())) 
			{
				shippingScheduleMasterCUDRepo.save(this.setShippingScheduleMaster_DTO(shippingScheduleMaster_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingScheduleMasters(CopyOnWriteArrayList<Long> jcmSeqNos) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingScheduleMasterCUDRepo.delSelectShippingScheduleMasters(jcmSeqNos);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delAllShippingScheduleMasters() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingScheduleMasterCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	private synchronized ShippingScheduleMaster_DTO getShippingScheduleMaster_DTO(ShippingScheduleMaster shippingScheduleMaster2) 
	{
		ShippingScheduleMaster_DTO shippingScheduleMasterDTO = new ShippingScheduleMaster_DTO();
		shippingScheduleMasterDTO.setScheduleSeqNo(shippingScheduleMaster2.getScheduleSeqNo());
		shippingScheduleMasterDTO.setTripTemplateSeqNo(shippingScheduleMaster2.getTripTemplateSeqNo());
		return shippingScheduleMasterDTO;
	}

	private synchronized ShippingScheduleMaster setShippingScheduleMaster_DTO(ShippingScheduleMaster_DTO shippingScheduleMasterDTO) {
		ShippingScheduleMaster shippingScheduleMaster = new ShippingScheduleMaster();
		shippingScheduleMaster.setScheduleSeqNo(shippingScheduleMasterDTO.getScheduleSeqNo());
		shippingScheduleMaster.setTripTemplateSeqNo(shippingScheduleMasterDTO.getTripTemplateSeqNo());
		return shippingScheduleMaster;
	}

}
package shipping_container_schedule_mgmt.services.cud;

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
import shipping_container_schedule_mgmt.model.dto.ShippingContainerSchedule_DTO;
import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedule;
import shipping_container_schedule_mgmt.model.master.ShippingContainerSchedulePK;
import shipping_container_schedule_mgmt.model.repo.cud.ShippingContainerSchedulesCUD_Repo;

@Service("shippingContainerSchedulesCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingContainerSchedulesCUD_Service implements I_ShippingContainerSchedulesCUD_Service 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ShippingContainerScheduleService.class);

	@Autowired
	private ShippingContainerSchedulesCUD_Repo shippingContainerSchedulesCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<ShippingContainerSchedule_DTO> newShippingContainerSchedule(ShippingContainerSchedule_DTO shippingContainerSchedule_DTO) 
	{
		CompletableFuture<ShippingContainerSchedule_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			ShippingContainerSchedule_DTO jcmDTO = null;
			ShippingContainerSchedulePK shippingContainerSchedulePK = new ShippingContainerSchedulePK();
			shippingContainerSchedulePK.setScheduleSeqNo(shippingContainerSchedule_DTO.getScheduleSeqNo());
			shippingContainerSchedulePK.setScSeqNo(shippingContainerSchedule_DTO.getScSeqNo());
			if (!shippingContainerSchedulesCUDRepo.existsById(shippingContainerSchedulePK)) 
			{
				jcmDTO = this.getShippingContainerSchedule_DTO(
						shippingContainerSchedulesCUDRepo.save(this.setShippingContainerSchedule_DTO(shippingContainerSchedule_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updShippingContainerSchedule(ShippingContainerSchedule_DTO shippingContainerSchedule_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			ShippingContainerSchedule_DTO jcmDTO = null;
			ShippingContainerSchedulePK shippingContainerSchedulePK = new ShippingContainerSchedulePK();
			shippingContainerSchedulePK.setScheduleSeqNo(shippingContainerSchedule_DTO.getScheduleSeqNo());
			shippingContainerSchedulePK.setScSeqNo(shippingContainerSchedule_DTO.getScSeqNo());

			if (shippingContainerSchedulesCUDRepo.existsById(shippingContainerSchedulePK)) 
			{
				shippingContainerSchedulesCUDRepo.save(this.setShippingContainerSchedule_DTO(shippingContainerSchedule_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingContainerSchedules(CopyOnWriteArrayList<ShippingContainerSchedulePK> shippingContainerSchedulePKs)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerSchedulesCUDRepo.deleteAllById(shippingContainerSchedulePKs);;
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingContainerSchedulesBySchedules(CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerSchedulesCUDRepo.delSelectShippingContainerSchedulesBySchedules(ids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delAllShippingContainerSchedules() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingContainerSchedulesCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	private synchronized ShippingContainerSchedule_DTO getShippingContainerSchedule_DTO(
			ShippingContainerSchedule shippingContainerSchedule2) {
		ShippingContainerSchedule_DTO shippingContainerScheduleDTO = new ShippingContainerSchedule_DTO();
		shippingContainerScheduleDTO.setScheduleSeqNo(shippingContainerSchedule2.getId().getScheduleSeqNo());
		shippingContainerScheduleDTO.setScSeqNo(shippingContainerSchedule2.getId().getScSeqNo());
		return shippingContainerScheduleDTO;
	}

	private synchronized ShippingContainerSchedule setShippingContainerSchedule_DTO(ShippingContainerSchedule_DTO shippingContainerScheduleDTO) 
	{
		ShippingContainerSchedule shippingContainerSchedule = new ShippingContainerSchedule();
		ShippingContainerSchedule_DTO jcmDTO = null;
		ShippingContainerSchedulePK shippingContainerSchedulePK = new ShippingContainerSchedulePK();
		shippingContainerSchedulePK.setScheduleSeqNo(shippingContainerScheduleDTO.getScheduleSeqNo());
		shippingContainerSchedulePK.setScSeqNo(shippingContainerScheduleDTO.getScSeqNo()); 
		shippingContainerSchedule.setId(shippingContainerSchedulePK);
		return shippingContainerSchedule;
	}

}
package shipping_container_schedule_mgmt.services.read;

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
import shipping_container_schedule_mgmt.model.repo.read.ShippingContainerSchedulesRead_Repo;

@Service("shippingContainerSchedulesReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingContainerSchedulesRead_Service implements I_ShippingContainerSchedulesRead_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ShippingContainerScheduleService.class);

	@Autowired
	private ShippingContainerSchedulesRead_Repo shippingContainerScheduleReadRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> getAllShippingContainerSchedules() {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerSchedule> shippingList = (CopyOnWriteArrayList<ShippingContainerSchedule>) shippingContainerScheduleReadRepo
							.findAll();
					CopyOnWriteArrayList<ShippingContainerSchedule_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerSchedule_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerSchedule_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> getSelectShippingContainerSchedules(CopyOnWriteArrayList<ShippingContainerSchedulePK> shippingContainerSchedulePKs) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerSchedule> shippingList = (CopyOnWriteArrayList<ShippingContainerSchedule>) shippingContainerScheduleReadRepo
							.findAllById(shippingContainerSchedulePKs);
					CopyOnWriteArrayList<ShippingContainerSchedule_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerSchedule_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerSchedule_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> getSelectShippingContainerSchedulesBySchedules(
			CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingContainerSchedule_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingContainerSchedule> shippingList = (CopyOnWriteArrayList<ShippingContainerSchedule>) shippingContainerScheduleReadRepo
							.getSelectShippingContainerSchedulesBySchedules(ids);
					CopyOnWriteArrayList<ShippingContainerSchedule_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingContainerSchedule_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingContainerSchedule_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}
	
	private synchronized CopyOnWriteArrayList<ShippingContainerSchedule_DTO> getShippingContainerSchedule_DTOs(
			CopyOnWriteArrayList<ShippingContainerSchedule> shippingContainerSchedules) {
		ShippingContainerSchedule_DTO shippingDTO = null;
		CopyOnWriteArrayList<ShippingContainerSchedule_DTO> shippingDTOs = new CopyOnWriteArrayList<ShippingContainerSchedule_DTO>();

		for (int i = 0; i < shippingContainerSchedules.size(); i++) {
			shippingDTO = getShippingContainerSchedule_DTO(shippingContainerSchedules.get(i));
			shippingDTOs.add(shippingDTO);
		}
		return shippingDTOs;
	}

	private synchronized ShippingContainerSchedule_DTO getShippingContainerSchedule_DTO(
			ShippingContainerSchedule shippingContainerSchedule2) {
		ShippingContainerSchedule_DTO shippingContainerScheduleDTO = new ShippingContainerSchedule_DTO();
		shippingContainerScheduleDTO.setScheduleSeqNo(shippingContainerSchedule2.getId().getScheduleSeqNo());
		shippingContainerScheduleDTO.setScSeqNo(shippingContainerSchedule2.getId().getScSeqNo());
		return shippingContainerScheduleDTO;
	}

}
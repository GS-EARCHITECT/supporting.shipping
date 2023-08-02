package shipping_schedule_details_mgmt.services.read;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import shipping_schedule_details_mgmt.model.dto.ShippingScheduleDetail_DTO;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetail;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetailPK;
import shipping_schedule_details_mgmt.model.repo.read.ShippingScheduleDetailsRead_Repo;

@Service("shippingScheduleDetailsReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingScheduleDetailsRead_Service implements I_ShippingScheduleDetailsRead_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ShippingScheduleDetailService.class);

	@Autowired
	private ShippingScheduleDetailsRead_Repo shippingScheduleDetailsReadRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getAllShippingScheduleDetails() {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingScheduleDetail> shippingList = (CopyOnWriteArrayList<ShippingScheduleDetail>) shippingScheduleDetailsReadRepo
							.findAll();
					CopyOnWriteArrayList<ShippingScheduleDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingScheduleDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetails(CopyOnWriteArrayList<ShippingScheduleDetailPK> shippingScheduleDetailPKs) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingScheduleDetail> shippingList = (CopyOnWriteArrayList<ShippingScheduleDetail>) shippingScheduleDetailsReadRepo
							.findAllById(shippingScheduleDetailPKs);
					CopyOnWriteArrayList<ShippingScheduleDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingScheduleDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsBySchedules(
			CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingScheduleDetail> shippingList = (CopyOnWriteArrayList<ShippingScheduleDetail>) shippingScheduleDetailsReadRepo
							.getSelectShippingScheduleDetailsBySchedules(ids);
					CopyOnWriteArrayList<ShippingScheduleDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingScheduleDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsByCarriers(CopyOnWriteArrayList<Long> cids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingScheduleDetail> shippingList = (CopyOnWriteArrayList<ShippingScheduleDetail>) shippingScheduleDetailsReadRepo
							.getSelectShippingScheduleDetailsByCarriers(cids);
					CopyOnWriteArrayList<ShippingScheduleDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingScheduleDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsByLocFrom(CopyOnWriteArrayList<Long> tids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingScheduleDetail> shippingList = (CopyOnWriteArrayList<ShippingScheduleDetail>) shippingScheduleDetailsReadRepo
							.getSelectShippingScheduleDetailsByLocFrom(tids);
					CopyOnWriteArrayList<ShippingScheduleDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingScheduleDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getSelectShippingScheduleDetailsByLocTo(CopyOnWriteArrayList<Long> tids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<ShippingScheduleDetail> shippingList = (CopyOnWriteArrayList<ShippingScheduleDetail>) shippingScheduleDetailsReadRepo
							.getSelectShippingScheduleDetailsByLocTo(tids);
					CopyOnWriteArrayList<ShippingScheduleDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingScheduleDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getShippingScheduleDetailsBetweenETimes(String frDtTm, String toDtTm) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
					LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
					Timestamp frTs = Timestamp.valueOf(frDTTm);
					Timestamp toTs = Timestamp.valueOf(toDTTm);

					CopyOnWriteArrayList<ShippingScheduleDetail> shippingList = (CopyOnWriteArrayList<ShippingScheduleDetail>) shippingScheduleDetailsReadRepo
							.getShippingScheduleDetailsBetweenETimes(frTs, toTs);
					CopyOnWriteArrayList<ShippingScheduleDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingScheduleDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> getShippingScheduleDetailsBetweenATimes(String frDtTm, String toDtTm) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingScheduleDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
					LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
					Timestamp frTs = Timestamp.valueOf(frDTTm);
					Timestamp toTs = Timestamp.valueOf(toDTTm);

					CopyOnWriteArrayList<ShippingScheduleDetail> shippingList = (CopyOnWriteArrayList<ShippingScheduleDetail>) shippingScheduleDetailsReadRepo
							.getShippingScheduleDetailsBetweenATimes(frTs, toTs);
					CopyOnWriteArrayList<ShippingScheduleDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingScheduleDetail_DTO>();
					jcmDTOs = shippingList != null ? this.getShippingScheduleDetail_DTOs(shippingList) : null;
					return jcmDTOs;
				}, asyncExecutor);

		return future;
	}

	
	private synchronized CopyOnWriteArrayList<ShippingScheduleDetail_DTO> getShippingScheduleDetail_DTOs(
			CopyOnWriteArrayList<ShippingScheduleDetail> shippingScheduleDetails) {
		ShippingScheduleDetail_DTO shippingDTO = null;
		CopyOnWriteArrayList<ShippingScheduleDetail_DTO> shippingDTOs = new CopyOnWriteArrayList<ShippingScheduleDetail_DTO>();

		for (int i = 0; i < shippingScheduleDetails.size(); i++) {
			shippingDTO = getShippingScheduleDetail_DTO(shippingScheduleDetails.get(i));
			shippingDTOs.add(shippingDTO);
		}
		return shippingDTOs;
	}

	private synchronized ShippingScheduleDetail_DTO getShippingScheduleDetail_DTO(
			ShippingScheduleDetail shippingScheduleDetail2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		ShippingScheduleDetail_DTO shippingScheduleDetailDTO = new ShippingScheduleDetail_DTO();
		shippingScheduleDetailDTO.setAta(formatter.format(shippingScheduleDetail2.getAta().toLocalDateTime()));
		shippingScheduleDetailDTO.setAtd(formatter.format(shippingScheduleDetail2.getAtd().toLocalDateTime()));
		shippingScheduleDetailDTO.setEta(formatter.format(shippingScheduleDetail2.getEta().toLocalDateTime()));
		shippingScheduleDetailDTO.setEtd(formatter.format(shippingScheduleDetail2.getEtd().toLocalDateTime()));
		shippingScheduleDetailDTO.setScheduleSeqNo(shippingScheduleDetail2.getId().getScheduleSeqNo());
		shippingScheduleDetailDTO.setCarrierAssetSeqNo(shippingScheduleDetail2.getId().getCarrierAssetSeqNo());
		shippingScheduleDetailDTO.setFrLocationSeqNo(shippingScheduleDetail2.getId().getFrLocationSeqNo());
		shippingScheduleDetailDTO.setToLocationSeqNo(shippingScheduleDetail2.getId().getToLocationSeqNo());		
		return shippingScheduleDetailDTO;
	}

}
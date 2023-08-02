package shipping_schedule_details_mgmt.services.cud;

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
import shipping_master_mgmt.model.master.ShippingMaster;
import shipping_schedule_details_mgmt.model.dto.ShippingScheduleDetail_DTO;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetail;
import shipping_schedule_details_mgmt.model.master.ShippingScheduleDetailPK;
import shipping_schedule_details_mgmt.model.repo.cud.ShippingScheduleDetailsCUD_Repo;

@Service("shippingScheduleDetailsCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingScheduleDetailsCUD_Service implements I_ShippingScheduleDetailsCUD_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ShippingScheduleDetailService.class);

	@Autowired
	private ShippingScheduleDetailsCUD_Repo shippingScheduleDetailsCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<ShippingScheduleDetail_DTO> newShippingScheduleDetail(
			ShippingScheduleDetail_DTO shippingScheduleDetail_DTO) {
		CompletableFuture<ShippingScheduleDetail_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			ShippingScheduleDetail_DTO jcmDTO = null;
			ShippingScheduleDetailPK shippingScheduleDetailPK = new ShippingScheduleDetailPK();
			shippingScheduleDetailPK.setCarrierAssetSeqNo(shippingScheduleDetail_DTO.getCarrierAssetSeqNo());
			shippingScheduleDetailPK.setFrLocationSeqNo(shippingScheduleDetail_DTO.getFrLocationSeqNo());
			shippingScheduleDetailPK.setScheduleSeqNo(shippingScheduleDetail_DTO.getScheduleSeqNo());
			shippingScheduleDetailPK.setToLocationSeqNo(shippingScheduleDetail_DTO.getToLocationSeqNo());
			
			if (!shippingScheduleDetailsCUDRepo.existsById(shippingScheduleDetailPK)) 
			{
				jcmDTO = this.getShippingScheduleDetail_DTO(
						shippingScheduleDetailsCUDRepo.save(this.setShippingScheduleDetail_DTO(shippingScheduleDetail_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updShippingScheduleDetail(ShippingScheduleDetail_DTO shippingScheduleDetail_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			ShippingScheduleDetail_DTO jcmDTO = null;
			ShippingScheduleDetailPK shippingScheduleDetailPK = new ShippingScheduleDetailPK();
			shippingScheduleDetailPK.setCarrierAssetSeqNo(shippingScheduleDetail_DTO.getCarrierAssetSeqNo());
			shippingScheduleDetailPK.setFrLocationSeqNo(shippingScheduleDetail_DTO.getFrLocationSeqNo());
			shippingScheduleDetailPK.setScheduleSeqNo(shippingScheduleDetail_DTO.getScheduleSeqNo());
			shippingScheduleDetailPK.setToLocationSeqNo(shippingScheduleDetail_DTO.getToLocationSeqNo());
	
			if (shippingScheduleDetailsCUDRepo.existsById(shippingScheduleDetailPK)) 
			{
				shippingScheduleDetailsCUDRepo.save(this.setShippingScheduleDetail_DTO(shippingScheduleDetail_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingScheduleDetails(CopyOnWriteArrayList<ShippingScheduleDetailPK> shippingScheduleDetailPKs)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingScheduleDetailsCUDRepo.deleteAllById(shippingScheduleDetailPKs);;
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingScheduleDetailsBySchedules(CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingScheduleDetailsCUDRepo.delSelectShippingScheduleDetailsBySchedules(ids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingScheduleDetailsByCarriers(CopyOnWriteArrayList<Long> cids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingScheduleDetailsCUDRepo.delSelectShippingScheduleDetailsByCarriers(cids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingScheduleDetailsByLocFrom(CopyOnWriteArrayList<Long> fids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingScheduleDetailsCUDRepo.delSelectShippingScheduleDetailsByLocFrom(fids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingScheduleDetailsByLocTo(CopyOnWriteArrayList<Long> tids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingScheduleDetailsCUDRepo.delSelectShippingScheduleDetailsByLocTo(tids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delShippingScheduleDetailsBetweenETimes(String frDtTm, String toDtTm)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
			LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
			Timestamp frTs = Timestamp.valueOf(frDTTm);
			Timestamp toTs = Timestamp.valueOf(toDTTm);
			shippingScheduleDetailsCUDRepo.delShippingScheduleDetailsBetweenETimes(frTs, toTs);
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> delShippingScheduleDetailsBetweenATimes(String frDtTm, String toDtTm)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
			LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
			Timestamp frTs = Timestamp.valueOf(frDTTm);
			Timestamp toTs = Timestamp.valueOf(toDTTm);
			shippingScheduleDetailsCUDRepo.delShippingScheduleDetailsBetweenATimes(frTs, toTs);
			return;
		}, asyncExecutor);
		return future;
	}

	
	@Override
	public CompletableFuture<Void> delAllShippingScheduleDetails() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingScheduleDetailsCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	private synchronized ShippingScheduleDetail_DTO getShippingScheduleDetail_DTO(
			ShippingScheduleDetail shippingScheduleDetail2) 
	{
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

	private synchronized ShippingScheduleDetail setShippingScheduleDetail_DTO(ShippingScheduleDetail_DTO shippingScheduleDetailDTO) 
	{
		ShippingScheduleDetail shippingScheduleDetail = new ShippingScheduleDetail();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime etd = LocalDateTime.parse(shippingScheduleDetailDTO.getEtd(), formatter);
		LocalDateTime eta = LocalDateTime.parse(shippingScheduleDetailDTO.getEta(), formatter);
		LocalDateTime atd = LocalDateTime.parse(shippingScheduleDetailDTO.getAtd(), formatter);
		LocalDateTime ata = LocalDateTime.parse(shippingScheduleDetailDTO.getAta(), formatter);
		Timestamp etds = Timestamp.valueOf(etd);		
		Timestamp etas = Timestamp.valueOf(eta);
		Timestamp atds = Timestamp.valueOf(atd);		
		Timestamp atas = Timestamp.valueOf(ata);
		shippingScheduleDetail.setEtd(etds);
		shippingScheduleDetail.setEta(etas);
		shippingScheduleDetail.setAtd(atds);
		shippingScheduleDetail.setAta(atas);
		ShippingScheduleDetailPK shippingScheduleDetailPK = new ShippingScheduleDetailPK();
		shippingScheduleDetailPK.setScheduleSeqNo(shippingScheduleDetailDTO.getScheduleSeqNo());
		shippingScheduleDetailPK.setCarrierAssetSeqNo(shippingScheduleDetailDTO.getCarrierAssetSeqNo());
		shippingScheduleDetailPK.setFrLocationSeqNo(shippingScheduleDetailDTO.getFrLocationSeqNo());
		shippingScheduleDetailPK.setToLocationSeqNo(shippingScheduleDetailDTO.getToLocationSeqNo());
		shippingScheduleDetail.setId(shippingScheduleDetailPK);
		return shippingScheduleDetail;
	}

}
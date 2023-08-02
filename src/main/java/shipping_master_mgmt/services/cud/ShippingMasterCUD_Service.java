package shipping_master_mgmt.services.cud;

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
import shipping_master_mgmt.model.dto.ShippingMaster_DTO;
import shipping_master_mgmt.model.master.ShippingMaster;
import shipping_master_mgmt.model.repo.cud.ShippingMasterCUD_Repo;

@Service("shippingMasterCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingMasterCUD_Service implements I_ShippingMasterCUD_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ShippingMasterService.class);

	@Autowired
	private ShippingMasterCUD_Repo shippingMasterCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<ShippingMaster_DTO> newShippingMaster(
			ShippingMaster_DTO shippingMaster_DTO) {
		CompletableFuture<ShippingMaster_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			ShippingMaster_DTO jcmDTO = null;
			if (!shippingMasterCUDRepo.existsById(shippingMaster_DTO.getShippingSeqNo())) 
			{
				jcmDTO = this.getShippingMaster_DTO(
						shippingMasterCUDRepo.save(this.setShippingMaster_DTO(shippingMaster_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updShippingMaster(ShippingMaster_DTO shippingMaster_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			if (shippingMasterCUDRepo.existsById(shippingMaster_DTO.getShippingSeqNo())) 
			{
				shippingMasterCUDRepo.save(this.setShippingMaster_DTO(shippingMaster_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingMasters(CopyOnWriteArrayList<Long> jcmSeqNos) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.delSelectShippingMasters(jcmSeqNos);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingMastersForPartiesFrom(CopyOnWriteArrayList<Long> pids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.delSelectShippingMastersForPartiesFrom(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingMastersForPartiesTo(CopyOnWriteArrayList<Long> pids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.delSelectShippingMastersForPartiesTo(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingMastersByShippingIds(CopyOnWriteArrayList<String> sids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.delSelectShippingMastersByShippingIds(sids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingMastersPending()
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.delSelectShippingMastersPending();
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectShippingMastersDelivered()
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.delSelectShippingMastersDelivered();
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectWorksBetweenETimes(String frDtTm, String toDtTm) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
			LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
			Timestamp frTs = Timestamp.valueOf(frDTTm);
			Timestamp toTs = Timestamp.valueOf(toDTTm);
			shippingMasterCUDRepo.delSelectWorksBetweenETimes(frTs, toTs);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectWorksBetweenATimes(String frDtTm, String toDtTm) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
			LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
			Timestamp frTs = Timestamp.valueOf(frDTTm);
			Timestamp toTs = Timestamp.valueOf(toDTTm);
			shippingMasterCUDRepo.delSelectWorksBetweenATimes(frTs, toTs);
			return;
		}, asyncExecutor);

		return future;
	}
	
	@Override
	public CompletableFuture<Void> delAllShippingMasters() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updShippingMasterDone(Long id)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.updShippingMasterDone(id);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updShippingMasterDoneStatus(Long scid, Character st)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.updShippingMasterDoneStatus(scid, st);
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updShippingMasterOk(Long id)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.updShippingMasterOk(id);
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updShippingMasterOkStatus(Long scid, Character st)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			shippingMasterCUDRepo.updShippingMasterOkStatus(scid, st);
			return;
		}, asyncExecutor);
		return future;
	}
	
	private synchronized ShippingMaster_DTO getShippingMaster_DTO(ShippingMaster shippingMaster2) 
	{
		ShippingMaster_DTO shippingMasterDTO = new ShippingMaster_DTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		shippingMasterDTO.setAta(formatter.format(shippingMaster2.getAta().toLocalDateTime()));
		shippingMasterDTO.setAtd(formatter.format(shippingMaster2.getAtd().toLocalDateTime()));
		shippingMasterDTO.setEta(formatter.format(shippingMaster2.getEta().toLocalDateTime()));
		shippingMasterDTO.setEtd(formatter.format(shippingMaster2.getEtd().toLocalDateTime()));
		shippingMasterDTO.setFrompartySeqNo(shippingMaster2.getFrompartySeqNo());
		shippingMasterDTO.setTopartySeqNo(shippingMaster2.getTopartySeqNo());
		shippingMasterDTO.setOkflag(shippingMaster2.getOkflag());
		shippingMasterDTO.setShippingId(shippingMaster2.getShippingId());
		shippingMasterDTO.setShippingSeqNo(shippingMaster2.getShippingSeqNo());		
		return shippingMasterDTO;
	}

	private synchronized ShippingMaster setShippingMaster_DTO(ShippingMaster_DTO shippingMasterDTO) {
		ShippingMaster shippingMaster = new ShippingMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime etd = LocalDateTime.parse(shippingMasterDTO.getEtd(), formatter);
		LocalDateTime eta = LocalDateTime.parse(shippingMasterDTO.getEta(), formatter);
		LocalDateTime atd = LocalDateTime.parse(shippingMasterDTO.getAtd(), formatter);
		LocalDateTime ata = LocalDateTime.parse(shippingMasterDTO.getAta(), formatter);
		Timestamp etds = Timestamp.valueOf(etd);		
		Timestamp etas = Timestamp.valueOf(eta);
		Timestamp atds = Timestamp.valueOf(atd);		
		Timestamp atas = Timestamp.valueOf(ata);
		shippingMaster.setEtd(etds);
		shippingMaster.setEta(etas);
		shippingMaster.setAtd(atds);
		shippingMaster.setAta(atas);
		shippingMaster.setFrompartySeqNo(shippingMasterDTO.getFrompartySeqNo());
		shippingMaster.setTopartySeqNo(shippingMasterDTO.getTopartySeqNo());
		shippingMaster.setOkflag(shippingMasterDTO.getOkflag());
		shippingMaster.setShippingId(shippingMasterDTO.getShippingId());
		return shippingMaster;
	}

}
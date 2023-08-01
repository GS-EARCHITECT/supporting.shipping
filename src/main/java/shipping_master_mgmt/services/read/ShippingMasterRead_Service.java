package shipping_master_mgmt.services.read;

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
import shipping_master_mgmt.model.repo.read.ShippingMasterRead_Repo;

@Service("shippingMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ShippingMasterRead_Service implements I_ShippingMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(ShippingMasterService.class);

	@Autowired
	private ShippingMasterRead_Repo shippingMasterReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getAllShippingMasters()  
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingMaster> shippingList = (CopyOnWriteArrayList<ShippingMaster>) shippingMasterReadRepo.findAll();
		CopyOnWriteArrayList<ShippingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMasters(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingMaster> shippingList = (CopyOnWriteArrayList<ShippingMaster>) shippingMasterReadRepo.getSelectShippingMasters(jcmSeqNos);
		CopyOnWriteArrayList<ShippingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersForPartiesFrom(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingMaster> shippingList = (CopyOnWriteArrayList<ShippingMaster>) shippingMasterReadRepo.getSelectShippingMastersForPartiesFrom(pids);
		CopyOnWriteArrayList<ShippingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersForPartiesTo(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingMaster> shippingList = (CopyOnWriteArrayList<ShippingMaster>) shippingMasterReadRepo.getSelectShippingMastersForPartiesTo(pids);
		CopyOnWriteArrayList<ShippingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersByShippingIds(CopyOnWriteArrayList<String> sids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingMaster> shippingList = (CopyOnWriteArrayList<ShippingMaster>) shippingMasterReadRepo.getSelectShippingMastersByShippingIds(sids);
		CopyOnWriteArrayList<ShippingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingMaster> shippingList = (CopyOnWriteArrayList<ShippingMaster>) shippingMasterReadRepo.getSelectShippingMastersPending();
		CopyOnWriteArrayList<ShippingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectShippingMastersDelivered() 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ShippingMaster> shippingList = (CopyOnWriteArrayList<ShippingMaster>) shippingMasterReadRepo.getSelectShippingMastersDelivered();
		CopyOnWriteArrayList<ShippingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectWorksBetweenETimes(String frDtTm, String toDtTm) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTs = Timestamp.valueOf(frDTTm);
		Timestamp toTs = Timestamp.valueOf(toDTTm);
		CopyOnWriteArrayList<ShippingMaster> shippingList = (CopyOnWriteArrayList<ShippingMaster>) shippingMasterReadRepo.getSelectWorksBetweenETimes(frTs, toTs);
		CopyOnWriteArrayList<ShippingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> getSelectWorksBetweenATimes(String frDtTm, String toDtTm) 
	{
		CompletableFuture<CopyOnWriteArrayList<ShippingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTs = Timestamp.valueOf(frDTTm);
		Timestamp toTs = Timestamp.valueOf(toDTTm);
		CopyOnWriteArrayList<ShippingMaster> shippingList = (CopyOnWriteArrayList<ShippingMaster>) shippingMasterReadRepo.getSelectWorksBetweenATimes(frTs, toTs);
		CopyOnWriteArrayList<ShippingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();
		jcmDTOs = shippingList != null ? this.getShippingMaster_DTOs(shippingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	private synchronized CopyOnWriteArrayList<ShippingMaster_DTO> getShippingMaster_DTOs(CopyOnWriteArrayList<ShippingMaster> shippingMasters) {
		ShippingMaster_DTO shippingDTO = null;
		CopyOnWriteArrayList<ShippingMaster_DTO> shippingDTOs = new CopyOnWriteArrayList<ShippingMaster_DTO>();

		for (int i = 0; i < shippingMasters.size(); i++) {
			shippingDTO = getShippingMaster_DTO(shippingMasters.get(i));
			shippingDTOs.add(shippingDTO);
		}
		return shippingDTOs;
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

}
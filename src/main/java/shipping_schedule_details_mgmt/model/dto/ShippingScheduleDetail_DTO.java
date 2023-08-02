package shipping_schedule_details_mgmt.model.dto;

import java.io.Serializable;

public class ShippingScheduleDetail_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374477372015613827L;

	private Long scheduleSeqNo;
	private Long carrierAssetSeqNo;
	private Long frLocationSeqNo;
	private Long toLocationSeqNo;
	private String ata;
	private String atd;
	private String eta;
	private String etd;

	public Long getScheduleSeqNo() {
		return scheduleSeqNo;
	}

	public void setScheduleSeqNo(Long scheduleSeqNo) {
		this.scheduleSeqNo = scheduleSeqNo;
	}

	public Long getCarrierAssetSeqNo() {
		return carrierAssetSeqNo;
	}

	public void setCarrierAssetSeqNo(Long carrierAssetSeqNo) {
		this.carrierAssetSeqNo = carrierAssetSeqNo;
	}

	public Long getFrLocationSeqNo() {
		return frLocationSeqNo;
	}

	public void setFrLocationSeqNo(Long frLocationSeqNo) {
		this.frLocationSeqNo = frLocationSeqNo;
	}

	public Long getToLocationSeqNo() {
		return toLocationSeqNo;
	}

	public void setToLocationSeqNo(Long toLocationSeqNo) {
		this.toLocationSeqNo = toLocationSeqNo;
	}

	public String getAta() {
		return ata;
	}

	public void setAta(String ata) {
		this.ata = ata;
	}

	public String getAtd() {
		return atd;
	}

	public void setAtd(String atd) {
		this.atd = atd;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getEtd() {
		return etd;
	}

	public void setEtd(String etd) {
		this.etd = etd;
	}

	public ShippingScheduleDetail_DTO(Long scheduleSeqNo, Long carrierAssetSeqNo, Long frLocationSeqNo,
			Long toLocationSeqNo, String ata, String atd, String eta, String etd) {
		super();
		this.scheduleSeqNo = scheduleSeqNo;
		this.carrierAssetSeqNo = carrierAssetSeqNo;
		this.frLocationSeqNo = frLocationSeqNo;
		this.toLocationSeqNo = toLocationSeqNo;
		this.ata = ata;
		this.atd = atd;
		this.eta = eta;
		this.etd = etd;
	}

	public ShippingScheduleDetail_DTO() {
		super();
	}

}
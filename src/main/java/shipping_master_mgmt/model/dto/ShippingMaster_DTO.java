package shipping_master_mgmt.model.dto;

import java.io.Serializable;
import javax.persistence.*;

public class ShippingMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4973955303361198440L;
	private long shippingSeqNo;
	private String ata;
	private String atd;
	private String eta;
	private String etd;
	private Long frompartySeqNo;
	private Character okflag;
	private String shippingId;
	private Long topartySeqNo;

	public long getShippingSeqNo() {
		return shippingSeqNo;
	}

	public void setShippingSeqNo(long shippingSeqNo) {
		this.shippingSeqNo = shippingSeqNo;
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

	public Long getFrompartySeqNo() {
		return frompartySeqNo;
	}

	public void setFrompartySeqNo(Long frompartySeqNo) {
		this.frompartySeqNo = frompartySeqNo;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public Long getTopartySeqNo() {
		return topartySeqNo;
	}

	public void setTopartySeqNo(Long topartySeqNo) {
		this.topartySeqNo = topartySeqNo;
	}

	public ShippingMaster_DTO(long shippingSeqNo, String ata, String atd, String eta, String etd, Long frompartySeqNo,
			Character okflag, String shippingId, Long topartySeqNo) {
		super();
		this.shippingSeqNo = shippingSeqNo;
		this.ata = ata;
		this.atd = atd;
		this.eta = eta;
		this.etd = etd;
		this.frompartySeqNo = frompartySeqNo;
		this.okflag = okflag;
		this.shippingId = shippingId;
		this.topartySeqNo = topartySeqNo;
	}

	public ShippingMaster_DTO() {
		super();
	}

}
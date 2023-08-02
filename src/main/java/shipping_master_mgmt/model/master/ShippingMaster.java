package shipping_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the SHIPPING_MASTER database table.
 * 
 */
@Entity
@Table(name = "SHIPPING_MASTER")
public class ShippingMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIPPING_SEQUENCE")
	@SequenceGenerator(name = "SHIPPING_SEQUENCE", sequenceName = "SHIPPING_SEQUENCE", allocationSize = 1)
	@Column(name = "SHIPPING_SEQ_NO")
	private Long shippingSeqNo;

	@Column(name = "DONEFLAG")
	private Character doneFlag;
	
	@Column(name = "INFLAG")
	private Character inFlag;
	
	@Column(name = "OKFLAG")
	private Character okflag;

	@Column(name = "ATA")
	private Timestamp ata;

	@Column(name = "ATD")
	private Timestamp atd;

	@Column(name = "ETA")
	private Timestamp eta;

	@Column(name = "ETD")
	private Timestamp etd;

	@Column(name = "FROMPARTY_SEQ_NO")
	private Long frompartySeqNo;

	@Column(name = "SHIPPING_ID")
	private String shippingId;

	@Column(name = "TOPARTY_SEQ_NO")
	private Long topartySeqNo;

	public ShippingMaster() {
	}

	public Long getShippingSeqNo() {
		return shippingSeqNo;
	}

	public void setShippingSeqNo(Long shippingSeqNo) {
		this.shippingSeqNo = shippingSeqNo;
	}

	public Timestamp getAta() {
		return ata;
	}

	public void setAta(Timestamp ata) {
		this.ata = ata;
	}

	public Timestamp getAtd() {
		return atd;
	}

	public void setAtd(Timestamp atd) {
		this.atd = atd;
	}

	public Timestamp getEta() {
		return eta;
	}

	public void setEta(Timestamp eta) {
		this.eta = eta;
	}

	public Timestamp getEtd() {
		return etd;
	}

	public void setEtd(Timestamp etd) {
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

	public Character getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Character doneFlag) {
		this.doneFlag = doneFlag;
	}

	public Character getInFlag() {
		return inFlag;
	}

	public void setInFlag(Character inFlag) {
		this.inFlag = inFlag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frompartySeqNo == null) ? 0 : frompartySeqNo.hashCode());
		result = prime * result + ((shippingSeqNo == null) ? 0 : shippingSeqNo.hashCode());
		result = prime * result + ((topartySeqNo == null) ? 0 : topartySeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShippingMaster other = (ShippingMaster) obj;
		if (frompartySeqNo == null) {
			if (other.frompartySeqNo != null)
				return false;
		} else if (!frompartySeqNo.equals(other.frompartySeqNo))
			return false;
		if (shippingSeqNo == null) {
			if (other.shippingSeqNo != null)
				return false;
		} else if (!shippingSeqNo.equals(other.shippingSeqNo))
			return false;
		if (topartySeqNo == null) {
			if (other.topartySeqNo != null)
				return false;
		} else if (!topartySeqNo.equals(other.topartySeqNo))
			return false;
		return true;
	}

	public ShippingMaster(Long shippingSeqNo, Character doneFlag, Character inFlag, Character okflag, Timestamp ata,
			Timestamp atd, Timestamp eta, Timestamp etd, Long frompartySeqNo, String shippingId, Long topartySeqNo) {
		super();
		this.shippingSeqNo = shippingSeqNo;
		this.doneFlag = doneFlag;
		this.inFlag = inFlag;
		this.okflag = okflag;
		this.ata = ata;
		this.atd = atd;
		this.eta = eta;
		this.etd = etd;
		this.frompartySeqNo = frompartySeqNo;
		this.shippingId = shippingId;
		this.topartySeqNo = topartySeqNo;
	}

	
	
}
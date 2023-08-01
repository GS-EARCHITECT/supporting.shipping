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
public class ShippingMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIPPING_SEQUENCE")
	@SequenceGenerator(name = "SHIPPING_SEQUENCE", sequenceName = "SHIPPING_SEQUENCE", allocationSize = 1)
	@Column(name = "SHIPPING_SEQ_NO")
	private long shippingSeqNo;

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

	@Column(name = "OKFLAG")
	private Character okflag;

	@Column(name = "SHIPPING_ID")
	private String shippingId;

	@Column(name = "TOPARTY_SEQ_NO")
	private Long topartySeqNo;

	public ShippingMaster() {
	}

	public long getShippingSeqNo() {
		return shippingSeqNo;
	}

	public void setShippingSeqNo(long shippingSeqNo) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (shippingSeqNo ^ (shippingSeqNo >>> 32));
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
		if (shippingSeqNo != other.shippingSeqNo)
			return false;
		return true;
	}

	public ShippingMaster(long shippingSeqNo, Timestamp ata, Timestamp atd, Timestamp eta, Timestamp etd,
			Long frompartySeqNo, Character okflag, String shippingId, Long topartySeqNo) {
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

}
package shipping_container_schedule_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SHIPPING_CONTAINER_SCHEDULE database table.
 * 
 */
@Embeddable
public class ShippingContainerSchedulePK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "SCHEDULE_SEQ_NO")
	private Long scheduleSeqNo;

	@Column(name = "SC_SEQ_NO")
	private Long scSeqNo;

	public ShippingContainerSchedulePK() {
	}

	public Long getScheduleSeqNo() {
		return this.scheduleSeqNo;
	}

	public void setScheduleSeqNo(Long scheduleSeqNo) {
		this.scheduleSeqNo = scheduleSeqNo;
	}

	public Long getScSeqNo() {
		return this.scSeqNo;
	}

	public void setScSeqNo(Long scSeqNo) {
		this.scSeqNo = scSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ShippingContainerSchedulePK)) {
			return false;
		}
		ShippingContainerSchedulePK castOther = (ShippingContainerSchedulePK) other;
		return (this.scheduleSeqNo == castOther.scheduleSeqNo) && (this.scSeqNo == castOther.scSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.scheduleSeqNo ^ (this.scheduleSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.scSeqNo ^ (this.scSeqNo >>> 32)));

		return hash;
	}

	public ShippingContainerSchedulePK(Long scheduleSeqNo, Long scSeqNo) {
		super();
		this.scheduleSeqNo = scheduleSeqNo;
		this.scSeqNo = scSeqNo;
	}

}
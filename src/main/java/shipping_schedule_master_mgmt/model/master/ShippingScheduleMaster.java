package shipping_schedule_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SHIPPING_SCHEDULE_MASTER database table.
 * 
 */
@Entity
@Table(name = "SHIPPING_SCHEDULE_MASTER")
public class ShippingScheduleMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULE_SEQUENCE")
	@SequenceGenerator(name = "SCHEDULE_SEQUENCE", sequenceName = "SCHEDULE_SEQUENCE", allocationSize = 1)
	@Column(name = "SCHEDULE_SEQ_NO")
	private Long scheduleSeqNo;

	@Column(name = "TRIP_TEMPLATE_SEQ_NO")
	private Long tripTemplateSeqNo;

	public ShippingScheduleMaster() {
	}

	public long getScheduleSeqNo() {
		return this.scheduleSeqNo;
	}

	public void setScheduleSeqNo(long scheduleSeqNo) {
		this.scheduleSeqNo = scheduleSeqNo;
	}

	public Long getTripTemplateSeqNo() {
		return this.tripTemplateSeqNo;
	}

	public void setTripTemplateSeqNo(Long tripTemplateSeqNo) {
		this.tripTemplateSeqNo = tripTemplateSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scheduleSeqNo == null) ? 0 : scheduleSeqNo.hashCode());
		result = prime * result + ((tripTemplateSeqNo == null) ? 0 : tripTemplateSeqNo.hashCode());
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
		ShippingScheduleMaster other = (ShippingScheduleMaster) obj;
		if (scheduleSeqNo == null) {
			if (other.scheduleSeqNo != null)
				return false;
		} else if (!scheduleSeqNo.equals(other.scheduleSeqNo))
			return false;
		if (tripTemplateSeqNo == null) {
			if (other.tripTemplateSeqNo != null)
				return false;
		} else if (!tripTemplateSeqNo.equals(other.tripTemplateSeqNo))
			return false;
		return true;
	}

	public ShippingScheduleMaster(Long scheduleSeqNo, Long tripTemplateSeqNo) {
		super();
		this.scheduleSeqNo = scheduleSeqNo;
		this.tripTemplateSeqNo = tripTemplateSeqNo;
	}

}
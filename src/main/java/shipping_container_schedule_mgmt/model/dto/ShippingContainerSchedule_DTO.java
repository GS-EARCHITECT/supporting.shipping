package shipping_container_schedule_mgmt.model.dto;

import java.io.Serializable;

public class ShippingContainerSchedule_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3327300384598331344L;
	private Long scheduleSeqNo;
	private Long scSeqNo;

	public Long getScheduleSeqNo() {
		return scheduleSeqNo;
	}

	public void setScheduleSeqNo(Long scheduleSeqNo) {
		this.scheduleSeqNo = scheduleSeqNo;
	}

	public Long getScSeqNo() {
		return scSeqNo;
	}

	public void setScSeqNo(Long scSeqNo) {
		this.scSeqNo = scSeqNo;
	}

	public ShippingContainerSchedule_DTO() {
		super();
	}

}
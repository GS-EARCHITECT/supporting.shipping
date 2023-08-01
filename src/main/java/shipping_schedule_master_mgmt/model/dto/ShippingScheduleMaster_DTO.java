package shipping_schedule_master_mgmt.model.dto;

import java.io.Serializable;

public class ShippingScheduleMaster_DTO implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private Long scheduleSeqNo;
	private Long tripTemplateSeqNo;

	public Long getScheduleSeqNo() {
		return scheduleSeqNo;
	}

	public void setScheduleSeqNo(Long scheduleSeqNo) {
		this.scheduleSeqNo = scheduleSeqNo;
	}

	public Long getTripTemplateSeqNo() {
		return tripTemplateSeqNo;
	}

	public void setTripTemplateSeqNo(Long tripTemplateSeqNo) {
		this.tripTemplateSeqNo = tripTemplateSeqNo;
	}

	public ShippingScheduleMaster_DTO(Long scheduleSeqNo, Long tripTemplateSeqNo) {
		super();
		this.scheduleSeqNo = scheduleSeqNo;
		this.tripTemplateSeqNo = tripTemplateSeqNo;
	}

	public ShippingScheduleMaster_DTO() {
		super();
	}

}
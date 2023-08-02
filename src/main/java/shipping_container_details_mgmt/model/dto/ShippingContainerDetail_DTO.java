package shipping_container_details_mgmt.model.dto;

import java.io.Serializable;

public class ShippingContainerDetail_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374477372015613827L;
	private Long consignmentSeqNo;
	private Long scSeqNo;
	private Character okFlag;
	private Character doneFlag;

	public Long getConsignmentSeqNo() {
		return consignmentSeqNo;
	}

	public void setConsignmentSeqNo(Long consignmentSeqNo) {
		this.consignmentSeqNo = consignmentSeqNo;
	}

	public Long getScSeqNo() {
		return scSeqNo;
	}

	public void setScSeqNo(Long scSeqNo) {
		this.scSeqNo = scSeqNo;
	}

	public Character getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Character doneFlag) {
		this.doneFlag = doneFlag;
	}

	public Character getOkFlag() {
		return okFlag;
	}

	public void setOkFlag(Character okFlag) {
		this.okFlag = okFlag;
	}

	public ShippingContainerDetail_DTO() {
		super();
	}

	public ShippingContainerDetail_DTO(Long consignmentSeqNo, Long scSeqNo, Character okFlag, Character doneFlag) {
		super();
		this.consignmentSeqNo = consignmentSeqNo;
		this.scSeqNo = scSeqNo;
		this.okFlag = okFlag;
		this.doneFlag = doneFlag;
	}

}
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

	public ShippingContainerDetail_DTO(Long consignmentSeqNo, Long scSeqNo) {
		super();
		this.consignmentSeqNo = consignmentSeqNo;	
		this.scSeqNo = scSeqNo;
	}

	public ShippingContainerDetail_DTO() {
		super();
	}

}
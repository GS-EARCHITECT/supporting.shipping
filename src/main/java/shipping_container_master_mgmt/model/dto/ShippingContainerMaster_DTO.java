package shipping_container_master_mgmt.model.dto;

import java.io.Serializable;

public class ShippingContainerMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3886608503666961916L;
	private Long scSeqNo;
	private String assetId;
	private Long assetSeqNo;
	private Long shippingSeqNo;

	public Long getScSeqNo() {
		return scSeqNo;
	}

	public void setScSeqNo(Long scSeqNo) {
		this.scSeqNo = scSeqNo;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Long getShippingSeqNo() {
		return shippingSeqNo;
	}

	public void setShippingSeqNo(Long shippingSeqNo) {
		this.shippingSeqNo = shippingSeqNo;
	}

	public ShippingContainerMaster_DTO(Long scSeqNo, String assetId, Long assetSeqNo, Long shippingSeqNo) {
		super();
		this.scSeqNo = scSeqNo;
		this.assetId = assetId;
		this.assetSeqNo = assetSeqNo;
		this.shippingSeqNo = shippingSeqNo;
	}

	public ShippingContainerMaster_DTO() {
		super();
	}

}
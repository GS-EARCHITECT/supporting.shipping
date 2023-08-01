package shipping_container_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SHIPPING_CONTAINER_MASTER database table.
 * 
 */
@Entity
@Table(name = "SHIPPING_CONTAINER_MASTER")
public class ShippingContainerMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SC_SEQUENCE")
	@SequenceGenerator(name = "SC_SEQUENCE", sequenceName = "SC_SEQUENCE", allocationSize = 1)
	@Column(name = "SC_SEQ_NO")
	private Long scSeqNo;

	@Column(name = "ASSET_ID")
	private String assetId;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "SHIPPING_SEQ_NO")
	private Long shippingSeqNo;

	public ShippingContainerMaster() {
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Long getShippingSeqNo() {
		return this.shippingSeqNo;
	}

	public void setShippingSeqNo(Long shippingSeqNo) {
		this.shippingSeqNo = shippingSeqNo;
	}

	public void setScSeqNo(Long scSeqNo) {
		this.scSeqNo = scSeqNo;
	}
	
	

	public Long getScSeqNo() {
		return scSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scSeqNo == null) ? 0 : scSeqNo.hashCode());
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
		ShippingContainerMaster other = (ShippingContainerMaster) obj;
		if (scSeqNo == null) {
			if (other.scSeqNo != null)
				return false;
		} else if (!scSeqNo.equals(other.scSeqNo))
			return false;
		return true;
	}

	public ShippingContainerMaster(Long scSeqNo, String assetId, Long assetSeqNo, Long shippingSeqNo) {
		super();
		this.scSeqNo = scSeqNo;
		this.assetId = assetId;
		this.assetSeqNo = assetSeqNo;
		this.shippingSeqNo = shippingSeqNo;
	}

}
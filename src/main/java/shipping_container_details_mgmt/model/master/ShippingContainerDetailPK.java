package shipping_container_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SHIPPING_CONTAINER_DETAILS database table.
 * 
 */
@Embeddable
public class ShippingContainerDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "CONSIGNMENT_SEQ_NO")
	private Long consignmentSeqNo;

	@Column(name = "SC_SEQ_NO")
	private Long scSeqNo;

	public ShippingContainerDetailPK() {
	}

	public Long getConsignmentSeqNo() {
		return this.consignmentSeqNo;
	}

	public void setConsignmentSeqNo(Long consignmentSeqNo) {
		this.consignmentSeqNo = consignmentSeqNo;
	}

	public Long getScSeqNo() {
		return this.scSeqNo;
	}

	public void setScSeqNo(Long scSeqNo) {
		this.scSeqNo = scSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consignmentSeqNo == null) ? 0 : consignmentSeqNo.hashCode());
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
		ShippingContainerDetailPK other = (ShippingContainerDetailPK) obj;
		if (consignmentSeqNo == null) {
			if (other.consignmentSeqNo != null)
				return false;
		} else if (!consignmentSeqNo.equals(other.consignmentSeqNo))
			return false;
		if (scSeqNo == null) {
			if (other.scSeqNo != null)
				return false;
		} else if (!scSeqNo.equals(other.scSeqNo))
			return false;
		return true;
	}

	public ShippingContainerDetailPK(Long consignmentSeqNo, Long scSeqNo) {
		super();
		this.consignmentSeqNo = consignmentSeqNo;
		this.scSeqNo = scSeqNo;
	}

}
package shipping_schedule_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SHIPPING_SCHEDULE_DETAILS database table.
 * 
 */
@Embeddable
public class ShippingScheduleDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "SCHEDULE_SEQ_NO")
	private Long scheduleSeqNo;

	@Column(name = "CARRIER_ASSET_SEQ_NO")
	private Long carrierAssetSeqNo;

	@Column(name = "FR_LOCATION_SEQ_NO")
	private Long frLocationSeqNo;

	@Column(name = "TO_LOCATION_SEQ_NO")
	private Long toLocationSeqNo;

	public ShippingScheduleDetailPK() {
	}

	public Long getScheduleSeqNo() {
		return this.scheduleSeqNo;
	}

	public void setScheduleSeqNo(Long scheduleSeqNo) {
		this.scheduleSeqNo = scheduleSeqNo;
	}

	public Long getCarrierAssetSeqNo() {
		return this.carrierAssetSeqNo;
	}

	public void setCarrierAssetSeqNo(Long carrierAssetSeqNo) {
		this.carrierAssetSeqNo = carrierAssetSeqNo;
	}

	public Long getFrLocationSeqNo() {
		return this.frLocationSeqNo;
	}

	public void setFrLocationSeqNo(Long frLocationSeqNo) {
		this.frLocationSeqNo = frLocationSeqNo;
	}

	public Long getToLocationSeqNo() {
		return this.toLocationSeqNo;
	}

	public void setToLocationSeqNo(Long toLocationSeqNo) {
		this.toLocationSeqNo = toLocationSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ShippingScheduleDetailPK)) {
			return false;
		}
		ShippingScheduleDetailPK castOther = (ShippingScheduleDetailPK) other;
		return (this.scheduleSeqNo == castOther.scheduleSeqNo)
				&& (this.carrierAssetSeqNo == castOther.carrierAssetSeqNo)
				&& (this.frLocationSeqNo == castOther.frLocationSeqNo)
				&& (this.toLocationSeqNo == castOther.toLocationSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.scheduleSeqNo ^ (this.scheduleSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.carrierAssetSeqNo ^ (this.carrierAssetSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.frLocationSeqNo ^ (this.frLocationSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.toLocationSeqNo ^ (this.toLocationSeqNo >>> 32)));

		return hash;
	}

	public ShippingScheduleDetailPK(Long scheduleSeqNo, Long carrierAssetSeqNo, Long frLocationSeqNo,
			Long toLocationSeqNo) {
		super();
		this.scheduleSeqNo = scheduleSeqNo;
		this.carrierAssetSeqNo = carrierAssetSeqNo;
		this.frLocationSeqNo = frLocationSeqNo;
		this.toLocationSeqNo = toLocationSeqNo;
	}

}
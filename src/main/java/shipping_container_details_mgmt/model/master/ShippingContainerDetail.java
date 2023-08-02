package shipping_container_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SHIPPING_CONTAINER_DETAILS database table.
 * 
 */
@Entity
@Table(name = "SHIPPING_CONTAINER_DETAILS")
public class ShippingContainerDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShippingContainerDetailPK id;

	@Column(name = "OKFLAG")
	private Character okFlag;

	@Column(name = "DONEFLAG")
	private Character doneFlag;
	
	public ShippingContainerDetail() {
	}

	public ShippingContainerDetailPK getId() {
		return this.id;
	}

	public void setId(ShippingContainerDetailPK id) {
		this.id = id;
	}

	public Character getOkFlag() {
		return okFlag;
	}

	public Character getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Character doneFlag) {
		this.doneFlag = doneFlag;
	}

	public void setOkFlag(Character okFlag) {
		this.okFlag = okFlag;
	}

	public ShippingContainerDetail(ShippingContainerDetailPK id, Character okFlag, Character doneFlag) {
		super();
		this.id = id;
		this.okFlag = okFlag;
		this.doneFlag = doneFlag;
	}


}
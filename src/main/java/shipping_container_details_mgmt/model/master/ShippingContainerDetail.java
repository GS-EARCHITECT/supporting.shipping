package shipping_container_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SHIPPING_CONTAINER_DETAILS database table.
 * 
 */
@Entity
@Table(name="SHIPPING_CONTAINER_DETAILS")
public class ShippingContainerDetail implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShippingContainerDetailPK id;

	public ShippingContainerDetail() {
	}

	public ShippingContainerDetailPK getId() {
		return this.id;
	}

	public void setId(ShippingContainerDetailPK id) {
		this.id = id;
	}

	public ShippingContainerDetail(ShippingContainerDetailPK id) {
		super();
		this.id = id;
	}

	
}
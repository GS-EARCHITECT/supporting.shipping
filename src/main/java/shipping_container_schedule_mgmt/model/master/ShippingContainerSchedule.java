package shipping_container_schedule_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SHIPPING_CONTAINER_SCHEDULE database table.
 * 
 */
@Entity
@Table(name = "SHIPPING_CONTAINER_SCHEDULE")
public class ShippingContainerSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShippingContainerSchedulePK id;

	public ShippingContainerSchedule() {
	}

	public ShippingContainerSchedulePK getId() {
		return this.id;
	}

	public void setId(ShippingContainerSchedulePK id) {
		this.id = id;
	}

	public ShippingContainerSchedule(ShippingContainerSchedulePK id) {
		super();
		this.id = id;
	}

}
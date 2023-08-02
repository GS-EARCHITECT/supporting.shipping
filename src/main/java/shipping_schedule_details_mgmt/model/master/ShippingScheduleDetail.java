package shipping_schedule_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the SHIPPING_SCHEDULE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "SHIPPING_SCHEDULE_DETAILS")
public class ShippingScheduleDetail implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShippingScheduleDetailPK id;

	@Column(name = "ATA")
	private Timestamp ata;

	@Column(name = "ATD")
	private Timestamp atd;

	@Column(name = "ETA")
	private Timestamp eta;

	@Column(name = "ETD")
	private Timestamp etd;

	public ShippingScheduleDetail() {
	}

	public ShippingScheduleDetailPK getId() {
		return this.id;
	}

	public void setId(ShippingScheduleDetailPK id) {
		this.id = id;
	}

	public Timestamp getAta() {
		return this.ata;
	}

	public void setAta(Timestamp ata) {
		this.ata = ata;
	}

	public Timestamp getAtd() {
		return this.atd;
	}

	public void setAtd(Timestamp atd) {
		this.atd = atd;
	}

	public Timestamp getEta() {
		return this.eta;
	}

	public void setEta(Timestamp eta) {
		this.eta = eta;
	}

	public Timestamp getEtd() {
		return this.etd;
	}

	public void setEtd(Timestamp etd) {
		this.etd = etd;
	}

	public ShippingScheduleDetail(ShippingScheduleDetailPK id, Timestamp ata, Timestamp atd, Timestamp eta,
			Timestamp etd) {
		super();
		this.id = id;
		this.ata = ata;
		this.atd = atd;
		this.eta = eta;
		this.etd = etd;
	}

}
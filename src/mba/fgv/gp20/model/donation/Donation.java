package mba.fgv.gp20.model.donation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "donation")
@Table(name ="donation")
@NamedQueries({ 
	@NamedQuery(name = "findAllDonations", query = "SELECT a FROM donation a")
})
public class Donation {
	@Id
	@SequenceGenerator(name="seq_donation", sequenceName="seq_donation", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_donation")
	private long id;

	@Column(name="description")
	private String description;

	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	@Column(name="condition")
	private Condition condition;

	@Column(name="validity")
	private Date validity;
	
	@OneToOne
	@JoinColumn(name="origin_id")
	private City origin;

	@OneToOne
	@JoinColumn(name="destination_id")
	private City destination;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	public City getOrigin() {
		return origin;
	}

	public void setOrigin(City origin) {
		this.origin = origin;
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

}

package mba.fgv.gp20.model.donation;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "category")
@Table(name ="category")
public class Category {
	@Id
	@SequenceGenerator(name="seq_category", sequenceName="seq_category", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_category")
	private long id;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Donation> donations;
	
	@Column(name="description")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
package mba.fgv.gp20.model.donation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "city")
@Table(name ="city")
public class City {
	@Id
	@SequenceGenerator(name="seq_city", sequenceName="seq_city", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_city")
	private long id;

	@Column(name="name")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
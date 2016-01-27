package mba.fgv.gp20.model.donation;

import java.util.List;

import javax.persistence.TypedQuery;

import mba.fgv.gp20.model.generic.GenericDaoImpl;

public class DonationDaoImpl extends GenericDaoImpl<Donation> {
	public DonationDaoImpl() {
		super(Donation.class);
	}	

	
	public List<Donation> findAllDonations() {
		List<Donation> result = null;
		TypedQuery<Donation> query = getEntityManager().createNamedQuery("findAllDonations", Donation.class);

		try {
			result = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

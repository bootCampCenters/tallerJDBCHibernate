package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;

import org.springframework.samples.petclinic.bill.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillDAO extends AbstractJpaDAO<Bill,Integer> implements IBillAO{

    public BillDAO() {
        super();

        setClazz(Bill.class);
    }

    
    public List<Bill> getBIllsByIdNumber(long idNumber) {
    	
    	return getEntityManager().createQuery("select b from Bill b where b.idNumber= " + idNumber).getResultList();
    	
    }
    // API


	@Override
	public List<Bill> getBIllsByIdNumberNamedQuery(long idNumber) {
		// TODO Auto-generated method stub
		return getEntityManager().createNamedQuery("billByIdNumber").setParameter("idNumber", idNumber).getResultList();
	}

}

package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;

import org.springframework.samples.petclinic.bill.Bill;

/**
 * Interfaz para definir los métodos especificos para la entidad Bill
 * @author operator
 *
 */
public interface IBillAO extends IBaseDAO<Bill, Integer> {
	
	List<Bill> getBIllsByIdNumber(long idNumber);
	
	List<Bill> getBIllsByIdNumberNamedQuery(long idNumber);


}

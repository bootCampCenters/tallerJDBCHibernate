/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.bill.Bill;
import org.springframework.samples.petclinic.persistence.dao.BillDAO;
import org.springframework.samples.petclinic.persistence.dao.IBillAO;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class DAOApplication implements CommandLineRunner {
		
	
	@Autowired
	IBillAO billDAO;
	

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DAOApplication.class, args);
        
    }
    
    
    
    @Override
    @Transactional
    public void run(String... arg0) {
    	

		Bill b = new Bill();
		b.setIdNumber(954);
		b.setMoney(4.0);
		b.setPaymentDate(new Date());
		
		billDAO.create(b); 
		
		
		Bill b2 = new Bill();
		b2.setIdNumber(955);
		b2.setMoney(5.0);
		b2.setPaymentDate(new Date());
		
		billDAO.create(b2);
		
		
		Bill b3 = new Bill();
		b3.setIdNumber(956);
		b3.setMoney(6.0);
		b3.setPaymentDate(new Date());
		
		billDAO.create(b3); 
		
		Bill b4 = new Bill();
		b4.setIdNumber(954);
		b4.setMoney(7.0);
		b4.setPaymentDate(new Date());
		
		billDAO.create(b4);
		
		List<Bill> bills  = billDAO.getBIllsByIdNumber(954); 
		
		for(Bill bill:bills) {
			System.out.println("Consulta con Id 954 . Bill recuperada con ID  " + bill.getId() + " y money " + bill.getMoney() );
		}
		
		
		List<Bill> billsNamedQuery  = billDAO.getBIllsByIdNumberNamedQuery(954); 
		for(Bill billNamed:billsNamedQuery) {
			System.out.println("Consulta namedQuery con Id 954 . Bill recuperada con ID  " + billNamed.getId() + " y money " + billNamed.getMoney() );
		}
		
		List<Bill> Allbills =  billDAO.findAll();
		System.out.println("Bills totales recuperadas");
		for(Bill billAux:Allbills) {
			System.out.println("Bill recuperada con PK " + billAux.getId() + " IdNumber "  + billAux.getIdNumber() +  " y money " + billAux.getMoney() );
		}


    }

}

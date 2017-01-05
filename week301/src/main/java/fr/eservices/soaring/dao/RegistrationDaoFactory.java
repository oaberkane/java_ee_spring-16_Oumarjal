package fr.eservices.soaring.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.eservices.soaring.model.Pilote;
import fr.eservices.soaring.model.Repas;
import fr.eservices.soaring.model.Reservation;

public class RegistrationDaoFactory implements RegistrationDao{

	EntityManagerFactory entityManagerFactory; 
	 EntityManager entityManager ; 
	
	public RegistrationDaoFactory() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static RegistrationDao createRegistrationDao() {
		return new RegistrationDaoFactory();
	}	
	
	
	@Override
	public List<Pilote> findPilotsByName(String nom) {
		Query query = entityManager.createQuery(
				"SELECT pi FROM Pilote pi WHERE nom = ?1", Pilote.class);

		query.setParameter(1, nom);
		List list = query.getResultList();
		return list;
		
	}
	@Override
	public List<Pilote> findPilotsByRegion(int id_region) {
		Query query = entityManager.createQuery(
		"SELECT pi FROM Pilote pi JOIN pi.club pc JOIN pc.region pc_r WHERE pc_r.id = ?1", Pilote.class);
		query.setParameter(1, id_region);
		List list = query.getResultList();
		return list;
	}

	@Override
	public List<Pilote> findPilotsByClub(int id_club) {
		Query query = entityManager.createQuery(
				"SELECT pi FROM Pilote pi WHERE club_id = ?1", Pilote.class);

		query.setParameter(1, id_club);
		List list = query.getResultList();
		return list;
	}

	@Override
	public List<Pilote> findPilotsBelow(Date currentDate, int age) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.YEAR, -age);
		Date f_date = c.getTime();
	
		Query query = entityManager.createQuery(
				"SELECT p FROM Pilote p WHERE dateNaissance < ?1 AND dateNaissance >= ?2", Pilote.class);

		
		query.setParameter(2, f_date);
		query.setParameter(1, currentDate);
		List list = query.getResultList();
		return list;
	}

	@Override
	public Map<Repas, Integer> getAvailableSeatsForLunch(Date day, String time) {
		
		   
		   String timeSplit1 = time.split(":")[0];
		   String timeSplit2 = time.split(":")[1];
		   
		   int i = Integer.parseInt(timeSplit1);
		   
		   int iIncrem=i+2;
		   int iDec=i-2;
		   
		   String timPlus="";
		   String timMoins="";
		  
		   if (iIncrem>9){timPlus =iIncrem+":"+timeSplit2;}
		   else {timPlus ="0"+iIncrem+":"+timeSplit2;}
		   
		   if (iDec>9) {timMoins = iDec+":"+timeSplit2;}
		   else {timMoins ="0"+iDec+":"+timeSplit2;}
		   
		   
		Query query = entityManager.createQuery("SELECT rep FROM Repas rep WHERE heure BETWEEN ?2 AND ?1 AND date=?3 AND id not IN (SELECT repas_id FROM Reservation res)") ;
		
		query.setParameter(1, timPlus);
		query.setParameter(2, timMoins);
		query.setParameter(3, day);
		
		
		Query query2 = entityManager.createQuery("SELECT rep, res.nbPersonnes FROM Repas rep, Reservation res WHERE heure BETWEEN ?2 AND ?1 AND date=?3 AND rep.id=res.repas_id ") ;
		query2.setParameter(1, timPlus);
		query2.setParameter(2, timMoins);
		query2.setParameter(3, day);
		
		
		List list1 = query.getResultList();
		List<Object[]> list2 = query2.getResultList();

		Map<Repas, Integer> hm = new HashMap<>();
		for(int m=0; m<list2.size();m++){
			int lastVal=0;
			if (!hm.containsKey(list2.get(m)[0])){
				hm.put((Repas) list2.get(m)[0], 20-(Integer)list2.get(m)[1]);
			}
			
			
			else{
				lastVal=(Integer)hm.get(list2.get(m)[0]);
				hm.put((Repas) list2.get(m)[0], lastVal-(Integer)list2.get(m)[1]);
			}
		}
		for(int n=0; n<list1.size();n++){
			hm.put((Repas) list1.get(n), 20);
		}
		
		for(Repas r: hm.keySet()){
			if(hm.get(r)<=0) hm.remove(r);
		}
		
		return hm; 
	}
	
}
	

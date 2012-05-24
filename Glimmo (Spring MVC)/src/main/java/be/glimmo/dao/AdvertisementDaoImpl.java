package be.glimmo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import be.glimmo.domain.Advertisement;
import be.glimmo.domain.Good;
import be.glimmo.domain.enumeration.AdvertisementType;

@Repository("AdvertisementDao")
public class AdvertisementDaoImpl extends GenericDaoImpl<Advertisement, Long> implements AdvertisementDao {

	public Advertisement findById(Long id) {
		return super.findById(id);
	}

	@SuppressWarnings("unchecked")
	public List<Advertisement> listAdvertisementByType(AdvertisementType advertisementType) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("adType", advertisementType));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Advertisement> listAdvertisementByType(AdvertisementType advertisementType, boolean isActive) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("adType", advertisementType));
		criteria.add(Restrictions.eq("active", isActive));
		return criteria.list();
	}

	public List<Advertisement> listAdvertisementByType(AdvertisementType advertisementType, Class<? extends Good> type) {
		// TODO complete and test (see .class attribute)
//		StringBuilder hql = new StringBuilder();
//		hql.append("FROM " + getPersistentClass().getName() + " ad ");
//		hql.append("WHERE ad.adType = :AD_TYPE ");
//		hql.append("WHERE ad.good)
//		
//		Query query = getSession().createQuery(hql.toString());
//		return query.list();
		return null;
	}

}

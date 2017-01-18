package com.tsystems.ecrono.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsystems.ecrono.domain.DorsalEntity;

@Repository
@Transactional
public class HibernateClassificationRepository implements ClassificationRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public HibernateClassificationRepository(EntityManager entityManager) {
	super();
	this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DorsalEntity> getClassificationForRace(Long raceId) {

	return entityManager.unwrap(Session.class).createCriteria(DorsalEntity.class)//
		.add(Restrictions.eq("raceId", raceId))//
		.setFetchMode("runner", FetchMode.JOIN)//
		.setFetchMode("timeStamps", FetchMode.JOIN)//
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}

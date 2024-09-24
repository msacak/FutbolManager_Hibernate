package com.ajwalker.repository;

import com.ajwalker.entity.Manager;
import com.ajwalker.entity.Team;
import com.ajwalker.entity.TransferOffer;
import com.ajwalker.utility.HibernateConnection;

import java.util.List;

public class TransferOfferRepository extends RepositoryManager<TransferOffer,Long> {

    private static TransferOfferRepository instance;
    private TransferOfferRepository() {
        super(TransferOffer.class);
    }


    public static TransferOfferRepository getInstance() {
        if (instance == null) {
            instance = new TransferOfferRepository();
        }
        return instance;
    }

    public List<TransferOffer> displayOffersForReceiver(Manager manager) {
        String hql = "from TransferOffer where receiver = :receiver";
        return HibernateConnection.em.createQuery(hql, TransferOffer.class)
                .setParameter("receiver", manager.getTeam())
                .getResultList();
    }
}

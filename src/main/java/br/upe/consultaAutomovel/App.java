package br.upe.consultaAutomovel;

import java.util.List;

import javax.lang.model.SourceVersion;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.cache.spi.QueryResultsCache;

import br.upe.consultaAutomovel.models.Automovel;
import br.upe.consultaAutomovel.utils.JPAUtil;

public class App {
    public static void main(String[] args) {
        Automovel auto = new Automovel();
        auto.setMarca("Fiat");
        auto.setModelo("Ferrari");
        auto.setAnoFabricacao(2016);

        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery("select a from Automovel a", Automovel.class);
        List<Automovel> autos = q.getResultList();
        
        for(Automovel a : autos)
        {
            System.out.println(a.getMarca());
            System.out.println(a.getModelo());
        }

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(auto);
        tx.commit();

        em.close();
    }
}
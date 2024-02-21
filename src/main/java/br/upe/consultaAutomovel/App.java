package br.upe.consultaAutomovel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.upe.consultaAutomovel.models.Automovel;
import br.upe.consultaAutomovel.utils.JPAUtil;

public class App {
    public static void main(String[] args) {
        Automovel auto = new Automovel();
        auto.setMarca("Fiat");
        auto.setModelo("Ferrari");
        auto.setAnoFabricacao(2016);

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(auto);
        tx.commit();

        em.close();
    }
}
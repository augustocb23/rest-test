package com.augus.restTest.persistence.dao;

import com.augus.restTest.domain.Produto;
import com.augus.restTest.domain.helpers.BuscaLazyParams;
import com.augus.restTest.domain.helpers.SortOrder;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProdutoDaoImpl extends AbstractDao<Produto, Long> implements ProdutoDao {
    @Override
    public List<Produto> findPage(BuscaLazyParams params) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
        Root<Produto> root = criteriaQuery.from(Produto.class);

        //filtra pelo nome
        criteriaQuery.where(builder.like(root.get("nome"), params.getFilter()));

        //define a ordem
        Path path = root.get(params.getSortColumn());
        criteriaQuery.orderBy(params.getSortOrder() == SortOrder.ASC ?
                builder.asc(path) :
                builder.desc(path));

        TypedQuery<Produto> query = getEntityManager().createQuery(criteriaQuery);
        //define os limites da consulta
        query.setMaxResults(params.getPageSize());
        query.setFirstResult(params.getPageNumber() * params.getPageSize());

        return query.getResultList();
    }
}

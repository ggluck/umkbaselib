package com.umk.base.service;

import com.umk.base.repository.DefaultRepository;
import com.umk.base.repository.QueryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract class BaseService<Entity extends Serializable> {
    protected abstract <T extends DefaultRepository<Entity>> T repository();
    public Entity findOne(Long id){
        return repository().findOne(id);
    }
    public void delete(Long id){
       repository().delete(id);
    }
    public void delete(Entity entity){
        repository().delete(entity);
    }
    public void deleteByIds(Collection<Long> ids){
        for(Long id :ids){
           delete(id);
        }
    }
    public void delete(Collection<Entity> entities){
        repository().delete(entities);
    }

    public Page<Entity> findAll(List<QueryFilter> filters,Pageable pageable){
        return repository().findAll(filters,pageable);
    }
    public List<Entity> findAll(List<QueryFilter> filters){
        return repository().findAll(filters);
    }
    public Entity save(Entity entity) {
       return repository().save(entity);
    }
    public Class<Entity> getEntity(){
    	return repository().getEntity();
    }

}

package com.global.book.basic;

import java.util.List;
import java.util.Optional;

import javax.persistence.MappedSuperclass;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.global.book.entity.Auther;
import com.global.book.error.RecordNotFoundExecption;
import com.global.book.error.RecordNotFoundExecption;

 @MappedSuperclass
 public class BasicService<T extends BasicEntity<ID>, ID extends Number> {

	@Autowired
	private BasicRepository<T, ID> basicRepository;
	@Autowired
	private MessageSource messageSource;

//	public T findById(ID id) {
//
//		return basicRepository.findById(id).orElseThrow();
//	}
//	
	public T findById(ID id) {

		Optional<T> entity = basicRepository.findById(id);
		if (entity.isPresent()) {
			return entity.get();
			
		} else {
//			Locale local = new Locale("en");
			String [] msgParam = {id.toString()};
			String msg = messageSource.getMessage("validation.recoredNotFound.message", msgParam,LocaleContextHolder.getLocale());
			
			throw new RecordNotFoundExecption(msg);
		}

	}
//	public T findById(ID id) {
//		
//	 
//	       if(basicRepository.findById(id).isPresent()) {
//	    	   return basicRepository.findById(id).orElseThrow();
//	       }else
//	       {
//	    	   throw new RecordNotFoundExecption("this record with id = "+ id +"not found");
//	       }
//			
//		}

	public List<T> findAll() {

		return basicRepository.findAll();
	}

	public T insert(T entity) {
		if (entity.getId() != null) {
			throw new RuntimeException();
		}

		return basicRepository.save(entity);
	}

	public List<T> insertAll(List<T> entity) {

		return basicRepository.saveAll(entity);
	}

	public T update(T entity) {

		return basicRepository.save(entity);
	}

	public void deleteById(ID id) {

		basicRepository.deleteById(id);
	}
	

}

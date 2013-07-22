package net.sf.gazpachosurvey.repository.support;

import java.io.Serializable;
import java.util.List;

import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends
		JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
	
	Page<T> findByExample(T example, Pageable pageable);

	Page<T> findByExample(T example, List<Range<T, ?>> ranges, Pageable pageable);

	List<T> find();

	List<T> find(String pattern);
	
	List<T> findByExample(T entity, SearchParameters sp);
}
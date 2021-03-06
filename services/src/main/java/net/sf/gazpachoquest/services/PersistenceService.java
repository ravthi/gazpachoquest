/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services;

import java.util.List;
import java.util.Optional;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.qbe.SearchParameters;

import org.springframework.data.domain.Page;

public interface PersistenceService<T extends Persistable> {
    long count();

    void delete(Integer id);

    List<T> findAll();

    List<T> findByExample(T example, SearchParameters searchParameters);

    T findOne(Integer id);

    Optional<T> findOneByExample(T example, SearchParameters searchParameters);

    T save(T entity);

    void deleteByExample(T entity, SearchParameters searchParameters);

    Page<T> findPaginated(Integer pageNumber, Integer size);

    User getAuthenticatedUser();
}

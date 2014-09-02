/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.domain.audit;

import net.sf.gazpachoquest.domain.user.User;

import org.springframework.data.domain.AuditorAware;

public class SimpleAuditorAware implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {
        return User.with().id(1).build();
    }
}

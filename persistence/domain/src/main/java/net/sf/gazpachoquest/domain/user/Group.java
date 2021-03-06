package net.sf.gazpachoquest.domain.user;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import net.sf.gazpachoquest.domain.support.AbstractAuditable;

@Entity
@Table(name = "groups")
public class Group extends AbstractAuditable {

    private static final long serialVersionUID = 2209952243152855595L;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private final Set<User> users = new HashSet<User>();

    public Group() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void assignUser(User user) {
        users.add(user);
        user.addGroup(this);
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String description;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Group build() {
            Group group = new Group();
            group.setId(id);
            group.name = name;
            group.description = description;
            return group;
        }
    }
}

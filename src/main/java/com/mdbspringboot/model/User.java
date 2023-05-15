package com.mdbspringboot.model;

import java.util.List;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {
    @Id
    private String id;    
    private String name;
    private List<Role> roles;
    private List<Resource> resource;

    public List<Resource> getResource() {
        return resource;
    }
    public void setResource(List<Resource> resource) {
        this.resource = resource;
    }
    public User(){}
    public User(String id, String name) {
        super();
        this.id = id;
        this.name = name;
        
    }
    @PersistenceCreator
    public User(String id, String name, List<Role> roles) {
        super();
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
   


    public class Role {

        private String roleId;
        private String facilityId;
        private String facilityName; 
        private String type;
        private String market;

        public Role(){}
        
        @PersistenceCreator
        public Role(String roleId, String facilityId, String type, String market, String facilityName) {
            this.roleId = roleId;
            this.facilityId = facilityId;
            this.type = type;
            this.market = market;
            this.facilityName = facilityName;
        }
        public String getRoleId() {
            return roleId;
        }
        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }
        public String getFacilityId() {
            return facilityId;
        }
        public void setFacilityId(String facilityId) {
            this.facilityId = facilityId;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public String getMarket() {
            return market;
        }
        public void setMarket(String market) {
            this.market = market;
        }
    
        public String getFacilityName() {
            return facilityName;
        }

        public void setFacilityName(String facilityName) {
            this.facilityName = facilityName;
        }
    }
    

}

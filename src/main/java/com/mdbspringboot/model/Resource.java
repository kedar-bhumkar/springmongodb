package com.mdbspringboot.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("resources")
public class Resource {

    @Id
    private String id;
    private String name;
    private String type;
    private String default_access;
    private String status;
    private List<Metadata> metadata;

   

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }



    public Resource(String id, String name, String type, String default_access, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.default_access = default_access;
        this.status = status;
    }

    public String getDefault_access() {
        return default_access;
    }

    public void setDefault_access(String default_access) {
        this.default_access = default_access;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public class Metadata {
        private String docName;
        private String docType;
        private String docDescription;


        public Metadata(String docName, String docType, String docDescription) {
            this.docName = docName;
            this.docType = docType;
            this.docDescription = docDescription;
        }

        public String getDocDescription() {
            return docDescription;
        }

        public void setDocDescription(String docDescription) {
            this.docDescription = docDescription;
        }        

        public String getDocName() {
            return docName;
        }

        public void setDocName(String docName) {
            this.docName = docName;
        }

        public String getDocType() {
            return docType;
        }

        public void setDocType(String docType) {
            this.docType = docType;
        }

    }

}
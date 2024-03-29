/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.dto;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */

import java.util.Date;
import java.util.Objects;

public class AbstractTransfer {
  
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    private String uuid;
    private int jpaVersion;
    
    public AbstractTransfer() {
    }

    public AbstractTransfer(String uuid, int jpaVersion) {
        this.uuid = uuid;
        this.jpaVersion = jpaVersion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getJpaVersion() {
        return jpaVersion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isNew() {
        return uuid == null;
    }

    public void setJpaVersion(int jpaVersion) {
        this.jpaVersion = jpaVersion;
    }
    

    @Override
    public int hashCode() {
        if (uuid == null) {
            throw new IllegalStateException("UUID not set");
        }
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.uuid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractTransfer other = (AbstractTransfer) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AbstractTransfer{" + "id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", uuid=" + uuid + ", jpaVersion=" + jpaVersion + '}';
    }
}



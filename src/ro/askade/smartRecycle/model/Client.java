package ro.askade.smartRecycle.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by AdrianIonita on 3/8/2017.
 */
public class Client {

    private BigInteger clientId;
    private String clientName;
    private BigInteger clientCategoryId;
    private Date creationDate;
    private String createdBy;
    private Date lastUpdateDate;
    private String lastUpdatedBy;

    /**
     * @return
     */
    @Column(name = "client_id", updatable=false)
    @Id
    @GeneratedValue
    public BigInteger getClientId() {
        return clientId;
    }

    /**
     * @param clientId
     */
    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    /**
     * @return
     */
    @Column (name = "client_name")
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return
     */
    @Column (name = "client_category_id")
    public BigInteger getClientCategoryId() {
        return clientCategoryId;
    }

    /**
     * @param clientCategoryId
     */
    public void setClientCategoryId(BigInteger clientCategoryId) {
        this.clientCategoryId = clientCategoryId;
    }

    /**
     * @return
     */
    @Column (name = "creation_date", updatable=false)
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return
     */
    @Column (name = "created_by", updatable=false)
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return
     */
    @Column (name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Version
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * @param lastUpdateDate
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * @return
     */
    @Column(name = "last_updated_by")
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * @param lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}

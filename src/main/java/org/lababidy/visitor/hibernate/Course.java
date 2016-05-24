/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lababidy.visitor.hibernate;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohannad Lababidy <m.lababidy@gmail.com>
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAllCource", query = "SELECT c FROM Course c Order By c.cid "),
    @NamedQuery(name = "Course.findByCid", query = "SELECT c FROM Course c WHERE c.cid like CONCAT('%',cid,'%')"),
    @NamedQuery(name = "Course.findByCname", query = "SELECT c FROM Course c WHERE c.cname like CONCAT('%',cname,'%')")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Course.listCourseNames", query = "SELECT cname FROM course ORDER BY cname"),
    @NamedNativeQuery(name = "Course.findLikeCname", query = "SELECT * FROM course as e "
            + "WHERE UPPER(name) LIKE ? "
            + "ORDER BY cname"),
    @NamedNativeQuery(name = "Course.insertCource", query = "INSERT INTO course (cname,cnotes) VALUES (?, ?)"),
    @NamedNativeQuery(name = "Course.UpdataCource", query = "UPDATE course SET cname=?,cnotes=? WHERE cid=?"),
    @NamedNativeQuery(name = "Course.deleteCource", query = "DELETE FROM course WHERE cid=?")

})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid")
    private Integer cid;
    @Size(max = 45)
    @Column(name = "cname")
    private String cname;
    @Lob
    @Size(max = 65535)
    @Column(name = "cnotes")
    private String cnotes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vcid")
    private Collection<Visitor> visitorCollection;

    public Course() {
    }

    public Course(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCnotes() {
        return cnotes;
    }

    public void setCnotes(String cnotes) {
        this.cnotes = cnotes;
    }

    @XmlTransient
    public Collection<Visitor> getVisitorCollection() {
        return visitorCollection;
    }

    public void setVisitorCollection(Collection<Visitor> visitorCollection) {
        this.visitorCollection = visitorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.lababidy.visitor.hibernate.Course[ cid=" + cid + " ]";
    }

}

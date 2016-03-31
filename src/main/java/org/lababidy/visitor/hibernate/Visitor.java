/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lababidy.visitor.hibernate;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohannad Lababidy <m.lababidy@gmail.com>
 */
@Entity
@Table(name = "visitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitor.findAll", query = "SELECT v FROM Visitor v"),
    @NamedQuery(name = "Visitor.findByVid", query = "SELECT v FROM Visitor v WHERE v.vid = :vid"),
    @NamedQuery(name = "Visitor.findByVfname", query = "SELECT v FROM Visitor v WHERE v.vfname = :vfname"),
    @NamedQuery(name = "Visitor.findByVlname", query = "SELECT v FROM Visitor v WHERE v.vlname = :vlname"),
    @NamedQuery(name = "Visitor.findByVmobile", query = "SELECT v FROM Visitor v WHERE v.vmobile = :vmobile"),
    @NamedQuery(name = "Visitor.findByVtelephone", query = "SELECT v FROM Visitor v WHERE v.vtelephone = :vtelephone"),
    @NamedQuery(name = "Visitor.findByVemail", query = "SELECT v FROM Visitor v WHERE v.vemail = :vemail")})
public class Visitor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vid")
    private Integer vid;
    @Size(max = 45)
    @Column(name = "vfname")
    private String vfname;
    @Size(max = 45)
    @Column(name = "vlname")
    private String vlname;
    @Size(max = 45)
    @Column(name = "vmobile")
    private String vmobile;
    @Size(max = 45)
    @Column(name = "vtelephone")
    private String vtelephone;
    @Size(max = 45)
    @Column(name = "vemail")
    private String vemail;
    @Lob
    @Size(max = 65535)
    @Column(name = "vnotes")
    private String vnotes;
    @JoinColumn(name = "vcid", referencedColumnName = "cid")
    @ManyToOne(optional = false)
    private Course vcid;

    public Visitor() {
    }

    public Visitor(Integer vid) {
        this.vid = vid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVfname() {
        return vfname;
    }

    public void setVfname(String vfname) {
        this.vfname = vfname;
    }

    public String getVlname() {
        return vlname;
    }

    public void setVlname(String vlname) {
        this.vlname = vlname;
    }

    public String getVmobile() {
        return vmobile;
    }

    public void setVmobile(String vmobile) {
        this.vmobile = vmobile;
    }

    public String getVtelephone() {
        return vtelephone;
    }

    public void setVtelephone(String vtelephone) {
        this.vtelephone = vtelephone;
    }

    public String getVemail() {
        return vemail;
    }

    public void setVemail(String vemail) {
        this.vemail = vemail;
    }

    public String getVnotes() {
        return vnotes;
    }

    public void setVnotes(String vnotes) {
        this.vnotes = vnotes;
    }

    public Course getVcid() {
        return vcid;
    }

    public void setVcid(Course vcid) {
        this.vcid = vcid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vid != null ? vid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitor)) {
            return false;
        }
        Visitor other = (Visitor) object;
        if ((this.vid == null && other.vid != null) || (this.vid != null && !this.vid.equals(other.vid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.lababidy.visitor.hibernate.Visitor[ vid=" + vid + " ]";
    }

}

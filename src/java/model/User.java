/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "user_")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findByUuid", query = "SELECT u FROM User u WHERE u.uuid = :uuid"),
	@NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid"),
	@NamedQuery(name = "User.findByCompanyid", query = "SELECT u FROM User u WHERE u.companyid = :companyid"),
	@NamedQuery(name = "User.findByCreatedate", query = "SELECT u FROM User u WHERE u.createdate = :createdate"),
	@NamedQuery(name = "User.findByModifieddate", query = "SELECT u FROM User u WHERE u.modifieddate = :modifieddate"),
	@NamedQuery(name = "User.findByDefaultuser", query = "SELECT u FROM User u WHERE u.defaultuser = :defaultuser"),
	@NamedQuery(name = "User.findByContactid", query = "SELECT u FROM User u WHERE u.contactid = :contactid"),
	@NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
	@NamedQuery(name = "User.findByPasswordencrypted", query = "SELECT u FROM User u WHERE u.passwordencrypted = :passwordencrypted"),
	@NamedQuery(name = "User.findByPasswordreset", query = "SELECT u FROM User u WHERE u.passwordreset = :passwordreset"),
	@NamedQuery(name = "User.findByPasswordmodifieddate", query = "SELECT u FROM User u WHERE u.passwordmodifieddate = :passwordmodifieddate"),
	@NamedQuery(name = "User.findByDigest", query = "SELECT u FROM User u WHERE u.digest = :digest"),
	@NamedQuery(name = "User.findByReminderqueryquestion", query = "SELECT u FROM User u WHERE u.reminderqueryquestion = :reminderqueryquestion"),
	@NamedQuery(name = "User.findByReminderqueryanswer", query = "SELECT u FROM User u WHERE u.reminderqueryanswer = :reminderqueryanswer"),
	@NamedQuery(name = "User.findByGracelogincount", query = "SELECT u FROM User u WHERE u.gracelogincount = :gracelogincount"),
	@NamedQuery(name = "User.findByScreenname", query = "SELECT u FROM User u WHERE u.screenname = :screenname"),
	@NamedQuery(name = "User.findByEmailaddress", query = "SELECT u FROM User u WHERE u.emailaddress = :emailaddress"),
	@NamedQuery(name = "User.findByFacebookid", query = "SELECT u FROM User u WHERE u.facebookid = :facebookid"),
	@NamedQuery(name = "User.findByOpenid", query = "SELECT u FROM User u WHERE u.openid = :openid"),
	@NamedQuery(name = "User.findByPortraitid", query = "SELECT u FROM User u WHERE u.portraitid = :portraitid"),
	@NamedQuery(name = "User.findByLanguageid", query = "SELECT u FROM User u WHERE u.languageid = :languageid"),
	@NamedQuery(name = "User.findByTimezoneid", query = "SELECT u FROM User u WHERE u.timezoneid = :timezoneid"),
	@NamedQuery(name = "User.findByGreeting", query = "SELECT u FROM User u WHERE u.greeting = :greeting"),
	@NamedQuery(name = "User.findByComments", query = "SELECT u FROM User u WHERE u.comments = :comments"),
	@NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
	@NamedQuery(name = "User.findByMiddlename", query = "SELECT u FROM User u WHERE u.middlename = :middlename"),
	@NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
	@NamedQuery(name = "User.findByJobtitle", query = "SELECT u FROM User u WHERE u.jobtitle = :jobtitle"),
	@NamedQuery(name = "User.findByLogindate", query = "SELECT u FROM User u WHERE u.logindate = :logindate"),
	@NamedQuery(name = "User.findByLoginip", query = "SELECT u FROM User u WHERE u.loginip = :loginip"),
	@NamedQuery(name = "User.findByLastlogindate", query = "SELECT u FROM User u WHERE u.lastlogindate = :lastlogindate"),
	@NamedQuery(name = "User.findByLastloginip", query = "SELECT u FROM User u WHERE u.lastloginip = :lastloginip"),
	@NamedQuery(name = "User.findByLastfailedlogindate", query = "SELECT u FROM User u WHERE u.lastfailedlogindate = :lastfailedlogindate"),
	@NamedQuery(name = "User.findByFailedloginattempts", query = "SELECT u FROM User u WHERE u.failedloginattempts = :failedloginattempts"),
	@NamedQuery(name = "User.findByLockout", query = "SELECT u FROM User u WHERE u.lockout = :lockout"),
	@NamedQuery(name = "User.findByLockoutdate", query = "SELECT u FROM User u WHERE u.lockoutdate = :lockoutdate"),
	@NamedQuery(name = "User.findByAgreedtotermsofuse", query = "SELECT u FROM User u WHERE u.agreedtotermsofuse = :agreedtotermsofuse"),
	@NamedQuery(name = "User.findByEmailaddressverified", query = "SELECT u FROM User u WHERE u.emailaddressverified = :emailaddressverified"),
	@NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status")})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Size(max = 75)
    @Column(name = "uuid_")
	private String uuid;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
	private Long userid;
	@Column(name = "companyid")
	private BigInteger companyid;
	@Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	@Column(name = "modifieddate")
    @Temporal(TemporalType.TIMESTAMP)
	private Date modifieddate;
	@Column(name = "defaultuser")
	private Boolean defaultuser;
	@Column(name = "contactid")
	private BigInteger contactid;
	@Size(max = 75)
    @Column(name = "password_")
	private String password;
	@Column(name = "passwordencrypted")
	private Boolean passwordencrypted;
	@Column(name = "passwordreset")
	private Boolean passwordreset;
	@Column(name = "passwordmodifieddate")
    @Temporal(TemporalType.TIMESTAMP)
	private Date passwordmodifieddate;
	@Size(max = 255)
    @Column(name = "digest")
	private String digest;
	@Size(max = 75)
    @Column(name = "reminderqueryquestion")
	private String reminderqueryquestion;
	@Size(max = 75)
    @Column(name = "reminderqueryanswer")
	private String reminderqueryanswer;
	@Column(name = "gracelogincount")
	private Integer gracelogincount;
	@Size(max = 75)
    @Column(name = "screenname")
	private String screenname;
	@Size(max = 75)
    @Column(name = "emailaddress")
	private String emailaddress;
	@Column(name = "facebookid")
	private BigInteger facebookid;
	@Size(max = 1024)
    @Column(name = "openid")
	private String openid;
	@Column(name = "portraitid")
	private BigInteger portraitid;
	@Size(max = 75)
    @Column(name = "languageid")
	private String languageid;
	@Size(max = 75)
    @Column(name = "timezoneid")
	private String timezoneid;
	@Size(max = 255)
    @Column(name = "greeting")
	private String greeting;
	@Size(max = 2147483647)
    @Column(name = "comments")
	private String comments;
	@Size(max = 75)
    @Column(name = "firstname")
	private String firstname;
	@Size(max = 75)
    @Column(name = "middlename")
	private String middlename;
	@Size(max = 75)
    @Column(name = "lastname")
	private String lastname;
	@Size(max = 100)
    @Column(name = "jobtitle")
	private String jobtitle;
	@Column(name = "logindate")
    @Temporal(TemporalType.TIMESTAMP)
	private Date logindate;
	@Size(max = 75)
    @Column(name = "loginip")
	private String loginip;
	@Column(name = "lastlogindate")
    @Temporal(TemporalType.TIMESTAMP)
	private Date lastlogindate;
	@Size(max = 75)
    @Column(name = "lastloginip")
	private String lastloginip;
	@Column(name = "lastfailedlogindate")
    @Temporal(TemporalType.TIMESTAMP)
	private Date lastfailedlogindate;
	@Column(name = "failedloginattempts")
	private Integer failedloginattempts;
	@Column(name = "lockout")
	private Boolean lockout;
	@Column(name = "lockoutdate")
    @Temporal(TemporalType.TIMESTAMP)
	private Date lockoutdate;
	@Column(name = "agreedtotermsofuse")
	private Boolean agreedtotermsofuse;
	@Column(name = "emailaddressverified")
	private Boolean emailaddressverified;
	@Column(name = "status")
	private Integer status;

	public User() {
	}

	public User(Long userid) {
		this.userid = userid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public BigInteger getCompanyid() {
		return companyid;
	}

	public void setCompanyid(BigInteger companyid) {
		this.companyid = companyid;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Boolean getDefaultuser() {
		return defaultuser;
	}

	public void setDefaultuser(Boolean defaultuser) {
		this.defaultuser = defaultuser;
	}

	public BigInteger getContactid() {
		return contactid;
	}

	public void setContactid(BigInteger contactid) {
		this.contactid = contactid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getPasswordencrypted() {
		return passwordencrypted;
	}

	public void setPasswordencrypted(Boolean passwordencrypted) {
		this.passwordencrypted = passwordencrypted;
	}

	public Boolean getPasswordreset() {
		return passwordreset;
	}

	public void setPasswordreset(Boolean passwordreset) {
		this.passwordreset = passwordreset;
	}

	public Date getPasswordmodifieddate() {
		return passwordmodifieddate;
	}

	public void setPasswordmodifieddate(Date passwordmodifieddate) {
		this.passwordmodifieddate = passwordmodifieddate;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getReminderqueryquestion() {
		return reminderqueryquestion;
	}

	public void setReminderqueryquestion(String reminderqueryquestion) {
		this.reminderqueryquestion = reminderqueryquestion;
	}

	public String getReminderqueryanswer() {
		return reminderqueryanswer;
	}

	public void setReminderqueryanswer(String reminderqueryanswer) {
		this.reminderqueryanswer = reminderqueryanswer;
	}

	public Integer getGracelogincount() {
		return gracelogincount;
	}

	public void setGracelogincount(Integer gracelogincount) {
		this.gracelogincount = gracelogincount;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public BigInteger getFacebookid() {
		return facebookid;
	}

	public void setFacebookid(BigInteger facebookid) {
		this.facebookid = facebookid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public BigInteger getPortraitid() {
		return portraitid;
	}

	public void setPortraitid(BigInteger portraitid) {
		this.portraitid = portraitid;
	}

	public String getLanguageid() {
		return languageid;
	}

	public void setLanguageid(String languageid) {
		this.languageid = languageid;
	}

	public String getTimezoneid() {
		return timezoneid;
	}

	public void setTimezoneid(String timezoneid) {
		this.timezoneid = timezoneid;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public Date getLogindate() {
		return logindate;
	}

	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public Date getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(Date lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	public String getLastloginip() {
		return lastloginip;
	}

	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}

	public Date getLastfailedlogindate() {
		return lastfailedlogindate;
	}

	public void setLastfailedlogindate(Date lastfailedlogindate) {
		this.lastfailedlogindate = lastfailedlogindate;
	}

	public Integer getFailedloginattempts() {
		return failedloginattempts;
	}

	public void setFailedloginattempts(Integer failedloginattempts) {
		this.failedloginattempts = failedloginattempts;
	}

	public Boolean getLockout() {
		return lockout;
	}

	public void setLockout(Boolean lockout) {
		this.lockout = lockout;
	}

	public Date getLockoutdate() {
		return lockoutdate;
	}

	public void setLockoutdate(Date lockoutdate) {
		this.lockoutdate = lockoutdate;
	}

	public Boolean getAgreedtotermsofuse() {
		return agreedtotermsofuse;
	}

	public void setAgreedtotermsofuse(Boolean agreedtotermsofuse) {
		this.agreedtotermsofuse = agreedtotermsofuse;
	}

	public Boolean getEmailaddressverified() {
		return emailaddressverified;
	}

	public void setEmailaddressverified(Boolean emailaddressverified) {
		this.emailaddressverified = emailaddressverified;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userid != null ? userid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.User[ userid=" + userid + " ]";
	}
	
}

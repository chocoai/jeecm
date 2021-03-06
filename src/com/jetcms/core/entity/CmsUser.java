package com.jetcms.core.entity;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.jetcms.cms.entity.assist.CmsJobApply;
import com.jetcms.cms.entity.main.Channel;
import com.jetcms.cms.entity.main.Content;
import com.jetcms.cms.entity.main.ContentBuy;
import com.jetcms.common.hibernate4.PriorityInterface;
import com.jetcms.common.util.DateUtils;
import com.jetcms.core.entity.base.BaseCmsUser;

public class CmsUser extends BaseCmsUser implements PriorityInterface {
	private static final long serialVersionUID = 1L;
	public Byte getCheckStep(Integer siteId) {
		CmsUserSite us = getUserSite(siteId);
		if (us != null) {
			return getUserSite(siteId).getCheckStep();
		} else {
			return null;
		}
	}
	
	public Integer getWorkflowStep(CmsWorkflow flow){
		Integer step=0;
		if(flow!=null){
			List<CmsWorkflowNode> nodes=flow.getNodes();
			Integer size=nodes.size();
			for (step = size; step > 0; step--) {
				CmsWorkflowNode node = nodes.get(step - 1);
				CmsRole nodeRole=node.getRole();
				Set<CmsRole>roles=new HashSet<CmsRole>();
				roles.add(nodeRole);
				if (CollectionUtils.containsAny(roles,getRoles())) {
					return step;
				}
			}
		}
		return step;
	}

	public String getRealname() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getRealname();
		} else {
			return null;
		}
	}
	public void setRealnameJd(String realName){
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			ext.setRealname(realName);
		} else {
			ext.setRealname(null);
		}
	}

	public Boolean getGender() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getGender();
		} else {
			return null;
		}
	}

	public Date getBirthday() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getBirthday();
		} else {
			return null;
		}
	}

	public String getIntro() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getIntro();
		} else {
			return null;
		}
	}

	public String getComefrom() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getComefrom();
		} else {
			return null;
		}
	}

	public String getQq() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getQq();
		} else {
			return null;
		}
	}

	public String getMsn() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getMsn();
		} else {
			return null;
		}
	}

	public String getPhone() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getPhone();
		} else {
			return null;
		}
	}

	public String getMobile() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getMobile();
		} else {
			return null;
		}
	}
	public String getUserImg() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getUserImg();
		} else {
			return null;
		}
	}
	public String getUserSignature() {
		CmsUserExt ext = getUserExt();
		if (ext != null) {
			return ext.getUserSignature();
		} else {
			return null;
		}
	}
	
	public String getAccountWeixin() {
		CmsUserAccount ext = getUserAccount();
		if (ext != null) {
			return ext.getAccountWeixin();
		} else {
			return null;
		}
	}
	
	public String getAccountAlipy() {
		CmsUserAccount ext = getUserAccount();
		if (ext != null) {
			return ext.getAccountAlipy();
		} else {
			return null;
		}
	}
	
	public Short getDrawAccount() {
		CmsUserAccount ext = getUserAccount();
		if (ext != null) {
			return ext.getDrawAccount();
		} else {
			return 0;
		}
	}

	public CmsUserExt getUserExt() {
		Set<CmsUserExt> set = getUserExtSet();
		if (set != null && set.size() > 0) {
			return set.iterator().next();
		} else {
			return null;
		}
	}
	
	public CmsUserAccount getUserAccount() {
		Set<CmsUserAccount> set = getUserAccountSet();
		if (set != null && set.size() > 0) {
			return set.iterator().next();
		} else {
			return null;
		}
	}

	public CmsUserSite getUserSite(Integer siteId) {
		Set<CmsUserSite> set = getUserSites();
		for (CmsUserSite us : set) {
			if (us.getSite().getId().equals(siteId)) {
				return us;
			}
		}
		return null;
	}
	
	public CmsUserResume getUserResume(){
		Set<CmsUserResume>set=getUserResumeSet();
		if(set!=null&&set.size()>0){
			return set.iterator().next();
		}else{
			return null;
		}
	}

	public Set<Channel> getChannels(Integer siteId) {
		Set<Channel> set = getChannels();
		Set<Channel> results = new HashSet<Channel>();
		for (Channel c : set) {
			if (c.getSite().getId().equals(siteId)) {
				results.add(c);
			}
		}
		return results;
	}
	
	public Set<Channel> getChannelsByDepartment(Integer siteId) {
		Set<Channel> set;
		Set<Channel> results = new HashSet<Channel>();
		if(getDepartment()!=null){
			set=getDepartment().getChannels();
			for (Channel c : set) {
				if (c.getSite().getId().equals(siteId)) {
					results.add(c);
				}
			}
		}
		return results;
	}

	public Integer[] getChannelIds() {
		Set<Channel> channels = getChannels();
		return Channel.fetchIds(channels);
	}

	public Set<Integer> getChannelIds(Integer siteId) {
		Set<Channel> channels = getChannels();
		Set<Integer> ids = new HashSet<Integer>();
		for (Channel c : channels) {
			if (c.getSite().getId().equals(siteId)) {
				ids.add(c.getId());
			}
		}
		return ids;
	}

	public Integer[] getRoleIds() {
		Set<CmsRole> roles = getRoles();
		return CmsRole.fetchIds(roles);
	}
	

	public Integer[] getSiteIds() {
		Set<CmsSite> sites = getSites();
		return CmsSite.fetchIds(sites);
	}

	public void addToRoles(CmsRole role) {
		if (role == null) {
			return;
		}
		Set<CmsRole> set = getRoles();
		if (set == null) {
			set = new HashSet<CmsRole>();
			setRoles(set);
		}
		set.add(role);
	}
	public void addToCatalog(CmsCatalog catalog) {
		if (catalog == null) {
			return;
		}
		Set<CmsCatalog> set = getCatalog();
		if (set == null) {
			set = new HashSet<CmsCatalog>();
			setCatalog(set);
		}
		set.add(catalog);
	}

	public void addToChannels(Channel channel) {
		if (channel == null) {
			return;
		}
		Set<Channel> set = getChannels();
		if (set == null) {
			set = new HashSet<Channel>();
			setChannels(set);
		}
		set.add(channel);
	}
	
	public void addToControlChannels(Channel channel) {
		if (channel == null) {
			return;
		}
		Set<Channel> set = getControlChannels();
		if (set == null) {
			set = new HashSet<Channel>();
			setControlChannels(set);
		}
		set.add(channel);
	}
	
	public void addToCollection(Content content) {
		if (content == null) {
			return;
		}
		Set<Content> set =getCollectContents();
		if (set == null) {
			set = new HashSet<Content>();
			setCollectContents(set);
		}
		set.add(content);
	}
	public void delFromCollection(Content content) {
		if (content == null) {
			return;
		}
		Set<Content> set =getCollectContents();
		if (set == null) {
			return;
		}else{
			set.remove(content);
		}
	}
	public void clearCollection() {
		getCollectContents().clear();
	}

	public Set<CmsSite> getSites() {
		Set<CmsUserSite> userSites = getUserSites();
		Set<CmsSite> sites = new HashSet<CmsSite>(userSites.size());
		for (CmsUserSite us : userSites) {
			sites.add(us.getSite());
		}
		return sites;
	}
	
	public Set<Content>getApplyContent(){
		Set<CmsJobApply>jobApplys=getJobApplys();
		Set<Content>contents=new HashSet<Content>(jobApplys.size());
		for(CmsJobApply apply:jobApplys){
			contents.add(apply.getContent());
		}
		return contents;
	}
	
	public boolean hasApplyToday(Integer contentId){
		Date now=Calendar.getInstance().getTime();
		Set<CmsJobApply>jobApplys=getJobApplys();
		for(CmsJobApply apply:jobApplys){
			if(DateUtils.isInDate(now, apply.getApplyTime())&&apply.getContent().getId().equals(contentId)){
				return true;
			}
		}
		return false;
	}

	public boolean isSuper() {
		Set<CmsRole> roles = getRoles();
		if (roles == null) {
			return false;
		}
		for (CmsRole role : getRoles()) {
			if (role.getAll()) {
				return true;
			}
		}
		return false;
	}

	public Set<String> getPerms(Integer siteId,Set<String>perms) {
		if(getDisabled()){
			return null;
		}
		Set<CmsUserSite> userSits=getUserSites();
		if(userSits==null){
			return null;
		}
		Set<CmsRole> roles = getRoles();
		if (roles == null) {
			return null;
		}
		boolean hasSitePermission=false;
		for(CmsUserSite cus:userSits){
			if(cus.getSite().getId().equals(siteId)){
				hasSitePermission=true;
			}
		}
		if(!hasSitePermission){
			return null;
		}
		boolean isSuper = false;
		Set<String> allPerms = new HashSet<String>();
		for (CmsRole role : getRoles()) {
			if(role.getAll()){
				isSuper=true;
				break;
			}
			allPerms.addAll(role.getPerms());
		}
		if (isSuper) {
			allPerms.clear();
			allPerms.add("*");
		}
		return allPerms;
	}

	/**
	 * 是否允许上传，根据每日限额
	 * 
	 * @param size
	 * @return
	 */
	public boolean isAllowPerDay(int size) {
		int allowPerDay = getGroup().getAllowPerDay();
		if (allowPerDay == 0) {
			return true;
		}
		if (getUploadDate() != null) {
			if (isToday(getUploadDate())) {
				size += getUploadSize();
			}
		}
		return allowPerDay >= size;
	}

	/**
	 * 是否允许上传，根据文件大小
	 * 
	 * @param size
	 *            文件大小，单位KB
	 * @return
	 */
	public boolean isAllowMaxFile(int size) {
		int allowPerFile = getGroup().getAllowMaxFile();
		if (allowPerFile == 0) {
			return true;
		} else {
			return allowPerFile >= size;
		}
	}

	/**
	 * 是否允许上传后缀
	 * 
	 * @param ext
	 * @return
	 */
	public boolean isAllowSuffix(String ext) {
		return getGroup().isAllowSuffix(ext);
	}

	public void forMember(UnifiedUser u) {
		forUser(u);
		setAdmin(false);
		setRank(0);
		setViewonlyAdmin(false);
		setSelfAdmin(false);
	}

	public void forAdmin(UnifiedUser u, boolean viewonly, boolean selfAdmin,
			int rank) {
		forUser(u);
		setAdmin(true);
		setRank(rank);
		setViewonlyAdmin(viewonly);
		setSelfAdmin(selfAdmin);
	}

	public void forUser(UnifiedUser u) {
		setDisabled(false);
		setId(u.getId());
		setUsername(u.getUsername());
		setEmail(u.getEmail());
		setRegisterIp(u.getRegisterIp());
		setRegisterTime(u.getRegisterTime());
		setLastLoginIp(u.getLastLoginIp());
		setLastLoginTime(u.getLastLoginTime());
		setLoginCount(0);
	}
	
	public boolean hasBuyContent(Content c){
		boolean hasBuy=false;
		Set<ContentBuy>buys=getBuyContentSet();
		for(ContentBuy b:buys){
			if(b.getContent().equals(c)&&b.getUserHasPaid()){
				hasBuy=true;
				break;
			}
		}
		return hasBuy;
	}

	public void init() {
		if (getUploadTotal() == null) {
			setUploadTotal(0L);
		}
		if (getUploadSize() == null) {
			setUploadSize(0);
		}
		if (getUploadDate() == null) {
			setUploadDate(new java.sql.Date(System.currentTimeMillis()));
		}
		if (getAdmin() == null) {
			setAdmin(false);
		}
		if (getRank() == null) {
			setRank(0);
		}
		if (getViewonlyAdmin() == null) {
			setViewonlyAdmin(false);
		}
		if (getSelfAdmin() == null) {
			setSelfAdmin(false);
		}
		if (getDisabled() == null) {
			setDisabled(false);
		}

		if(getFileTotal()==null){
			setFileTotal(0);
		}
		if(getGrain()==null){
			setGrain(0);
		}
		if(getCreateId()==null){
			setCreateId(0);
		}
	}

	public static Integer[] fetchIds(Collection<CmsUser> users) {
		if (users == null) {
			return null;
		}
		Integer[] ids = new Integer[users.size()];
		int i = 0;
		for (CmsUser u : users) {
			ids[i++] = u.getId();
		}
		return ids;
	}

	/**
	 * 用于排列顺序。此处优先级为0，则按ID升序排。
	 */
	public Number getPriority() {
		return 0;
	}

	/**
	 * 是否是今天。根据System.currentTimeMillis() / 1000 / 60 / 60 / 24计算。
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		long day = date.getTime() / 1000 / 60 / 60 / 24;
		long currentDay = System.currentTimeMillis() / 1000 / 60 / 60 / 24;
		return day==(currentDay-1);
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsUser() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsUser(Integer id) {
		super(id);
	}
	public CmsUser(Integer id,String username) {
		super(id,username);
	}
	/**
	 * Constructor for required fields
	 */
	public CmsUser(Integer id,
			com.jetcms.core.entity.CmsGroup group,
			String username, Date registerTime,
			String registerIp, Integer loginCount,
			Integer rank, Long uploadTotal,
			Integer uploadSize, Boolean admin,
			Boolean viewonlyAdmin, Boolean selfAdmin,
			Boolean disabled,Integer createId,Double chargeAmount,Boolean pay,String dynamicPass) {

		super(id, group, username, registerTime, registerIp, loginCount, rank,
				uploadTotal, uploadSize, admin, viewonlyAdmin, selfAdmin,
				disabled,createId,chargeAmount,pay,dynamicPass);
	}

	/* [CONSTRUCTOR MARKER END] */
	private double countzd;//总单
	private double countze;//总额
	private double grzd;  //个人销售总单
	private double grze;//个人销售总额
	private double ygzd;//员工销售总单
	private double ygze;//员工销售总额
	private double dlzd;//代理销售总单
	private double dlze;//代理销售总额
	public double getGrzd() {
		return grzd;
	}

	public void setGrzd(double grzd) {
		this.grzd = grzd;
	}

	public double getGrze() {
		return grze;
	}

	public void setGrze(double grze) {
		this.grze = grze;
	}

	public double getYgzd() {
		return ygzd;
	}

	public void setYgzd(double ygzd) {
		this.ygzd = ygzd;
	}

	public double getYgze() {
		return ygze;
	}

	public void setYgze(double ygze) {
		this.ygze = ygze;
	}

	public double getDlzd() {
		return dlzd;
	}

	public void setDlzd(double dlzd) {
		this.dlzd = dlzd;
	}

	public double getDlze() {
		return dlze;
	}

	public void setDlze(double dlze) {
		this.dlze = dlze;
	}

	public double getCountzd() {
		return countzd;
	}

	public void setCountzd(double countzd) {
		this.countzd = countzd;
	}

	public double getCountze() {
		return countze;
	}

	public void setCountze(double countze) {
		this.countze = countze;
	}
	
}
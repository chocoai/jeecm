package com.jetcms.cms.entity.assist.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jc_score_record table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_score_record"
 */

public abstract class BaseCmsScoreRecord  implements Serializable {

	public static String REF = "CmsScoreRecord";
	public static String PROP_COUNT = "count";
	public static String PROP_ITEM = "item";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";


	// constructors
	public BaseCmsScoreRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsScoreRecord (Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsScoreRecord (
		Integer id,
		com.jetcms.cms.entity.assist.CmsScoreItem item,
		com.jetcms.cms.entity.main.Content content,
		Integer count) {

		this.setId(id);
		this.setItem(item);
		this.setContent(content);
		this.setCount(count);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private Integer count;

	// many to one
	private com.jetcms.cms.entity.assist.CmsScoreItem item;
	private com.jetcms.cms.entity.main.Content content;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="score_record_id"
     */
	public Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: score_count
	 */
	public Integer getCount () {
		return count;
	}

	/**
	 * Set the value related to the column: score_count
	 * @param count the score_count value
	 */
	public void setCount (Integer count) {
		this.count = count;
	}


	/**
	 * Return the value associated with the column: score_item_id
	 */
	public com.jetcms.cms.entity.assist.CmsScoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: score_item_id
	 * @param item the score_item_id value
	 */
	public void setItem (com.jetcms.cms.entity.assist.CmsScoreItem item) {
		this.item = item;
	}


	/**
	 * Return the value associated with the column: content_id
	 */
	public com.jetcms.cms.entity.main.Content getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: content_id
	 * @param content the content_id value
	 */
	public void setContent (com.jetcms.cms.entity.main.Content content) {
		this.content = content;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jetcms.cms.entity.assist.CmsScoreRecord)) return false;
		else {
			com.jetcms.cms.entity.assist.CmsScoreRecord cmsScoreRecord = (com.jetcms.cms.entity.assist.CmsScoreRecord) obj;
			if (null == this.getId() || null == cmsScoreRecord.getId()) return false;
			else return (this.getId().equals(cmsScoreRecord.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
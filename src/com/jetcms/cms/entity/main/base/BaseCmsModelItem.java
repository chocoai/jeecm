package com.jetcms.cms.entity.main.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jc_model_item table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_model_item"
 */

public abstract class BaseCmsModelItem  implements Serializable {

	public static String REF = "CmsModelItem";
	public static String PROP_SINGLE = "single";
	public static String PROP_DATA_TYPE = "dataType";
	public static String PROP_CUSTOM = "custom";
	public static String PROP_OPT_VALUE = "optValue";
	public static String PROP_HELP = "help";
	public static String PROP_PRIORITY = "priority";
	public static String PROP_FIELD = "field";
	public static String PROP_LABEL = "label";
	public static String PROP_COLS = "cols";
	public static String PROP_MODEL = "model";
	public static String PROP_DEF_VALUE = "defValue";
	public static String PROP_HELP_POSITION = "helpPosition";
	public static String PROP_ROWS = "rows";
	public static String PROP_SIZE = "size";
	public static String PROP_DISPLAY = "display";
	public static String PROP_CHANNEL = "channel";
	public static String PROP_ID = "id";


	// constructors
	public BaseCmsModelItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsModelItem (Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsModelItem (
		Integer id,
		com.jetcms.cms.entity.main.CmsModel model,
		String field,
		String label,
		Integer dataType,
		Boolean single,
		Boolean channel,
		Boolean custom,
		Boolean display) {

		this.setId(id);
		this.setModel(model);
		this.setField(field);
		this.setLabel(label);
		this.setDataType(dataType);
		this.setSingle(single);
		this.setChannel(channel);
		this.setCustom(custom);
		this.setDisplay(display);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private String field;
	private String label;
	private Integer priority;
	private String defValue;
	private String optValue;
	private String size;
	private String rows;
	private String cols;
	private String help;
	private String helpPosition;
	private Integer dataType;
	private Boolean single;
	private Boolean channel;
	private Boolean custom;
	private Boolean display;
	private Boolean required;
	private Integer imageWidth;
	private Integer imageHeight;

	// many to one
	private com.jetcms.cms.entity.main.CmsModel model;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="modelitem_id"
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
	 * Return the value associated with the column: field
	 */
	public String getField () {
		return field;
	}

	/**
	 * Set the value related to the column: field
	 * @param field the field value
	 */
	public void setField (String field) {
		this.field = field;
	}


	/**
	 * Return the value associated with the column: item_label
	 */
	public String getLabel () {
		return label;
	}

	/**
	 * Set the value related to the column: item_label
	 * @param label the item_label value
	 */
	public void setLabel (String label) {
		this.label = label;
	}


	/**
	 * Return the value associated with the column: priority
	 */
	public Integer getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (Integer priority) {
		this.priority = priority;
	}


	/**
	 * Return the value associated with the column: def_value
	 */
	public String getDefValue () {
		return defValue;
	}

	/**
	 * Set the value related to the column: def_value
	 * @param defValue the def_value value
	 */
	public void setDefValue (String defValue) {
		this.defValue = defValue;
	}


	/**
	 * Return the value associated with the column: opt_value
	 */
	public String getOptValue () {
		return optValue;
	}

	/**
	 * Set the value related to the column: opt_value
	 * @param optValue the opt_value value
	 */
	public void setOptValue (String optValue) {
		this.optValue = optValue;
	}


	/**
	 * Return the value associated with the column: text_size
	 */
	public String getSize () {
		return size;
	}

	/**
	 * Set the value related to the column: text_size
	 * @param size the text_size value
	 */
	public void setSize (String size) {
		this.size = size;
	}


	/**
	 * Return the value associated with the column: area_rows
	 */
	public String getRows () {
		return rows;
	}

	/**
	 * Set the value related to the column: area_rows
	 * @param rows the area_rows value
	 */
	public void setRows (String rows) {
		this.rows = rows;
	}


	/**
	 * Return the value associated with the column: area_cols
	 */
	public String getCols () {
		return cols;
	}

	/**
	 * Set the value related to the column: area_cols
	 * @param cols the area_cols value
	 */
	public void setCols (String cols) {
		this.cols = cols;
	}


	/**
	 * Return the value associated with the column: help
	 */
	public String getHelp () {
		return help;
	}

	/**
	 * Set the value related to the column: help
	 * @param help the help value
	 */
	public void setHelp (String help) {
		this.help = help;
	}


	/**
	 * Return the value associated with the column: help_position
	 */
	public String getHelpPosition () {
		return helpPosition;
	}

	/**
	 * Set the value related to the column: help_position
	 * @param helpPosition the help_position value
	 */
	public void setHelpPosition (String helpPosition) {
		this.helpPosition = helpPosition;
	}


	/**
	 * Return the value associated with the column: data_type
	 */
	public Integer getDataType () {
		return dataType;
	}

	/**
	 * Set the value related to the column: data_type
	 * @param dataType the data_type value
	 */
	public void setDataType (Integer dataType) {
		this.dataType = dataType;
	}


	/**
	 * Return the value associated with the column: is_single
	 */
	public Boolean getSingle () {
		return single;
	}

	/**
	 * Set the value related to the column: is_single
	 * @param single the is_single value
	 */
	public void setSingle (Boolean single) {
		this.single = single;
	}


	/**
	 * Return the value associated with the column: is_channel
	 */
	public Boolean getChannel () {
		return channel;
	}

	/**
	 * Set the value related to the column: is_channel
	 * @param channel the is_channel value
	 */
	public void setChannel (Boolean channel) {
		this.channel = channel;
	}


	/**
	 * Return the value associated with the column: is_custom
	 */
	public Boolean getCustom () {
		return custom;
	}

	/**
	 * Set the value related to the column: is_custom
	 * @param custom the is_custom value
	 */
	public void setCustom (Boolean custom) {
		this.custom = custom;
	}


	/**
	 * Return the value associated with the column: is_display
	 */
	public Boolean getDisplay () {
		return display;
	}

	/**
	 * Set the value related to the column: is_display
	 * @param display the is_display value
	 */
	public void setDisplay (Boolean display) {
		this.display = display;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}
	
	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}

	public Integer getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}

	/**
	 * Return the value associated with the column: model_id
	 */
	public com.jetcms.cms.entity.main.CmsModel getModel () {
		return model;
	}

	/**
	 * Set the value related to the column: model_id
	 * @param model the model_id value
	 */
	public void setModel (com.jetcms.cms.entity.main.CmsModel model) {
		this.model = model;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jetcms.cms.entity.main.CmsModelItem)) return false;
		else {
			com.jetcms.cms.entity.main.CmsModelItem cmsModelItem = (com.jetcms.cms.entity.main.CmsModelItem) obj;
			if (null == this.getId() || null == cmsModelItem.getId()) return false;
			else return (this.getId().equals(cmsModelItem.getId()));
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
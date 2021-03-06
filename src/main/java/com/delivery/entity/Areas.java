package com.delivery.entity;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;

/**
 * generated by Generate POJOs.groovy 
 * @Date 2020-10-20 16:35
 *
 * @author Yvan
 */

@Data
@Entity
@Table ( name ="areas" )
public class Areas implements Serializable {

	private static final long serialVersionUID = 5760495573206399865L;

 	@Column(name = "id" )
	@Id
	@GeneratedValue
	private String id;

	/**
	 * 区名
	 */
 	@Column(name = "areas_name" )
	private String areasName;

	/**
	 * 市id
	 */
 	@Column(name = "city_id" )
	private String cityId;

	/**
	 * 省id
	 */
 	@Column(name = "province_id" )
	private String provinceId;

}

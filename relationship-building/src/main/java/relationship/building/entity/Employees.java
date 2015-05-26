/**
 * 
 */
package relationship.building.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EMPLOYEESテーブル用エンティティ
 * @author furuhashitomoki
 *
 */

@Entity
@Table (name = "EMPLOYEES")
public class Employees {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_NO", nullable = false, unique = true)
	public Integer id;
	
	
	@Column(name = "EMP_NAME", nullable = false)
	public String empName;
	
	
	@Column(name = "EMP_FURIGANA")
	public String empFurigana;
	
	
	@Column(name = "BIRTHDAY")
	public String dateOfBirth;
	
	
	@Column(name = "TELEPHONE_NUMBER")
	public String telephoneNumber;

	
	@Column(name = "NOTE")
	public String note;
	
	@Column(name = "DELETE_FLAG")
	public int deleteFlag;
	

	@Column(name = "STATUS", nullable = false)
	public Integer talkStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	public Timestamp registrationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE", nullable = false)
	public Timestamp updateDate;

}

/**
 * 
 */
package relationship.building.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LOGINテーブル用エンティティ
 * @author furuhashitomoki
 *
 */
@Entity
@Table(name = "LOGIN")
public class Login {
	
	@Column(name = "USER_NAME", nullable = false)
	public String userName;
	
	@Column(name = "PASSWORD", nullable = false, unique = true)
	public String password;
	
	@Column(name = "DELETE_FLAG", nullable = false)
	public Integer deleteFlag;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REGISTRATION_DATE" , nullable = false)
	public Timestamp registrationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE" , nullable = false)
	public Timestamp updateDate;

}

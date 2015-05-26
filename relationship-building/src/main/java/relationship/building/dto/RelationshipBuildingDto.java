/**
 * 
 */
package relationship.building.dto;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

/**
 * 社員情報を格納するDtoクラス
 * 
 * @author furuhashitomoki
 *
 */
@Component(instance = InstanceType.SESSION)
public class RelationshipBuildingDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Integer id;
	public String empName;
	public String empFurigana;
	public String birthYear;
	public String birthMonth;
	public String birthDay;
	public String dateOfBirth;
	public String telephoneNumber;
	public String note;
	public Integer deleteFlag;
	public String talkStatus;

	// デフォルトコンストラクタ
	public RelationshipBuildingDto() {

	}

	public RelationshipBuildingDto(Integer id, String empName,
			String empFurigana, String dateOfBirth, String telephoneNumber,
			String note, String talkStatus) {

		this.id = id;
		this.empName = empName;
		this.empFurigana = empFurigana;
		this.dateOfBirth = dateOfBirth;
		this.telephoneNumber = telephoneNumber;
		this.note = note;
		this.talkStatus = talkStatus;
	}
}

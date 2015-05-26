/**
 * 
 */
package relationship.building.service;

import java.util.List;

import relationship.building.dto.RelationshipBuildingDto;
import relationship.building.dto.RelationshipBuildingViewDto;
import relationship.building.entity.Employees;

/**
 * サービスクラス共通のメソッドを持つサービスクラス
 * 
 * @author furuhashitomoki
 *
 */
public class CommonService {

	/**
	 * エンティティをDtoに変換するメソッド.
	 * 
	 * @param employees
	 *            変換するエンティティ
	 * @return 変換されたDto
	 */
	RelationshipBuildingViewDto createDto(List<Employees> employees) {
		RelationshipBuildingViewDto rbvd = new RelationshipBuildingViewDto();
		String talkStatus;

		for (Employees emp : employees) {

			if (emp.talkStatus == 0) {
				talkStatus = "話していない";
			} else {
				talkStatus = "話した";
			}

			RelationshipBuildingDto relationshipBuildingDisp = new RelationshipBuildingDto(
					emp.id, emp.empName, emp.empFurigana, emp.dateOfBirth,
					emp.telephoneNumber, emp.note, talkStatus);

			rbvd.rbvd.add(relationshipBuildingDisp);

		}

		return rbvd;
	}
}

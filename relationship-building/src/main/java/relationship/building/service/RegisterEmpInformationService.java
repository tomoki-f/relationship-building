/**
 * 
 */
package relationship.building.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.service.S2AbstractService;

import relationship.building.dto.RelationshipBuildingDto;
import relationship.building.dto.RelationshipBuildingViewDto;
import relationship.building.entity.Employees;

/**
 * 社員情報を登録するサービスクラス
 * 
 * @author furuhashitomoki
 *
 */
public class RegisterEmpInformationService extends S2AbstractService<Employees> {

	@Resource
	protected RelationshipBuildingDto relationshipBuildingDto;

	/**
	 * Dtoをデータベースに挿入するメソッド.
	 * 
	 * @param relationshipBuildingDto
	 *            対象のDto
	 * @return 更新したデータ
	 */
	public int insert(RelationshipBuildingDto relationshipBuildingDto) {
		Employees entity = new Employees();
		Timestamp registrationDate = new Timestamp(System.currentTimeMillis());
		Timestamp updateDate = new Timestamp(System.currentTimeMillis());
		Integer deleteFlag = 0;
		Integer talkStatus;

		if (relationshipBuildingDto.talkStatus.equals("話した")) {
			talkStatus = 1;
		} else {
			talkStatus = 0;
		}

		entity.empName = relationshipBuildingDto.empName;
		entity.empFurigana = relationshipBuildingDto.empFurigana;
		entity.dateOfBirth = relationshipBuildingDto.dateOfBirth;
		entity.telephoneNumber = relationshipBuildingDto.telephoneNumber;
		entity.note = relationshipBuildingDto.note;
		entity.talkStatus = talkStatus;
		entity.deleteFlag = deleteFlag;
		entity.registrationDate = registrationDate;
		entity.updateDate = updateDate;

		return insert(entity);

	}

	/**
	 * Dtoを全件取得するメソッド.
	 * 
	 * @return 取得したDto
	 */
	public RelationshipBuildingViewDto getAllDto() {
		List<Employees> employees = findAll();
		RelationshipBuildingViewDto relationshipBuildingViewDto = createDto(employees);
		return relationshipBuildingViewDto;
	}

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

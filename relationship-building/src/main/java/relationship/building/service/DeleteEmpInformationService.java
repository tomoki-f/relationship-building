/**
 * 
 */
package relationship.building.service;

import java.sql.Timestamp;

import org.seasar.extension.jdbc.service.S2AbstractService;

import relationship.building.dto.RelationshipBuildingDto;
import relationship.building.entity.Employees;

/**
 * 社員情報の削除を行うサービスクラス
 * 
 * @author furuhashitomoki
 *
 */
public class DeleteEmpInformationService extends S2AbstractService<Employees> {

	/**
	 * IDで指定したエンティティを取得するメソッド.
	 * 
	 * @param Id
	 *            ID
	 * @return 結果
	 */
	public Employees findById(Integer Id) {
		return select().id(Id).getSingleResult();
	}

	/**
	 * IDで指定したDtoを取得するメソッド.
	 * 
	 * @param id
	 *            ID
	 * @return 取得したDto
	 */
	public RelationshipBuildingDto getDtoById(Integer id) {
		Employees entity = findById(id);

		String talkStatus;

		if (entity.talkStatus == 1) {
			talkStatus = "話した";
		} else {
			talkStatus = "話していない";
		}

		RelationshipBuildingDto relationshipBuildingDto = new RelationshipBuildingDto();

		relationshipBuildingDto.id = entity.id;
		relationshipBuildingDto.empName = entity.empName;
		relationshipBuildingDto.empFurigana = entity.empFurigana;
		relationshipBuildingDto.dateOfBirth = entity.dateOfBirth;
		relationshipBuildingDto.telephoneNumber = entity.telephoneNumber;
		relationshipBuildingDto.note = entity.note;
		relationshipBuildingDto.talkStatus = talkStatus;
		relationshipBuildingDto.deleteFlag = entity.deleteFlag;

		return relationshipBuildingDto;
	}

	/**
	 * Dtoを論理削除するメソッド.
	 * 
	 * @param relationshipBuildingDto
	 *            対象Dto
	 * @return 更新したデータ
	 */
	public int logicalDelete(RelationshipBuildingDto relationshipBuildingDto) {
		Employees entity = findById(relationshipBuildingDto.id);
		Timestamp updateDate = new Timestamp(System.currentTimeMillis());
		Integer deleteFlag = 1;
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
		entity.updateDate = updateDate;

		return update(entity);
	}
}

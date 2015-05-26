/**
 * 
 */
package relationship.building.service;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;

import relationship.building.constant.RelationshipBuildingConstants;
import relationship.building.dto.RelationshipBuildingDto;
import relationship.building.dto.RelationshipBuildingViewDto;
import relationship.building.entity.Employees;

/**
 * 社員情報を表示するためのServiceクラス
 * 
 * @author furuhashitomoki
 *
 */
public class EmployeesListService extends S2AbstractService<Employees> {

	@Resource
	protected RegisterEmpInformationService registerEmpInformationService;

	@Resource
	protected CommonService commonService;

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
	 * 
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
	 * 削除されていないDtoをすべて取得する.
	 * 
	 * @return 取得したDto
	 */
	public RelationshipBuildingViewDto getAllDtoExceptDeleted() {
		List<Employees> employees = select().where(
				new SimpleWhere().eq("deleteFlag", 0)).getResultList();

		RelationshipBuildingViewDto relationshipBuildingViewDto = registerEmpInformationService
				.createDto(employees);

		return relationshipBuildingViewDto;
	}

	/**
	 * 一覧画面のページに応じたDtoを取得する.
	 * 
	 * @param page
	 * @return 取得したDto
	 */
	public RelationshipBuildingViewDto selectDtoPerPage(int page) {

		List<Employees> emp = select()
				.where(new SimpleWhere().eq("deleteFlag", 0)).orderBy("id")
				.limit(RelationshipBuildingConstants.PER_PAGE)
				.offset(page * RelationshipBuildingConstants.PER_PAGE)
				.getResultList();

		RelationshipBuildingViewDto rbvd = commonService.createDto(emp);

		return rbvd;
	}

	/**
	 * 削除された社員を除いたすべての社員数を取得する.
	 * 
	 * @return 削除された社員を除いた社員数
	 */
	public long findAllEmpExceptDelete() {
		return select().where(new SimpleWhere().eq("deleteFlag", 0)).getCount();

	}
}

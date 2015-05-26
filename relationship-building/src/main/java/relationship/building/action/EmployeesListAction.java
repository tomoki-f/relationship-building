/**
 * 
 */
package relationship.building.action;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.framework.util.IntegerConversionUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relationship.building.dto.RelationshipBuildingDto;
import relationship.building.dto.RelationshipBuildingViewDto;
import relationship.building.entity.Employees;
import relationship.building.form.RelationshipBuildingForm;
import relationship.building.service.EmployeesListService;

/**
 * 社員一覧画面の制御を行うActionクラス
 * 
 * @author furuhashitomoki
 *
 */
public class EmployeesListAction {

	public RelationshipBuildingViewDto rbvd = new RelationshipBuildingViewDto();

	// 誕生年、誕生月、誕生した日　を持つ配列
	public String[] dateOfBirth;

	// 誕生年
	public String birthYear;

	// 誕生月
	public String birthMonth;

	// 誕生した日
	public String birthDay;

	public List<Employees> empList;

	// 登録されている社員データの総件数
	public long totalEmpData;

	public boolean hasNext = false;

	public boolean hasPrev = false;

	@ActionForm
	@Resource
	protected RelationshipBuildingForm relationshipBuildingForm;

	@Resource
	protected EmployeesListService employeesListService;

	@Resource
	public RelationshipBuildingDto relationshipBuildingDto;

	/**
	 * 社員一覧画面を表示する.
	 * 
	 * @return 遷移先(一覧画面)
	 */
	@Execute(validator = false)
	public String index() {
		// rbvd = employeesListService.getAllDtoExceptDeleted();

		totalEmpData = employeesListService.findAllEmpExceptDelete();

		int page = IntegerConversionUtil
				.toPrimitiveInt(this.relationshipBuildingForm.page);

		rbvd = employeesListService.selectDtoPerPage(page);

		int resultSize = rbvd.rbvd.size();

		// 社員一覧に社員情報がない場合
		if (resultSize == 0) {
			return "empInfoNotFound.jsp";

			// 社員一覧に社員情報があり、ページがある場合
		} else if (resultSize != 0 && page != 0) {
			hasPrev = true;
			return "list.jsp";

		} else {
			hasNext = true;
			return "list.jsp";
		}
	}

	/**
	 * 社員情報の詳細画面を表示する.
	 * 
	 * @return 遷移先(社員情報詳細画面)
	 */
	@Execute(validator = false)
	public String dispEmpDetail() {
		Integer id = relationshipBuildingForm.id;
		relationshipBuildingDto = employeesListService.getDtoById(id);

		// 生年月日が選択されていない場合は詳細画面に生年月日を表示しない
		// これがないと生年月日が登録されていない社員の詳細を表示する際にエラーが起きる
		if (relationshipBuildingDto.dateOfBirth.equals("//")) {
			return "empInformationDetail.jsp";
		} else {
			dateOfBirth = relationshipBuildingDto.dateOfBirth.split("/", 0);

			birthYear = dateOfBirth[0];
			birthMonth = dateOfBirth[1];
			birthDay = dateOfBirth[2];

			return "empInformationDetail.jsp";
		}
	}

	/**
	 * 社員情報の削除を確認する画面を表示する.
	 * 
	 * @return 遷移先(削除確認画面)
	 */
	@Execute(validator = false)
	public String dispDeleteConfirmation() {
		return "/deleteEmpInformation/dispDeleteConfirmation/";
	}

	/**
	 * 更新画面表示する.
	 * 
	 * @return 遷移先(更新画面)
	 */
	@Execute(validator = false)
	public String dispUpdateScreen() {
		return "/updateEmpInformation/dispUpdateScreen?redirect=true";
	}

}

/**
 * 
 */
package relationship.building.action;

import javax.annotation.Resource;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relationship.building.dto.RelationshipBuildingDto;
import relationship.building.form.RelationshipBuildingForm;
import relationship.building.service.DeleteEmpInformationService;

/**
 * 社員情報を削除するアクションクラス
 * 
 * @author furuhashitomoki
 *
 */
public class DeleteEmpInformationAction {

	@ActionForm
	@Resource
	protected RelationshipBuildingForm relationshipBuildingForm;

	@Resource
	protected DeleteEmpInformationService deleteEmpInformationService;

	@Resource
	public RelationshipBuildingDto relationShipBuildingDto;

	/**
	 * 社員情報一覧画面を表示するメソッド.
	 * 
	 * @return 遷移先(社員情報一覧画面)
	 */
	@Execute(validator = false)
	public String index() {
		return "/employeesList";
	}

	/**
	 * トップ画面を表示するメソッド.
	 * 
	 * @return 遷移先(トップ画面)
	 */
	@Execute(validator = false)
	public String dispToppage() {
		return "/toppage";
	}

	/**
	 * 社員情報の削除を確認する画面を表示する.
	 * 
	 * @return 遷移先(削除確認画面)
	 */
	@Execute(validator = false)
	public String dispDeleteConfirmation() {

		Integer id = relationshipBuildingForm.id;
		relationShipBuildingDto = deleteEmpInformationService.getDtoById(id);

		return "deleteConfirmation.jsp";
	}

	/**
	 * 削除完了画面を表示する.
	 * 
	 * @return 遷移先(削除完了画面)
	 */
	@Execute(validator = false)
	public String dispCompletionOfDelete() {
		return "completionOfDelete.jsp";
	}

	/**
	 * 社員情報の削除し完了画面を表示する.
	 * 
	 * @return 遷移先(削除完了画面)
	 */
	@Execute(validator = false)
	@RemoveSession(name = "relationshipBuildingDto")
	public String deleteEmpInformation() {

		Integer id = relationshipBuildingForm.id;
		relationShipBuildingDto = deleteEmpInformationService.getDtoById(id);

		deleteEmpInformationService.logicalDelete(relationShipBuildingDto);

		return "completionOfDelete.jsp";
	}

}

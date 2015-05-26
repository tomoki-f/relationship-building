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
import relationship.building.service.UpdateEmpInformationService;

/**
 * 社員情報の更新を制御するActionクラス
 * 
 * @author furuhashitomoki
 *
 */
public class UpdateEmpInformationAction {

	// 生年月日
	public String dateOfBirth;

	// 誕生年、誕生月、誕生日を持つ配列
	public String[] birthday;

	@ActionForm
	@Resource
	protected RelationshipBuildingForm relationshipBuildingForm;

	@Resource
	protected UpdateEmpInformationService updateEmpInformationService;

	@Resource
	public RelationshipBuildingDto relationshipBuildingDto;

	/**
	 * 社員情報一覧画面を表示する.
	 * 
	 * @return 遷移先(社員情報一覧画面)
	 */
	@Execute(validator = false)
	public String index() {
		return "/employeesList";
	}

	/**
	 * トップ画面を表示する.
	 * 
	 * @return 遷移先(トップ画面)
	 */
	@Execute(validator = false)
	public String dispToppage() {
		return "/toppage";
	}

	/**
	 * 選んだ社員の更新画面を表示する.
	 * 
	 * @return 遷移先(更新画面)
	 */
	@Execute(validator = false)
	public String dispUpdateScreen() {
		Integer id = relationshipBuildingForm.id;
		relationshipBuildingDto = updateEmpInformationService.getDtoById(id);

		// 生年月日を誕生年、誕生月、誕生日に分割し、配列に入れる
		birthday = relationshipBuildingDto.dateOfBirth.split("/", 0);
		relationshipBuildingDto.birthYear = birthday[0];
		relationshipBuildingDto.birthMonth = birthday[1];
		relationshipBuildingDto.birthDay = birthday[2];

		return "update.jsp";
	}

	/**
	 * 更新画面で入力された値を受け取り更新確認画面を表示する.
	 * 
	 * @return 遷移先(更新確認画面)
	 */
	@Execute(validator = true, input = "update.jsp")
	public String dispUpdateConfirmation() {

		dateOfBirth = relationshipBuildingForm.birthYear + "/"
				+ relationshipBuildingForm.birthMonth + "/"
				+ relationshipBuildingForm.birthDay;

		/* 更新確認画面から更新画面に戻った際に誕生日を表示させるためDtoにFormの値を代入 */
		relationshipBuildingDto.birthYear = relationshipBuildingForm.birthYear;
		relationshipBuildingDto.birthMonth = relationshipBuildingForm.birthMonth;
		relationshipBuildingDto.birthDay = relationshipBuildingForm.birthDay;

		/* 新たに入力された内容をDtoに代入 */
		relationshipBuildingDto.id = relationshipBuildingForm.id;
		relationshipBuildingDto.empName = relationshipBuildingForm.empName;
		relationshipBuildingDto.empFurigana = relationshipBuildingForm.empFurigana;
		relationshipBuildingDto.dateOfBirth = dateOfBirth;
		relationshipBuildingDto.telephoneNumber = relationshipBuildingForm.telephoneNumber;
		relationshipBuildingDto.note = relationshipBuildingForm.note;
		relationshipBuildingDto.talkStatus = relationshipBuildingForm.talkStatus;

		return "UpdateConfirmation.jsp";
	}

	/**
	 * 更新完了画面を表示する.
	 * 
	 * @return 遷移先(更新完了画面)
	 */
	@Execute(validator = false)
	// @RemoveSession(name = )
	public String dispCompletionOfUpdate() {
		return "completionOfUpdate.jsp";
	}

	/**
	 * 社員情報の更新を行う.
	 * 
	 * @return 遷移先(更新完了画面)
	 */
	@Execute(validator = false)
	@RemoveSession(name = "relationshipBuildingDto")
	public String updateEmpInformation() {

		updateEmpInformationService.update(relationshipBuildingDto);

		return "completionOfUpdate.jsp";
	}

	/**
	 * 更新画面を表示する.
	 * 
	 * @return 遷移先(更新画面)
	 */
	@Execute(validator = false)
	public String goUpdateScreen() {

		return "update.jsp";
	}

}

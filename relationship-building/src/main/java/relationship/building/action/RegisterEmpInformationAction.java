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
import relationship.building.service.RegisterEmpInformationService;

/**
 * @author furuhashitomoki
 *
 */
public class RegisterEmpInformationAction {

	@ActionForm
	@Resource
	public RelationshipBuildingForm relationshipBuildingForm;

	@Resource
	protected RegisterEmpInformationService registerEmpInformationService;

	@Resource
	protected RelationshipBuildingDto relationshipBuildingDto;

	/**
	 * 社員情報の新規登録画面を表示する.
	 * 
	 * @return　遷移先（登録画面)
	 */
	@Execute(validator = false)
	public String index() {
		return "register.jsp";
	}

	/**
	 * 社員情報の登録を行う.
	 * 
	 * @return 遷移先(登録完了画面)
	 */
	@Execute(validator = false)
	@RemoveSession(name = "relationshipBuildingDto")
	public String submit() {

		registerEmpInformationService.insert(relationshipBuildingDto);

		return "completionOfRegistration.jsp";
	}

	/**
	 * 登録画面で入力された値け取り、登録確認画面を表示する.
	 * 
	 * @return 遷移先（登録確認画面)
	 */
	@Execute(validator = true, input = "register.jsp")
	public String dispRegisterComfirmationScreen() {

		String dateOfBirth = relationshipBuildingForm.birthYear + "/"
				+ relationshipBuildingForm.birthMonth + "/"
				+ relationshipBuildingForm.birthDay;

		relationshipBuildingDto.birthYear = relationshipBuildingForm.birthYear;
		relationshipBuildingDto.birthMonth = relationshipBuildingForm.birthMonth;
		relationshipBuildingDto.birthDay = relationshipBuildingForm.birthDay;

		relationshipBuildingDto.id = relationshipBuildingForm.id;
		relationshipBuildingDto.empName = relationshipBuildingForm.empName;
		relationshipBuildingDto.empFurigana = relationshipBuildingForm.empFurigana;
		relationshipBuildingDto.dateOfBirth = dateOfBirth;
		relationshipBuildingDto.telephoneNumber = relationshipBuildingForm.telephoneNumber;
		relationshipBuildingDto.note = relationshipBuildingForm.note;
		relationshipBuildingDto.talkStatus = relationshipBuildingForm.talkStatus;

		return "registerConfirmation.jsp";
	}

	/**
	 * 登録完了画面を表示する.
	 * 
	 * @return 遷移先(登録完了画面)
	 */
	@Execute(validator = false)
	public String dispCompletionScreen() {
		return "completionOfRegistration.jsp";

	}

	/**
	 * 入力された値を保持し、登録画面に遷移する.
	 * 
	 * @return 遷移先(登録画面)
	 */
	@Execute(validator = false)
	public String goRegisterPage() {
		relationshipBuildingForm.empName = relationshipBuildingDto.empName;
		relationshipBuildingForm.empFurigana = relationshipBuildingDto.empFurigana;
		relationshipBuildingForm.birthYear = relationshipBuildingDto.birthYear;
		relationshipBuildingForm.birthMonth = relationshipBuildingDto.birthMonth;
		relationshipBuildingForm.birthDay = relationshipBuildingDto.birthDay;
		relationshipBuildingForm.telephoneNumber = relationshipBuildingDto.telephoneNumber;
		relationshipBuildingForm.note = relationshipBuildingDto.note;
		relationshipBuildingForm.talkStatus = relationshipBuildingDto.talkStatus;

		return "register.jsp";
	}

}

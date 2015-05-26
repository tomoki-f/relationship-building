/**
 * 
 */
package relationship.building.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.Execute;

import relationship.building.dto.UserDataDto;
import relationship.building.service.ToppageService;

/**
 * トップ画面の制御を行うActionクラス
 * 
 * @author furuhashitomoki
 *
 */
public class ToppageAction {

	// 削除された社員を除いた社員数
	public long amountOfAllEmpExceptDelete;

	// 話したことのあるすべての社員数
	public long amountOfTalkedEmp;

	// 話したことのないすべての社員数
	public long amountOfNotTalkedEmp;

	// 話したことのある社員の割合
	public double talkedEmpRatio;

	// 話したことのない社員の割合
	public double notTalkedEmpRatio;

	// 画面に表示するユーザー名
	public String userName;

	@Resource
	protected ToppageService toppageService;

	@Resource
	protected UserDataDto userDataDto;

	/**
	 * 話したことのあるすべての社員数、 話したことのある社員の割合、 話したことのない社員の割合を計算したのち トップ画面を表示する.
	 * 
	 * @return 遷移先(トップ画面)
	 */
	@Execute(validator = false)
	public String index() {

		userName = userDataDto.userName;

		amountOfAllEmpExceptDelete = toppageService.findAllEmpExceptDelete();
		amountOfTalkedEmp = toppageService.findAllTalkedEmpExceptDelete();
		amountOfNotTalkedEmp = toppageService.findAllNotTalkedEmpExceptDelete();

		talkedEmpRatio = toppageService.calcTalkedEmpRatio();
		notTalkedEmpRatio = toppageService.calcNotTalkedEmpRatio();

		return "index.jsp";
	}
}

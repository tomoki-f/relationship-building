/**
 * 
 */
package relationship.building.action;

import javax.annotation.Resource;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.Execute;

import relationship.building.dto.UserDataDto;

/**
 * ログアウトを制御するActionクラス
 * 
 * @author furuhashitomoki
 *
 */
public class LogOutAction {

	@Resource
	protected UserDataDto userDataDto;

	/**
	 * セッションを破棄したのちログイン画面を表示する.
	 * 
	 * @return 遷移先(ログイン画面)
	 */
	@Execute(validator = false)
	@RemoveSession(name = "userDataDto")
	public String index() {
		return "/login?redirect=true";
	}
}

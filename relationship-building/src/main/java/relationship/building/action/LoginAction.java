/**
 * 
 */
package relationship.building.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relationship.building.dto.UserDataDto;
import relationship.building.form.LoginForm;
import relationship.building.service.LoginService;

/**
 * ログインを制御するActionクラス
 * 
 * @author furuhashitomoki
 *
 */
public class LoginAction {

	@ActionForm
	@Resource
	protected LoginForm loginForm;

	@Resource
	protected LoginService loginService;

	@Resource
	protected UserDataDto userDataDto;

	public String errorMessage;

	/**
	 * ログイン画面を表示する.
	 * 
	 * @return 遷移先(ログイン画面)
	 */
	@Execute(validator = false)
	public String index() {
		return "login.jsp";
	}

	/**
	 * ユーザー名とパスワードがデータベースに登録されているか判定したのち遷移先の画面を表示.
	 * 
	 * @return 遷移先
	 * 
	 */
	@Execute(validator = true, input = "login.jsp")
	public String checkLogin() {

		String userName = loginForm.userName;
		String password = loginForm.password;
		userDataDto = loginService.getDtoByUserName(userName);
		if (userDataDto == null) {

			errorMessage = "認証できません。ユーザー名またはパスワードが正しくありません。";
			return "/login";

		} else {

			if (userName.equals(userDataDto.userName)
					&& password.equals(userDataDto.password)) {

				return "/toppage?redirect=true";

			} else {
				errorMessage = "認証できません。ユーザー名またはパスワードが正しくありません。";
				return "/login";
			}
		}
	}

	/**
	 * トップ画面に遷移する.
	 * 
	 * @return 遷移先(トップ画面)
	 */
	@Execute(validator = false)
	public String dispToppage() {
		return "/toppage";
	}
}

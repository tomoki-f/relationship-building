/**
 * 
 */
package relationship.building.form;

import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

/**
 * ログイン情報を受け取るFormクラス
 * 
 * @author furuhashitomoki
 *
 */
public class LoginForm {

	// ユーザー名
	// 入力必須を指定
	// かつ半角英数字のみを指定
	@Mask(mask = "^[a-zA-Z0-9]+$", msg = @Msg(key = "ユーザー名は半角英数字のみです", resource = false))
	@Required(msg = @Msg(key = "ユーザー名は必須です", resource = false))
	public String userName;

	// パスワード
	// 入力必須を指定
	// かつ半角英数字のみを指定
	@Mask(mask = "^[a-zA-Z0-9]+$", msg = @Msg(key = "パスワードは半角英数字のみです", resource = false))
	@Required(msg = @Msg(key = "パスワードは必須です", resource = false))
	public String password;

}

/**
 * 
 */
package relationship.building.dto;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

/**
 * ログイン時のユーザーデータを格納するDtoクラス
 * 
 * @author furuhashitomoki
 *
 */
@Component(instance = InstanceType.SESSION)
public class UserDataDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ユーザー名
	public String userName;

	// パスワード
	public String password;

}

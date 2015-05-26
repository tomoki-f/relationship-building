/**
 * 
 */
package relationship.building.service;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;

import relationship.building.dto.UserDataDto;
import relationship.building.entity.Login;

/**
 * ログイン情報
 * 
 * @author furuhashitomoki
 *
 */
public class LoginService extends S2AbstractService<Login> {

	@Resource
	protected UserDataDto userDataDto;

	/**
	 * ユーザー名で指定したエンティティを取得する.
	 * 
	 * @param userName
	 *            　ユーザー名
	 * @return　結果
	 */
	public Login findByUserName(String userName) {
		return select().where(new SimpleWhere().eq("userName", userName))
				.getSingleResult();

	}

	/**
	 * ユーザー名で指定したDtoを取得する.
	 * 
	 * @param userName
	 *            ユーザー名
	 * @return userDataDto 取得したDto
	 */
	public UserDataDto getDtoByUserName(String userName) {
		Login entity = findByUserName(userName);

		// ユーザー名がDBに存在しない場合はnullを返す
		if (entity == null) {
			return userDataDto = null;

			// ユーザー名がDBに存在する場合はユーザー名とパスワードを返す
		} else {

			userDataDto.userName = entity.userName;
			userDataDto.password = entity.password;

			return userDataDto;
		}
	}

}

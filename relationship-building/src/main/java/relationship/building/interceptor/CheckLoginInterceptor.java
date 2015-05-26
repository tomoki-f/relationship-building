/**
 * 
 */
package relationship.building.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.annotation.Execute;

import relationship.building.dto.UserDataDto;

/**
 * ログイン状態を確認するインターセプター
 * 
 * @author furuhashitomoki
 *
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Resource
	protected UserDataDto userDataDto;

	public HttpSession session;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		// trueの場合はトップ画面に遷移する
		// falseの場合はタイムアウト画面に遷移する
		if (!isExecuteMethod(invocation) || isLoggedIn()) {
			return invocation.proceed();

		} else if (session.isNew()) {
			return "/sessionTimeout.jsp";
		} else {
			return "/login/?redirect=true";
		}
	}

	/**
	 * 実行されたメソッドに@Executeが付いていたか判定する.
	 * 
	 * @param invocation
	 * @return
	 */
	private boolean isExecuteMethod(MethodInvocation invocation) {

		boolean result = invocation.getMethod().isAnnotationPresent(
				Execute.class);

		return result;

	}

	/**
	 * ログイン状態か判定する.
	 * 
	 * @return ログイン状態
	 */
	private boolean isLoggedIn() {

		boolean result = (userDataDto != null && userDataDto.password != null);

		return result;

	}
}

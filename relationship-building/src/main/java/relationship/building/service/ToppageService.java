/**
 * 
 */
package relationship.building.service;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;

import relationship.building.entity.Employees;

/**
 * トップ画面に表示する社員情報を取得するサービスクラス
 * 
 * @author furuhashitomoki
 *
 */
public class ToppageService extends S2AbstractService<Employees> {

	/**
	 * 削除された社員を除いたすべての社員数を取得する.
	 * 
	 * @return 削除された社員を除いた社員数
	 */
	public long findAllEmpExceptDelete() {
		return select().where(new SimpleWhere().eq("deleteFlag", 0)).getCount();

	}

	/**
	 * 削除された社員を除き、会話したことのある社員数を取得する.
	 * 
	 * @return 削除された社員を除いた会話したことのある社員数
	 */
	public long findAllTalkedEmpExceptDelete() {
		return select().where(
				new SimpleWhere().eq("talkStatus", 1).eq("deleteFlag", 0))
				.getCount();
	}

	/**
	 * 削除された社員を除き、会話したことのない社員数を取得する.
	 * 
	 * @return 削除された社員を除いた会話したことのない社員数
	 */
	public long findAllNotTalkedEmpExceptDelete() {
		return select().where(
				new SimpleWhere().eq("talkStatus", 0).eq("deleteFlag", 0))
				.getCount();
	}

	/**
	 * 削除された社員数を除いた全社員数に対する、話した社員のパーセントを計算する.
	 * 
	 * @return 削除された社員数を除いた全社員数に対する、話した社員のパーセント
	 */
	public double calcTalkedEmpRatio() {

		long amountOfAllEmpExceptDelete = findAllEmpExceptDelete();
		long amountOfTalkedEmp = findAllTalkedEmpExceptDelete();
		double talkedEmpRatio = 0;

		try {
			talkedEmpRatio = amountOfTalkedEmp * 100
					/ amountOfAllEmpExceptDelete;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return talkedEmpRatio;
	}

	/**
	 * 削除された社員数を除いた全社員数に対する、話していない社員のパーセントを計算する.
	 * 
	 * @return　削除された社員数を除いた全社員数に対する、話していない社員のパーセント
	 */
	public double calcNotTalkedEmpRatio() {
		long amountOfAllEmpExceptDelete = findAllEmpExceptDelete();
		long amountOfTalkedEmp = findAllTalkedEmpExceptDelete();
		double talkedEmpRatio = 0;
		double notTalkedEmpRatio = 0;

		try {
			talkedEmpRatio = amountOfTalkedEmp * 100
					/ amountOfAllEmpExceptDelete;
			notTalkedEmpRatio = 100 - talkedEmpRatio;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return notTalkedEmpRatio;
	}

}

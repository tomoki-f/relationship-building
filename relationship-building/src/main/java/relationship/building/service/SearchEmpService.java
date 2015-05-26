/**
 * 
 */
package relationship.building.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.service.S2AbstractService;

import relationship.building.constant.RelationshipBuildingConstants;
import relationship.building.dto.RelationshipBuildingViewDto;
import relationship.building.entity.Employees;

/**
 * 社員情報をDBから検索するServiceクラス
 * 
 * @author furuhashitomoki
 *
 */
public class SearchEmpService extends S2AbstractService<Employees> {

	@Resource
	protected CommonService commonService;

	public JdbcManager jdbcManager;

	/**
	 * キーワードによる部分検索を行い重複を消した結果のDtoを返す.
	 * 
	 * @return 検索結果
	 */
	public RelationshipBuildingViewDto searchEmpByKeyword(
			String[] dividedKeyword, int page) {

		// 検索結果を全件取得するためのリスト
		List<Employees> allResults = new ArrayList<Employees>();

		// 検索結果の重複をなくすためのマップ
		Map<Integer, Employees> notOverlappedSearchResults = new TreeMap<Integer, Employees>();

		for (int i = 0; i < dividedKeyword.length; i++) {

			String dividedQuery = "%" + dividedKeyword[i] + "%";

			// 部分検索を行うSQL文
			String searchDatabase = "SELECT * FROM EMPLOYEES WHERE DELETE_FLAG = 0 "
					+ "AND (EMP_NAME LIKE ?"
					+ "OR EMP_FURIGANA LIKE ?"
					+ "OR TELEPHONE_NUMBER LIKE ?"
					+ "OR BIRTHDAY LIKE ?"
					+ "OR NOTE LIKE ?)";

			// 検索結果をページに表示するだけ取得する
			allResults.addAll(jdbcManager
					.selectBySql(Employees.class, searchDatabase, dividedQuery,
							dividedQuery, dividedQuery, dividedQuery,
							dividedQuery)
					.limit(RelationshipBuildingConstants.PER_PAGE)
					.offset(page * RelationshipBuildingConstants.PER_PAGE)
					.getResultList());

		}

		// 取得した結果の重複を防ぐためMapコレクションに変換する
		for (Employees emp : allResults) {
			notOverlappedSearchResults.put(emp.id, emp);
		}

		// 重複のない検索を受け取るリスト
		List<Employees> uniqueResults = new ArrayList<Employees>();

		// CommonServiceのcreateDtoの引数に渡すため
		// 重複を消したMapをリストのuniqueResultsに再代入する
		for (Integer key : notOverlappedSearchResults.keySet()) {
			uniqueResults.add(notOverlappedSearchResults.get(key));
		}

		RelationshipBuildingViewDto rbvd = new RelationshipBuildingViewDto();

		rbvd = commonService.createDto(uniqueResults);

		return rbvd;

	}
}

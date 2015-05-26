/**
 * 
 */
package relationship.building.action;

import javax.annotation.Resource;

import org.seasar.framework.util.IntegerConversionUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relationship.building.dto.RelationshipBuildingViewDto;
import relationship.building.form.SearchEmpListForm;
import relationship.building.service.SearchEmpService;

/**
 * 社員一覧を検索し結果を表示するActionクラス
 * 
 * @author furuhashitomoki
 *
 */
public class SearchEmpAction {

	// 半角スペースの検索キーワード
	// 全角スペースで検索されたキーワードを半角スペースに変えるため
	public String halfWidthSpaceKeyword;

	// スペースごとに区切られたキーワードの配列
	public String[] dividedKeyword;

	// 検索された社員データの総件数
	public int totalSerchedEmpData;

	public boolean hasNext = false;

	public boolean hasPrev = false;

	public RelationshipBuildingViewDto rbvd = new RelationshipBuildingViewDto();

	@ActionForm
	@Resource
	protected SearchEmpListForm searchEmpListForm;

	@Resource
	protected SearchEmpService searchEmpService;

	/**
	 * 社員表の検索を行い、結果の画面を表示する.
	 * 
	 * @return 遷移先(検索結果画面)
	 */
	@Execute(validator = false)
	public String index() {

		if (searchEmpListForm.keyword != null) {
			// 入力されたキーワード間の全角スペースを半角スペースに変える
			halfWidthSpaceKeyword = searchEmpListForm.keyword.replaceAll("　",
					" ");

			// 半角スペースごとにキーワードを区切り、String配列に代入
			dividedKeyword = halfWidthSpaceKeyword.split(" ", 0);
		} else {

			String keyword = searchEmpListForm.keyword;

			halfWidthSpaceKeyword = keyword.replaceAll("　", " ");

			dividedKeyword = halfWidthSpaceKeyword.split(" ", 0);
		}

		int page = IntegerConversionUtil.toPrimitiveInt(searchEmpListForm.page);

		rbvd = searchEmpService.searchEmpByKeyword(dividedKeyword, page);

		totalSerchedEmpData = rbvd.rbvd.size();

		// 検索結果がゼロの場合
		if (totalSerchedEmpData == 0) {
			return "searchResultsNotFound.jsp";

			// 検索結果がある場合
		} else if (totalSerchedEmpData != 0 && page != 0) {
			hasPrev = true;
			return "searchResults.jsp";

		} else {
			hasNext = true;
			return "searchResults.jsp";

		}
	}

}

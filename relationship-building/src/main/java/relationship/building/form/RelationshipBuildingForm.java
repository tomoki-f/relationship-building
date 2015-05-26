/**
 * 
 */
package relationship.building.form;

import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

/**
 * 社員情報を受け取るFormクラス
 * 
 * @author furuhashitomoki
 *
 */
public class RelationshipBuildingForm {

	public Integer id;

	// 社員名
	// 社員名の入力を必須にする
	@Required(msg = @Msg(key = "名前の入力は必須です", resource = false), target = "dispRegisterComfirmationScreen , dispUpdateConfirmation")
	public String empName;

	// 社員フリガナ
	// フリガナをカタカナのみに指定
	@Mask(mask = "^[\u30A0-\u30FF]+$", msg = @Msg(key = "フリガナはカタカナのみです", resource = false), target = "dispRegisterComfirmationScreen , dispUpdateConfirmation")
	public String empFurigana;

	// 誕生年
	public String birthYear;

	// 誕生月
	public String birthMonth;

	// 誕生日
	public String birthDay;

	// 電話番号
	// 電話番号を半角数字とハイフンのみを指定
	@Mask(mask = "^[0-" + "9-]+$", msg = @Msg(key = "電話番号は半角数字とハイフンのみです", resource = false), target = "dispRegisterComfirmationScreen , dispUpdateConfirmation")
	@Maxlength(maxlength = 13, msg = @Msg(key = "電話番号はハイフンを含め13ケタ以内です", resource = false))
	public String telephoneNumber;

	// ノート
	// ノートの最大文字数を200文字に指定
	@Maxlength(maxlength = 200, msg = @Msg(key = "ノートは200字以内です", resource = false))
	public String note;

	// 社員と話したか、話していないかを表すステータス
	public String talkStatus;

	// 削除フラッグ
	public Integer deleteFlag;

	// ページ
	public String page;

}

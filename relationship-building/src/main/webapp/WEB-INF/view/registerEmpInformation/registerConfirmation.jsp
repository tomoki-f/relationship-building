<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>人間関係構築アプリ</title>
</head>
<body>

	<h1>登録確認画面</h1>
	<h3>以下の内容で登録します</h3>
	
	<ul>
		<li>名前:  ${empName}</li>
		<li>フリガナ:  ${empFurigana}</li>
		<li>生年月日:  ${birthYear}/ ${birthMonth}/ ${birthDay}</li>
		<li>電話番号:  ${telephoneNumber}</li>
		<li>ノート:  ${note}</li>
		<li>この社員さんと: ${talkStatus}</li>
	</ul>
	

	<s:form>
 		<input id="" type="submit" name="submit" value="登録" >
 	    <input id="" type="submit" name="goRegisterPage" value="戻る" >        
    </s:form>
      
  
</body>
</html>
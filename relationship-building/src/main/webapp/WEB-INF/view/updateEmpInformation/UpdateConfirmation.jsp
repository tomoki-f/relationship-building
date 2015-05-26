<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>人間関係構築アプリ</title>
</head>
<body>

	<h1>更新確認画面</h1>
	<h3>以下の内容に更新します</h3>
	
	<ul>
		<li>名前:  ${empName}</li>
		<li>フリガナ:  ${empFurigana}</li>
		<li>生年月日:  ${dateOfBirth}</li>
		<li>電話番号:  ${telephoneNumber}</li>
		<li>ノート:  ${note}</li>
		<li>この社員さんと: ${talkStatus}</li>
	</ul>
	

	<s:form>
		
 		<input id="" type="submit" name="updateEmpInformation" value="更新" >
 	    <input id="" type="submit" name="goUpdateScreen" value="戻る" > 
 	    <input type="hidden" name="id" value="${id}">     
    </s:form>
      

</body>
</html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>人間関係構築アプリ</title>
</head>
<body>

	<h1>削除確認画面</h1>
	<h3>以下の内容を削除します</h3>
	
	<ul>
		<li>名前:  ${relationShipBuildingDto.empName}</li>
		<li>フリガナ:  ${relationShipBuildingDto.empFurigana}</li>
		<li>生年月日:  ${relationShipBuildingDto.dateOfBirth}</li>
		<li>電話番号:  ${relationShipBuildingDto.telephoneNumber}</li>
		<li>ノート:  ${relationShipBuildingDto.note}</li>
		<li>この社員さんと: ${relationShipBuildingDto.talkStatus}</li>
	</ul>
	

	<s:form>
 		<input id="" type="submit" name="deleteEmpInformation" value="削除" >
 	    <input id="" type="submit" name="index" value="戻る" >   
 	    <input type="hidden" name="id" value="${relationShipBuildingDto.id}">     
    </s:form>
      

</body>
</html>
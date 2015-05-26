<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>人間関係構築アプリ</title>
</head>
<body>
<header>
	<div class="container">
	<div class="header-top">
		<a href="../toppage">
		<img src="../img/messageImage_1431253516300.jpg" width="50" height="50">
		</a>
	</div>
	<div class="header-index">
		<a href="../employeesList">一覧</a>
	</div>
	<div class="header-register">
		<a href="../registerEmpInformation">新規登録</a>
	</div>
	<div class="header-logout">
		<a href="../logOut">ログアウト</a>
	</div>
	</div>
</header>

	<h1>詳細</h1>
	

	
	<ul>
		<li>名前:  ${relationshipBuildingDto.empName}</li>
		<li>フリガナ:  ${relationshipBuildingDto.empFurigana}</li>
		<li>生年月日:  ${birthYear}/  ${birthMonth}/ ${birthDay}</li>
		<li>電話番号:  ${relationshipBuildingDto.telephoneNumber}</li>
		<li>ノート:  ${relationshipBuildingDto.note}</li>
		<li>この社員さんと: ${relationshipBuildingDto.talkStatus}</li>
	</ul>
<table>
<tr>
	<td>
		<form method="post" action="../updateEmpInformation/dispUpdateScreen/">
 			<input id="" type="submit" name="dispUpdateScreen" value="編集" >
 			<input type="hidden" value="${relationshipBuildingDto.id}" name="id" >
    	</form>
    </td>
    <td>
 		<form method="post" action="../deleteEmpInformation/dispDeleteConfirmation/">
 	   		<input id="" type="submit" name="dispDeleteConfirmation" value="削除" >
 	   		<input type="hidden" value="${relationshipBuildingDto.id}" name="id" >
 		</form>
 	</td>
 	<td>    
 		<form action="../employeesList/" >
 	    	<input type="submit" name="" value="戻る">    
 		</form>    
    </td>
</tr>
</table>
  
</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>人間関構築アプリ</title>
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

<h1>一覧</h1>

	<form method="post" action="../searchEmp/index" class="search" accept-charset="UTF-8">

	<div>
		<input type="text" name="keyword" value="${halfWidthSpaceKeyword}" class="textBox"><input type="submit" name="index" value="検索" class="btn">
	</div>
	</form>
	
	検索結果は全部で<strong>${totalSerchedEmpData}</strong>件のデータがあります	
		
	<table>
	<tr>
		<th>名前</th>
		<th>生年月日</th>
		<th>電話番号</th>
		<th>この社員さんと</th>
	</tr>
	
    <c:forEach var="employees" items="${rbvd.rbvd}">
    <tr>
    
    	<td>${employees.empName}</td>
    	<td>${employees.dateOfBirth}</td>
    	<td>${employees.telephoneNumber}</td>
    	<td>${employees.talkStatus}</td>
    	<td>
    		<form method="post" action="../employeesList/dispEmpDetail">
    		<input type="submit" name="dispEmpDetail" value="この社員の詳細を見る">
    		<input type="hidden" value="${employees.id}" name="id">
    		</form>   	
    	<td>
    		<form method = "post" action = "../updateEmpInformation/dispUpdateScreen/">
      		<input type="submit" name="dispUpdateScreen" value="このデータを編集する" />
      		<input type="hidden" value="${employees.id}" name="id" >
         	</form> 
		</td>
		<td>
			<form method ="post" action = "../deleteEmpInformation/dispDeleteConfirmation/">
      		<input type="submit" name="dispDeleteConfirmation" value="このデータを削除する" />
      		<input type="hidden" value="${employees.id}" name="id" >
			</form>
        </td>
    </c:forEach>
    </table>  
    
    <c:if test="${hasPrev}">
    	<a href="?page=${page - 1}"	>前へ</a>
    </c:if>
    <c:if test="${hasNext}">
    	<a href="?page=${page + 1}" >次へ</a>
    </c:if>
      
</body>
</html>
<!DOCTYPE html>
<html lang="ja">
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

<h3>こんにちは${userName}さん</h3>

	<div>
	<p>話したことのある社員さんは全体の${talkedEmpRatio}%です</p>(${amountOfTalkedEmp} / ${amountOfAllEmpExceptDelete})
	</div>
	
	<div>
	<p>話したことのない社員さんは全体の${notTalkedEmpRatio}%です</p>(${amountOfNotTalkedEmp} / ${amountOfAllEmpExceptDelete})
	</div>
	<br>
	
	<div>
	<p>登録人数: ${amountOfAllEmpExceptDelete}</p>
	</div>

	<div>
	<p>話した人数: ${amountOfTalkedEmp}</p>
	</div>
	
	<div>
	<p>話していない人数: ${amountOfNotTalkedEmp}</p>
	</div>

</body>
</html>
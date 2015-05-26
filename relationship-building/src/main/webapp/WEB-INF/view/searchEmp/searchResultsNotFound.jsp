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
	<form method="post" action="../searchEmp/index" class="search">

	<div>
		<input type="text" name="keyword" class="textBox"><input type="submit" name="index" value="検索" class="btn">
	</div>
	</form>

	 <h3>該当項目に一致するデータはありませんでした。</h3>
	
	 <form method="post" action="../employeesList" class="">
	 <input type="submit" value="戻る" >
	 </form>
      
</body>
</html>
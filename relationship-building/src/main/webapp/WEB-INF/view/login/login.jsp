<!DOCTYPE html>
<html lang="ja">
<head>
 	<meta charset="utf-8">
  	<title>人間関係構築アプリ</title>
</head>

<body>
	
	<img src="../img/messageImage_1431253516300.jpg" width="50" height="50">

	<h1>ログイン</h1>
		<s:form>
		 <%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%> 
		 <html:errors />
		<span style ="color:red">${errorMessage}</span> 
		<br>
		<label for="username">ユーザー名: </label>
		<input type="text" name="userName" value=""><br>(半角英数字)
		<br>
		
		<label for="password">パスワード: </label>
		<input type="password" name="password" value=""><br>(半角英数字)
		<br>
		
		<input type="submit" name="checkLogin" value="ログイン" >
		
		</s:form>

</body>
</html>
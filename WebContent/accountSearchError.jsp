<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>アカウント一覧画面</title>

		<style type="text/css">
		/* ========TAG LAYOUT======== */
			header{
			    width: 100%;
			    height: 60px;
			    background-color: black;
			}

			header ul{
			    float: left;
			    line-height: 40px;
			}

			header ul li{
			    float: left;
			    list-style: none;
			    padding-right: 20px;
			    color: white;
			    font-size: 18px;
			}

			main{
			    clear: both;
			    padding-bottom: 30px;
			}

			.main-container{
			    margin: 0 auto;
			}

			.searchtable {
				margin-bottom: 50px;
			}

			.searchtd, .searchth {
				padding: 10px;
				width: 300px;
			}

			.searchtable, .searchtd, .searchth, .maintable, .maintd, .mainth {
				border: solid 1px #595959;
				border-collapse: collapse;
			}

			form {
				width: fit-content;
   				margin: auto;
			}

			.button {
				width: 180pt;
			}

			.maintd, .mainth {
				padding: 10px;
				width: 90px;
			}

			.submittd {
				border-bottom: 1px solid #595959;
				border-collapse: collapse;
				padding: 30px;
				width: 90px;
				display: flex;
				justify-content: center;
			}

			h3{
			    padding: .25em 0 0 .5em;
			    border-bottom: 3px dotted darkgray ;
			    color:black;
			    font-weight: bold;
			    font-size:18px;
			}

			.error{
				font-size:20px;
				color: red;
			}

			footer{
			    clear: left;
			    width: 100%;
			    height: 60px;
			    margin-bottom: 0px;
			    margin-left: 0px;
			    color: white;
			    background-color: black;
			    text-align: center;
			    line-height: 60px;
			}
		</style>
	</head>
	<body>
        <img src="image/diblog_logo.jpg">
        <header>
            <ul>
                <li>トップ</li>
                <li>プロフィール</li>
                <li>D.I.Blogについて</li>
                <a href='<s:url action="UserCreateAction" />'><li>アカウント登録</li></a>
                <a href='<s:url action="AccountListAction" />'><li>アカウント一覧</li></a>
                <li>その他</li>
            </ul>
        </header>
        <main>
        	<div>
        		<h3>アカウント一覧画面</h3>
				<table class="searchtable">
					<tbody>
						<s:form action = "AccountSearchAction">
							<tr class="maintr">
								<th class="searchth">名前（性）</th>
								<th class="searchth">
									<input type="text" name="family_name" value="<s:property value="family_name" escape="false" />" style="width:250px;" />
								</th>
								<th class="searchth">名前（名）</th>
								<th class="searchth">
									<input type="text" name="last_name" value="<s:property value="last_name" escape="false" />" style="width:250px;" />
								</th>
							</tr>
							<tr class="maintr">
								<th class="searchth">カナ（性）</th>
								<th class="searchth">
									<input type="text" name="family_name_kana" value="<s:property value="family_name_kana" escape="false" />" style="width:250px;" />
								</th>
								<th class="searchth">カナ（名）</th>
								<th class="searchth">
									<input type="text" name="last_name_kana" value="<s:property value="last_name_kana" escape="false" />" style="width:250px;" />
								</th>
							</tr>
							<tr class="maintr">
								<th class="searchth">メールアドレス</th>
								<th class="searchth">
									<input type="text" name="mail" value="<s:property value="mail" escape="false" />" style="width:250px;" />
								</th>
								<th class="searchth">性別</th>
								<th class="searchth">
									<script>
										const gender = {
										    0: "男",
										    1: "女",
										    2: "未選択",
										};
										const chesked = <s:property value="gender" escape="false" />;
										for (const prop in gender) {
											if (chesked == prop) {
												// 選択されている
												document.write('<input type="radio" name="gender" value="'+prop+'" checked />'+gender[prop]);
											} else {
												// 選択されていない
												document.write('<input type="radio" name="gender" value="'+prop+'" />'+gender[prop]);
											}
										}
									</script>
								</th>
							</tr>
							<tr class="maintr">
								<th class="searchth">アカウント権限</th>
								<th class="searchth">
									<select name="authority">
										<script>
											const auths = {
												2: "未選択",
												0: "一般",
											    1: "管理者",
											};
											const selected = <s:property value="authority" escape="false" />;
											for (const prop in auths) {
												if (selected == prop) {
													// 選択されている
													document.write('<option value="'+prop+'" selected>'+auths[prop]+'</option>');
												} else {
													// 選択されていない
													document.write('<option value="'+prop+'">'+auths[prop]+'</option>');
												}
											    //console.log(prop);
											    //console.log(auths[prop]);
											}
										</script>
									</select>
								</th>
								<th class="searchth" colspan="2">
									<s:submit value="検索" class="button"/>
								</th>
							</tr>
						</s:form>
					</tbody>
				</table>
				<table>
					<tr class="error">
						<th>検索条件に一致するアカウントは存在しません。</th>
					</tr>
				</table>
			</div>
		</main>
        <footer>
            Copyright all right reserved diworks 2015 - 2018
        </footer>
    </body>
</html>
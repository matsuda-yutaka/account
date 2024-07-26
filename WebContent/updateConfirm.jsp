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
	<title>アカウント更新確認画面</title>

		<style type="text/css">
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
			}

			.main-container{
			    margin: 0 auto;
			}

			h1{
			    border-left: 5px solid black;
			    border-bottom: 2px solid black;
			    color:black;
			    font-weight: bold;
			    font-size:25px;
			}

			h3{
			    padding: .25em 0 0 .5em;
			    border-bottom: 3px dotted darkgray ;
			    color:black;
			    font-weight: bold;
			    font-size:18px;
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

			.password{
				before{content:"●";
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
				<table>
					<h3>アカウント更新確認画面</h3>
					<s:form action = "UserCreateCompleteAction">
						<tr id="box">
							<td>
								<label>名前（姓）:</label>
							</td>
							<td>
								<s:property value="family_name" escape="false" />
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>名前（名）:</label>
							</td>
							<td>
								<s:property value="last_name" escape="false" />
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>カナ（姓）:</label>
							</td>
							<td>
								<s:property value="family_name_kana" escape="false" />
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>カナ（名）:</label>
							</td>
							<td>
								<s:property value="last_name_kana" escape="false" />
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>メールアドレス:</label>
							</td>
							<td>
								<s:property value="mail" escape="false" />
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>パスワード:</label>
							</td>
							<td>
								<script>
									const str = "<s:property value="password" escape="false" />";
									//console.log(str.length);
									for(var no1 =0; no1 < str.length; no1++){
										document.write("⚫︎");
									}
								</script>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>性別:</label>
							</td>
							<td>
								<script>
									const gender = "<s:property value="gender" escape="false" />";
										if (gender == 0) {
											document.write("男");
										} else {
											document.write("女");
										}
								</script>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>郵便番号:</label>
							</td>
							<td>
								<s:property value="postal_code" escape="false" />
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>住所（都道府県）:</label>
							</td>
							<td>
								<s:property value="prefecture" escape="false" />
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>住所（地区町村）:</label>
							</td>
							<td>
								<s:property value="address_1" escape="false" />
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>住所（番地）:</label>
							</td>
							<td>
								<script>
									const address_2 = "<s:property value="address_2" escape="false" />";
										if (address_2 != null) {
											document.write(address_2);
										} else {
											document.write();
										}
								</script>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>アカウント権限:</label>
							</td>
							<td>
								<script>
									const authority = "<s:property value="authority" escape="false" />";
										if (authority == 0) {
											document.write("一般");
										} else {
											document.write("管理者");
										}
								</script>
							</td>
						</tr>
						<tr>
							<td>
								<s:submit value="更新する" />
							</td>
						</tr>
					</s:form>
					<s:form action = "UpdateGoBackAction">
						<tr>
							<td>
								<button onclick="history.back()">前に戻る</button>
							</td>
						</tr>
					</s:form>
				</table>
			</div>
       	</main>
        <footer>
            Copyright all right reserved diworks 2015 - 2018
        </footer>
    </body>
</html>
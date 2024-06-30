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

			table, td, th {
				border: solid 1px #595959;
				border-collapse: collapse;
			}

			td, th {
				padding: 10px;
				width: 90px;
			}

			.submit {
			}

			h3{
			    padding: .25em 0 0 .5em;
			    border-bottom: 3px dotted darkgray ;
			    color:black;
			    font-weight: bold;
			    font-size:18px;
			}

			.error{
				font-size:15px;
				color:red;
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
				<table>
					<h3>アカウント一覧画面</h3>
					<tbody>
						<tr>
							<th>ID</th>
							<th>名前（性）</th>
							<th>名前（名）</th>
							<th>カナ（性）</th>
							<th>カナ（名）</th>
							<th>メールアドレス</th>
							<th>性別</th>
							<th>アカウント権限</th>
							<th>削除フラグ</th>
							<th>登録日時</th>
							<th>更新日時</th>
							<th>操作</th>
						</tr>
						<s:iterator value="#session.accountListDTOList">
							<tr>
								<td><s:property value="id"/></td>
								<td><s:property value="family_name"/></td>
								<td><s:property value="last_name"/></td>
								<td><s:property value="family_name_kana"/></td>
								<td><s:property value="last_name_kana"/></td>
								<td><s:property value="mail"/></td>
								<td>
									<script>
										switch ("<s:property value="gender"/>") {
										case "0":
											document.write("男");
											break;
										case "1":
											document.write("女");
											break;
										default:
											document.write("");
											break;
										}
									</script>
								</td>
								<td>
									<script>
										switch ("<s:property value="authority"/>") {
										case "0":
											document.write("一般");
											break;
										case "1":
											document.write("管理者");
											break;
										default:
											document.write("");
											break;
										}
									</script>
								</td>
								<td><s:property value="delete_flag"/></td>
								<td><s:property value="registered_time"/></td>
								<td><s:property value="update_time"/></td>
								<td class= "submit">
									<s:form action = "UserCreateConfirmAction">
										<s:submit value="更新" />
									</s:form>
									<s:form action = "UserCreateConfirmAction">
										<s:submit value="削除" />
									</s:form>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</main>
        <footer>
            Copyright all right reserved diworks 2015 - 2018
        </footer>
    </body>
</html>
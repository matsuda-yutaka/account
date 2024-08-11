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
	<title>アカウント登録完了画面</title>

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

			.kanryou{
				text-align: center;
				font-size:25px;
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
					<s:form action = "HomeAction">
							<h3>アカウント登録完了画面</h3>
							<div class="kanryou">
								<p>登録完了しました</p>
							</div>
							<s:submit value="TOPページへ戻る" />
					</s:form>
				</table>
			</div>
		</main>
        <footer>
            Copyright all right reserved diworks 2015 - 2018
        </footer>
    </body>
</html>
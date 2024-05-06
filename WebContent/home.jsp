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
	<title>Home画面</title>

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

			.left{
			    float: left;
			    border: 3px solid blue;
			    width: 69%;
			    height: 1300px;
			    margin-bottom: 10px;
			}

			h1{
			    border-left: 5px solid black;
			    border-bottom: 2px solid black;
			    color:black;
			    font-weight: bold;
			    font-size:25px;
			}

			.image2 img{
			    width:100%;
			}

			.box2{
			    background-color: lightgray;
			    text-align:center;
			}

			.box2 img{
			    width:170px;
			    margin:20px 10px - 10px 10px;
			}

			.box2 .box_pic2{
			    display:inline-block;
			}

			.right {
			    float: left;
			    border: 3px solid red;
			    width: 28.9%;
			    height: 1300px;
			    margin-bottom: 10px;
			}

			h3{
			    padding: .25em 0 0 .5em;
			    border-bottom: 3px dotted darkgray ;
			    color:black;
			    font-weight: bold;
			    font-size:18px;
			}

			.right ul li{
			    list-style: none;
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
                <li>問い合わせ</li>
                <li>その他</li>
            </ul>
        </header>
        <main>
            <div class="main-container">
                <div class="left">
                    <h1>プログラミングに役立つ情報</h1>
                    <p>2017年1月15日</p>
                    <div class="image2">
                        <img src="image/bookstore.jpg">
                    </div>
                    <p>D.I.BlogはD.I.Worksが提供する演習課題です。</p>
                    <p>記事中身</p>
                    <div class="box2">
                        <div class="box_pic2">
                            <img src="image/pic1.jpg">
                            <p>ドメイン取得方法</p>
                        </div>
                        <div class="box_pic2">
                            <img src="image/pic2.jpg">
                            <p>快適な職場環境</p>
                        </div>
                        <div class="box_pic2">
                            <img src="image/pic3.jpg">
                            <p>Linuxの基礎</p>
                        </div>
                        <div class="box_pic2">
                            <img src="image/pic4.jpg">
                            <p>マーケティング入門</p>
                        </div>
                    </div>
                    <div class="box2">
                        <div class="box_pic2">
                            <img src="image/pic5.jpg">
                            <p>アクティブラーニンング</p>
                        </div>
                        <div class="box_pic2">
                            <img src="image/pic6.jpg">
                            <p>CSSの効率的な勉強方法</p>
                        </div>
                        <div class="box_pic2">
                            <img src="image/pic7.jpg">
                            <p>リーダブルコードとは</p>
                        </div>
                        <div class="box_pic2">
                            <img src="image/pic8.jpg">
                            <p>HTML5の可能性</p>
                        </div>
                    </div>
                </div>
                <div class="right">
                    <h3>人気の記事</h3>
                    <ul>
                        <li>PHPオススメ本</li>
                        <li>PHP MyAdminの使い方</li>
                        <li>いま人気のエディタTops</li>
                        <li>HTMLの基礎</li>
                    </ul>
                    <h3>オススメリンク</h3>
                    <ul>
                        <li>ﾃﾞｨｰｱｲﾜｰｸｽ株式会社</li>
                        <li>XAMPPのダウンロード</li>
                        <li>Eclipseのダウンロード</li>
                        <li>Braketsのダウンロード</li>
                    </ul>
                    <h3>カテゴリ</h3>
                    <ul>
                        <li>HTML</li>
                        <li>PHP</li>
                        <li>MySQL</li>
                        <li>JavaScript</li>
                    </ul>
                </div>
            </div>
        </main>
        <footer>
            Copyright all right reserved diworks 2015 - 2018
        </footer>
    </body>
</html>
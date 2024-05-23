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
	<title>UserCreate画面</title>

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
		</style>
	</head>
	<body>
        <img src="image/diblog_logo.jpg">
        <header>
            <ul>
                <li>トップ</li>
                <li>プロフィール</li>
                <li>D.I.Blogについて</li>
                <a href='<s:url action="UserCreateConfirmAction" />'><li>アカウント登録</li></a>
                <li>問い合わせ</li>
                <li>その他</li>
            </ul>
        </header>
        <main>
        	<div>
				<table>
					<s:form action = "UserCreateConfirmAction">
						<tr>
							<td>
								<label>名前（姓）:</label>
							</td>
							<td>
								<input type="text" maxlength="10" name="family_name" value="session.family_name" pattern="[\u4E00-\u9FFF\u3040-\u309Fー]*" />
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage1 != ''">
										<s:property value="errorMessage1" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>名前（名）:</label>
							</td>
							<td>
								<input type="text" maxlength="10" name="last_name" value="session.last_name" pattern="[\u4E00-\u9FFF\u3040-\u309Fー]*" />
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage2 != ''">
										<s:property value="errorMessage2" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>カナ（姓）:</label>
							</td>
							<td>
								<input type="text" maxlength="10" name="family_name_kana" value="session.family_name_kana" pattern="[\u30A1-\u30F6]*" />
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage3 != ''">
										<s:property value="errorMessage3" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>カナ（名）:</label>
							</td>
							<td>
								<input type="text" maxlength="10" name="last_name_kana" value="session.last_name_kana" pattern="[\u30A1-\u30F6]*" />
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage4 != ''">
										<s:property value="errorMessage4" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>メールアドレス:</label>
							</td>
							<td>
								<input type="text" maxlength="100" name="mail" value="session.mail" pattern="[0-9a-zA-Z@-]+$" />
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage5 != ''">
										<s:property value="errorMessage5" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>パスワード:</label>
							</td>
							<td>
								<input type="password" maxlength="10" name="password" value="session.password" pattern="^[a-zA-Z0-9]+$" />
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage6 != ''">
										<s:property value="errorMessage6" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>性別:</label>
							</td>
							<td>
								<input type="radio" name="gender" value=0 checked/>
								<label for="男">男</label>
							</td>
							<td>
								<input type="radio" name="gender" value=1 />
								<label for="女">女</label>
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage7 != ''">
										<s:property value="errorMessage7" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>郵便番号:</label>
							</td>
							<td>
								<input type="text" maxlength="7" name="postal_code" value="session.postal_code" pattern="[0-9]+$" />
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage8 != ''">
										<s:property value="errorMessage8" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>住所（都道府県）:</label>
							</td>
							<td>
								<select name="prefecture" >
									<option value="session.prefecture" selected ></option>
								    <option value="北海道">北海道</option>
								    <option value="青森県">青森県</option>
								    <option value="秋田県">秋田県</option>
								    <option value="岩手県">岩手県</option>
								    <option value="山形県">山形県</option>
								    <option value="宮城県">宮城県</option>
								    <option value="福島県">福島県</option>
								    <option value="山梨県">山梨県</option>
								    <option value="長野県">長野県</option>
								    <option value="新潟県">新潟県</option>
								    <option value="富山県">富山県</option>
								    <option value="石川県">石川県</option>
								    <option value="福井県">福井県</option>
								    <option value="茨城県">茨城県</option>
								    <option value="栃木県">栃木県</option>
								    <option value="群馬県">群馬県</option>
								    <option value="埼玉県">埼玉県</option>
								    <option value="千葉県">千葉県</option>
								    <option value="東京都">東京都</option>
								    <option value="神奈川県">神奈川県</option>
								    <option value="愛知県">愛知県</option>
								    <option value="静岡県">静岡県</option>
								    <option value="岐阜県">岐阜県</option>
								    <option value="三重県">三重県</option>
								    <option value="大阪府">大阪府</option>
								    <option value="兵庫県">兵庫県</option>
								    <option value="京都府">京都府</option>
								    <option value="滋賀県">滋賀県</option>
								    <option value="奈良県">奈良県</option>
								    <option value="和歌山県">和歌山県</option>
								    <option value="岡山県">岡山県</option>
								    <option value="広島県">広島県</option>
								    <option value="鳥取県">鳥取県</option>
								    <option value="島根県">島根県</option>
								    <option value="山口県">山口県</option>
								    <option value="徳島県">徳島県</option>
								    <option value="香川県">香川県</option>
								    <option value="愛媛県">愛媛県</option>
								    <option value="高知県">高知県</option>
								    <option value="福岡県">福岡県</option>
								    <option value="佐賀県">佐賀県</option>
								    <option value="長崎県">長崎県</option>
								    <option value="熊本県">熊本県</option>
								    <option value="大分県">大分県</option>
								    <option value="宮崎県">宮崎県</option>
								    <option value="鹿児島県">鹿児島県</option>
								    <option value="沖縄県">沖縄県</option>
								</select>
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage9 != ''">
										<s:property value="errorMessage9" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>住所（地区町村）:</label>
							</td>
							<td>
								<input type="text" maxlength="10" name="address_1" value="session.address_1" pattern="[\u4E00-\u9FFF\u3041-\u309Fー\u30A1-\u30FC\-0-9０-９\s]*" />
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage10 != ''">
										<s:property value="errorMessage10" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>住所（番地）:</label>
							</td>
							<td>
								<input type="text" maxlength="100" name="address_2" value="session.address_2" pattern="[\u4E00-\u9FFF\u3041-\u309Fー\u30A1-\u30FC\-0-9０-９\s]*" />
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage11 != ''">
										<s:property value="errorMessage11" escape="false" />
								</s:if>
							</td>
						</tr>
						<tr>
							<td>
								<label>アカウント権限:</label>
							</td>
							<td>
								<select name="authority" value="session.authority">
								    <option value=0>一般</option>
								    <option value=1>管理者</option>
								</select>
							</td>
						</tr>
						<tr>
							<td style="color: red;">
								<s:if test="errorMessage12 != ''">
										<s:property value="errorMessage12" escape="false" />
								</s:if>
							</td>
						</tr>
						<s:submit value="確認する" />
					</s:form>
				</table>
			</div>
       	</main>
        <footer>
            Copyright all right reserved diworks 2015 - 2018
        </footer>
    </body>
</html>
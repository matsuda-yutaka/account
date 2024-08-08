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
	<title>アカウント更新画面</title>

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

			.password {
				font-size:12px;
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
					<h3>アカウント更新画面</h3>
					<s:form action = "UpdateConfirmAction" method="get">
						<s:iterator value="#session.deleteDTOList">
							<tr>
								<td>
									<label>名前（姓）:</label>
								</td>
								<td>
									<input type="text" maxlength="10" name="family_name" value="<s:property value="family_name" escape="false" />" pattern="[\u4E00-\u9FFF\u3040-\u309Fー]*" />
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
									<input type="text" maxlength="10" name="last_name" value="<s:property value="last_name" escape="false" />" pattern="[\u4E00-\u9FFF\u3040-\u309Fー]*" />
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
									<input type="text" maxlength="10" name="family_name_kana" value="<s:property value="family_name_kana" escape="false" />" pattern="[\u30A1-\u30F6]*" />
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
									<input type="text" maxlength="10" name="last_name_kana" value="<s:property value="last_name_kana" escape="false" />" pattern="[\u30A1-\u30F6]*" />
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
									<input type="text" maxlength="100" name="mail" value="<s:property value="mail" escape="false" />" pattern="[0-9a-zA-Z@-]+$" />
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
									⚫︎⚫︎⚫︎⚫︎⚫︎⚫︎
								</td>
							</tr>
							<tr>
								<td class="password">
									パスワードの変更は
									<a href='<s:url action="UserCreateAction" method="get"/>?id=<s:property value="id"/>'>
										こちら
									</a>
									から
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
									<script>
											const gender = {
											    0: "男性",
											    1: "女性",
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
									<input type="text" maxlength="7" name="postal_code" value="<s:property value="postal_code" escape="false" />" pattern="[0-9]+$" />
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
									<select name="prefecture">
										<script>
											const prefecture = {
											    北海道: "北海道",
											    青森県: "青森県",
											    秋田県: "秋田県",
											    岩手県: "岩手県",
											    山形県: "山形県",
											    宮城県: "宮城県",
											    北海道: "北海道",
											    福島県: "福島県",
											    山梨県: "山梨県",
											    長野県: "長野県",
											    新潟県: "新潟県",
											    富山県: "富山県",
											    石川県: "石川県",
											    福井県: "福井県",
											    茨城県: "茨城県",
											    栃木県: "栃木県",
											    群馬県: "群馬県",
											    埼玉県: "埼玉県",
											    千葉県: "千葉県",
											    東京都: "東京都",
											    神奈川県: "神奈川県",
											    愛知県: "愛知県",
											    静岡県: "静岡県",
											    岐阜県: "岐阜県",
											    三重県: "三重県",
											    大阪府: "大阪府",
											    兵庫県: "兵庫県",
											    京都府: "京都府",
											    滋賀県: "滋賀県",
											    奈良県: "奈良県",
											    和歌山県: "和歌山県",
											    岡山県: "岡山県",
											    広島県: "広島県",
											    鳥取県: "鳥取県",
											    島根県: "島根県",
											    山口県: "山口県",
											    徳島県: "徳島県",
											    香川県: "香川県",
											    愛媛県: "愛媛県",
											    高知県: "高知県",
											    福岡県: "福岡県",
											    佐賀県: "佐賀県",
											    長崎県: "長崎県",
											    熊本県: "熊本県",
											    大分県: "大分県",
											    宮崎県: "宮崎県",
											    鹿児島県: "鹿児島県",
											    沖繩県: "沖繩県",
											};
											const selected2 = "<s:property value="prefecture" escape="false" />";
											console.log(selected2);
											for (const prop in prefecture) {
												if (selected2 == prop) {
													document.write('<option value="'+prop+'" selected>'+prefecture[prop]+'</option>');
												} else {
													document.write('<option value="'+prop+'">'+prefecture[prop]+'</option>');
												}
											}
										</script>
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
									<input type="text" maxlength="10" name="address_1" value="<s:property value="address_1" escape="false" />" pattern="[\u4E00-\u9FFF\u3041-\u309Fー\u30A1-\u30FC\-0-9０-９\s]*" />
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
									<input type="text" maxlength="100" name="address_2" value="<s:property value="session.address_2" escape="false" />" pattern="[\u4E00-\u9FFF\u3041-\u309Fー\u30A1-\u30FC\-0-9０-９\s]*" />
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
									<select name="authority">
										<script>
											const auths = {
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
								</td>
							</tr>
							<tr>
								<td style="color: red;">
									<s:if test="errorMessage12 != ''">
											<s:property value="errorMessage12" escape="false" />
									</s:if>
								</td>
							</tr>
						</s:iterator>
						<input type="hidden" name="id" value="<s:property value="id"/>"/>
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